package cn.jdl.ecology.starter.format.format;

import java.util.Objects;

public class StringFormatProcessor implements FormatProcessor {

    @Override
    public <T> String format(T obj) {
        return "StringFormatProcessor:" + Objects.toString(obj);
    }
}
