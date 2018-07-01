package com.example.android.educationalapp;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity
        implements CategoryMenuFragment.OnSpinnerChangedListener,
        QuizCategoryFragment.OnSubmitAgricScoreListener,
        IctFragment.OnIctScoreListener,
        ResultFragment.OnResultListerner{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //attach a toolbar to hold menu from where we can have a logout for the quiz
        Toolbar toolbar = findViewById(R.id.menu_toolbar);
        setSupportActionBar(toolbar);


        //to attach the fragment for the spinner, lets check whether the view is available to accept it
        if (findViewById(R.id.spinner_fragment) != null) {
            //check the previous saved data for this activity is not null, if not return
            if (savedInstanceState != null) {
                return;
            }

            //attach the fragment for the category select
            CategoryMenuFragment categoryFragment = new CategoryMenuFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                    .beginTransaction().add(R.id.spinner_fragment, categoryFragment, null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        int ictScore = IctFragment.ictScores;
        int agricScore = QuizCategoryFragment.agricScore;
    }

    //inflate the view for the toolbar menu item
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    //method to handle the selected toolbar option selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menuLogout:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
        return true;
    }

    public void onSpinnerChanged(int spinnerId) {
        // The user selected a category of an dropdown menu Item from the CategoryMenuFragment
        // Do something here to display that quiz category

        if (spinnerId == 0) {
            QuizCategoryFragment agricCategoryFragment = new QuizCategoryFragment();
            FragmentTransaction quizFragmentTransaction = getSupportFragmentManager()
                    .beginTransaction().replace(R.id.quiz_page_template, agricCategoryFragment, null);
            quizFragmentTransaction.addToBackStack(null);
            quizFragmentTransaction.commit();

        } else if (spinnerId == 1) {
            // Otherwise, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            IctFragment ictFragment = new IctFragment();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            QuizCategoryFragment agricCategoryFragment = new QuizCategoryFragment();
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.quiz_page_template, ictFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        } else {

            QuizCategoryFragment agricCategoryFragment = new QuizCategoryFragment();
            FragmentTransaction quizFragmentTransaction = getSupportFragmentManager()
                    .beginTransaction().replace(R.id.quiz_page_template, agricCategoryFragment, null);
            quizFragmentTransaction.addToBackStack(null);
            quizFragmentTransaction.commit();
        }
    }


    @Override
    public boolean onSubmitAgricScore(int agricScore) {

        Intent intentResult = new Intent(this, ResultFragment.class);
        startActivity(intentResult);

        Intent receiveIntent = getIntent();


        String sendMsg = "Thanks for Participating,  you scored:" + agricScore + "% You can try again";

       // Toast.makeText(getApplicationContext(), sendMsg, Toast.LENGTH_SHORT).show();


        String respondentName = receiveIntent.getStringExtra(MainActivity.NAME);
        String respondentEmail = receiveIntent.getStringExtra(MainActivity.EMAIL);
        boolean sendMail = receiveIntent.getBooleanExtra("sendMail", false);

        if (sendMail) {
            // Use an intent to launch an email app.
            // Send the order summary in the email body.

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + respondentEmail)); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, respondentName + " Agriculture Quiz Result");
            intent.putExtra(Intent.EXTRA_TEXT, sendMsg);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }
        return false;
    }


    @Override
    public boolean onIctScore(int scores) {
        Intent receiveIntent = getIntent();

        Intent intentResult = new Intent(this, ResultFragment.class);
        startActivity(intentResult);

        String sendMsg = "Thanks for Participating,  you scored:" + scores + "% You can try again";
//
//        Toast.makeText(getApplicationContext(), sendMsg, Toast.LENGTH_SHORT).show();


        String respondentName = receiveIntent.getStringExtra(MainActivity.NAME);
        String respondentEmail = receiveIntent.getStringExtra(MainActivity.EMAIL);
        boolean sendMail = receiveIntent.getBooleanExtra("sendMail", false);

        if (sendMail) {
            // Use an intent to launch an email app.
            // Send the order summary in the email body.

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + respondentEmail)); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, respondentName + " ICT Quiz Result");
            intent.putExtra(Intent.EXTRA_TEXT, sendMsg);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }
        return false;

    }

    @Override
    public void onReSult(int scores) {

        ResultFragment resultFragment = new ResultFragment();
        FragmentTransaction quizFragmentTransaction = getSupportFragmentManager()
                .beginTransaction().replace(R.id.quiz_page_template, resultFragment, null);

        quizFragmentTransaction.addToBackStack(null);
        quizFragmentTransaction.commit();
    }


}
