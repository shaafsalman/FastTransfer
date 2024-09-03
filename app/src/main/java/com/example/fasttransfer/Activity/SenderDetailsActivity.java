package com.example.fasttransfer.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fasttransfer.R;
import com.example.fasttransfer.Model.Sender;

public class SenderDetailsActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPhone, editTextCountry, editTextAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_details);

        // Initialize views
        editTextName = findViewById(R.id.et_sender_full_name);
        editTextEmail = findViewById(R.id.et_sender_email);
        editTextPhone = findViewById(R.id.et_sender_contact);
        editTextCountry = findViewById(R.id.et_sender_country);
        editTextAddress = findViewById(R.id.et_sender_address);
        Button buttonNext = findViewById(R.id.btn_next_sender);

        // Set button click listener
        buttonNext.setOnClickListener(v -> {
            // Collect sender details
            String name = editTextName.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String phone = editTextPhone.getText().toString().trim();
            String country = editTextCountry.getText().toString().trim();
            String address = editTextAddress.getText().toString().trim();

            // Create Sender object
            Sender sender = new Sender(name, email, phone, country, address);

            // Pass Sender object to the next activity
            Intent intent = new Intent(SenderDetailsActivity.this, ReceiverDetailsActivity.class);
            intent.putExtra("sender", (CharSequence) sender);
            startActivity(intent);
        });
    }
}
