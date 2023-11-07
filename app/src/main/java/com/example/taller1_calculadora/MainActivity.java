package com.example.taller1_calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private double firstOperand = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
    }

    public void onNumberClick(View view) {
        if (isOperatorClicked) {
            display.setText(((Button) view).getText());
            isOperatorClicked = false;
        } else {
            display.append(((Button) view).getText());
        }
    }

    public void onOperatorClick(View view) {
        firstOperand = Double.parseDouble(display.getText().toString());
        operator = ((Button) view).getText().toString();
        isOperatorClicked = true;
    }

    public void onEqualClick(View view) {
        double secondOperand = Double.parseDouble(display.getText().toString());
        double result = 0;

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                result = firstOperand / secondOperand;
                break;
        }

        display.setText(String.valueOf(result));
    }

    public void onClearClick(View view) {
        display.setText("0");
        firstOperand = 0;
        operator = "";
        isOperatorClicked = false;
    }
}