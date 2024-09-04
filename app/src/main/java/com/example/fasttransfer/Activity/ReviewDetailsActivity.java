package com.example.fasttransfer.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fasttransfer.R;

public class ReviewDetailsActivity extends AppCompatActivity {
    private static final String TAG = "ReviewDetailsActivity";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_details);

        // Initialize Sender views
        TextView senderName = findViewById(R.id.et_sender_full_name);
//        TextView senderEmail = findViewById(R.id.et_sender_email);
        TextView senderPhone = findViewById(R.id.et_sender_contact);
        TextView senderCountry = findViewById(R.id.et_sender_country);
        TextView senderAddress = findViewById(R.id.et_sender_address);

        // Initialize Receiver views
        TextView receiverName = findViewById(R.id.et_receiver_full_name);
//        TextView receiverEmail = findViewById(R.id.et_receiver_email);
        TextView receiverPhone = findViewById(R.id.et_receiver_contact);
        TextView receiverCountry = findViewById(R.id.et_receiver_country);
        TextView receiverAddress = findViewById(R.id.et_receiver_address);

        // Retrieve Sender details from the Intent
        String senderNameStr = getIntent().getStringExtra("sender_name");
        String senderEmailStr = getIntent().getStringExtra("sender_email");
        String senderPhoneStr = getIntent().getStringExtra("sender_phone");
        String senderCountryStr = getIntent().getStringExtra("sender_country");
        String senderAddressStr = getIntent().getStringExtra("sender_address");

        // Retrieve Receiver details from the Intent
        String receiverNameStr = getIntent().getStringExtra("receiver_name");
        String receiverEmailStr = getIntent().getStringExtra("receiver_email");
        String receiverPhoneStr = getIntent().getStringExtra("receiver_phone");
        String receiverCountryStr = getIntent().getStringExtra("receiver_country");
        String receiverAddressStr = getIntent().getStringExtra("receiver_address");

        Log.d(TAG, "Sender Name: " + senderNameStr);
        Log.d(TAG, "Sender Email: " + senderEmailStr);
        Log.d(TAG, "Sender Phone: " + senderPhoneStr);
        Log.d(TAG, "Sender Country: " + senderCountryStr);
        Log.d(TAG, "Sender Address: " + senderAddressStr);
        Log.d(TAG, "Receiver Name: " + receiverNameStr);
        Log.d(TAG, "Receiver Email: " + receiverEmailStr);
        Log.d(TAG, "Receiver Phone: " + receiverPhoneStr);
        Log.d(TAG, "Receiver Country: " + receiverCountryStr);
        Log.d(TAG, "Receiver Address: " + receiverAddressStr);

        // Set Sender details
        senderName.setText(senderNameStr != null ? senderNameStr : "N/A");
//        senderEmail.setText(senderEmailStr != null ? senderEmailStr : "N/A");
        senderPhone.setText(senderPhoneStr != null ? senderPhoneStr : "N/A");
        senderCountry.setText(senderCountryStr != null ? senderCountryStr : "N/A");
        senderAddress.setText(senderAddressStr != null ? senderAddressStr : "N/A");

        // Set Receiver details
        receiverName.setText(receiverNameStr != null ? receiverNameStr : "N/A");
//        receiverEmail.setText(receiverEmailStr != null ? receiverEmailStr : "N/A");
        receiverPhone.setText(receiverPhoneStr != null ? receiverPhoneStr : "N/A");
        receiverCountry.setText(receiverCountryStr != null ? receiverCountryStr : "N/A");
        receiverAddress.setText(receiverAddressStr != null ? receiverAddressStr : "N/A");
    }
}
