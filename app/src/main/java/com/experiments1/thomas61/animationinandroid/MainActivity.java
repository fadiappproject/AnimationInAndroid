package com.experiments1.thomas61.animationinandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView helloTextView;
    TextView hiTextView;
    TextView movingTextView;

    boolean helloVisible;
    boolean moved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloTextView = findViewById(R.id.hwTextView);
        hiTextView = findViewById(R.id.hiTextView);
        movingTextView = findViewById(R.id.moveTextView);
        helloTextView.setOnClickListener(textViewClicked);
        hiTextView.setOnClickListener(textViewClicked);
        helloVisible = true;
        moved = false;
        movingTextView.setOnClickListener(moveClicked);
    }
    View.OnClickListener textViewClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(
                    getApplicationContext(),
                    "TextView Clicked.",
                    Toast.LENGTH_SHORT
            ).show();

            if(helloVisible == true){
                helloTextView.animate().rotation(60f).setDuration(1500);
                helloTextView.animate().alpha(0.0f).setDuration(1500);
                hiTextView.animate().alpha(1f).setDuration(1500);
                helloVisible = false;
            }else{
                hiTextView.animate().alpha(0f).setDuration(1500);
                helloTextView.animate().rotation(0f).setDuration(1500);
                helloTextView.animate().alpha(1f).setDuration(1500);
                helloVisible = true;
            }

            //helloTextView.animate().rotation(60f).setDuration(1500);
            //helloTextView.animate().alpha(0.0f).setDuration(1500);
        }
    };

    View.OnClickListener moveClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(moved == false){
                movingTextView.animate().translationX(200f).alpha(0.5f).scaleX(1.5f).scaleY(1.5f).setDuration(1000);
                movingTextView.animate().translationY(300f).setDuration(800);
                moved = true;
            }else{
                movingTextView.animate().translationX(0f).alpha(1f).scaleX(1f).scaleY(1f).setDuration(2000);
                movingTextView.animate().translationY(0f).setDuration(1500);
                moved = false;
            }
        }
    };
}
