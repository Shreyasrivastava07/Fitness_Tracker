package com.example.fitnesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;

public class SecondActivity2 extends AppCompatActivity {

    int[] newArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);


        newArray= new int[]{
                R.id.Boat_pose, R.id.Boat_pose2,R.id.Boat_pose3,R.id.Boat_pose4,R.id.Boat_pose5,
                R.id.Boat_pose6, R.id.Boat_pose7, R.id.Boat_pose8, R.id.Boat_pose9, R.id.Boat_pose10,
                R.id.Boat_pose11, R.id.Boat_pose12, R.id.Boat_pose13, R.id.Boat_pose14, R.id.Boat_pose15


        };




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


            return true;
        }
        if (id==R.id.id_term){


            return true;
        }
        if (id==R.id.more){


            return true;
        }
        if (id==R.id.share){


            return true;
        }
        if (id==R.id.rate){


            return true;
        }
        return true;
    }


    @OptIn(markerClass = UnstableApi.class)
    public void ImageButtonClicked(View view) {
        for (int i=0;i< newArray.length;i++){
            if(view.getId()==newArray[i]){
                int value=i+1;
                Log.i("FIRST", String.valueOf(value));
                Intent intent = new Intent(SecondActivity2.this,ThirdActivity2.class);
                startActivity(intent);
                intent.putExtra("value",String.valueOf(value));

            }
        }
    }
}