package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {

        Button b_submit = findViewById(R.id.bv_submit);
        Button b_send_mail = findViewById(R.id.bv_send_mail);

        //variable declarations for each question options
        RadioButton q1_op2 = findViewById(R.id.rb_q1_o2);
        EditText q2_op = findViewById(R.id.et_q2);
        EditText q3_op = findViewById(R.id.et_q3);
        CheckBox q4_o1 = findViewById(R.id.cb_q4_o1);
        CheckBox q4_o2 = findViewById(R.id.cb_q4_o2);
        CheckBox q4_o3 = findViewById(R.id.cb_q4_o3);
        RadioButton q5_op3 = findViewById(R.id.rb_q5_o3);
        RadioButton q6_op1 = findViewById(R.id.rb_q6_o1);
        EditText q7_op = findViewById(R.id.et_q7);
        CheckBox q8_o1 = findViewById(R.id.cb_q8_o1);
        CheckBox q8_o2 = findViewById(R.id.cb_q8_o2);
        CheckBox q8_o3 = findViewById(R.id.cb_q8_o3);
        CheckBox q9_o1 = findViewById(R.id.cb_q9_o1);
        CheckBox q9_o2 = findViewById(R.id.cb_q9_o2);
        CheckBox q9_o3 = findViewById(R.id.cb_q9_o3);
        EditText q10_op = findViewById(R.id.et_q10);

        //for first question
        if (q1_op2.isChecked()) {
            LinearLayout llv=findViewById(R.id.llv_q1);
            llv.setBackgroundResource(R.drawable.correct_answer);
            score += 1;
        }
        else{
            LinearLayout llv=findViewById(R.id.llv_q1);
            llv.setBackgroundResource(R.drawable.wrong_answer);
        }
        //for second question
        if (q2_op.getText().toString().trim().toLowerCase().equals("australia")) {
            LinearLayout llv=findViewById(R.id.llv_q2);
            llv.setBackgroundResource(R.drawable.correct_answer);
            score += 1;
        }
        else{
            LinearLayout llv=findViewById(R.id.llv_q2);
            llv.setBackgroundResource(R.drawable.wrong_answer);
        }
        //for third question
        if (q3_op.getText().toString().trim().toLowerCase().equals("geographic grids")) {
            score += 1;
            LinearLayout llv=findViewById(R.id.llv_q3);
            llv.setBackgroundResource(R.drawable.correct_answer);
        } else {
            LinearLayout llv=findViewById(R.id.llv_q3);
            llv.setBackgroundResource(R.drawable.wrong_answer);
        }
        //for fourth question
        if (q4_o1.isChecked() && q4_o2.isChecked() && !q4_o3.isChecked()) {
            score += 1;
            LinearLayout llv=findViewById(R.id.llv_q4);
            llv.setBackgroundResource(R.drawable.correct_answer);
        } else {
            LinearLayout llv=findViewById(R.id.llv_q4);
            llv.setBackgroundResource(R.drawable.wrong_answer);
        }
        //for fifth question
        if (q5_op3.isChecked()) {
            score += 1;
            LinearLayout llv=findViewById(R.id.llv_q5);
            llv.setBackgroundResource(R.drawable.correct_answer);
        } else {
            LinearLayout llv=findViewById(R.id.llv_q5);
            llv.setBackgroundResource(R.drawable.wrong_answer);
        }
        //for sixth question
        if (q6_op1.isChecked()) {
            score += 1;
            LinearLayout llv=findViewById(R.id.llv_q6);
            llv.setBackgroundResource(R.drawable.correct_answer);
        } else {
            LinearLayout llv=findViewById(R.id.llv_q6);
            llv.setBackgroundResource(R.drawable.wrong_answer);
        }
        //for seventh question
        if (q7_op.getText().toString().trim().toLowerCase().equals("ionosphere")) {
            score += 1;
            LinearLayout llv=findViewById(R.id.llv_q7);
            llv.setBackgroundResource(R.drawable.correct_answer);
        } else {
            LinearLayout llv=findViewById(R.id.llv_q7);
            llv.setBackgroundResource(R.drawable.wrong_answer);
        }
        //for eighth question
        if (q8_o1.isChecked() && q8_o2.isChecked() && !q8_o3.isChecked()) {
            score += 1;
            LinearLayout llv=findViewById(R.id.llv_q8);
            llv.setBackgroundResource(R.drawable.correct_answer);
        } else {
            LinearLayout llv=findViewById(R.id.llv_q8);
            llv.setBackgroundResource(R.drawable.wrong_answer);
        }
        //for ninth question
        if (q9_o1.isChecked() && q9_o2.isChecked() && q9_o3.isChecked()) {
            score += 1;
            LinearLayout llv=findViewById(R.id.llv_q9);
            llv.setBackgroundResource(R.drawable.correct_answer);
        } else {
            LinearLayout llv=findViewById(R.id.llv_q9);
            llv.setBackgroundResource(R.drawable.wrong_answer);
        }
        //for tenth question
        if (q10_op.getText().toString().trim().toLowerCase().equals("basalt plateau")) {
            score += 1;
            LinearLayout llv=findViewById(R.id.llv_q10);
            llv.setBackgroundResource(R.drawable.correct_answer);
        } else {
            LinearLayout llv=findViewById(R.id.llv_q10);
            llv.setBackgroundResource(R.drawable.wrong_answer);
        }

        if (score == 10) {
            Toast.makeText(this, "Congratulations!!! You scored 10/10...", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Your score is " + score + "/10 Better luck next time.", Toast.LENGTH_SHORT).show();
        }

        b_submit.setVisibility(View.INVISIBLE);
        b_send_mail.setVisibility(View.VISIBLE);
    }

    public void mailResult(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Quiz Result");
        intent.putExtra(Intent.EXTRA_TEXT, "Your score is" + score + "/10");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}