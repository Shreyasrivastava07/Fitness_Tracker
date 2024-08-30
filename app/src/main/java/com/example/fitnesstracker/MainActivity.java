package com.example.fitnesstracker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button bt1,bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);




        bt1= findViewById(R.id.startyog1);
        bt2 = findViewById(R.id.start2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, SecondActivity2.class);
                startActivity(intent);
            }
        });









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.id_privacy){
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://ioexpert1.blogspot.com/2020/10/weight-loss-privacy-policy-page.html"));
            startActivity(intent);


            return true;
        }
        if (id==R.id.id_term){
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://ioexpert1.blogspot.com/2020/10/weight-loss-terms-and-conditions-page.html"));
            startActivity(intent);


            return true;
        }
        if (id==R.id.more){
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Leap+Fitness+Group&hl=en-IN"));
            startActivity(intent);


            return true;
        }
        if (id==R.id.share){
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String shareBody="This is the best app for maintaining your fitness \n"+"https://play.google.com/store/apps/details?id=com.example.fitnesstracker&hl=en";
            String shareHub= "Fitness app";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,shareHub);
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(myIntent,"share using"));


            return true;
        }
        if (id==R.id.rate){
            try{
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=" + getPackageName())));

            }catch (Exception ex){
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=" +
                        getPackageName())));
            }



            return true;
        }
        return true;
    }

    private void setSupportActionBar(Toolbar toolbar) {

    }

    public void AfterAge18(View view) {

        Intent intent= new Intent(MainActivity.this,SecondActivity.class);
    }

    public void beforeAge18(View view) {
        Intent intent= new Intent(MainActivity.this,SecondActivity2.class);

    }

    public void food(View view) {
        Intent intent= new Intent(MainActivity.this,FoodActivity.class);

    }
}