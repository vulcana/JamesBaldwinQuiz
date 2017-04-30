package com.example.android.jamesbaldwinquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int submitQuiz(View view) {

        int score = 0;

//        Renders xml objects as JavaScript variables

        RadioButton jamesBaldwinPhoto = (RadioButton) findViewById(R.id.jamesBaldwinSelection);
        RadioButton newYork = (RadioButton) findViewById(R.id.city1);
        EditText baldwinFirstWork = (EditText) findViewById(R.id.baldwin_first_work);
        String firstNovel = baldwinFirstWork.toString();
        RadioButton richardWright = (RadioButton) findViewById(R.id.reference3);
        Spinner datesSpinner = (Spinner) findViewById(R.id.dates_spinner);
        String birthDate = datesSpinner.getSelectedItem().toString();
        CheckBox expertYes = (CheckBox) findViewById(R.id.expert_yes);
        CheckBox expertNo = (CheckBox) findViewById(R.id.expert_no);
        TextView scoreTextView = (TextView) findViewById(R.id.score_text_view);

//        Calculates score based on correct answers

        if (jamesBaldwinPhoto.isChecked()) {
            score = score + 1;
        }

        if (firstNovel.equals("Go Tell It To The Mountain")) {
            score = score + 1;
        }

        if (newYork.isChecked()) {
            score = score + 1;
        }

        if (richardWright.isChecked()) {
            score = score + 1;
        }

        if (birthDate.equals("1924")) {
            score = score +1;
        }

//        Determines if the user's analysis of their own in/expertise is correct based on their score

        if (expertYes.isChecked() && score <=4) {
            Toast.makeText(this, "Wrong you are! You only scored " + score + "/6", Toast.LENGTH_LONG).show();
        }
        else if (expertYes.isChecked() && score >=5) {
            Toast.makeText(this, "You are indeed an expert! Well done on scoring " + score + "/6", Toast.LENGTH_LONG).show();
        }

        else if (expertNo.isChecked() && score <=4) {
            Toast.makeText(this, "Afraid you're right, you only scored " + score + "/6", Toast.LENGTH_LONG).show();
        }

        else {
            Toast.makeText(this, "Back yourself! You actually scored " + score + "/6", Toast.LENGTH_LONG).show();
        }

//        Displays score

        scoreTextView.setText("Your score is: " + score + "/6");

        return score;

    }

}




