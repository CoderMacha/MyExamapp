//package com.example.myexamapp;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//
//import com.example.myexamapp.databinding.ActivityScoreActivityBinding;
//
//public class ScoreActivityA extends AppCompatActivity {
//
//    ActivityScoreActivityBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding=ActivityScoreActivityBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().hide();
//        }
//        int correct= getIntent().getIntExtra("correctAnsw",0);
//        int totalQuestion=getIntent().getIntExtra("totalQuestion",0);
//
//        int wrong=totalQuestion-correct;
//
//        binding.totalRight.setText(String.valueOf(correct));
//        binding.totalWrong.setText(String.valueOf(wrong));
//        binding.totalQuestion.setText(String.valueOf(totalQuestion));
//
//        binding.btnRetry.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(ScoreActivityA.this,MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//            }
//        });
//
//        binding.btnQuit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                finish();
//            }
//        });
//    }
//}

package com.example.myexamapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myexamapp.databinding.ActivityScoreActivityBinding;

public class ScoreActivityA extends AppCompatActivity {

    ActivityScoreActivityBinding binding;
    private static final String TAG = "ScoreActivityA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        int correct = getIntent().getIntExtra("correctAnsw", 0);
        int totalQuestion = getIntent().getIntExtra("totalQuestion", 0);

        Log.d(TAG, "Correct answers: " + correct);
        Log.d(TAG, "Total questions: " + totalQuestion);

        int wrong = totalQuestion - correct;

        binding.totalRight.setText(String.valueOf(correct));
        binding.totalWrong.setText(String.valueOf(wrong));
        binding.totalQuestion.setText(String.valueOf(totalQuestion));

        // Calculate the percentage of correct answers
        double percentageCorrect = ((double) correct / totalQuestion) * 100;

        Log.d(TAG, "Percentage of correct answers: " + percentageCorrect);

        // Set the image based on the score
        if (correct == totalQuestion) {
            binding.imageView4.setImageResource(R.drawable.trophy_win);
        } else if (percentageCorrect < 50) {
            binding.imageView4.setImageResource(R.drawable.sad_emoji);
        } else if (percentageCorrect >= 70) {
            binding.imageView4.setImageResource(R.drawable.happiness_emoji);
        } else {
            binding.imageView4.setImageResource(R.drawable.placeholder); // Default image if none of the conditions match
        }

        binding.btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Retry button clicked");
                Intent intent = new Intent(ScoreActivityA.this, MainActivity.class);
               // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        binding.btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Quit button clicked");
                finish();
            }
        });
    }
}
