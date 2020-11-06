package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText text_a, text_b, text_c;
    private TextView result;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_a = findViewById(R.id.obj_a);
                text_b = findViewById(R.id.obj_b);
                text_c = findViewById(R.id.obj_c);
                result = findViewById(R.id.resultat);
                String str_a = text_a.getText().toString();
                String str_b = text_b.getText().toString();
                String str_c = text_c.getText().toString();
                double a = 0, b = 0, c = 0, d;

                try{
                    a = Double.parseDouble(str_a);
                    b = Double.parseDouble(str_b);
                    c = Double.parseDouble(str_c);
                d = b * b - 4 * a * c;
                if (d < 0){
                    result.setText("Нет корней");
                }
                if (d == 0){
                    double x = (-1 * b)/(2 * a);
                    result.setText("x = " + x);
                }
                if (d > 0){
                    double x1 = (-1 * b + Math.sqrt(d))/(2 * a);
                    double x2 = (-1 * b - Math.sqrt(d))/(2 * a);
                    result.setText("x1 = " + x1 + "; x2 = " + x2);
                }
                } catch (Exception e) {
                    result.setText("Ошибка, вы ввели строку");
                }

                text_a.setText("");
                text_b.setText("");
                text_c.setText("");
            }
        });
    }
}