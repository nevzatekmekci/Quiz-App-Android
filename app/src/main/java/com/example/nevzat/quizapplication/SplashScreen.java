package com.example.nevzat.quizapplication;
/**
 * Program başlatıldığında gösterilecek olan animasyonlu açılış sayfasının activity sınıfı
 */
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    Intent intent;
    ImageView questionMark;
    TextView quizApp;
    Animation anim,anim2;
    RelativeLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /**
         * Ekran üzerine bir image ve bir text eklendi. Ayrıca layout nesnesi de bir değişkende tutuldu.
         */
        questionMark = (ImageView) findViewById(R.id.splashQuestion);
        quizApp  = (TextView) findViewById(R.id.splashText);
        layout = (RelativeLayout) findViewById(R.id.splashScreenLayout);

        anim = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fade);
        anim2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.slide);

        questionMark.startAnimation(anim);
        intent = new Intent(this,MainActivity.class);
        /**
         * Image nesnesine fade animasyonu yaptırıldı. Burada Ana sayfaya geçirecek olan intent oluşturuldu
         * Animation Listenerla animasyonun bitişi dinlendi ve ardından layouta slide animasyonu yaptırıldı
         */
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                layout.startAnimation(anim2);
                /**
                 * 2. animasyonda yine listenerla dinlendi ve bittiğinde intent aracılığıyla main activitye geçildi.
                 */
                anim2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        startActivity(intent);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}
