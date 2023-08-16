package cn.jdl.ecology.types;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Health {

    public static final Health ZERO = new Health(0L);

    Long health;

    public static Health of(Long i) {
        return new Health(i);
    }
}

