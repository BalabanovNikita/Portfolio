package com.example.intcalculator;

import java.util.ArrayList;

public class Calculator {

    ArrayList<Action> CalculateAr = new ArrayList<Action>();
    private String CalculateStr = new String();


    public String getStr()
    {
        CalculateStr = "";
        for (int i=0; i<CalculateAr.size(); i++)
        {
            if (CalculateAr.get(i).IsItNumber())
            {
                if (CalculateAr.get(i).IsItNegative())
                {
                    CalculateStr+="("+ CalculateAr.get(i).GetNumber() +")";
                }
                else
                {
                    CalculateStr+=+ CalculateAr.get(i).GetNumber();
                }
            }
            else
            {
                CalculateStr+=CalculateAr.get(i).GetAction();
            }
        }

        return CalculateStr;
    }

    public boolean AddAction(Action Act)
    {
        if (CalculateAr.size() == 0) // если строка пуста
        {
            if (Act.IsItDeleat() || Act.IsItAction() || Act.IsItNegative()) {
                return false;
            } else {
                CalculateAr.add(Act);
                return true;
            }
        }
        else //если строка не пуста
        {
            if (Act.IsItDeleat()) // если удаление
            {
                if (CalculateAr.get(CalculateAr.size()-1).IsItNumber()) {
                    if (CalculateAr.get(CalculateAr.size() - 1).IsItLong()) {
                        CalculateAr.get(CalculateAr.size() - 1).SetNumber(CalculateAr.get(CalculateAr.size() - 1).GetNumber() / 10);
                        if (CalculateAr.get(CalculateAr.size() - 1).GetNumber() < 10) {
                            CalculateAr.get(CalculateAr.size() - 1).SetLong(false);
                        }
                        return true;
                    } else {
                        CalculateAr.remove(CalculateAr.size() - 1);
                        return true;
                    }
                }
                else
                {
                    CalculateAr.remove(CalculateAr.size() - 1);
                    return true;
                }
            }
            else
            {
                if (Act.IsItNumber()) // если цифра
                {
                    if (CalculateAr.get(CalculateAr.size()-1).IsItNumber())
                    {
                        CalculateAr.get(CalculateAr.size()-1).SetNumber(CalculateAr.get(CalculateAr.size()-1).GetNumber()*10 + Act.GetNumber());
                        CalculateAr.get(CalculateAr.size()-1).SetLong(true);
                        return true;
                    }
                    else
                    {
                        CalculateAr.add(Act);
                        return true;
                    }
                }
                else
                {
                    if (Act.IsItNegative()) //если смена знака
                    {
                        if (CalculateAr.get(CalculateAr.size()-1).IsItNumber())
                        {
                            if (CalculateAr.get(CalculateAr.size()-1).IsItNegative())
                            {
                                CalculateAr.get(CalculateAr.size()-1).SetNegative(false);
                                return true;
                            }
                            else
                            {
                                CalculateAr.get(CalculateAr.size()-1).SetNegative(true);
                                return true;
                            }

                        }
                        else
                        {
                            return false;
                        }
                    }
                    else { //если действие
                        if (CalculateAr.get(CalculateAr.size() - 1).IsItAction()) {
                            CalculateAr.get(CalculateAr.size() - 1).SetAction(Act.GetAction());
                            return true;
                        } else // если предыдущее действие это число
                        {
                            CalculateAr.add(Act);
                            return true;
                        }
                    }
                }
            }

        }
    }

    public boolean IsReadyForCalculate()
    {
        return CalculateAr.get(CalculateAr.size()-1).IsItNumber();
    }
    public String Calculate() {
        ArrayList<Action> CalculateAr1 = new ArrayList<Action>();
        for (int i = 0; i < CalculateAr.size(); i++)
        {
            Action Act = new Action(CalculateAr.get(i));
            CalculateAr1.add(Act);
        }


        for (int i = 0; i < CalculateAr1.size(); i++) {
            if (CalculateAr1.get(i).IsItAction()) {
                if (CalculateAr1.get(i).GetAction()=='*')
                {
                    CalculateAr1.get(i-1).SetNumber(CalculateAr1.get(i-1).GetNumber() * CalculateAr1.get(i+1).GetNumber());
                    CalculateAr1.remove(i+1);
                    CalculateAr1.remove(i);
                    i=i-1;
                }
                else
                {
                    if (CalculateAr1.get(i).GetAction()=='/') {
                        CalculateAr1.get(i-1).SetNumber(CalculateAr1.get(i-1).GetNumber() / CalculateAr1.get(i+1).GetNumber());
                        CalculateAr1.remove(i+1);
                        CalculateAr1.remove(i);
                        i=i-1;
                    }
                }
            }
        }

        for (int i = 0; i < CalculateAr1.size(); i++) {
            if (CalculateAr1.get(i).IsItAction()) {
                if (CalculateAr1.get(i).GetAction()=='+')
                {
                    CalculateAr1.get(i-1).SetNumber(CalculateAr1.get(i-1).GetNumber() + CalculateAr1.get(i+1).GetNumber());
                    CalculateAr1.remove(i+1);
                    CalculateAr1.remove(i);
                    i=i-1;
                }
                else
                {
                    if (CalculateAr1.get(i).GetAction()=='-') {
                        CalculateAr1.get(i-1).SetNumber(CalculateAr1.get(i-1).GetNumber() - CalculateAr1.get(i+1).GetNumber());
                        CalculateAr1.remove(i+1);
                        CalculateAr1.remove(i);
                        i=i-1;
                    }
                }
            }
        }
        return String.valueOf(CalculateAr1.get(0).GetNumber());
    }

    public void CleanStr()
    {
        CalculateStr = "";
        CalculateAr.clear();
    }

}
