package com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0;

import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Insert.InsertIntoAlfa;
import com.mkproject.ProjectAPI.PapiPlugin.MySQL.Builder_v1_0.Select.BuilderSelect;

public class BuilderAbstractController {

    private String query = "";

    public void addSql(String sql) {
        if (this.query.equals("")) this.query += " ( " + sql;
        else this.query += (sql.indexOf(",") == 0 ? "" : " ") + sql;
    }

    public BuilderAbstractController end() {
        this.query += " ) ";
        return this;
    }

    public String getQuery() {
        return this.query + ";";
    }

    // For beauty
    private enum BeautyQueryElement {
        UNION,
        SELECT,
        FROM,
        WHERE,
        JOIN,
        INNER_JOIN,
        LEFT_JOIN,
        RIGHT_JOIN,
        FULL_JOIN,
        LEFT_OUTER_JOIN,
        RIGHT_OUTER_JOIN,
        FULL_OUTER_JOIN,
        ORDER_BY,
    }

    public String getBeautyQuery() {
        String result = this.query + " ";

        result = result.replace(" ( ", "(\n");
        result = result.replace(" ) ", "\n)");

        for (BeautyQueryElement elem : BeautyQueryElement.values()) {
            String elemName = elem.name().replace("_"," ");
            result = result.replace(" " + elemName + " ", "\n" + elemName + " ");
        }

        String[] resultLines = result.split("\n");
        result = "";

        int tabs = 0;

        for(String line : resultLines)
        {
            String lineEdited = line.trim();

            if (lineEdited.startsWith(")"))
                tabs--;

            String beforeTabsStr = "";
            for (int i = 0; i < tabs; i++) {
                beforeTabsStr += "\t";
            }

            if (lineEdited.length() > 1 && lineEdited.endsWith("(")) {
                lineEdited = lineEdited.substring(0, lineEdited.length() - 1) + "\n" + beforeTabsStr + "(";
                tabs++;
            }

            result += beforeTabsStr + lineEdited + "\n";

            if (lineEdited.startsWith("("))
                tabs++;
        }

        return result.trim() + ";";
    }
}
