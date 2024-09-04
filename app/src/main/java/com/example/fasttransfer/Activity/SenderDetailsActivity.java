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
import com.example.fasttransfer.Model.Sender;
import com.example.fasttransfer.R;

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

        buttonNext.setOnClickListener(v -> {
            if (validateInputs()) {
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String country = editTextCountry.getText().toString().trim();
                String address = editTextAddress.getText().toString().trim();


                Intent intent = new Intent(SenderDetailsActivity.this, ReceiverDetailsActivity.class);
                intent.putExtra("sender_name", name);
                intent.putExtra("sender_email", email);
                intent.putExtra("sender_phone", phone);
                intent.putExtra("sender_country", country);
                intent.putExtra("sender_address", address);
                startActivity(intent);
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
