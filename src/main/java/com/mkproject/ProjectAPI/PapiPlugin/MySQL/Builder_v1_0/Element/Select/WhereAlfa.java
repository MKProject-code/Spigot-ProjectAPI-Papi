package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Element.Select;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.BuilderAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.ElementAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Build.BuilderSQLQuery;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderUtils;

public final class WhereAlfa extends ElementAbstractController {

    public WhereAlfa(BuilderAbstractController builder) {
        super(builder);
    }

    public BuilderSQLQuery end() {
        return (BuilderSQLQuery) this.getBuilder().end();
    }

    public WhereAlfa and(String table, String column, String operator, String value) {
        table = BuilderUtils.formatTable(table);
        column = BuilderUtils.formatColumn(column);

        String sql = "";
        if (operator.equals("=") || operator.equals("!=") || operator.equals("<>") || operator.equals("<") || operator.equals(">") || operator.equals("<=") || operator.equals(">="))
            sql = table + "." + column + operator + BuilderUtils.formatValue(value);
        else if (operator.equalsIgnoreCase("BETWEEN") && value.toUpperCase().contains(" AND "))
            sql = table + "." + column + " BETWEEN " + BuilderUtils.formatValue(value).replaceFirst(" AND ", "' AND '");
        else if (operator.equalsIgnoreCase("LIKE"))
            sql = table + "." + column + " LIKE " + BuilderUtils.formatValue(value);
        else if (operator.equalsIgnoreCase("IN") && value.contains("(") && value.contains(")")) {
            //TODO !
            sql = table + "." + column + " IN " + BuilderUtils.formatValue(value);
        }

        this.addBuilderSql("AND", sql);
        return new WhereAlfa(this.getBuilder());
    }

    public WhereAlfa or(String table, String column, String operator, String value) {
        table = BuilderUtils.formatTable(table);
        column = BuilderUtils.formatColumn(column);

        String sql = "";
        if (operator.equals("=") || operator.equals("!=") || operator.equals("<>") || operator.equals("<") || operator.equals(">") || operator.equals("<=") || operator.equals(">="))
            sql = table + "." + column + operator + BuilderUtils.formatValue(value);
        else if (operator.equalsIgnoreCase("BETWEEN") && value.toUpperCase().contains(" AND "))
            sql = table + "." + column + " BETWEEN " + BuilderUtils.formatValue(value).replaceFirst(" AND ", "' AND '");
        else if (operator.equalsIgnoreCase("LIKE"))
            sql = table + "." + column + " LIKE " + BuilderUtils.formatValue(value);
        else if (operator.equalsIgnoreCase("IN") && value.contains("(") && value.contains(")")) {
            //TODO !
            sql = table + "." + column + " IN " + BuilderUtils.formatValue(value);
        }

        this.addBuilderSql("OR", sql);
        return new WhereAlfa(this.getBuilder());
    }

    public OrderByAlfa orderBy() {
        return new OrderByAlfa(this.getBuilder());
    }
}
