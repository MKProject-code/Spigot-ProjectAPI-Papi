package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

public class JoinBeta extends BuilderElement {

    public JoinBeta(Builder builder) {
        super(builder);
    }

    public JoinBeta and(String table, String column, String operator, String value) {
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

        this.addBuilderSql("AND", sql);
        return new JoinBeta(this.getBuilder());
    }

    public JoinBeta or(String table, String column, String operator, String value) {
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

        this.addBuilderSql("OR", sql);
        return new JoinBeta(this.getBuilder());
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
    public JoinAlfa innerJoin() {
        this.addBuilderSql("INNER");
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa leftJoin() {
        this.addBuilderSql("LEFT");
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa rightJoin() {
        this.addBuilderSql("RIGHT");
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa fullJoin() {
        this.addBuilderSql("FULL");
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa leftOuterJoin() {
        this.addBuilderSql("LEFT OUTER");
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa rightOuterJoin() {
        this.addBuilderSql("RIGHT OUTER");
        return new JoinAlfa(this.getBuilder());
    }
    public JoinAlfa fullOutereJoin() {
        this.addBuilderSql("FULL OUTER");
        return new JoinAlfa(this.getBuilder());
    }
}
