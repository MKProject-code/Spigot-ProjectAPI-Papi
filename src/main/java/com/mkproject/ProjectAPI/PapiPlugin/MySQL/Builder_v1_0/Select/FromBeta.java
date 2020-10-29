package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Select;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderAbstractElement;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderUtils;

public final class FromBeta extends BuilderAbstractElement {

    protected FromBeta(BuilderAbstractController builder) {
        super(builder);
    }

    public FromBeta add(String table, String alias) {
        table = BuilderUtils.formatTable(table);
        alias = BuilderUtils.formatTable(alias);

        this.addBuilderSql(",", table + " AS " + alias);
        return this;
    }

    public BuilderSelect end() {
        return (BuilderSelect) this.getBuilder();
    }

    public WhereAlfa where(String table, String column, String operator, String value) {
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

        this.addBuilderSql("WHERE", sql);
        return new WhereAlfa(this.getBuilder());
    }

    public OrderByAlfa orderBy() {
        return new OrderByAlfa(this.getBuilder());
    }

    public JoinAlfa join() {
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa innerJoin(String table, String alias) {
        table = BuilderUtils.formatTable(table);
        alias = BuilderUtils.formatTable(alias);

        this.addBuilderSql("INNER JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa leftJoin(String table, String alias) {
        table = BuilderUtils.formatTable(table);
        alias = BuilderUtils.formatTable(alias);

        this.addBuilderSql("LEFT JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa rightJoin(String table, String alias) {
        table = BuilderUtils.formatTable(table);
        alias = BuilderUtils.formatTable(alias);

        this.addBuilderSql("RIGHT JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa fullJoin(String table, String alias) {
        table = BuilderUtils.formatTable(table);
        alias = BuilderUtils.formatTable(alias);

        this.addBuilderSql("FULL JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa leftOuterJoin(String table, String alias) {
        table = BuilderUtils.formatTable(table);
        alias = BuilderUtils.formatTable(alias);

        this.addBuilderSql("LEFT OUTER JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa rightOuterJoin(String table, String alias) {
        table = BuilderUtils.formatTable(table);
        alias = BuilderUtils.formatTable(alias);

        this.addBuilderSql("RIGHT OUTER JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa fullOuterJoin(String table, String alias) {
        table = BuilderUtils.formatTable(table);
        alias = BuilderUtils.formatTable(alias);

        this.addBuilderSql("FULL OUTER JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
}
