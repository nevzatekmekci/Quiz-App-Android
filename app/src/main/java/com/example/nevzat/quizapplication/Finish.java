package com.example.nevzat.quizapplication;
/**
 * Oyun sonu aktivite sınıfı
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.AvoidXfermode;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Finish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /**
         * Login ekranında girilen bilgiler oradaki keyle getSharePreferences metodu aracılığıyla preferences nesnesine alınır
         * Ardından tüm bilgiler değişkenlere aktarılır.
         */
        SharedPreferences preferences = getSharedPreferences("finish", MODE_PRIVATE);
        Intent intent = getIntent();
        /**
         * Score bilgisi bir önceki sayfadan putExtra ile gönderilidiğinden buradan intent getExtra metoduyla alınır.
         * 0-100 arası puanlama yapıldığından önceki sayfada doğru sayısı olarak tutulan score 10 ile çarpılır.
         */
        int score = intent.getIntExtra("score",0)*10;
        ImageView image = (ImageView) findViewById(R.id.imageView);

        /**
         * Bu ekranda 1 imageview bir text view bulunmaktadır. Kullanıcı yarışmayı kazandığında winner, kaybettiğinde loser yazılı imagelar gösterilir
         * Ayrıca Toast nesneleriyle kullanıcı bilgilendirilir.
         * Son olarak preferences ile alınan bilgiler textview üzerinde gösterilir.
         */
        if(score==100){
            Toast.makeText(getApplicationContext(), "Tebrikler. Oyunu Kazandınız.", Toast.LENGTH_LONG).show();
            image.setImageDrawable(getResources().getDrawable(R.drawable.vinner));
        }
        else{
            Toast.makeText(getApplicationContext(), "Kaybettiniz. Lütfen Tekrar Deneyiniz!", Toast.LENGTH_LONG).show();
            image.setImageDrawable(getResources().getDrawable(R.drawable.loser));
        }

        String name = preferences.getString("name", null);
        String surname = preferences.getString("surname",null);
        String email = preferences.getString("email",null);
        String birthdate = preferences.getString("birthDate",null);
        String phone = preferences.getString("phone",null);
        TextView textView = (TextView) findViewById(R.id.textView7);
        textView.setText(name+" "+surname+"\nAge: "+birthdate+"\nScore: "+score);

    }

    /**
     * geri tuşunabasıldığında prıgramın kapatılması
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        moveTaskToBack(true);

    }

}
