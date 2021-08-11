package com.example.lab4;

import android.app.Application;

import java.io.Serializable;
import java.util.ArrayList;

public class FormList extends Application implements Serializable {
    private ArrayList<Form> FromAr = new ArrayList<Form>();

    public void AddForm(String secondName, String firstName, String thridName,
                        Education education, BranchesOfWork branchOfWork, ExpOfWork expirienceOfWork,
                        int workPaid, Boolean fullWork, Boolean partialWork,
                        Boolean timeToTimeWork, Boolean internship,
                        Boolean physicalLimitations, Boolean convictions,
                        String addInformation)
    {
        FromAr.add(new Form(secondName, firstName, thridName, education, branchOfWork, expirienceOfWork, workPaid, fullWork, partialWork, timeToTimeWork, internship, physicalLimitations, convictions, addInformation));
    };
    public void AddForm(Form newForm)
    {
        FromAr.add(newForm);
    };
    public void AddFormInID(Form newForm, int i)
    {
        FromAr.add(i, newForm);
    };
    public int getLenght()
    {
        return FromAr.size();
    }

    public void deleteForm(int i)
    {
        FromAr.remove(i);
    }
    public Form getFromByID(int i)
    {
        return FromAr.get(i);
    }
    public void updateForm(String secondName, String firstName, String thridName,
    Education education, BranchesOfWork branchOfWork, ExpOfWork expirienceOfWork,
    int workPaid, Boolean fullWork, Boolean partialWork,
    Boolean timeToTimeWork, Boolean internship,
    Boolean physicalLimitations, Boolean convictions,
    String addInformation, int i)
    {
        FromAr.remove(i);
        FromAr.add(i, new Form(secondName, firstName, thridName, education, branchOfWork, expirienceOfWork, workPaid, fullWork, partialWork, timeToTimeWork, internship, physicalLimitations, convictions, addInformation));
    }

}
