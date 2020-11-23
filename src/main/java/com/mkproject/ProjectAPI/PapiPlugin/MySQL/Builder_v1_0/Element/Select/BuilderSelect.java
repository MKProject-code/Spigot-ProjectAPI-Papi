package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Element.Select;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.AbstractController.BuilderAbstractController;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.PapiMySQL;

public final class BuilderSelect extends BuilderAbstractController {

    public BuilderSelect(PapiMySQL papiMySQL) {
        super(papiMySQL);
    }

    public SelectAlfa select() {
        return new SelectAlfa(this);
    }

}
