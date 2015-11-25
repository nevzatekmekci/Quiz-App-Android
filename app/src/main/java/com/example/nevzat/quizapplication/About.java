package com.example.nevzat.quizapplication;

/**
 * Statik bir sayfadır. Kullanıcıya oyun hakkında bilgi verir.
 */
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView about = (TextView) findViewById(R.id.aboutText2);
        about.setText("Quiz App Mobil Programlamaya Giriş Dersi ödevi kapsamında geliştirilmiş bir mobil uygulamadır." +
                " Nevzat Ekmekçi 2015\nTüm Hakları Saklıdır.");
    }

}
