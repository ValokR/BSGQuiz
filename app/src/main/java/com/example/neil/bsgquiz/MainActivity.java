package com.example.neil.bsgquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * @param answer: User input answer to corresponding question
     * @return boolean correct or incorrect
     */
    private boolean submitAnswer(String answer) {
        //TODO compare user's answer against correct answer
    }

    /**
     *
     * @param questionNumber: what question are we getting a hint for
     * @return String containing a hint to give to the user
     */
    private String getHint(int questionNumber) {

    }
}
