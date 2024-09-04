package com.example.fasttransfer.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fasttransfer.Helper.InputValidator;
import com.example.fasttransfer.R;

public class SenderDetailsActivity extends AppCompatActivity {

    private EditText name, email, phone, country, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_sender_details);

        initViews();
        setupButtonClickListener();
    }

    private void initViews() {
        name = findViewById(R.id.etSenderName);
        email = findViewById(R.id.etSenderEmail);
        phone = findViewById(R.id.etSenderContact);
        country = findViewById(R.id.etSenderCountry);
        address = findViewById(R.id.etSenderAddress);
    }

    private void setupButtonClickListener() {
        Button buttonNext = findViewById(R.id.btnNext);
        buttonNext.setOnClickListener(v -> {
            if (validateInputs()) {
                passDataToNextActivity();
            }
        });
    }

    private boolean validateInputs() {
        if (isInvalidInput(name, "Name is required")) return false;
        if (!InputValidator.isValidEmail(email)) {
            showToast("Invalid email address");
            return false;
        }
        if (!InputValidator.isValidPhone(phone)) {
            showToast("Invalid phone number");
            return false;
        }
        if (isInvalidInput(country, "Country is required")) return false;
        return !isInvalidInput(address, "Address is required");
    }

    private boolean isInvalidInput(EditText editText, String errorMessage) {
        if (InputValidator.isEmpty(editText)) {
            showToast(errorMessage);
            return true;
        }
        return false;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void passDataToNextActivity() {
        Intent intent = new Intent(SenderDetailsActivity.this, ReceiverDetailsActivity.class);
        intent.putExtra("sender_name", name.getText().toString().trim());
        intent.putExtra("sender_email", email.getText().toString().trim());
        intent.putExtra("sender_phone", phone.getText().toString().trim());
        intent.putExtra("sender_country", country.getText().toString().trim());
        intent.putExtra("sender_address", address.getText().toString().trim());
        startActivity(intent);
    }
}
