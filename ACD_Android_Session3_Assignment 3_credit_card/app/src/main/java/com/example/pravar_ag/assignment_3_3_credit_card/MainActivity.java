package com.example.pravar_ag.assignment_3_3_credit_card;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    EditText etCard_balance, etInterest_rate, etMinimum_payment, etFinal_card_balance, etMonths_remaining, etInterest_paid;

    Button compute, clear_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etCard_balance=(EditText)findViewById(R.id.et_card_balance);
        etInterest_rate=(EditText)findViewById(R.id.et_interest_rate);
        etMinimum_payment=(EditText)findViewById(R.id.et_minimum_payment);
        etFinal_card_balance=(EditText)findViewById(R.id.et_finalCard_balance);
        etMonths_remaining=(EditText)findViewById(R.id.et_months_remaining);
        etInterest_paid=(EditText)findViewById(R.id.et_interest_paid);
        compute=(Button)findViewById(R.id.button_Compute);
        clear_text = (Button)findViewById(R.id.button_Clear);




        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                double balance = Double.parseDouble(etCard_balance.getText().toString());
                double rate = Double.parseDouble(etInterest_rate.getText().toString());

                double mFltIntPaid = Math.round((balance * (rate / (100 * 12))));

                double minimum_payment = Double.parseDouble(etMinimum_payment.getText().toString());

                double monthlyPrinciple = minimum_payment - mFltIntPaid;
                double monthlyBalance = balance - monthlyPrinciple;

                etFinal_card_balance.setText(Double.toString(monthlyBalance));
                etMonths_remaining.setText(null);
                etInterest_paid.setText(Double.toString(mFltIntPaid));


            }

        });

        clear_text.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                etCard_balance.setText(null);
                etInterest_rate.setText(null);
                etMinimum_payment.setText(null);
                etFinal_card_balance.setText(null);
                etMonths_remaining.setText(null);
                etInterest_paid.setText(null);
            }
        });





    }










}
