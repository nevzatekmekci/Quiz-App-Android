package com.example.nevzat.quizapplication;
/**
 * Animasyon sonrası gözüken sınıftır. Ekran üzerinde bulunan 4 farklı buton ile diğer sayfalara geçiş sağlanır.
 * Butonların onClick() eventlerinden faydalınılmıştır. Intent yapısı kullanılmıştır. Quiz, About, Contact ve HowToPlay sayfalarına geçiş yapılabilir.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void onClickBtn(View v)
    {
        Intent newInt = new Intent(this, Login.class);
        startActivity(newInt);
    }
    public void onClickBtn2(View v)
    {
        Intent newInt = new Intent(this, HowToPlay.class);
        startActivity(newInt);
    }
    public void onClickBtn3(View v)
    {
        Intent newInt = new Intent(this, About.class);
        startActivity(newInt);
    }
    public void onClickBtn4(View v)
    {
        Intent newInt = new Intent(this, Contact.class);
        startActivity(newInt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
