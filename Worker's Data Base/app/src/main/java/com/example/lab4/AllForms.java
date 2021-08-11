package com.example.lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class AllForms extends AppCompatActivity {
    TextView T;
    Button backButton;
    Button deleatButton;
    Button updateButton;
    Spinner sp;
    TextView Text1;
    TextView Text2;
    TextView Text3;
    TextView Text4;
    TextView Text5;
    TextView Text6;
    TextView Text7;
    TextView Text8;
    TextView Text9;
    FormList Flist;
    ArrayList<String> FIO;
    int numb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_forms);
        backButton = (Button) findViewById(R.id.button11);
        deleatButton = (Button) findViewById(R.id.button9);
        updateButton = (Button) findViewById(R.id.button10);
        T= (TextView) findViewById(R.id.textView19);

        sp = (Spinner) findViewById(R.id.spinner3);

        Flist = (FormList) getIntent().getSerializableExtra("class");
        String st = Integer.toString(Flist.getLenght());
        Text1 = (TextView) findViewById(R.id.textView19);
        Text2 = (TextView) findViewById(R.id.textView21);
        Text3 = (TextView) findViewById(R.id.textView22);
        Text4 = (TextView) findViewById(R.id.textView23);
        Text5 = (TextView) findViewById(R.id.textView24);
        Text6 = (TextView) findViewById(R.id.textView25);
        Text7 = (TextView) findViewById(R.id.textView26);
        Text8 = (TextView) findViewById(R.id.textView27);
        Text9 = (TextView) findViewById(R.id.textView28);



        FIO = new ArrayList<>();
        for (int i = 0; i<Flist.getLenght(); i++)
        {
            FIO.add(Flist.getFromByID(i).getSecondName() + " " + Flist.getFromByID(i).getFirstName() + " " + Flist.getFromByID(i).getThridName());
        }
        ArrayAdapter<String> spinnerCount = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, FIO);
        sp.setAdapter(spinnerCount);
        numb = 0;
        sp.setSelection(numb);
        Text1.setText(Flist.getFromByID(numb).getSecondName() + " " + Flist.getFromByID(numb).getFirstName() + " " + Flist.getFromByID(numb).getThridName());
        Text2.setText(getString(R.string.Education) + Flist.getFromByID(numb).getEducation().getTitle());
        Text3.setText(getString(R.string.Branche) + Flist.getFromByID(numb).getBranchOfWork().getTitle());
        Text4.setText(getString(R.string.wishedWorkpay) + Flist.getFromByID(numb).getWorkPaid() + " руб");
        Text5.setText(getString(R.string.Exp) + Flist.getFromByID(numb).getExpirienceOfWork().getTitle());
        Text6.setText(getString(R.string.typeOfWork) + Flist.getFromByID(numb).getTypesOfWork() );
        if (!Flist.getFromByID(numb).getPhysicalLimitations()) Text7.setText( getString(R.string.toggleButn1Off));
        else Text7.setText(getString(R.string.toggleButn1On));
        if (!Flist.getFromByID(numb).getConvictions()) Text8.setText(getString(R.string.toggleButn2Off));
        else Text8.setText(getString(R.string.toggleButn2On));
        Text9.setText(getString(R.string.addInf) + Flist.getFromByID(numb).getAddInformation() );



        T.setText("Номер анкеты: " + numb);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("class", Flist);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllForms.this, AddForm.class);

                intent.putExtra("class", Flist);
                intent.putExtra("number", numb);
                startActivityForResult(intent, 2);
            }
        });





        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                T.setText(getString(R.string.numberOfForm) + position);
                numb = position;
                Text1.setText(Flist.getFromByID(numb).getSecondName() + " " + Flist.getFromByID(numb).getFirstName() + " " + Flist.getFromByID(numb).getThridName());
                Text2.setText(getString(R.string.Education) + Flist.getFromByID(numb).getEducation().getTitle());
                Text3.setText(getString(R.string.Branche) + Flist.getFromByID(numb).getBranchOfWork().getTitle());
                Text4.setText(getString(R.string.wishedWorkpay) + Flist.getFromByID(numb).getWorkPaid() + " руб");
                Text5.setText(getString(R.string.Exp) + Flist.getFromByID(numb).getExpirienceOfWork().getTitle());
                Text6.setText(getString(R.string.typeOfWork) + Flist.getFromByID(numb).getTypesOfWork() );
                if (!Flist.getFromByID(numb).getPhysicalLimitations()) Text7.setText( getString(R.string.toggleButn1Off));
                else Text7.setText(getString(R.string.toggleButn1On));
                if (!Flist.getFromByID(numb).getConvictions()) Text8.setText(getString(R.string.toggleButn2Off));
                else Text8.setText(getString(R.string.toggleButn2On));
                Text9.setText(getString(R.string.addInf) + Flist.getFromByID(numb).getAddInformation() );
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        deleatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Flist.deleteForm(numb);
                numb = 0;
                FIO = new ArrayList<>();
                for (int i = 0; i<Flist.getLenght(); i++)
                {
                    FIO.add(Flist.getFromByID(i).getSecondName() + " " + Flist.getFromByID(i).getFirstName() + " " + Flist.getFromByID(i).getThridName());
                }
                ArrayAdapter<String> spinnerCount = new ArrayAdapter<String>(AllForms.this, android.R.layout.simple_spinner_dropdown_item, FIO);
                sp.setAdapter(spinnerCount);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(2, RESULT_OK, data);
        Flist = (FormList) data.getSerializableExtra("class");
        FIO = new ArrayList<>();
        for (int i = 0; i<Flist.getLenght(); i++)
        {
            FIO.add(Flist.getFromByID(i).getSecondName() + " " + Flist.getFromByID(i).getFirstName() + " " + Flist.getFromByID(i).getThridName());
        }
        ArrayAdapter<String> spinnerCount = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, FIO);
        sp.setAdapter(spinnerCount);
        numb = 0;
        sp.setSelection(numb);
        Text1.setText(Flist.getFromByID(numb).getSecondName() + " " + Flist.getFromByID(numb).getFirstName() + " " + Flist.getFromByID(numb).getThridName());
        Text2.setText(getString(R.string.Education) + Flist.getFromByID(numb).getEducation().getTitle());
        Text3.setText(getString(R.string.Branche) + Flist.getFromByID(numb).getBranchOfWork().getTitle());
        Text4.setText(getString(R.string.wishedWorkpay) + Flist.getFromByID(numb).getWorkPaid() + " руб");
        Text5.setText(getString(R.string.Exp) + Flist.getFromByID(numb).getExpirienceOfWork().getTitle());
        Text6.setText(getString(R.string.typeOfWork) + Flist.getFromByID(numb).getTypesOfWork() );
        if (!Flist.getFromByID(numb).getPhysicalLimitations()) Text7.setText( getString(R.string.toggleButn1Off));
        else Text7.setText(getString(R.string.toggleButn1On));
        if (!Flist.getFromByID(numb).getConvictions()) Text8.setText(getString(R.string.toggleButn2Off));
        else Text8.setText(getString(R.string.toggleButn2On));
        Text9.setText(getString(R.string.addInf) + Flist.getFromByID(numb).getAddInformation() );



        T.setText(getString(R.string.numberOfForm) + numb);


    }
}