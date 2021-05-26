package cn.jdl.ecology.dynamic.datadource;

import com.github.pagehelper.PageInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Properties;

/**
 * 多数据库源配置
 */

@Configuration
@EnableConfigurationProperties(MybatisProperties.class)
@Slf4j
public class DataSourceConfiguration {

    private MybatisProperties mybatisProperties;

    public DataSourceConfiguration(MybatisProperties properties) {
        this.mybatisProperties = properties;
    }

    private static final String MASTER_DATA_SOURCE_PREFIX = "spring.datasource.master";
    private static final String SLAVE_DATA_SOURCE_PREFIX = "spring.datasource.slave";

    @Bean
    public DataSourceAspect dataSourceAopInService(){
        return new DataSourceAspect();
    }

    @Bean
    public Interceptor writeSqlInterceptor() {
        log.info("------ 初始化Sql拦截器 ------");
        return new WriteSqlInterceptor();

    }

    @Bean
    @ConfigurationProperties(MASTER_DATA_SOURCE_PREFIX)
    public DataSource masterDataSource() {
        log.info("------ 初始化 HikariDataSource Master ------");
        return new HikariDataSource();

    }

    @Bean
    @ConfigurationProperties(SLAVE_DATA_SOURCE_PREFIX)
    public DataSource slaveDataSource() {
        log.info("------ 初始化 HikariDataSource Slave ------");
        return new HikariDataSource();

    }

    @Primary
    @Bean()
    public DynamicDataSource dynamicDataSource(DataSource masterDataSource, DataSource slaveDataSource) {
        log.info("------ 初始化 DynamicDataSource   ------");
        val targetDataSources = new HashMap<String, DataSource>();
        targetDataSources.put(DynamicDataSourceHolder.MASTER_DATA_SOURCE, masterDataSource);
        targetDataSources.put(DynamicDataSourceHolder.SLAVE_DATA_SOURCE, slaveDataSource);
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }

    /**
     *　配置mybatis的sqlSession连接动态数据源
     * @param dynamicDataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(mybatisProperties.resolveMapperLocations());
        bean.setTypeAliasesPackage(mybatisProperties.getTypeAliasesPackage());
        bean.setConfiguration(mybatisProperties.getConfiguration());

        SqlSessionFactory sqlSessionFactory = bean.getObject();
        sqlSessionFactory.getConfiguration().addInterceptor(new WriteSqlInterceptor());

        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("pageSizeZero","false");
        properties.setProperty("reasonable","false");
        pageInterceptor.setProperties(properties);
        sqlSessionFactory.getConfiguration().addInterceptor(pageInterceptor);

        return sqlSessionFactory;
    }
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 将动态数据源添加到事务管理器中，并生成新的bean
     * @return the platform transaction manager
     */
    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }
}
