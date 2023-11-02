package edu.utsa.cs3443.arq335_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
This class only takes care of onClick events
that is why we can make the class to implement the interface for onClick events
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        //Do I need to send anything to the other views from this view?
        //if button clicked is trick then go to the TrickActivity
        //else go to the TreatActivity
        //Intent intent = new Intent(MainActivity.this, )
    }

    private void setupButtons() {
        //two buttons and they both have an id which is an integer
        int[] buttonIDs = {R.id.button_1, R.id.button_2};
        String[] buttonText = {"Trick", "Treat"};
        for (int i = 0; i < buttonIDs.length; i++) {
            Button button = findViewById(buttonIDs[i]);
            button.setText(buttonText[i]);
            button.setOnClickListener(this);
        }
    }
}