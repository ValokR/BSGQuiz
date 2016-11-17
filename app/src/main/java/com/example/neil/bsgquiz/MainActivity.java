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

    String[] questionHeaders, answerKey, questions, correctAnswerString, hints;

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
        correctAnswerString = res.getStringArray(R.array.correct_answers_array);
        hints = res.getStringArray(R.array.hints_array);
    }

    /**
     *  This method checks if the user's answer is correct, and steps forward to the next question
     */

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

        if (questionCounter < 6) {
            nextQuestion();
        }
        else {
            Toast.makeText(this, "Test complete, you got " + correctAnswers + " questions correct!", Toast.LENGTH_LONG).show();
        }
    }

    /**
     *  This method displays a hint when the hint button is pressed
     */
    public void getHint(View view) {
        TextView hintTextView = (TextView) findViewById(R.id.hint_text_view);
        hintTextView.setText(hints[questionCounter]);
    }

    /**
     *  Encapsulation of stepping forward to next question
     */
    private void nextQuestion() {
        //step forward question header
        TextView headerText = (TextView) findViewById(R.id.question_header);
        headerText.setText(questionHeaders[questionCounter]);

        //step forward question text
        TextView questionText = (TextView) findViewById(R.id.question_text_view);
        questionText.setText(questions[questionCounter]);

        //reset hint for EditText
        EditText userAnswerEditText = (EditText) findViewById(R.id.answer_text);
        userAnswerEditText.setText("");

        //update correct answer counter
        TextView correctAnswersTextView = (TextView) findViewById(R.id.correct_answer_counter);
        correctAnswersTextView.setText(correctAnswerString[correctAnswers]);

        //reset hint text
        TextView hintText = (TextView) findViewById(R.id.hint_text_view);
        hintText.setText("");

        questionCounter++;
    }
}
