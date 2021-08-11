package com.example.lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    EditText textField;
    Button btn1;
    Button btn2;
    Button btn3;
    int AddAct = 1;
    Form WorkForm;
    FormList FList = new FormList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
        ExpOfWork.WitoutExp.setTitle(getString(R.string.Exp1));
        ExpOfWork.From1To3.setTitle(getString(R.string.Exp2));
        ExpOfWork.From3To6.setTitle(getString(R.string.Exp3));
        ExpOfWork.MoreThen6.setTitle(getString(R.string.Exp4));

        Education.NotFullMiddle.setTitle(getString(R.string.Education1));
        Education.Middle.setTitle(getString(R.string.Education2));
        Education.High.setTitle(getString(R.string.Education3));

        BranchesOfWork.StateOrganization.setTitle(getString(R.string.Branch1));
        BranchesOfWork.EmergingIndustry.setTitle(getString(R.string.Branch2));
        BranchesOfWork.IT.setTitle(getString(R.string.Branch3));
        BranchesOfWork.Services.setTitle(getString(R.string.Branch4));

        final TextView T = (TextView) findViewById(R.id.textView2);
        T.setText("Всего в базе " + FList.getLenght() + " анкет");
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddForm.class);
                startActivityForResult(intent, AddAct);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllForms.class);
                intent.putExtra("class", FList);
                startActivityForResult(intent, 3);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Statistic.class);
                intent.putExtra("FormCount",  FList.getLenght());
                if (FList.getLenght() == 0)
                {
                    intent.putExtra("education", "1");
                    intent.putExtra("BranchOfWork", "1");
                    intent.putExtra("Expirience", "1");
                    intent.putExtra("WorkPay", -1);
                    intent.putExtra("TypeOfWork", "1");
                }
                else
                {
                    int ed0 = 0;
                    int ed1 = 0;
                    int ed2 = 0;

                    int branch0 = 0;
                    int branch1 = 0;
                    int branch2 = 0;
                    int branch3 = 0;

                    int exp0 = 0;
                    int exp1 = 0;
                    int exp2 = 0;
                    int exp3 = 0;

                    int workType0 = 0;
                    int workType1 = 0;
                    int workType2 = 0;
                    int workType3 = 0;

                    int workpay = 0;

                    for (int i = 0; i<FList.getLenght(); i++)
                    {
                        if (FList.getFromByID(i).getEducation().getType()==0)
                        {
                            ed0++;
                        }
                        else
                        {
                            if (FList.getFromByID(i).getEducation().getType()==1)
                            {
                                ed1++;
                            }
                            else
                            {
                                ed2++;
                            }
                        }

                        if (FList.getFromByID(i).getBranchOfWork().getType()==0)
                        {
                            branch0++;
                        }
                        else
                        {
                            if (FList.getFromByID(i).getBranchOfWork().getType()==1)
                            {
                                branch1++;
                            }
                            else
                            {
                                if (FList.getFromByID(i).getBranchOfWork().getType()==2)
                                {
                                    branch2++;
                                }
                                else
                                {
                                    branch3++;
                                }
                            }
                        }

                        if (FList.getFromByID(i).getExpirienceOfWork().getType()==0)
                        {
                            exp0++;
                        }
                        else
                        {
                            if (FList.getFromByID(i).getExpirienceOfWork().getType()==1)
                            {
                                exp1++;
                            }
                            else
                            {
                                if (FList.getFromByID(i).getExpirienceOfWork().getType()==2)
                                {
                                    exp2++;
                                }
                                else
                                {
                                    exp3++;
                                }
                            }
                        }
                        if(FList.getFromByID(i).getFullWork())
                        {
                            workType0++;
                        }
                        if(FList.getFromByID(i).getPartialWork())
                        {
                            workType1++;
                        }
                        if(FList.getFromByID(i).getTimeToTimeWork())
                        {
                            workType2++;
                        }
                        if(FList.getFromByID(i).getInternship())
                        {
                            workType3++;
                        }
                        workpay = workpay+ FList.getFromByID(i).getWorkPaid();
                    }

                    if (ed0>ed1)
                    {
                        if (ed0>ed2)
                        {
                            intent.putExtra("education", Education.NotFullMiddle.getTitle());
                        }
                        else
                        {
                            intent.putExtra("education", Education.High.getTitle());
                        }
                    }
                    else
                    {
                        if (ed1>ed2)
                        {
                            intent.putExtra("education", Education.Middle.getTitle());
                        }
                        else
                        {
                            intent.putExtra("education", Education.High.getTitle());
                        }
                    }


                    if (exp0>exp1 && exp0>exp2 && exp0>exp3)
                    {
                        intent.putExtra("Expirience",ExpOfWork.WitoutExp.getTitle());
                    }
                    else {
                        if (exp1 > exp0 && exp1 > exp2 && exp1 > exp3) {
                            intent.putExtra("Expirience", ExpOfWork.From1To3.getTitle());
                        }
                        else {
                            if (exp2 > exp1 && exp2 > exp1 && exp2 > exp3) {
                                intent.putExtra("Expirience", ExpOfWork.From3To6.getTitle());
                            }
                            else {
                                intent.putExtra("Expirience", ExpOfWork.MoreThen6.getTitle());
                            }
                        }
                    }
                    if (branch0>branch1 && branch0>branch2 && branch0>branch3)
                    {
                        intent.putExtra("BranchOfWork",  BranchesOfWork.StateOrganization.getTitle());
                    }
                    else {
                        if (branch1 > branch0 && branch1 > branch2 && branch1 > branch3) {
                            intent.putExtra("BranchOfWork", BranchesOfWork.EmergingIndustry.getTitle());
                        }
                        else {
                            if (branch2 > branch1 && branch2 > branch1 && branch2 > branch3) {
                                intent.putExtra("BranchOfWork", BranchesOfWork.IT.getTitle());
                            }
                            else {
                                intent.putExtra("BranchOfWork", BranchesOfWork.Services.getTitle());
                            }
                        }
                    }
                    intent.putExtra("WorkPay", workpay/FList.getLenght());

                    intent.putExtra("TypeOfWork", "Нет данных");
                    if (workType0>workType1 && workType0>workType2 && workType0>workType3)
                    {
                        intent.putExtra("TypeOfWork", getString(R.string.WorkType1));
                    }
                    else {
                        if (workType1 > workType0 && workType1 > workType2 && workType1 > workType3) {
                            intent.putExtra("TypeOfWork", getString(R.string.WorkType2));
                        }
                        else {
                            if (workType2 > workType1 && workType2 > workType1 && workType2 > workType3) {
                                intent.putExtra("TypeOfWork", getString(R.string.WorkType3));
                            }
                            else {
                                intent.putExtra("TypeOfWork", getString(R.string.WorkType4));
                            }
                        }
                    }
                }
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            super.onActivityResult(AddAct, RESULT_OK, data);
            //Form newForm = (Form)getIntent().getSerializable("NewForm");
            //Form newForm = (Form) getIntent().getSerializableExtra("NewForm");
            String secondName = data.getStringExtra("secondname");
            String firstName = data.getStringExtra("firstName");
            ;
            String thridName = data.getStringExtra("thridName");
            ;
            int education1 = data.getIntExtra("education", 1);
            ;
            int branchOfWork1 = data.getIntExtra("branchOfWork", 1);
            ;
            int expirienceOfWork1 = data.getIntExtra("expirienceOfWork", 1);
            ;
            int workPaid = data.getIntExtra("workPaid", 1);
            ;
            Boolean fullWork = data.getBooleanExtra("fullWork", true);
            ; // полная занятость
            Boolean partialWork = data.getBooleanExtra("partialWork", true);
            ; // частичная занятость
            Boolean timeToTimeWork = data.getBooleanExtra("timeToTimeWork", true);
            ; // разовая работа
            Boolean internship = data.getBooleanExtra("internship", true);
            ; // стажировка
            Boolean physicalLimitations = data.getBooleanExtra("physicalLimitations", true);
            ; //физические ограничения
            Boolean convictions = data.getBooleanExtra("convictions", true);
            ; // судимости
            String addInformation = data.getStringExtra("addInformation");
            ;

            Education education;
            if (education1 == 0) {
                education = Education.NotFullMiddle;
            } else {
                if (education1 == 1) {
                    education = Education.Middle;
                } else {
                    education = Education.High;
                }
            }
            BranchesOfWork branchOfWork;
            if (branchOfWork1 == 0) {
                branchOfWork = BranchesOfWork.StateOrganization;
            } else {
                if (branchOfWork1 == 1) {
                    branchOfWork = BranchesOfWork.EmergingIndustry;
                } else {
                    if (branchOfWork1 == 2) {
                        branchOfWork = BranchesOfWork.IT;
                    } else {
                        branchOfWork = BranchesOfWork.Services;
                    }
                }
            }

            ExpOfWork expirienceOfWork;
            if (expirienceOfWork1 == 0) {
                expirienceOfWork = ExpOfWork.WitoutExp;
            } else {
                if (expirienceOfWork1 == 1) {
                    expirienceOfWork = ExpOfWork.From1To3;
                } else {
                    if (expirienceOfWork1 == 2) {
                        expirienceOfWork = ExpOfWork.From3To6;
                    } else {
                        expirienceOfWork = ExpOfWork.MoreThen6;
                    }
                }
            }
            WorkForm = new Form(secondName, firstName, thridName, education, branchOfWork, expirienceOfWork, workPaid, fullWork, partialWork, timeToTimeWork,
                    internship, physicalLimitations, convictions, addInformation);
            FList.AddForm(secondName, firstName, thridName, education, branchOfWork, expirienceOfWork, workPaid, fullWork, partialWork, timeToTimeWork,
                    internship, physicalLimitations, convictions, addInformation);


            //FList.AddForm(newForm);
            final TextView T = (TextView) findViewById(R.id.textView2);
            T.setText("Всего в базе " + FList.getLenght() + " анкет");
        }
        if (requestCode==3)
        {
            super.onActivityResult(3, RESULT_OK, data);
            FList = (FormList) data.getSerializableExtra("class");
            final TextView T = (TextView) findViewById(R.id.textView2);
            T.setText("Всего в базе " + FList.getLenght() + " анкет");
        }
    }



}