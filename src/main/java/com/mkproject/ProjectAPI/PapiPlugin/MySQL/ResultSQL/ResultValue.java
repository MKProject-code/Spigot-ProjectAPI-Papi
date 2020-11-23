package com.mkproject.ProjectAPI.PapiPlugin.MySQL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ResultValue {

    private Object resultValue;

    ResultValue(Object resultValue) {
        this.resultValue = resultValue;
    }

    public String getString() {
        return String.valueOf(this.resultValue);
    }
    public Integer getInt() {
        return Integer.parseInt(String.valueOf(this.resultValue));
    }
    public Boolean getBoolean() {
        return Boolean.parseBoolean(String.valueOf(this.resultValue));
    }
    public Long getLong() {
        return Long.parseLong(String.valueOf(this.resultValue));
    }
    public Double getDouble() {
        return Double.parseDouble(String.valueOf(this.resultValue));
    }
    public LocalDateTime getDateTime() {
        return LocalDateTime.parse((CharSequence) this.resultValue);
    }
    public LocalDateTime getDateTime(String pattern) {
        return LocalDateTime.parse((CharSequence) this.resultValue, DateTimeFormatter.ofPattern(pattern));
    }
}
