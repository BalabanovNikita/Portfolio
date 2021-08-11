package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class AddForm extends AppCompatActivity {

    private String secondName;
    private String firstName;
    private String thridName;
    private int education;
    private int branchOfWork;
    private int expirienceOfWork;
    private int workPaid;
    private Boolean fullWork; // полная занятость
    private Boolean partialWork; // частичная занятость
    private Boolean timeToTimeWork; // разовая работа
    private Boolean internship; // стажировка
    private Boolean physicalLimitations; //физические ограничения
    private Boolean convictions; // судимости
    private String addInformation;
    Form newForm;
    Boolean cheked = false;
    Boolean cheked1 = false;
    Button backButton;
    Button saveButton;
    Button cancelButtlon;
    EditText textField1;
    EditText textField2;
    EditText textField3;
    EditText textField4;
    RadioGroup RadBut;
    Spinner spinner;
    SeekBar seekBar;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    ToggleButton toggleButton1;
    ToggleButton toggleButton2;
    TextView TextNumb;
    Switch enableSwitch;
    RadioButton RadioButton1;
    RadioButton RadioButton2;
    RadioButton RadioButton3;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);
        backButton = (Button) findViewById(R.id.button6);
        Intent i = getIntent();
        TextNumb = (TextView) findViewById(R.id.textView11);
        FormList inList = (FormList)i.getSerializableExtra("class");
        seekBar = (SeekBar)findViewById(R.id.seekBar3);
        RadBut = (RadioGroup) findViewById(R.id.RadioGroup1);
        RadioButton1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton3 = (RadioButton) findViewById(R.id.radioButton3);

        number = -1;
        number = (int)i.getIntExtra("number", -1);
        if (number!=-1)
        {
            textField1 = (EditText) findViewById(R.id.editTextTextPersonName);
            textField2 = (EditText) findViewById(R.id.editTextTextPersonName2);
            textField3 = (EditText) findViewById(R.id.editTextTextPersonName3);
            textField4 = (EditText) findViewById(R.id.editTextTextPersonName4);
            textField1.setText(inList.getFromByID(number).getSecondName());
            textField2.setText(inList.getFromByID(number).getFirstName());
            textField3.setText(inList.getFromByID(number).getThridName());
            textField4.setText(inList.getFromByID(number).getAddInformation());
            TextNumb.setText(String.valueOf(inList.getFromByID(number).getWorkPaid())+ " руб");
            seekBar.setProgress(inList.getFromByID(number).getWorkPaid());
            checkBox1 = (CheckBox) findViewById(R.id.checkBox2);
            checkBox2 = (CheckBox) findViewById(R.id.checkBox);
            checkBox3 = (CheckBox) findViewById(R.id.checkBox4);
            checkBox4 = (CheckBox) findViewById(R.id.checkBox3);
            checkBox1.setChecked(inList.getFromByID(number).getFullWork());
            checkBox2.setChecked(inList.getFromByID(number).getPartialWork());
            checkBox3.setChecked(inList.getFromByID(number).getTimeToTimeWork());
            checkBox4.setChecked(inList.getFromByID(number).getInternship());
            toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
            toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
            toggleButton1.setChecked(inList.getFromByID(number).getPhysicalLimitations());
            toggleButton2.setChecked(inList.getFromByID(number).getConvictions());

            if (inList.getFromByID(number).getEducation().getType() == 0) RadioButton1.setChecked(true);
            if (inList.getFromByID(number).getEducation().getType() == 1) RadioButton2.setChecked(true);
            if (inList.getFromByID(number).getEducation().getType() == 2) RadioButton3.setChecked(true);
            spinner = (Spinner)findViewById(R.id.spinner);
            spinner.setSelection(inList.getFromByID(number).getBranchOfWork().getType());
            spinner = (Spinner)findViewById(R.id.spinner2);
            spinner.setSelection(inList.getFromByID(number).getExpirienceOfWork().getType());
        }


        enableSwitch = (Switch)findViewById(R.id.switch1);
        cancelButtlon = (Button) findViewById(R.id.button5);
        saveButton = (Button) findViewById(R.id.button4);
        enableSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
                {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (saveButton.isEnabled()) {
                            saveButton.setEnabled(false);
                        }
                        else {
                            saveButton.setEnabled(true);
                        }
                    }
                }
        );

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //TextNumb.setText(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                TextNumb.setText(String.valueOf(seekBar.getProgress()) + " руб");
            }
        });
        cancelButtlon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textField1 = (EditText) findViewById(R.id.editTextTextPersonName);
                textField2 = (EditText) findViewById(R.id.editTextTextPersonName2);
                textField3 = (EditText) findViewById(R.id.editTextTextPersonName3);
                textField4 = (EditText) findViewById(R.id.editTextTextPersonName4);
                textField1.setText("Фамилия");
                textField2.setText("Имя");
                textField3.setText("Отчество");
                textField4.setText("Введите сюда дополнительную информацию");
                TextNumb.setText("0 руб");
                seekBar.setProgress(0);
                checkBox1 = (CheckBox) findViewById(R.id.checkBox2);
                checkBox2 = (CheckBox) findViewById(R.id.checkBox);
                checkBox3 = (CheckBox) findViewById(R.id.checkBox4);
                checkBox4 = (CheckBox) findViewById(R.id.checkBox3);
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                checkBox4.setChecked(false);
                toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
                toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
                toggleButton1.setChecked(false);
                toggleButton2.setChecked(false);
                RadioButton1.setChecked(true);
                spinner = (Spinner)findViewById(R.id.spinner);
                spinner.setSelection(0);
                spinner = (Spinner)findViewById(R.id.spinner2);
                spinner.setSelection(0);
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cheked) {
                    Intent intent = new Intent();
                    intent.putExtra("secondname", secondName);
                    intent.putExtra("firstName", firstName);
                    intent.putExtra("thridName", thridName);
                    intent.putExtra("education", education);
                    intent.putExtra("branchOfWork", branchOfWork);
                    intent.putExtra("expirienceOfWork", expirienceOfWork);
                    intent.putExtra("workPaid", workPaid);
                    intent.putExtra("fullWork", fullWork);
                    intent.putExtra("partialWork", partialWork);
                    intent.putExtra("timeToTimeWork", timeToTimeWork);
                    intent.putExtra("internship", internship);
                    intent.putExtra("physicalLimitations", physicalLimitations);
                    intent.putExtra("convictions", convictions);
                    intent.putExtra("addInformation", addInformation);


                    //String formSeri = newForm.toString();
                    //intent.putExtra("FormStr",formSeri);
                    //Form FRestored = (Form)formSeri;

                    //intent.putExtra("NewForm", newForm);
                    setResult(RESULT_OK, intent);
                }
                else
                {
                    if (cheked1)
                    {
                        Intent intent = new Intent();
                        intent.putExtra("class", inList);
                        setResult(RESULT_OK, intent);
                    }
                    else {
                        Intent intent = new Intent();
                        setResult(RESULT_CANCELED, intent);
                    }
                }
                finish();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textField1 = (EditText) findViewById(R.id.editTextTextPersonName);
                textField2 = (EditText) findViewById(R.id.editTextTextPersonName2);
                textField3 = (EditText) findViewById(R.id.editTextTextPersonName3);
                textField4 = (EditText) findViewById(R.id.editTextTextPersonName4);
                String SecondName = textField1.getText().toString();
                String FirstName = textField2.getText().toString();
                String ThirdName = textField3.getText().toString();
                String addStr = textField4.getText().toString();

                int y = 0;
                y = RadBut.getCheckedRadioButtonId();

                Education education1;
                if (y==RadioButton1.getId())
                {
                    education1 = Education.NotFullMiddle;
                    education = 0;
                }
                else
                {
                    if (y==RadioButton2.getId())
                    {
                        education1 = Education.Middle;
                        education = 1;
                    }
                    else
                    {
                        education1 = Education.High;
                        education = 2;
                    }
                }
                spinner = (Spinner)findViewById(R.id.spinner);
                int y1 = spinner.getSelectedItemPosition();
                branchOfWork = y1;
                BranchesOfWork branchOfWork1;
                if (y1==0)
                {
                    branchOfWork1 = BranchesOfWork.StateOrganization;
                }
                else
                {
                    if (y1==1)
                    {
                        branchOfWork1 = BranchesOfWork.EmergingIndustry;
                    }
                    else
                    {
                        if (y1==2)
                        {
                            branchOfWork1 = BranchesOfWork.IT;
                        }
                        else
                        {
                            branchOfWork1 = BranchesOfWork.Services;
                        }
                    }
                }
                spinner = (Spinner)findViewById(R.id.spinner2);
                int y2 = spinner.getSelectedItemPosition();
                expirienceOfWork = y2;
                ExpOfWork expirienceOfWork1;
                if (y2==0)
                {
                    expirienceOfWork1 = ExpOfWork.WitoutExp;
                }
                else
                {
                    if (y2==1)
                    {
                        expirienceOfWork1 = ExpOfWork.From1To3;
                    }
                    else
                    {
                        if (y2==2)
                        {
                            expirienceOfWork1 = ExpOfWork.From3To6;
                        }
                        else
                        {
                            expirienceOfWork1 = ExpOfWork.MoreThen6;
                        }
                    }
                }

                seekBar = (SeekBar)findViewById(R.id.seekBar3);
                checkBox1 = (CheckBox) findViewById(R.id.checkBox2);
                checkBox2 = (CheckBox) findViewById(R.id.checkBox);
                checkBox3 = (CheckBox) findViewById(R.id.checkBox4);
                checkBox4 = (CheckBox) findViewById(R.id.checkBox3);
                toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
                toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);

                secondName=SecondName;
                firstName=FirstName;
                thridName=ThirdName;
                branchOfWork = y1;
                expirienceOfWork = y2;
                workPaid=seekBar.getProgress();
                fullWork=checkBox1.isChecked(); // полная занятость
                partialWork=checkBox2.isChecked(); // частичная занятость
                timeToTimeWork=checkBox3.isChecked(); // разовая работа
                internship=checkBox4.isChecked(); // стажировка
                physicalLimitations=toggleButton1.isChecked(); //физические ограничения
                convictions=toggleButton2.isChecked(); // судимости
                addInformation=addStr;
                cheked = true;
                if (number !=-1) {
                    newForm = new Form(secondName, firstName, thridName, education1, branchOfWork1, expirienceOfWork1, workPaid, fullWork, partialWork,timeToTimeWork,
                            internship, physicalLimitations, convictions, addInformation);
                    inList.deleteForm(number);
                    inList.AddFormInID(newForm, number);
                    cheked1 = true;
                    cheked = false;
                }

            }
        });
    }
}