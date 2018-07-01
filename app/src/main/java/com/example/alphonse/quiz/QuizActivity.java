package com.example.alphonse.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QuizActivity extends AppCompatActivity {

    private Set<Integer> singleAnswerIds;
    private Set<Integer> multipleAnswerIds;
    private static final int NUM_CORRECT_MULTIPLE_CHOICES = 3;
    private static final int INT_SIZE = 32;
    private static final int NUM_QUESTIONS = 5;
    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setUpToolbar();
        singleAnswerIds = new HashSet<>();
        multipleAnswerIds = new HashSet<>();
        editTextInput = findViewById(R.id.question2_input);
    }


    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.app_name);
        }
    }

    public void onRadioButtonClicked(View view) {
        singleAnswerIds.add(view.getId());
    }

    public void onCheckBoxClicked(View view) {
        multipleAnswerIds.add(view.getId());
    }

    public void evaluateQuiz(View view) {
        int correct = 0;
        correct += singleAnswerIds.size();

        if (multipleAnswerIds.size() == NUM_CORRECT_MULTIPLE_CHOICES) {
            correct +=1;
        }

        //check text input
        String input = editTextInput.getText().toString();
        if (!input.isEmpty()) {
            if (Integer.parseInt(input) == INT_SIZE) {
                correct +=1;
            }
        }

        Toast.makeText(this, "You answered " + correct + " out of " + NUM_QUESTIONS + " correctly.", Toast.LENGTH_SHORT).show();
    }
}
