package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

public final class FromAlfa extends BuilderElement {

    protected FromAlfa(Builder builder) {
        super(builder);
    }

    public FromBeta add(String table, String alias) {
        table = BuilderUtils.getFormatTable(table);
        alias = BuilderUtils.getFormatTable(alias);

        this.addBuilderSql("FROM", table + " AS " + alias);
        return new FromBeta(this.getBuilder());
    }
}
