package com.example.android.educationalapp;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {


//declare the view from the layout
    private String name;
    private String email;
    private boolean sendMail;
    private int selectedId;

    //declare tbe class variable for the name, email and sendmail
    public final static String NAME = "respondentName";
    public final static String EMAIL = "respondentEmail";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 19) {
            //attach a flag if it is greater that 19
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            //otherwise clear the flags
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        //initialized the intent to move the the name, email and sendmail property to QuizActivity
       final Intent intent = new Intent(this, QuizActivity.class);

            //get the buttion from the view
        Button gotoquiz = (Button) findViewById(R.id.take_quiz);

        //set the click listener for the button to capture the clicks on the button
        gotoquiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //get the text entered into the edittext view
                EditText nameText = (EditText) findViewById(R.id.quiz_name);
                name = nameText.getText().toString();

                //get the text entered into the edittext view
                EditText emailText = (EditText) findViewById(R.id.quiz_email);
                email = emailText.getText().toString();

                //check whether the checkbox is checked
                CheckBox checkedText = (CheckBox) findViewById(R.id.send_to_email);
                sendMail = checkedText.isChecked();

                if(name.isEmpty() ){
                  //make a toast to inform the user to provide an email address
                 Toast.makeText(getApplicationContext(), "Please, enter your name just we can know you ", Toast.LENGTH_LONG ).show();
                return;
                }

                if(sendMail && email.isEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    //make a toast if the users checked send mail but did not provide an email address
                    Toast.makeText(getApplicationContext(), "Please provide a valid email address", Toast.LENGTH_LONG).show();
                    return;
                }

                 //try if the extra data passed to the intent object is propagated if not throw error
                    try{

                        intent.putExtra(MainActivity.NAME, name);
                        intent.putExtra(MainActivity.EMAIL, email);
                        intent.putExtra("sendMail", sendMail);

                        startActivity(intent);

                    }catch (Exception e){
                      Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG ).show();
                    }




            }
        });
    }




}
