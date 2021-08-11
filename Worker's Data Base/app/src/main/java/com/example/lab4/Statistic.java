package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Statistic extends AppCompatActivity {

    TextView Text1;
    TextView Text2;
    TextView Text3;
    TextView Text4;
    TextView Text5;
    TextView Text6;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);


        Bundle arguments = getIntent().getExtras();

        String count = arguments.get("FormCount").toString();
        String education = arguments.get("education").toString();
        String BranchOfWork = arguments.get("BranchOfWork").toString();
        String Expirience = arguments.get("Expirience").toString();
        String WorkPay = arguments.get("WorkPay").toString();
        String TypeOfWork = arguments.get("TypeOfWork").toString();
        Text1 = (TextView) findViewById(R.id.textView13);
        Text2 = (TextView) findViewById(R.id.textView14);
        Text3 = (TextView) findViewById(R.id.textView15);
        Text4 = (TextView) findViewById(R.id.textView16);
        Text5 = (TextView) findViewById(R.id.textView17);
        Text6 = (TextView) findViewById(R.id.textView18);

        if (count.equals("0") )
        {
            Text1.setText("Всего в базе анкет: " + count);
            Text2.setText("Чаще всего соискатели имеют образоввание: Нет данных");
            Text3.setText("Наиболее востребованная область: Нет данных");
            Text4.setText("Чаще всего встречабщийся опыт: Нет данных");
            Text5.setText("Средний ожидаемый уровень зарплаты: Нет данных");
            Text6.setText("Наиболее желаемый тип занятости: Нет данных");
        }
        else
        {
            Text1.setText("Всего в базе анкет: " + count);
            Text2.setText("Чаще всего соискатели имеют образоввание: " + education);
            Text3.setText("Наиболее востребованная область: " + BranchOfWork);
            Text4.setText("Чаще всего встречабщийся опыт: " + Expirience);
            Text5.setText("Средний ожидаемый уровень зарплаты: " + WorkPay + " руб");
            Text6.setText("Наиболее желаемый тип занятости: " + TypeOfWork);
        }


        backButton = (Button) findViewById(R.id.button7);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                finish();
            }
        });


    }

}