package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

public class JoinAlfa extends BuilderElement {

    public JoinAlfa(Builder builder) {
        super(builder);
    }

    public JoinBeta on(String table, String column, String operator, String value) {
        table = BuilderUtils.getFormatTable(table);
        column = BuilderUtils.getFormatColumn(column);

        String sql = "";
        if (operator.equals("=") || operator.equals("!=") || operator.equals("<>") || operator.equals("<") || operator.equals(">") || operator.equals("<=") || operator.equals(">="))
            sql = table + "." + column + operator + BuilderUtils.getFormatValue(value);
        else if (operator.equalsIgnoreCase("BETWEEN") && value.toUpperCase().contains(" AND "))
            sql = table + "." + column + " BETWEEN " + BuilderUtils.getFormatValue(value).replaceFirst(" AND ", "' AND '");
        else if (operator.equalsIgnoreCase("LIKE"))
            sql = table + "." + column + " LIKE " + BuilderUtils.getFormatValue(value);
        else if (operator.equalsIgnoreCase("IN") && value.contains("(") && value.contains(")")) {
            //TODO !
            sql = table + "." + column + " IN " + BuilderUtils.getFormatValue(value);
        }

        this.addBuilderSql("ON", sql);
        return new JoinBeta(this.getBuilder());
    }
}
