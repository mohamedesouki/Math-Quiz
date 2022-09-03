package org.first.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    Button play;
    Button exit;
    TextView result;
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        play = findViewById(R.id.buttonPlayAgain);
        exit =  findViewById(R.id.buttonExit);
        result =  findViewById(R.id.textViewScore);

        Intent intent = getIntent();
        score = intent.getIntExtra("score1" ,0);
        String userScore = String.valueOf(score);
        result.setText("Your score : " + userScore);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}