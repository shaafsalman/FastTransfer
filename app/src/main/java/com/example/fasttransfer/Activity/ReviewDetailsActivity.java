package com.example.fasttransfer.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fasttransfer.R;
import com.example.fasttransfer.Model.Sender;

public class ReviewDetailsActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_details);

        // Initialize views
        TextView senderName = findViewById(R.id.sender_name);
        TextView senderEmail = findViewById(R.id.sender_email);
        TextView senderPhone = findViewById(R.id.sender_phone);
        TextView senderCountry = findViewById(R.id.sender_country);
        TextView senderAddress = findViewById(R.id.sender_address);

        // Retrieve Sender object from Intent
        Sender sender = (Sender) getIntent().getSerializableExtra("sender");

        // Display sender details
        if (sender != null) {
            senderName.setText("Name: " + sender.getName());
            senderEmail.setText("Email: " + sender.getEmail());
            senderPhone.setText("Phone: " + sender.getPhone());
            senderCountry.setText("Country: " + sender.getCountry());
            senderAddress.setText("Address: " + sender.getAddress());
        } else {
            // Handle the case where Sender is null (optional)
            senderName.setText("Name: N/A");
            senderEmail.setText("Email: N/A");
            senderPhone.setText("Phone: N/A");
            senderCountry.setText("Country: N/A");
            senderAddress.setText("Address: N/A");
        }
    }
}
