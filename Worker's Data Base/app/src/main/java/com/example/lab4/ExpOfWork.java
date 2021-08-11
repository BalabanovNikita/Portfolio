package com.example.lab4;

public enum ExpOfWork {
    WitoutExp ("@string/Exp1", 0 ),
    From1To3 ("@string/Exp2", 1),
    From3To6 ("@string/Exp3", 2),
    MoreThen6 ("@string/Exp4", 3);

    private String Title;
    private int type;
    ExpOfWork(String Str, int type)
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
