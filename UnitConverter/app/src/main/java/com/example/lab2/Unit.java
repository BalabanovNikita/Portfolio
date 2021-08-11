package com.example.lab2;

public class Unit {
    public Unit(SIZES Size, double N)
    {
        this.Size = Size;
        this.number = N;
    }


    private SIZES Size;
    private double number;

    public SIZES getSize()
    {
        return this.Size;
    }
    public double getNumber()
    {
        return this.number;
    }

}
