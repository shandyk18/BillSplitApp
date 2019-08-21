package com.example.billsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * MainActivity holds the calculations for the splitting and tip of a given bill
 *
 */
public class MainActivity extends AppCompatActivity {

    // TextView display of amoutn each person pays
    public TextView result;
    public Button buttonTen, buttonFifteen, buttonTwenty, buttonCalculate;
    // Formats to dollar currency
    public NumberFormat formatter;
    public double tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formatter = NumberFormat.getCurrencyInstance();
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
        buttonTen = (Button) findViewById(R.id.tipTen);
        buttonFifteen = (Button) findViewById(R.id.tipFifteen);
        buttonTwenty = (Button) findViewById(R.id.tipTwenty);
        tip = 1.0;

        result = (TextView) findViewById(R.id.result);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(formatter.format(calculate()));
            }
        });

        buttonTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tip = 1.1;
            }
        });

        buttonFifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tip = 1.15;
            }
        });

        buttonTwenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tip = 1.2;
            }
        });
    }

    /**
     * When "Calculate" button is clicked, the result is calculated
     *
     */
    public double calculate() {
        EditText editTextTotal = (EditText) findViewById(R.id.billTotal);
        EditText editTextSplit = (EditText) findViewById(R.id.splitBy);
        double totalAmount = Double.parseDouble(editTextTotal.getText().toString());
        double numSplit = Double.parseDouble(editTextSplit.getText().toString());
        double tipTotal = totalAmount * tip;
        return tipTotal / numSplit;
    }
}
