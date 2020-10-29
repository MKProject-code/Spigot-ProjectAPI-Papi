package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Select;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderAbstractElement;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderUtils;

public final class FromAlfa extends BuilderAbstractElement {

    protected FromAlfa(BuilderAbstractController builder) {
        super(builder);
    }

    public FromBeta add(String table, String alias) {
        table = BuilderUtils.formatTable(table);
        alias = BuilderUtils.formatTable(alias);

        this.addBuilderSql("FROM", table + " AS " + alias);
        return new FromBeta(this.getBuilder());
    }
}
