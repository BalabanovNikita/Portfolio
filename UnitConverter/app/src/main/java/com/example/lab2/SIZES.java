package com.example.lab2;

public enum SIZES {

    METER ("метров", 0,0, 1, "метр", "в метры" ),
    INCH ("дюймов", 0, 1, 39.37, "дюйм", "в дюймы"),
    FOOT ("футов", 0, 2, 3.281, "фут", "в футы"),
    YARD ("ярдов", 0, 3, 1.094, "ярд", "в ярды"),

    KILOGR ("килограмм", 1,0,1, "кило", "в килограммы"),
    FUNT("фунтов", 1, 1, 2.205, "фунт", "в фунты"),
    OZT ("унций",1,2, 35.27, "унц", "в унции"),
    STOUNE ("стон", 1, 3, 0.1574, "стон", "в стон"),

    LITRA ("литров", 2,0,1, "литр", "в литры"),
    GALLON ("галлонов", 2,1,0.264171, "галл", "в галлоны"),
    QUART ("кварт", 2,2,1.05669, "кварт", "в кварты"),
    PINT ("пинт", 2,3,2.113, "пинт", "в пинты");

    private String title;
    private String ShortTitle;
    private String ButtonTitle;
    private int type;
    private int number;
    private double size;


    SIZES(String title, int type, int number, double size, String ShortTitle, String ButtonTitle) {
        this.title = title;
        this.type = type;
        this.number = number;
        this.size = size;
        this.ShortTitle = ShortTitle;
        this.ButtonTitle = ButtonTitle;
    }
    public String getShortTitle() {
        return ShortTitle;
    }
    public String getButtonTitle() {
        return ButtonTitle;
    }
    public int getType() {
        return type;
    }
    public int getNumb() {
        return number;
    }
    public String getTitle() {
        return title;
    }
    public double getSize() {
        return size;
    }
    @Override
    public String toString() {
        return "DayOfWeek{" +
                "title='" + title + '\'' +
                '}';
    }
}
