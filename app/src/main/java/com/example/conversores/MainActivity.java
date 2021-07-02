package com.example.conversores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView gv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gv = findViewById(R.id.gv);
        gv.setAdapter(new Adapter_GridView(this));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(MainActivity.this, ConversorMoeda_Activity.class);
                    startActivity(intent);
                }
                else if(position == 1){
                    Intent intent = new Intent(MainActivity.this, ConversorGraus_Activity.class);
                    startActivity(intent);
                }
                else if(position == 2){
                    Intent intent = new Intent(MainActivity.this, ConversorTempo_Activity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(MainActivity.this, ConversorVelocidade_Activity.class);
                    startActivity(intent);
                }
            }
        });
    }
}