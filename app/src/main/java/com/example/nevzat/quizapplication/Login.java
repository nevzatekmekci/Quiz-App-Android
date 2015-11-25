package com.example.nevzat.quizapplication;
/**
 * Kullanıcı bilgilerinin alındığı aktivite sınıfı
 */
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.widget.DatePicker;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    DatePicker calendar;
    SharedPreferences.Editor editor;
    Animation anim;
    Intent newInt;
    EditText name, surname, email, birthDate, phone;
    public DatePicker.OnDateChangedListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /**
         * Ekran üzerinde kişilk bilgilerini alan  edit text widgetları değişkenlere findviewById aracılığıyla aktarıldı.
         */

        newInt = new Intent(this, Quiz.class);
        name = (EditText) findViewById(R.id.editText);
        surname = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);
        birthDate = (EditText) findViewById(R.id.editText4);
        phone = (EditText) findViewById(R.id.editText5);
        editor = this.getSharedPreferences("finish", MODE_PRIVATE).edit();


    }

    /**
     * Burada ilk olarak takvim widgetı açılarak takvim üzerinden doğum tarihi girilmesi yapılmaya çalışılmıştır.
     * Alınan hatalar sonucu iptal edilip yaş bilgisi alınmıştır.
     * @param v
     */
    /*
    public void editTextClick(View v){
        calendar.setVisibility(View.VISIBLE);
        calendar.init(calendar.getYear(), calendar.getMonth(), calendar.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                view.setVisibility(View.GONE);
                view.setVisibility(View.INVISIBLE);
                birthDate.setText(calendar.getDayOfMonth()+"/"+calendar.getMonth()+"/"+calendar.getYear());
            }
        });

    }
*/
    /*public void dateClick(View v){
        if(calendar.getVisibility()==View.VISIBLE){
            calendar.setVisibility(View.GONE);
            calendar.setVisibility(View.INVISIBLE);
            birthDate.setText(calendar.getDayOfMonth()+"/"+calendar.getMonth()+"/"+calendar.getYear());
        }
    }*/

    /**
     * Bilgiler gönderilmeden önce kullanıcının isim,soyisim ve yaş bilgilerini girip girmediği kontrol edilir.
     * Bunlar kesinlikle doldurulması gereken alanlardır. Kullanıcı 3 alandan birini bile girmediğinde edittext üzerine error verilir ve sonraki sayfaya geçiş
     * engellenir.
     * Kullanıcı istenilen alanları doldurduğunda intent ile Quiz sayfasına geçiş yapılır. Burada Finish sayfasına kullanıcı bilgileri gönderilirken aralarda
     * başka sınıflar yer alacağından putExtra metodları yerine SharedPreferences yapısı kullanılmış ve haberleşme(Veri aktarımı) sağlanmıştır.
     * @param v
     */
    public void onClickBtn(View v) {
        if (name.getText().toString().trim().equals("") ||
                surname.getText().toString().trim().equals("") ||
                birthDate.getText().toString().trim().equals("")) {

            if (name.getText().toString().trim().equals(""))
                name.setError("Name is required!");
            if (surname.getText().toString().trim().equals(""))
                surname.setError("Surname is required!");
            if (birthDate.getText().toString().trim().equals(""))
                birthDate.setError("Age is required!");

        } else {
            editor = this.getSharedPreferences("finish", MODE_PRIVATE).edit();
            editor.putString("name", name.getText().toString());
            editor.putString("surname", surname.getText().toString());
            editor.putString("email", email.getText().toString());
            editor.putString("birthDate", birthDate.getText().toString());
            editor.putString("phone", phone.getText().toString());
            editor.commit();
            startActivity(newInt);
        }

    }
}
