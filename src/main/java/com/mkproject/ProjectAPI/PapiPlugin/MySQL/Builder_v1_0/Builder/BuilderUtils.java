package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

public final class BuilderUtils {
    public static String formatColumn(String column) {
        if(column == null || column.length() == 0)
            throw new IllegalArgumentException("Column name can't be NULL!");
        return "`" + column + "`";
    }
    public static String formatTable(String table) {
        if(table == null || table.length() == 0)
            throw new IllegalArgumentException("Table name can't be NULL!");
        return "`" + table + "`";
    }
    public static String formatValue(String value) {
        return value == null ? "NULL" : "'" + value + "'";
    }

    // For beauty
    private enum BeautyQueryElement {
        UNION,
        SELECT,
        FROM,
        WHERE,
        JOIN,
        INNER_JOIN,
        LEFT_JOIN,
        RIGHT_JOIN,
        FULL_JOIN,
        LEFT_OUTER_JOIN,
        RIGHT_OUTER_JOIN,
        FULL_OUTER_JOIN,
        ORDER_BY,
    }

    public static String formatBeautyQuery(String query) {
        StringBuilder result = new StringBuilder(query + " ");

        result = new StringBuilder(result.toString().replace(" ( ", "(\n"));
        result = new StringBuilder(result.toString().replace(" ) ", "\n)"));

        for (BeautyQueryElement elem : BeautyQueryElement.values()) {
            String elemName = elem.name().replace("_", " ");
            result = new StringBuilder(result.toString().replace(" " + elemName + " ", "\n" + elemName + " "));
        }

        String[] resultLines = result.toString().split("\n");
        result = new StringBuilder();

        int tabs = 0;

        for (String line : resultLines) {
            String lineEdited = line.trim();

            if (lineEdited.startsWith(")"))
                tabs--;

            StringBuilder beforeTabsStr = new StringBuilder();
            for (int i = 0; i < tabs; i++) {
                beforeTabsStr.append("\t");
            }

            if (lineEdited.length() > 1 && lineEdited.endsWith("(")) {
                lineEdited = lineEdited.substring(0, lineEdited.length() - 1) + "\n" + beforeTabsStr + "(";
                tabs++;
            }

            result.append(beforeTabsStr).append(lineEdited).append("\n");

            if (lineEdited.startsWith("("))
                tabs++;
        }

        return result.toString().trim() + ";";
    }
}
