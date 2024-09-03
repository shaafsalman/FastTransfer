package com.example.fasttransfer.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fasttransfer.R;
import com.example.fasttransfer.Model.Receiver;

public class ReceiverDetailsActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPhone, editTextCountry, editTextAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_details);

        // Initialize views
        editTextName = findViewById(R.id.et_receiver_full_name);
        editTextEmail = findViewById(R.id.et_receiver_email);
        editTextPhone = findViewById(R.id.et_receiver_contact);
        editTextCountry = findViewById(R.id.et_receiver_country);
        editTextAddress = findViewById(R.id.et_receiver_address);
        Button buttonNext = findViewById(R.id.btn_next_receiver);

        // Set button click listener
        buttonNext.setOnClickListener(v -> {
            // Collect receiver details
            String name = editTextName.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String phone = editTextPhone.getText().toString().trim();
            String country = editTextCountry.getText().toString().trim();
            String address = editTextAddress.getText().toString().trim();

            // Create Receiver object
            Receiver receiver = new Receiver(name, email, phone, country, address);

            // Pass Receiver object to the next activity
            Intent intent = new Intent(ReceiverDetailsActivity.this, ReviewDetailsActivity.class);
            intent.putExtra("receiver", (CharSequence) receiver);
            startActivity(intent);
        });
    }
}
