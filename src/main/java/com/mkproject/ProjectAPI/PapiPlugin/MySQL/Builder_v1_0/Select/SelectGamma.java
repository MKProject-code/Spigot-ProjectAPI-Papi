package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Select;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderAbstractElement;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderUtils;

public final class SelectGamma extends BuilderAbstractElement {

    boolean includePrefix;

    protected SelectGamma(BuilderAbstractController builder, boolean includePrefix) {
        super(builder);
        this.includePrefix = includePrefix;
    }

    public SelectGamma add(String table, String column) {
        return this.add(table, column, null);
    }

    public SelectGamma add(String table, String column, String alias) {
        table = BuilderUtils.formatTable(table);
        column = BuilderUtils.formatColumn(column);

        this.addBuilderSql(",", table + "." + column + (alias == null ? "" : " AS " + alias));
        return new SelectGamma(this.getBuilder(), false);
    }

    public SelectGamma addCount(String table, String column) {
        return this.addCount(table, column, null);
    }

    public SelectGamma addCount(String table, String column, String alias) {
        table = BuilderUtils.formatTable(table);
        column = BuilderUtils.formatColumn(column);

        this.addBuilderSql(",", "COUNT(" + table + "." + column + ")" + (alias == null ? "" : " AS " + alias));
        return new SelectGamma(this.getBuilder(), false);
    }

    public SelectGamma addAvg(String table, String column) {
        return this.addAvg(table, column, null);
    }

    public SelectGamma addAvg(String table, String column, String alias) {
        table = BuilderUtils.formatTable(table);
        column = BuilderUtils.formatColumn(column);

        this.addBuilderSql(",", "AVG(" + table + "." + column + ")" + (alias == null ? "" : " AS " + alias));
        return new SelectGamma(this.getBuilder(), false);
    }

    public SelectGamma addSum(String table, String column) {
        return this.addSum(table, column, null);
    }

    public SelectGamma addSum(String table, String column, String alias) {
        table = BuilderUtils.formatTable(table);
        column = BuilderUtils.formatColumn(column);

        this.addBuilderSql(",", "SUM(" + table + "." + column + ")" + (alias == null ? "" : " AS " + alias));
        return new SelectGamma(this.getBuilder(), false);
    }

    public FromAlfa from() {
        return new FromAlfa(this.getBuilder());
    }
}