package com.example.emailler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private EditText mto;
    private EditText msubject;
    private EditText mmessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mto=findViewById(R.id.edit_text_to);
        msubject=findViewById(R.id.edit_text_subject);
        mmessage=findViewById(R.id.edit_text_message);


        Button SendButton=findViewById(R.id.button_send);
        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendMail();
            }
        });
    }
    private void SendMail()
    {
        String recipientList=mto.getText().toString();
        String[] recipients = recipientList.split(",");
        String subject = msubject.getText().toString();
        String message = mmessage.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an app"));

    }
}