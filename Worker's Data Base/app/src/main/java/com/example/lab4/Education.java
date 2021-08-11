package com.example.lab4;

import android.content.Context;
import android.content.res.Resources;

public enum Education {
    NotFullMiddle ("1", 0 ),
    Middle ("2", 1),
    High ("3", 2);
    //NotFullMiddle (Resources.getSystem().getString(R.string.Education1), 0 ),
    private String Title;
    private int type;
    Education(String Str, int type)
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
