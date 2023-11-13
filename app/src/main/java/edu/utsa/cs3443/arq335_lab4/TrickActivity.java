package edu.utsa.cs3443.arq335_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.utsa.cs3443.arq335_lab4.model.Trivia;

public class TrickActivity extends AppCompatActivity implements View.OnClickListener{
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private TextView questionView;
    private String correctAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trick);
        loadQuestion();
        setupQuestionText();
        setupButton();
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button)view;
        String answerClicked = clickedButton.getText().toString();
        //we have answer clicked text, now we need to compare it to the correct answer and based on if its correct,
        //we have display correct answer or incorrect answer toast.
        if (answerClicked == correctAns) {
            //The two should be the same exact text
            Toast.makeText(TrickActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(TrickActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }


    }

    public void loadQuestion() {
        Trivia trivia = new Trivia();
        trivia.loadTrivia(this);
        //if i have getter methods in trivia class, I can simply retrieve them and use them in this trick activity class
        this.question = trivia.getQuestion();
        this.option1 = trivia.getOption1();
        this.option2 = trivia.getOption2();
        this.option3 = trivia.getOption3();
        this.correctAns = trivia.getCorrectAnswer();
    }

    public void setupQuestionText() {
        //We have to grab the text that is in the xml file and use setText(this.question) to it to set the text.
        questionView = findViewById(R.id.questionText);
        questionView.setText(this.question);
    }

    public void setupButton() {
        int[] buttonIDs = {R.id.button_1, R.id.button_2, R.id.button_3};
        String[] buttonText = {option1, option2, option3};
        for (int i = 0; i < buttonIDs.length; i++) {
            Button button = findViewById(buttonIDs[i]);
            button.setText(buttonText[i]);
            button.setOnClickListener(this);
        }
    }


}