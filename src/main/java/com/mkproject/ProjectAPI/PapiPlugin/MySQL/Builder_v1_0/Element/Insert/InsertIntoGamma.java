package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Element.Insert;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.BuilderAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.ElementAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Build.BuilderSQLUpdate;

public final class InsertIntoGamma extends ElementAbstractController {

    protected InsertIntoGamma(BuilderAbstractController builder) {
        super(builder);
    }

    public BuilderSQLUpdate end() {
        return (BuilderSQLUpdate) this.getBuilder().end();
    }

}
