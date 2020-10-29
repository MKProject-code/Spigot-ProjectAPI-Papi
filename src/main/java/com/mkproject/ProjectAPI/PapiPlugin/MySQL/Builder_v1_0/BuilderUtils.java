package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

public final class BuilderUtils {

    protected static String getFormatColumn(String column) {
        return "`" + column + "`";
    }

    protected static String getFormatTable(String table) {
        return "`" + table + "`";
    }

    public static String getFormatValue(String value) {
        return "'" + value + "'";
    }
}
