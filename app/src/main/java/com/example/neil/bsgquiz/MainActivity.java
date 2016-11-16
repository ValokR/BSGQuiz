package com.example.neil.bsgquiz;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    String[] questionHeaders, answerKey, questions, correctAnswerString;

    int correctAnswers = 0;
    int questionCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        questionHeaders = res.getStringArray(R.array.question_header_array);
        answerKey = res.getStringArray(R.array.answer_key_array);
        questions = res.getStringArray(R.array.questions_array);
        correctAnswerString = res.getStringArray(R.array.correct_answers);
    }


    public void submitAnswer(View view) {
        //create Edit Text object, and extract user input answer from it
        EditText userAnswerEditText = (EditText) findViewById(R.id.answer_text);
        String userAnswer = userAnswerEditText.getText().toString();

        //compare against answer key and tell user if right or wrong
        if (userAnswer.compareToIgnoreCase(answerKey[questionCounter]) == 0) {
            Toast.makeText(this, "That's Correct!", Toast.LENGTH_SHORT).show();
            correctAnswers++;
        } else {
            Toast.makeText(this, "Sorry, That's Incorrect", Toast.LENGTH_SHORT).show();
        }
        nextQuestion();
    }

    /**
     * @param questionNumber: what question are we getting a hint for
     * @return String containing a hint to give to the user
     */
    private String getHint(int questionNumber) {
        return "0";
    }

    private void nextQuestion() {
        //step forward question header
        TextView headerText = (TextView) findViewById(R.id.question_header);
        headerText.setText(questionHeaders[questionCounter]);

        //step forward question text
        TextView questionText = (TextView) findViewById(R.id.question_text_view);
        questionText.setText(questions[questionCounter]);

        //reset hint for EditText
        EditText userAnswerEditText = (EditText) findViewById(R.id.answer_text);
        userAnswerEditText.setHint(R.string.input_field_hint);

        //update correct answer counter
        TextView correctAnswersTextView = (TextView) findViewById(R.id.correct_answer_counter);
        correctAnswersTextView.setText(correctAnswerString[correctAnswers]);

        questionCounter++;
    }
}
