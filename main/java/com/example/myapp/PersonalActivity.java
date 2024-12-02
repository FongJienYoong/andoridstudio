package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PersonalActivity extends AppCompatActivity {

    private EditText etName, etIc, etAge;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        etName = findViewById(R.id.etName);
        etIc = findViewById(R.id.etIc);
        etAge = findViewById(R.id.etAge);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(v -> {
            // Validate inputs
            if (TextUtils.isEmpty(etName.getText()) || TextUtils.isEmpty(etIc.getText()) || TextUtils.isEmpty(etAge.getText())) {
                Toast.makeText(PersonalActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Pass data to SubscriptionActivity
                Intent intent = new Intent(PersonalActivity.this, SubscriptionActivity.class);
                intent.putExtra("name", etName.getText().toString());
                intent.putExtra("ic", etIc.getText().toString());
                intent.putExtra("age", etAge.getText().toString());
                startActivity(intent);
            }
        });
    }
}
