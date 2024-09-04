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
import com.example.fasttransfer.R;

import java.util.Objects;

public class ReceiverDetailsActivity extends AppCompatActivity {

    private EditText name, email, phone, country, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_receiver_details);

        initViews();
        setupButtonClickListener();
    }

    private void initViews() {
        name = findViewById(R.id.etReceiverName);
        email = findViewById(R.id.etReceiverEmail);
        phone = findViewById(R.id.etReceiverContact);
        country = findViewById(R.id.etReceiverCountry);
        address = findViewById(R.id.etReceiverAddress);
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
        Intent intent = new Intent(ReceiverDetailsActivity.this, ReviewDetailsActivity.class);

        intent.putExtra("sender_name", getIntent().getStringExtra("sender_name"));
        intent.putExtra("sender_email", getIntent().getStringExtra("sender_email"));
        intent.putExtra("sender_phone", getIntent().getStringExtra("sender_phone"));
        intent.putExtra("sender_country", getIntent().getStringExtra("sender_country"));
        intent.putExtra("sender_address", getIntent().getStringExtra("sender_address"));

        intent.putExtra("receiver_name", name.getText().toString().trim());
        intent.putExtra("receiver_email", email.getText().toString().trim());
        intent.putExtra("receiver_phone", phone.getText().toString().trim());
        intent.putExtra("receiver_country", country.getText().toString().trim());
        intent.putExtra("receiver_address", address.getText().toString().trim());

        logReceiverDetails();
        startActivity(intent);
    }

    private void logReceiverDetails() {
        Log.d(TAG, "Receiver Name: " + name.getText().toString().trim());
        Log.d(TAG, "Receiver Email: " + email.getText().toString().trim());
        Log.d(TAG, "Receiver Phone: " + phone.getText().toString().trim());
        Log.d(TAG, "Receiver Country: " + country.getText().toString().trim());
        Log.d(TAG, "Receiver Address: " + address.getText().toString().trim());
    }
}
