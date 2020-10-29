package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

public final class SelectGamma extends BuilderElement {

    boolean includePrefix;

    protected SelectGamma(Builder builder, boolean includePrefix) {
        super(builder);
        this.includePrefix = includePrefix;
    }

    public SelectGamma add(String table, String column) {
        return this.add(table, column, null);
    }

    public SelectGamma add(String table, String column, String alias) {
        table = BuilderUtils.getFormatTable(table);
        column = BuilderUtils.getFormatColumn(column);

        this.addBuilderSql(",", table + "." + column + (alias == null ? "" : " AS " + alias));
        return new SelectGamma(this.getBuilder(), false);
    }

    public SelectGamma addCount(String table, String column) {
        return this.addCount(table, column, null);
    }

    public SelectGamma addCount(String table, String column, String alias) {
        table = BuilderUtils.getFormatTable(table);
        column = BuilderUtils.getFormatColumn(column);

        this.addBuilderSql(",", "COUNT(" + table + "." + column + ")" + (alias == null ? "" : " AS " + alias));
        return new SelectGamma(this.getBuilder(), false);
    }

    public SelectGamma addAvg(String table, String column) {
        return this.addAvg(table, column, null);
    }

    public SelectGamma addAvg(String table, String column, String alias) {
        table = BuilderUtils.getFormatTable(table);
        column = BuilderUtils.getFormatColumn(column);

        this.addBuilderSql(",", "AVG(" + table + "." + column + ")" + (alias == null ? "" : " AS " + alias));
        return new SelectGamma(this.getBuilder(), false);
    }

    public SelectGamma addSum(String table, String column) {
        return this.addSum(table, column, null);
    }

    public SelectGamma addSum(String table, String column, String alias) {
        table = BuilderUtils.getFormatTable(table);
        column = BuilderUtils.getFormatColumn(column);

        this.addBuilderSql(",", "SUM(" + table + "." + column + ")" + (alias == null ? "" : " AS " + alias));
        return new SelectGamma(this.getBuilder(), false);
    }

    public FromAlfa from() {
        return new FromAlfa(this.getBuilder());
    }
}