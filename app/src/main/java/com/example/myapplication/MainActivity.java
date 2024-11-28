package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtInput;
    private String input = "";
    private String operator = "";
    private double firstNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = findViewById(R.id.txtInput);

        View.OnClickListener numberClickListener = v -> {
            Button button = (Button) v;
            input += button.getText().toString();
            txtInput.setText(input);
        };

        View.OnClickListener operatorClickListener = v -> {
            Button button = (Button) v;
            if (!input.isEmpty()) {
                firstNum = Double.parseDouble(input);
                operator = button.getText().toString();
                input = "";
                txtInput.setText("");
            }
        };

        findViewById(R.id.btn0).setOnClickListener(numberClickListener);
        findViewById(R.id.btn1).setOnClickListener(numberClickListener);
        findViewById(R.id.btn2).setOnClickListener(numberClickListener);
        findViewById(R.id.btn3).setOnClickListener(numberClickListener);
        findViewById(R.id.btn4).setOnClickListener(numberClickListener);
        findViewById(R.id.btn5).setOnClickListener(numberClickListener);
        findViewById(R.id.btn6).setOnClickListener(numberClickListener);
        findViewById(R.id.btn7).setOnClickListener(numberClickListener);
        findViewById(R.id.btn8).setOnClickListener(numberClickListener);
        findViewById(R.id.btn9).setOnClickListener(numberClickListener);

        findViewById(R.id.btnAdd).setOnClickListener(operatorClickListener);
        findViewById(R.id.btnSubtract).setOnClickListener(operatorClickListener);
        findViewById(R.id.btnMultiply).setOnClickListener(operatorClickListener);
        findViewById(R.id.btnDivide).setOnClickListener(operatorClickListener);

        findViewById(R.id.btnEquals).setOnClickListener(v -> {
            if (!input.isEmpty() && !operator.isEmpty()) {
                double secondNum = Double.parseDouble(input);
                double result = 0;

                switch (operator) {
                    case "+":
                        result = firstNum + secondNum;
                        break;
                    case "-":
                        result = firstNum - secondNum;
                        break;
                    case "*":
                        result = firstNum * secondNum;
                        break;
                    case "/":
                        if (secondNum != 0) {
                            result = firstNum / secondNum;
                        } else {
                            txtInput.setText("Error");
                            return;
                        }
                        break;
                }

                txtInput.setText(String.valueOf(result));
                input = String.valueOf(result);
                operator = "";
            }
        });

        findViewById(R.id.btnClear).setOnClickListener(v -> {
            input = "";
            operator = "";
            firstNum = 0;
            txtInput.setText("");
        });
    }
}
