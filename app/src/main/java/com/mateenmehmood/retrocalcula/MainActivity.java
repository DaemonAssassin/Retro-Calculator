package com.mateenmehmood.retrocalcula;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textDisplay, operatorDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDisplay = findViewById(R.id.textView);
        operatorDisplay = findViewById(R.id.operator_text_view);
    }


    /** Creating helping variables **/
    boolean isNewOperator = true;
    char operator;
    String oldText = "";


    public void clearBtn (View view) {
        textDisplay.setText("0");
        operatorDisplay.setText("");
        isNewOperator = true;
    }


    /*** All buttons onClick methods ***/
    public void zeroBtn (View view) {
        displayText(getString(R.string.zero_btn));
    }
    public void oneBtn (View view) {
        displayText(getString(R.string.one_btn));
    }
    public void twoBtn (View view) {
        displayText(getString(R.string.two_btn));
    }
    public void threeBtn (View view) {
        displayText(getString(R.string.three_btn));
    }
    public void fourBtn (View view) {
        displayText(getString(R.string.four_btn));
    }
    public void fiveBtn (View view) {
        displayText(getString(R.string.five_btn));
    }
    public void sixBtn (View view) {
        displayText(getString(R.string.six_btn));
    }
    public void sevenBtn (View view) {
        displayText(getString(R.string.seven_btn));
    }
    public void eightBtn (View view) {
        displayText(getString(R.string.eight_btn));
    }
    public void nineBtn (View view) {
        displayText(getString(R.string.nine_btn));
    }
    public void dotBtn (View view) {
        displayText(getString(R.string.dot_btn));
    }




    /*** All operators onClick methods ***/
    public void backspaceBtn (View view) {
        String oldString = textDisplay.getText().toString();
        if (oldString.length() != 0) {
            String newString = oldString.substring(0,oldString.length()-1);
            textDisplay.setText(newString);
        }
    }

    @SuppressLint("SetTextI18n")
    public void plusMinusBtn (View view) {
        oldText = textDisplay.getText().toString();
        textDisplay.setText("-" + oldText);
    }

    public void divideBtn (View view) {
        operatorDisplay.setText(getString(R.string.divide_btn));

        //getting String as char
        operator = '/';

        //getting oldText
        oldText = textDisplay.getText().toString();

        isNewOperator = true;
    }

    public void multiplyBtn (View view) {
        operatorDisplay.setText(getString(R.string.multiply_btn));

        //getting String as char
        operator = '*';

        //getting oldText
        oldText = textDisplay.getText().toString();

        isNewOperator = true;
    }

    public void minusBtn (View view) {
        operatorDisplay.setText(getString(R.string.minus_btn));

        //getting String as char
        operator = getString(R.string.minus_btn).charAt(0);

        //getting oldText
        oldText = textDisplay.getText().toString();

        isNewOperator = true;
    }

    public void addBtn (View view) {
        operatorDisplay.setText(getString(R.string.add_btn));

        //getting String as char
        operator = getString(R.string.add_btn).charAt(0);

        //getting oldText
        oldText = textDisplay.getText().toString();

        isNewOperator = true;
    }

    public void equalBtn (View view) {
        operatorDisplay.setText(getString(R.string.equal_btn));
        calculateResult();
    }

    //method to calculate result
    @SuppressLint("SetTextI18n")
    public void calculateResult () {
        //getting new string
        String newText = textDisplay.getText().toString();
        //creating result variable
        double result;

        //switch to check which operation should we have to perform
        switch (operator) {
            case '+':
                result = Float.parseFloat(oldText) + Float.parseFloat(newText);
                textDisplay.setText("" + result);
                break;
            case '-':
                result = Float.parseFloat(oldText) - Float.parseFloat(newText);
                textDisplay.setText("" + result);
                break;
            case '/':
                result = Float.parseFloat(oldText) / Float.parseFloat(newText);
                textDisplay.setText("" + result);
                break;
            case '*':
                result = Float.parseFloat(oldText) * Float.parseFloat(newText);
                textDisplay.setText("" + result);
                break;
        }
    }

    //creating display Text method
    @SuppressLint("SetTextI18n")
    public void displayText (String stringToAdd) {

        //condition to check that the operator is new
        if (isNewOperator) {
            textDisplay.setText("");
            isNewOperator = false;
        }

        //getting old text
        String oldString = textDisplay.getText().toString();

        //updating text
        textDisplay.setText(oldString + stringToAdd);
    }

}