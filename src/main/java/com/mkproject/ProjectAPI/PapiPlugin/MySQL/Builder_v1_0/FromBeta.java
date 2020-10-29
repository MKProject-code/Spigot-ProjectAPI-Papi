package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

public final class FromBeta extends BuilderElement {

    protected FromBeta(Builder builder) {
        super(builder);
    }

    public FromBeta add(String table, String alias) {
        table = BuilderUtils.getFormatTable(table);
        alias = BuilderUtils.getFormatTable(alias);

        this.addBuilderSql(",", table + " AS " + alias);
        return this;
    }

    public Builder end() {
        return this.getBuilder();
    }

    public WhereAlfa where(String table, String column, String operator, String value) {
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
        table = BuilderUtils.getFormatTable(table);
        alias = BuilderUtils.getFormatTable(alias);

        this.addBuilderSql("INNER JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa leftJoin(String table, String alias) {
        table = BuilderUtils.getFormatTable(table);
        alias = BuilderUtils.getFormatTable(alias);

        this.addBuilderSql("LEFT JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa rightJoin(String table, String alias) {
        table = BuilderUtils.getFormatTable(table);
        alias = BuilderUtils.getFormatTable(alias);

        this.addBuilderSql("RIGHT JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa fullJoin(String table, String alias) {
        table = BuilderUtils.getFormatTable(table);
        alias = BuilderUtils.getFormatTable(alias);

        this.addBuilderSql("FULL JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa leftOuterJoin(String table, String alias) {
        table = BuilderUtils.getFormatTable(table);
        alias = BuilderUtils.getFormatTable(alias);

        this.addBuilderSql("LEFT OUTER JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa rightOuterJoin(String table, String alias) {
        table = BuilderUtils.getFormatTable(table);
        alias = BuilderUtils.getFormatTable(alias);

        this.addBuilderSql("RIGHT OUTER JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa fullOuterJoin(String table, String alias) {
        table = BuilderUtils.getFormatTable(table);
        alias = BuilderUtils.getFormatTable(alias);

        this.addBuilderSql("FULL OUTER JOIN", table + " AS " + alias);
        return new JoinAlfa(this.getBuilder());
    }
}
