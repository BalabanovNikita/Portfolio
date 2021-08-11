package com.example.lab4;

import java.io.Serializable;

public class Form implements Serializable {
    private String secondName;
    private String firstName;
    private String thridName;
    private Education education;
    private BranchesOfWork branchOfWork;
    private ExpOfWork expirienceOfWork;
    private int workPaid;
    private Boolean fullWork; // полная занятость
    private Boolean partialWork; // частичная занятость
    private Boolean timeToTimeWork; // разовая работа
    private Boolean internship; // стажировка
    private Boolean physicalLimitations; //физические ограничения
    private Boolean convictions; // судимости
    private String addInformation;

    @Override
    public String toString() {
        return "Form{" +
                "secondName='" + secondName + '\'' +
                ", firstName=" + firstName +
                ", thridName='" + thridName + '\'' +
                ", education='" + education + '\'' +
                ", branchOfWork='" + branchOfWork + '\'' +
                ", expirienceOfWork='" + expirienceOfWork + '\'' +
                ", workPaid='" + workPaid + '\'' +
                ", fullWork='" + fullWork + '\'' +
                ", partialWork='" + partialWork + '\'' +
                ", timeToTimeWork='" + timeToTimeWork + '\'' +
                ", internship='" + internship + '\'' +
                ", physicalLimitations='" + physicalLimitations + '\'' +
                ", convictions='" + convictions + '\'' +
                ", addInformation=" + addInformation +
                '}';
    }

    public Form (String secondName, String firstName, String thridName, Education education, BranchesOfWork branchOfWork, ExpOfWork expirienceOfWork, int workPaid, Boolean fullWork, Boolean partialWork, Boolean timeToTimeWork, Boolean internship, Boolean physicalLimitations, Boolean convictions, String addInformation)
    {
        this.secondName = secondName;
        this.firstName = firstName;
        this.thridName = thridName;
        this.education = education;
        this.branchOfWork = branchOfWork;
        this.expirienceOfWork = expirienceOfWork;
        this.workPaid = workPaid;
        this.fullWork = fullWork;
        this.partialWork = partialWork;
        this.timeToTimeWork = timeToTimeWork;
        this.internship = internship;
        this.physicalLimitations = physicalLimitations;
        this.convictions = convictions;
        this.addInformation = addInformation;
    }
    public String getSecondName() {
        return secondName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getThridName() {
        return thridName;
    }
    public String getAddInformation() {
        return addInformation;
    }
    public Education getEducation() {
        return education;
    }

    public BranchesOfWork getBranchOfWork() {
        return branchOfWork;
    }

    public ExpOfWork getExpirienceOfWork() {
        return expirienceOfWork;
    }

    public int getWorkPaid() {
        return workPaid;
    }

    public Boolean getFullWork() {
        return fullWork;
    }
    public Boolean getPartialWork() {
        return partialWork;
    }
    public Boolean getTimeToTimeWork() {
        return timeToTimeWork;
    }
    public Boolean getInternship() {
        return internship;
    }
    public Boolean getPhysicalLimitations() {
        return physicalLimitations;
    }
    public Boolean getConvictions() {
        return convictions;
    }


    public String getTypesOfWork() {

        String St = "";
        if (fullWork) St += "Полная занятость. ";
        if (partialWork) St += "Частичная занятость. ";
        if (timeToTimeWork) St += "Разовая работа. ";
        if (internship) St += "Стажировка. ";
        return St;
    }




    public void setSecondName(String St) {
        secondName = St;
    }
    public void setFirstName(String St) {
        firstName= St;
    }
    public void setThridName(String St) {
        thridName= St;
    }
    public void setFddInformation(String St) {
        addInformation= St;
    }
    public void setEducation(Education count) {
        education = count;
    }

    public void setBranchOfWork(BranchesOfWork count) {
        branchOfWork = count;
    }

    public void setExpirienceOfWork(ExpOfWork count) {
        expirienceOfWork = count;
    }

    public void setWorkPaid(int count) {
        workPaid = count;
    }

    public void setFullWork(Boolean bool) {
        fullWork = bool;
    }
    public void setPartialWork(Boolean bool) {
        partialWork = bool;
    }
    public void setTimeToTimeWork(Boolean bool) {
        timeToTimeWork = bool;
    }
    public void setInternship(Boolean bool) {
        internship = bool;
    }
    public void setPhysicalLimitations(Boolean bool) {
        physicalLimitations = bool;
    }
    public void setConvictions(Boolean bool) {
        convictions = bool;
    }
}
