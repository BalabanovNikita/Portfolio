package com.example.lab4;

import java.util.ArrayList;

public enum BranchesOfWork {

    StateOrganization ("@string/Branch1", 0 ),
    EmergingIndustry ("@string/Branch2", 1),
    IT ("@string/Branch3", 2),
    Services ("@string/Branch4", 3);

    private String Title;
    private int type;
    BranchesOfWork(String Str, int type)
    {
        Title = Str;
        this.type = type;
    }
    public int getType() {
        return type;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
}
