package com.example.billsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    public TextView result;
    public Button buttonTen, buttonFifteen, buttonTwenty, buttonCalculate;
    public NumberFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formatter = NumberFormat.getCurrencyInstance();
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
        buttonTen = (Button) findViewById(R.id.tipTen);
        buttonFifteen = (Button) findViewById(R.id.tipTwenty);
        buttonTwenty = (Button) findViewById(R.id.tipTwenty);

        result = (TextView) findViewById(R.id.result);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(formatter.format(calculate(1.1)));
            }
        });
    }

    /**
     * Called when "Calculate" button is clicked
     *
     */
    public double calculate(double tip) {
        EditText editTextTotal = (EditText) findViewById(R.id.billTotal);
        EditText editTextSplit = (EditText) findViewById(R.id.splitBy);
        double totalAmount = Double.parseDouble(editTextTotal.getText().toString());
        double numSplit = Double.parseDouble(editTextSplit.getText().toString());
        double tipTotal = totalAmount * 1.1;
        return tipTotal / numSplit;
    }
}
