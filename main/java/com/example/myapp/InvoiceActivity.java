package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class InvoiceActivity extends AppCompatActivity {

    private TextView tvInvoiceDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        tvInvoiceDetails = findViewById(R.id.tvInvoiceDetails);

        // Get data from previous activity
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String ic = intent.getStringExtra("ic");
        String age = intent.getStringExtra("age");
        String selectedPlan = intent.getStringExtra("selectedPlan");
        double finalPrice = intent.getDoubleExtra("finalPrice", 0);
        double discountAmount = intent.getDoubleExtra("discountAmount", 0);

        // Prepare invoice details
        String invoiceDetails = "Name: " + name + "\n" +
                "IC: " + ic + "\n" +
                "Age: " + age + "\n" +
                "Plan: " + selectedPlan + "\n" +
                "Discount Amount: RM " + discountAmount + "\n" +
                "Total Price: RM " + finalPrice;

        tvInvoiceDetails.setText(invoiceDetails);
    }
}
