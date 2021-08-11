package com.example.intcalculator;

public class Action {

    private boolean isNumber = false;
    private boolean isAction = false;
    private boolean isDeleat = false;

    private boolean isNegative = false;
    private boolean isLong = false;
    private int num=0;
    private char action=' ';

    public Action (Action Act)
    {
        isNumber = Act.isNumber;
        isAction = Act.isAction;
        isDeleat = Act.isDeleat;
        isNegative = Act.isNegative;
        num=Act.GetNumber();
        isLong = Act.isLong;
        action = Act.GetAction();
    }
    public Action (int numeral)
    {
        num=numeral;
        isNumber = true;
    }

    public Action (boolean isNeg)
    {
        isNegative = true;
    }
    public Action (char act)
    {
        action=act;
        isAction = true;
    }

    public Action ()
    {
        isDeleat = true;
    }
    public boolean IsItLong()
    {
        return isLong;
    }
    public boolean IsItNegative()
    {
        return isNegative;
    }

    public boolean IsItNumber()
    {
        return isNumber;
    }

    public boolean IsItAction()
    {
        return isAction;
    }

    public boolean IsItDeleat()
    {
        return isDeleat;
    }

    public void SetNegative(boolean isNeg)
    {
        isNegative = isNeg;
        num = num * -1;
    }
    public void SetLong(boolean isLong)
    {
        this.isLong = isLong;
    }
    public int GetNumber() {
        if (isNegative)
        {
            return num;
        }
        else
        {
            return num;
        }
    }
    public void SetNumber(int newNumb)
    {
        num = newNumb;
    }

    public void SetAction(char newAct)
    {
        action = newAct;
    }

    public char GetAction()
    {
        return action;
    }

}
