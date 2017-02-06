package com.example.nando.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LostPassword extends AppCompatActivity {
    private EditText mEmailView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lost_password);
        mEmailView = (EditText) findViewById(R.id.email);

        Button mLostPasswordButton = (Button) findViewById(R.id.password_lost_button);
        mLostPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);

                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{mEmailView.getText().toString()});
                i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                }
                catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(LostPassword.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}