package com.example.intcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn10;
    Button btn11;
    Button btn12;
    Button btn13;
    Button btn14;
    Button btn15;
    Button btn16;
    Button btn17;
    Button btn18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView T = (TextView) findViewById(R.id.textView);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn10 = (Button) findViewById(R.id.button10);
        btn11 = (Button) findViewById(R.id.button11);
        btn12 = (Button) findViewById(R.id.button12);
        btn13 = (Button) findViewById(R.id.button13);
        btn14 = (Button) findViewById(R.id.button14);
        btn15 = (Button) findViewById(R.id.button15);
        btn16 = (Button) findViewById(R.id.button16);
        btn17 = (Button) findViewById(R.id.button17);
        btn18 = (Button) findViewById(R.id.button18);
        Calculator Calc = new Calculator();
        btn1.setOnClickListener(new View.OnClickListener() { //отчистка
            @Override
            public void onClick(View v) {
                Calc.CleanStr();
                T.setText(null);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() { //удаление последнего
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action();
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action(true);
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() { //9
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action(9);
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() { //8
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action(8);
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() { //7
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action(7);
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() { //6
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action(6);
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() { //5
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action(5);
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() { //4
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action(4);
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() { //3
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action(3);
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() { //2
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action(2);
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() { //1
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action(1);
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() { //0
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action(0);
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() { //вычисление
            @Override
            public void onClick(View v) {
                T.setText(null);
                T.setText(Calc.getStr() +"=" + Calc.Calculate());
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() { //деление
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action('/');
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() { //умножение
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action('*');
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn17.setOnClickListener(new View.OnClickListener() { //вычитание
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action('-');
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
        btn18.setOnClickListener(new View.OnClickListener() { //сложение
            @Override
            public void onClick(View v) {
                T.setText(null);
                Action Act1 = new Action('+');
                Calc.AddAction(Act1);
                T.setText(Calc.getStr());
            }
        });
    }
}