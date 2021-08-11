package com.example.lab2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btn1;
    Button btn2;
    Button btn3;
    SIZES ButtonSize1;
    SIZES ButtonSize2;
    SIZES ButtonSize3;
    String textStr;
    double num=0;
    EditText textField;
    Unit inUnit;
    Unit outUnit;
    SIZES inSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView T = (TextView) findViewById(R.id.textView2);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        final UnitConverter Uc = new UnitConverter();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Uc.Convert(inUnit, ButtonSize1)!=null) {
                    outUnit = Uc.Convert(inUnit, ButtonSize1);
                    String St = Double.toString(outUnit.getNumber());
                    T.setText(num + " " + inUnit.getSize().getTitle() + " = " + St + " " + ButtonSize1.getTitle());
                }
                else
                {
                    T.setText("Ошибка! Вы ввели некорректные данные!");
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Uc.Convert(inUnit, ButtonSize2)!=null) {
                    outUnit = Uc.Convert(inUnit, ButtonSize2);
                    String St = Double.toString(outUnit.getNumber());
                    T.setText(num + " " + inUnit.getSize().getTitle() + " = " + St + " " + ButtonSize2.getTitle());
                }
                else
                {
                    T.setText("Ошибка! Вы ввели некорректные данные!");
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Uc.Convert(inUnit, ButtonSize3)!=null) {
                    outUnit = Uc.Convert(inUnit, ButtonSize3);
                    String St = Double.toString(outUnit.getNumber());
                    T.setText(num + " " + inUnit.getSize().getTitle() + " = " + St + " " + ButtonSize3.getTitle());
                }
                else
                {
                    T.setText("Ошибка! Вы ввели некорректные данные!");
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                }
            }
        });

        textField = (EditText) findViewById(R.id.editTextTextPersonName);

        textField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Str = textField.getText().toString().trim().toLowerCase();
                if ((Str.indexOf(" ")!= -1) && (Str.length() != 0)) {
                    textStr = Str.substring(0, Str.indexOf(" "));
                    num = Double.parseDouble(textStr);

                    //Toast.makeText(MainActivity.this, Str, Toast.LENGTH_SHORT).show();
                    if ((Str.indexOf(SIZES.METER.getShortTitle()) != -1) || (Str.indexOf(SIZES.INCH.getShortTitle()) != -1) || (Str.indexOf(SIZES.FOOT.getShortTitle()) != -1) || (Str.indexOf(SIZES.YARD.getShortTitle()) != -1)) {
                        if (Str.indexOf(SIZES.METER.getShortTitle()) != -1) {
                            btn1.setText(SIZES.INCH.getButtonTitle());
                            btn2.setText(SIZES.FOOT.getButtonTitle());
                            btn3.setText(SIZES.YARD.getButtonTitle());
                            ButtonSize1 = SIZES.INCH;
                            ButtonSize2 = SIZES.FOOT;
                            ButtonSize3 = SIZES.YARD;
                            inSize = SIZES.METER;
                        } else {
                            if (Str.indexOf(SIZES.INCH.getShortTitle()) != -1) {
                                btn1.setText(SIZES.METER.getButtonTitle());
                                btn2.setText(SIZES.FOOT.getButtonTitle());
                                btn3.setText(SIZES.YARD.getButtonTitle());
                                ButtonSize1 = SIZES.METER;
                                ButtonSize2 = SIZES.FOOT;
                                ButtonSize3 = SIZES.YARD;
                                inSize = SIZES.INCH;

                            } else {
                                if (Str.indexOf(SIZES.FOOT.getShortTitle()) != -1) {
                                    btn1.setText(SIZES.INCH.getButtonTitle());
                                    btn2.setText(SIZES.METER.getButtonTitle());
                                    btn3.setText(SIZES.YARD.getButtonTitle());
                                    ButtonSize1 = SIZES.INCH;
                                    ButtonSize2 = SIZES.METER;
                                    ButtonSize3 = SIZES.YARD;
                                    inSize = SIZES.FOOT;
                                } else {
                                    if (Str.indexOf(SIZES.YARD.getShortTitle()) != -1) {
                                        btn1.setText(SIZES.INCH.getButtonTitle());
                                        btn2.setText(SIZES.FOOT.getButtonTitle());
                                        btn3.setText(SIZES.METER.getButtonTitle());
                                        ButtonSize1 = SIZES.INCH;
                                        ButtonSize2 = SIZES.FOOT;
                                        ButtonSize3 = SIZES.METER;
                                        inSize = SIZES.YARD;
                                    }
                                }
                            }
                        }

                    }


                    if ((Str.indexOf(SIZES.KILOGR.getShortTitle()) != -1) || (Str.indexOf(SIZES.FUNT.getShortTitle()) != -1) || (Str.indexOf(SIZES.OZT.getShortTitle()) != -1) || (Str.indexOf(SIZES.STOUNE.getShortTitle()) != -1)) {
                        if (Str.indexOf(SIZES.KILOGR.getShortTitle()) != -1) {
                            btn1.setText(SIZES.FUNT.getButtonTitle());
                            btn2.setText(SIZES.OZT.getButtonTitle());
                            btn3.setText(SIZES.STOUNE.getButtonTitle());
                            ButtonSize1 = SIZES.FUNT;
                            ButtonSize2 = SIZES.OZT;
                            ButtonSize3 = SIZES.STOUNE;
                            inSize = SIZES.KILOGR;
                        } else {
                            if (Str.indexOf(SIZES.FUNT.getShortTitle()) != -1) {
                                btn1.setText(SIZES.KILOGR.getButtonTitle());
                                btn2.setText(SIZES.OZT.getButtonTitle());
                                btn3.setText(SIZES.STOUNE.getButtonTitle());
                                ButtonSize1 = SIZES.KILOGR;
                                ButtonSize2 = SIZES.OZT;
                                ButtonSize3 = SIZES.STOUNE;
                                inSize = SIZES.FUNT;
                            } else {
                                if (Str.indexOf(SIZES.OZT.getShortTitle()) != -1) {
                                    btn1.setText(SIZES.FUNT.getButtonTitle());
                                    btn2.setText(SIZES.KILOGR.getButtonTitle());
                                    btn3.setText(SIZES.STOUNE.getButtonTitle());
                                    ButtonSize1 = SIZES.FUNT;
                                    ButtonSize2 = SIZES.KILOGR;
                                    ButtonSize3 = SIZES.STOUNE;
                                    inSize = SIZES.OZT;
                                } else {
                                    if (Str.indexOf(SIZES.STOUNE.getShortTitle()) != -1) {
                                        btn1.setText(SIZES.FUNT.getButtonTitle());
                                        btn2.setText(SIZES.OZT.getButtonTitle());
                                        btn3.setText(SIZES.KILOGR.getButtonTitle());
                                        ButtonSize1 = SIZES.FUNT;
                                        ButtonSize2 = SIZES.OZT;
                                        ButtonSize3 = SIZES.KILOGR;
                                        inSize = SIZES.STOUNE;
                                    }
                                }
                            }
                        }

                    }

                    if ((Str.indexOf(SIZES.LITRA.getShortTitle()) != -1) || (Str.indexOf(SIZES.GALLON.getShortTitle()) != -1) || (Str.indexOf(SIZES.QUART.getShortTitle()) != -1) || (Str.indexOf(SIZES.PINT.getShortTitle()) != -1)) {
                        if (Str.indexOf(SIZES.LITRA.getShortTitle()) != -1) {
                            btn1.setText(SIZES.GALLON.getButtonTitle());
                            btn2.setText(SIZES.QUART.getButtonTitle());
                            btn3.setText(SIZES.PINT.getButtonTitle());
                            ButtonSize1 = SIZES.GALLON;
                            ButtonSize2 = SIZES.QUART;
                            ButtonSize3 = SIZES.PINT;
                            inSize = SIZES.LITRA;
                        } else {
                            if (Str.indexOf(SIZES.GALLON.getShortTitle()) != -1) {
                                btn1.setText(SIZES.LITRA.getButtonTitle());
                                btn2.setText(SIZES.QUART.getButtonTitle());
                                btn3.setText(SIZES.PINT.getButtonTitle());
                                ButtonSize1 = SIZES.LITRA;
                                ButtonSize2 = SIZES.QUART;
                                ButtonSize3 = SIZES.PINT;
                                inSize = SIZES.GALLON;
                            } else {
                                if (Str.indexOf(SIZES.QUART.getShortTitle()) != -1) {
                                    btn1.setText(SIZES.GALLON.getButtonTitle());
                                    btn2.setText(SIZES.LITRA.getButtonTitle());
                                    btn3.setText(SIZES.PINT.getButtonTitle());
                                    ButtonSize1 = SIZES.GALLON;
                                    ButtonSize2 = SIZES.LITRA;
                                    ButtonSize3 = SIZES.PINT;
                                    inSize = SIZES.QUART;
                                } else {
                                    if (Str.indexOf(SIZES.PINT.getShortTitle()) != -1) {
                                        btn1.setText(SIZES.GALLON.getButtonTitle());
                                        btn2.setText(SIZES.QUART.getButtonTitle());
                                        btn3.setText(SIZES.LITRA.getButtonTitle());
                                        ButtonSize1 = SIZES.GALLON;
                                        ButtonSize2 = SIZES.QUART;
                                        ButtonSize3 = SIZES.LITRA;
                                        inSize = SIZES.PINT;
                                    }
                                }
                            }
                        }

                    }
                    inUnit = new Unit(inSize, num);
                    btn1.setEnabled(true);
                    btn2.setEnabled(true);
                    btn3.setEnabled(true);
                }
                else
                {
                    T.setText("Ошибка! Вы ввели некорректные данные!");
                    btn1.setEnabled(false);
                    btn2.setEnabled(false);
                    btn3.setEnabled(false);
                }
            }
        });

    }



    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "WHAT!", Toast.LENGTH_SHORT).show();
    }
}