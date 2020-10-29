package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

public final class BuilderUtils {
    public static String formatColumn(String column) {
        return "`" + column + "`";
    }
    public static String formatTable(String table) {
        return "`" + table + "`";
    }
    public static String formatValue(String value) {
        return "'" + value + "'";
    }
}
