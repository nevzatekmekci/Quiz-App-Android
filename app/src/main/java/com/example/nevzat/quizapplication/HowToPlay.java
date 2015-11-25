package com.example.nevzat.quizapplication;
/**
 * Statik bir sayfadır. Kullanıcıya oyun oynanışı hakkında bilgi verir.
 */
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class HowToPlay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView howToPlay = (TextView) findViewById(R.id.howToPlayText2);
        howToPlay.setText("Quiz App 10 sorudan oluşmaktadır. Tüm sorular 10 puan değerinde olup, tüm sorular doğru cevaplandığında kullanıcı" +
                " oyunu kazanmaktadır. Radio button içerisinde bulunan şıklara tıklamanız ardından butona tıklayarak soru cevabınızı göndermeniz" +
                " gerekmektedir. İyi Oyunlar.");
    }

}
