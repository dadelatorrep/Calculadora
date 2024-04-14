package com.dadelatorrep.calculadora;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextOperand1, editTextOperand2;
    TextView textViewResult;
    Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextOperand1 = findViewById(R.id.editTextOperand1);
        editTextOperand2 = findViewById(R.id.editTextOperand2);
        textViewResult = findViewById(R.id.textViewResult);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double number1 = Double.parseDouble(editTextOperand1.getText().toString());
        double number2 = Double.parseDouble(editTextOperand2.getText().toString());
        double result = 0;

        int id = v.getId();


        // Verificar qué botón se ha presionado
        if (v.getId() == R.id.buttonAdd) {
            result = number1 + number2;
        } else if (v.getId() == R.id.buttonSubtract) {
            result = number1 - number2;
        } else if (v.getId() == R.id.buttonMultiply) {
            result = number1 * number2;
        } else if (v.getId() == R.id.buttonDivide) {
            if (number2 != 0) {
                result = number1 / number2;
            } else {
                textViewResult.setText("Error: Division para cero");
                return;
            }
        }

        textViewResult.setText(String.valueOf(result));
    }
}
