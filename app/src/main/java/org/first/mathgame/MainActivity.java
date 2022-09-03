package org.first.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addition;
    Button subtraction;
    Button multiplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addition = findViewById(R.id.buttonAdd);
        subtraction = findViewById(R.id.buttonSub);
        multiplication = findViewById(R.id.buttonMulti);

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , Game.class);
                startActivity(intent);
                finish();
            }
        });
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , Subtraction.class);
                startActivity(intent);
                finish();
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , Multiplication.class);
                startActivity(intent);
                finish();
            }
        });
    }
}