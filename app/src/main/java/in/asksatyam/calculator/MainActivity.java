package in.asksatyam.calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Context;




public class MainActivity extends AppCompatActivity {

    ImageView btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0;
    ImageView btn_dot,btn_ac,btn_equal,btn_minus,btn_plus,btn_multiplication,btn_start_bracket,btn_end_bracket,btn_divide,btn_module;
    TextView inputTxt, TxtOutput;
    String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputTxt=findViewById(R.id.inputTxt);
        TxtOutput=findViewById(R.id.TxtOutput);

        btn_0=findViewById(R.id.btn_0);
        btn_1=findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        btn_3=findViewById(R.id.btn_3);
        btn_4=findViewById(R.id.btn_4);
        btn_5=findViewById(R.id.btn_5);
        btn_6=findViewById(R.id.btn_6);
        btn_7=findViewById(R.id.btn_7);
        btn_8=findViewById(R.id.btn_8);
        btn_9=findViewById(R.id.btn_9);

        btn_dot=findViewById(R.id.btn_dot);
        btn_ac=findViewById(R.id.btn_ac);
        btn_equal=findViewById(R.id.btn_equal);
        btn_minus=findViewById(R.id.btn_minus);
        btn_plus=findViewById(R.id.btn_plus);
        btn_multiplication=findViewById(R.id.btn_multiplication);
        btn_start_bracket=findViewById(R.id.btn_start_bracket);
        btn_divide=findViewById(R.id.btn_divide);
        btn_module=findViewById(R.id.btn_module);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"1");
            }
        });


        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"2");
            }
        });


        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"3");
            }
        });


        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"4");
            }
        });


        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"5");
            }
        });


        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"6");
            }
        });


        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"7");
            }
        });


        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"9");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+".");
            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputTxt.setText("");
                TxtOutput.setText("");
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"+");
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"-");
            }
        });

        btn_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"×");
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"÷");
            }
        });

        btn_module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                inputTxt.setText(data+"%");


            }
        });


        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=inputTxt.getText().toString();
                data=data.replaceAll("×","*");
                data=data.replaceAll("÷","/");
                data=data.replaceAll("%","/100");

                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable=rhino.initStandardObjects();
                    finalResult=rhino.evaluateString(scriptable,data,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="0";
                }
                TxtOutput.setText(finalResult);


            }
        });



    }
}