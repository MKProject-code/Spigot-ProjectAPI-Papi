package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Select;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.BuilderAbstractController;

public final class BuilderSelect extends BuilderAbstractController {

    public SelectAlfa select() {
        return new SelectAlfa(this);
    }

}
