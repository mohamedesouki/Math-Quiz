package org.first.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class Game extends AppCompatActivity {

    TextView score;
    TextView life;
    TextView time;

    EditText answer;
    TextView question;

    Button ok;
    Button nextQuestion;
    Random random = new Random();
    CountDownTimer timer;
    public static final long START_TIMER_IN_MILIS = 20000;
    Boolean running_timer;
    long time_left_in_milis = START_TIMER_IN_MILIS;
    int number1;
    int number2;
    int userAnswer;
    int realAnswer;
    int userScore = 0;
    int userLife = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        score = findViewById(R.id.textViewScore);
        life = findViewById(R.id.textViewLife);
        time = findViewById(R.id.textViewTime);

        answer = findViewById(R.id.editTextTextAnswer);
        question = findViewById(R.id.textViewQuestion);

        ok = findViewById(R.id.buttonOk);
        nextQuestion = findViewById(R.id.buttonNextQuestion);
        gameContinue();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userAnswer =Integer.valueOf(answer.getText().toString()) ;
                pauseTimer();


                if(userAnswer == realAnswer){
                    userScore+=10;
                    score.setText("" + userScore);
                    question.setText("Congratulations , your answer is true.");
                    pauseTimer();
                }else {
                    userLife-=1;
                    life.setText("" + userLife);
                    question.setText(" your answer is wrong.");
                }
            }
        });
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText("");
                gameContinue();
                resetTimer();
                if (userLife <=0){
                    Toast.makeText(getApplicationContext() , "Game Over" , Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(Game.this , Result.class);
                    intent1.putExtra("score1" , userScore);
                    startActivity(intent1);
                    finish();
                }else{
                    gameContinue();
                }
            }
        });

    }
    public void gameContinue(){
        number1 = random.nextInt(50);
        number2 = random.nextInt(50);
        realAnswer = number1 + number2;
        question.setText(number1 + "+" + number2);
        startCount();
    }

    public void startCount(){
        timer = new CountDownTimer(time_left_in_milis , 1000) {
            @Override
            public void onTick(long l) {
                time_left_in_milis = l;
                updateText();
            }

            @Override
            public void onFinish() {
                running_timer = false;
                pauseTimer();
                resetTimer();
                 updateText();
                userLife = userLife-1;
                question.setText("Sorry! time is up");
                life.setText("" + userLife);
            }
        }.start();
        running_timer  = true;
    }
    public void updateText(){
        int second = (int)(time_left_in_milis/1000) % 60;
        String time_left =String.format(Locale.getDefault() , "%02d" , second);
        time.setText(time_left);
    }

    public void  pauseTimer(){
        timer.cancel();
        running_timer = false;

    }
    public void resetTimer(){
        time_left_in_milis = START_TIMER_IN_MILIS;
        updateText();

    }

}