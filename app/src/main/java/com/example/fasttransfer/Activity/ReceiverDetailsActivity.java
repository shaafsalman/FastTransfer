package com.example.fasttransfer.Activity;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fasttransfer.Helper.InputValidator;
import com.example.fasttransfer.Model.Receiver;
import com.example.fasttransfer.Model.Sender;
import com.example.fasttransfer.R;

public class ReceiverDetailsActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPhone, editTextCountry, editTextAddress;
    private Sender sender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_details);


        editTextName = findViewById(R.id.et_receiver_full_name);
        editTextEmail = findViewById(R.id.et_receiver_email);
        editTextPhone = findViewById(R.id.et_receiver_contact);
        editTextCountry = findViewById(R.id.et_receiver_country);
        editTextAddress = findViewById(R.id.et_receiver_address);
        Button buttonNext = findViewById(R.id.btn_next_receiver);

        // Set button click listener
        buttonNext.setOnClickListener(v -> {
            if (validateInputs()) {
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String country = editTextCountry.getText().toString().trim();
                String address = editTextAddress.getText().toString().trim();

                Intent intent = new Intent(ReceiverDetailsActivity.this, ReviewDetailsActivity.class);

                intent.putExtra("sender_name", getIntent().getStringExtra("sender_name"));
                intent.putExtra("sender_email", getIntent().getStringExtra("sender_email"));
                intent.putExtra("sender_phone", getIntent().getStringExtra("sender_phone"));
                intent.putExtra("sender_country", getIntent().getStringExtra("sender_country"));
                intent.putExtra("sender_address", getIntent().getStringExtra("sender_address"));

                Log.d(TAG, "Receiver Name: " + name);
                Log.d(TAG, "Receiver Email: " + email);
                Log.d(TAG, "Receiver Phone: " + phone);
                Log.d(TAG, "Receiver Country: " + country);
                Log.d(TAG, "Receiver Address: " + address);


                intent.putExtra("receiver_name", name);
                intent.putExtra("receiver_email", email);
                intent.putExtra("receiver_phone", phone);
                intent.putExtra("receiver_country", country);
                intent.putExtra("receiver_address", address);
                startActivity(intent);
            }
        });
    }

    private boolean validateInputs() {
        if (InputValidator.isEmpty(editTextName)) {
            Toast.makeText(this, "Name is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!InputValidator.isValidEmail(editTextEmail)) {
            Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!InputValidator.isValidPhone(editTextPhone)) {
            Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (InputValidator.isEmpty(editTextCountry)) {
            Toast.makeText(this, "Country is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (InputValidator.isEmpty(editTextAddress)) {
            Toast.makeText(this, "Address is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
