package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SubscriptionActivity extends AppCompatActivity {

    private RadioGroup radioGroupPlans;
    private EditText etDiscountCode;
    private Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);

        radioGroupPlans = findViewById(R.id.radioGroupPlans);
        etDiscountCode = findViewById(R.id.etDiscountCode);
        btnProceed = findViewById(R.id.btnProceed);

        btnProceed.setOnClickListener(v -> {
            int selectedPlanId = radioGroupPlans.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedPlanId);

            String plan = selectedRadioButton != null ? selectedRadioButton.getText().toString() : null;
            String discountCode = etDiscountCode.getText().toString();
            double finalPrice = 0;
            double discountAmount = 0;

            if (plan == null) {
                Toast.makeText(SubscriptionActivity.this, "Please select a plan", Toast.LENGTH_SHORT).show();
            } else {
                // Plan prices
                if (plan.equals("Plan A - RM10")) {
                    finalPrice = 10;
                } else if (plan.equals("Plan B - RM20")) {
                    finalPrice = 20;
                } else if (plan.equals("Plan C - RM30")) {
                    finalPrice = 30;
                }

                // Apply discount if valid code
                if (!TextUtils.isEmpty(discountCode) && discountCode.equals("FONG")) {
                    discountAmount = finalPrice * 0.1; // 10% discount
                    finalPrice -= discountAmount;
                }

                // Pass data to InvoiceActivity
                Intent intent = new Intent(SubscriptionActivity.this, InvoiceActivity.class);
                intent.putExtra("name", getIntent().getStringExtra("name"));
                intent.putExtra("ic", getIntent().getStringExtra("ic"));
                intent.putExtra("age", getIntent().getStringExtra("age"));
                intent.putExtra("selectedPlan", plan);
                intent.putExtra("finalPrice", finalPrice);
                intent.putExtra("discountAmount", discountAmount);  // Pass the discount amount
                startActivity(intent);
            }
        });
    }
}
