package com.example.nevzat.quizapplication;
/**
 * Quiz sorularının gösterildiği ve yapıldığı activity
 */
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Quiz extends AppCompatActivity {
    /**
     * Değişkenlerin tüm metotlarda kullanılabilmesi için global tanımlama yapıldı.
     */
    RadioButton answer,answer1,answer2,answer3,answer4;
    Button sendButton;
    RadioGroup radioButtonGroup;
    TextView soru;
    Intent intent;
    ArrayList<ArrayList<String>> quiz = new ArrayList<ArrayList<String>>();
    int score=0,gate=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayList<Integer> list = new ArrayList<Integer>();


        /**
         * Strings.xml dosyasında oluşturulan sorular, şıklar ve doğru cevaplar dizilere aktarıldı.
         */
        String[] questions = getResources().getStringArray(R.array.questions);
        String[] answers = getResources().getStringArray(R.array.answers);
        String[] trueAnswers = getResources().getStringArray(R.array.trueAnswers);

        /**
         * Ekran üzerinde oluşturulan radiobuttonlar, cevaplama butonu, sorunun gösterildiği textview ve radiobuttongroup
         * findViewById kullanılarak değişkenlerde tutuldu.
         */
        answer1 = (RadioButton) findViewById(R.id.radioBtn1);
        answer2 = (RadioButton) findViewById(R.id.radioBtn2);
        answer3 = (RadioButton) findViewById(R.id.radioBtn3);
        answer4 = (RadioButton) findViewById(R.id.radioBtn4);
        sendButton = (Button) findViewById(R.id.sendButton);
        soru = (TextView) findViewById(R.id.txtQuestion);
        radioButtonGroup = (RadioGroup) findViewById(R.id.radioButtonGroup);

        /**
         * Her defasında farklı sırada soruların getirilmesi için 1-10 arası sayılar listeye alınıp shuffle(Collection sınıfı metodu)
         * ile karıştırma yapıldı.
         */
        for (int i=0; i<questions.length; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);

        /**
         * List of List yapısı içinde içerideki listede her soru için soru,şıklar ve cevap liste olarak tutuldu.
         * Ardından her liste ayrı bir listeye eklendi. İçerideki listenin ilk indisi soruyu, sonraki 4 indis şıkları, son indis ise doğru cevabın
         * şık numarasını tutmaktadır.
         */
        for(int i=0;i<questions.length;i++){
            ArrayList<String> question = new ArrayList<>();
            int indis = list.get(i);
            question.add(questions[indis]);
            for(int j=0;j<4;j++){
                question.add(answers[indis*4+j]);
            }
            question.add(trueAnswers[indis]);
            quiz.add(question);
        }
        soru.setText((score+1)+"- "+quiz.get(score).get(0));
        answer1.setText(quiz.get(score).get(1));
        answer2.setText(quiz.get(score).get(2));
        answer3.setText(quiz.get(score).get(3));
        answer4.setText(quiz.get(score).get(4));



    }
    public void onClickBtn(View v){
        /**
         * Eğer herhangi bir buton işaretlendiyse cevap kontrolü yapılıyor.
         */
        if(radioButtonGroup.getCheckedRadioButtonId()!=-1){
            /**
             * Tüm sorular doğru cevaplanana kadar yapılıyor. Score değişkeni içeride arttırıldığından 9'a kadar devam ediyor.
             */
            if((score<9)){
                /**
                 * işaretli olan radio button answer nesnesinde tutulur. Ardından listeden doğru şıkkın textiyle karşılaştırılır.
                 * Aynıysa bir sonraki soruya geçilir. Yanlışsa intent aracılığıyla bitiş sayfasına geçilir. Score tüm sorular doğru cevaplandığında
                 * veya yanlış cevaplanarak yarışma bittiğinde intentin putExtra metoduyla bitiş sayfasına aktarılır.
                 */
                answer = (RadioButton) findViewById(radioButtonGroup.getCheckedRadioButtonId());
                if(quiz.get(score).get((Integer.parseInt(quiz.get(score).get(5)))).equals(answer.getText())) {
                    /**
                     * Doğru, yanlış, şık işaretlenmemesi ve yarışma bitiş durumlarında Android Toast sınıfı aracılığıyla kullanıcıya bilgilendirme yapılır
                     */
                    Toast.makeText(getApplicationContext(), "Doğru", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {;
                        }
                    }, 1000);
                    score++;
                    soru.setText((score+1)+"- "+quiz.get(score).get(0));
                    answer1.setText(quiz.get(score).get(1));
                    answer2.setText(quiz.get(score).get(2));
                    answer3.setText(quiz.get(score).get(3));
                    answer4.setText(quiz.get(score).get(4));
                }
                else {
                    intent = new Intent(this,Finish.class);
                    intent.putExtra("score", score);
                    Toast.makeText(getApplicationContext(), "Yanlış. Doğru Cevap: "+quiz.get(score).get((Integer.parseInt(quiz.get(score).get(5)))), Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {startActivity(intent);
                        }
                    }, 1000);
                }
            }
            else {
                intent = new Intent(this,Finish.class);
                intent.putExtra("score", score+1);
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        startActivity(intent);
                    }
                }, 1000);
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Lütfen bir seçim yapınız!", Toast.LENGTH_SHORT).show();
        }
    }
}
