package com.example.nevzat.quizapplication;

/**
 * Statik bir sayfadır. Kullanıcıya geliştirici hakkında bilgi verir.
 */
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView contact = (TextView) findViewById(R.id.contactText2);
        contact.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        contact.setText("Nevzat Ekmekçi\n"+
                "+90 537 819 50 31\n"+
                "nvztekmekci@gmail.com");
    }

}
