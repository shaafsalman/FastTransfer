package com.example.fasttransfer.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fasttransfer.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReviewDetailsActivity extends AppCompatActivity {
    private static final String TAG = "ReviewDetailsActivity";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_review_details);

        FloatingActionButton fabBackToSender = findViewById(R.id.fabBackToSender);

         fabBackToSender.setOnClickListener(v -> {
            Intent indent = new Intent(ReviewDetailsActivity.this, SenderDetailsActivity.class);
            startActivity(indent);
        });

        // Initialize Sender views
        TextView senderName = findViewById(R.id.tvSenderName);
        TextView senderPhone = findViewById(R.id.tvSenderContact);
        TextView senderCountry = findViewById(R.id.tvSenderCountry);
        TextView senderAddress = findViewById(R.id.tvSenderAddress);

        // Initialize Receiver views
        TextView receiverName = findViewById(R.id.tvReceiverName);
        TextView receiverPhone = findViewById(R.id.tvReceiverContact);
        TextView receiverCountry = findViewById(R.id.tvReceiverCountry);
        TextView receiverAddress = findViewById(R.id.tvReceiverAddress);

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

        //Sender details
        senderName.setText(senderNameStr != null ? senderNameStr : "N/A");
        senderPhone.setText(senderPhoneStr != null ? senderPhoneStr : "N/A");
        senderCountry.setText(senderCountryStr != null ? senderCountryStr : "N/A");
        senderAddress.setText(senderAddressStr != null ? senderAddressStr : "N/A");

        //Receiver details
        receiverName.setText(receiverNameStr != null ? receiverNameStr : "N/A");
        receiverPhone.setText(receiverPhoneStr != null ? receiverPhoneStr : "N/A");
        receiverCountry.setText(receiverCountryStr != null ? receiverCountryStr : "N/A");
        receiverAddress.setText(receiverAddressStr != null ? receiverAddressStr : "N/A");
    }
}
