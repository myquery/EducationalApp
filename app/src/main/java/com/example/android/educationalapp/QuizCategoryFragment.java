package com.example.android.educationalapp;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuizCategoryFragment extends Fragment {


    //initialise score to score and add to it on correct answer
    public static int agricScore = 0;

    OnSubmitAgricScoreListener onSubmitAgricScoreListener;

    //declare the radiogroups in the layout
    private RadioGroup radioGroupAgricOne;
    private RadioGroup radioGroupAgricTwo;
    private RadioGroup radioGroupAgricThree;
    private RadioGroup radioGroupAgricFour;
    private RadioGroup radioGroupAgricFive;
    private RadioGroup radioGroupAgricSix;
    private RadioGroup radioGroupAgricSeven;
    private RadioGroup radioGroupAgricEight;
    private RadioGroup radioGroupAgricNine;
    private RadioGroup radioGroupAgricTen;


    //declare the radio buttons that are the correct answers to the question
    private RadioButton chlorosis;
    private RadioButton legumesSoilSurface;
    private RadioButton tobacco;
    private RadioButton soilCondition;
    private RadioButton bestSoil;
    private RadioButton aspergillosis;
    private RadioButton photosynthesis;
    private RadioButton maleOrgan;
    private RadioButton rumen;
    private RadioButton monogastric;

    public QuizCategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_quiz_category, container, false);
        Button button = view.findViewById(R.id.submit_quiz);




        //get the radioGroups by id
        radioGroupAgricOne = view.findViewById(R.id.agric_group_one);
        radioGroupAgricTwo = view.findViewById(R.id.agric_group_two);
        radioGroupAgricThree = view.findViewById(R.id.agric_group_three);
        radioGroupAgricFour = view.findViewById(R.id.agric_group_four);
        radioGroupAgricFive = view.findViewById(R.id.agric_group_five);
        radioGroupAgricSix = view.findViewById(R.id.agric_group_six);
        radioGroupAgricSeven = view.findViewById(R.id.agric_group_seven);
        radioGroupAgricEight = view.findViewById(R.id.agric_group_eight);
        radioGroupAgricNine = view.findViewById(R.id.agric_group_nine);
        radioGroupAgricTen = view.findViewById(R.id.agric_group_ten);

        //get the view from the layout, only the ones that are the correct answers
        chlorosis = view.findViewById(R.id.chlorosis);
        legumesSoilSurface = view.findViewById(R.id.legumes_soil_surface);
        tobacco = view.findViewById(R.id.beverage_three);
        soilCondition = view.findViewById(R.id.organic_two);
        bestSoil = view.findViewById(R.id.loamy_one);
        aspergillosis = view.findViewById(R.id.fungal_one);
        photosynthesis = view.findViewById(R.id.photosynthesis_one);
        maleOrgan = view.findViewById(R.id.male_organ_two);
        rumen = view.findViewById(R.id.ruminant_one);
        monogastric = view.findViewById(R.id.monogastric_three);

        //check to see if selected radio button  is the correct answer button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitquiz();
            }
        });


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        try {
            onSubmitAgricScoreListener = (OnSubmitAgricScoreListener) activity;
        } catch (ClassCastException e) {

            throw new ClassCastException(activity.toString() + "OnSubmitAgricScoreListener is not defined");
        }
    }


    public interface OnSubmitAgricScoreListener {
        public boolean onSubmitAgricScore(int agricScore);


    }

    //create a private method to handle the quiz results
    private void submitquiz() {

        boolean hasClorosis = chlorosis.isChecked();
        boolean hasLegumesSoilSurface = legumesSoilSurface.isChecked();
        boolean hasTobacco = tobacco.isChecked();
        boolean hasSoilCondition = soilCondition.isChecked();
        boolean hasBestSoil = bestSoil.isChecked();
        boolean hasAspergillosis = aspergillosis.isChecked();
        boolean hasPhotosynthesis = photosynthesis.isChecked();
        boolean hasMaleOrgan = maleOrgan.isChecked();
        boolean hasRumen = rumen.isChecked();
        boolean hasMonogastric = monogastric.isChecked();


        //try each radioGroup child button to check if the selected radiobutton is the correct answer
        try {
            if ((radioGroupAgricOne.getCheckedRadioButtonId() == R.id.chlorosis) && hasClorosis) {
                agricScore += 10;
            } else {
                agricScore -= 10;
            }

            if ((radioGroupAgricOne.getCheckedRadioButtonId() == R.id.legumes_soil_surface) && hasLegumesSoilSurface) {
                agricScore += 10;
            } else {
                agricScore -= 10;
            }


            if ((radioGroupAgricThree.getCheckedRadioButtonId() == R.id.beverage_three) && hasTobacco) {
                agricScore += 10;

            } else {
                agricScore -= 10;

            }

            if ((radioGroupAgricFour.getCheckedRadioButtonId() == R.id.organic_two) && hasSoilCondition) {
                agricScore += 10;

            } else {
                agricScore -= 10;

            }

            if ((radioGroupAgricFive.getCheckedRadioButtonId() == R.id.loamy_one) && hasBestSoil) {
                agricScore += 10;

            } else {
                agricScore -= 10;

            }

            if ((radioGroupAgricSix.getCheckedRadioButtonId() == R.id.fungal_one) && hasAspergillosis) {
                agricScore += 10;

            } else {
                agricScore -= 10;

            }

            if ((radioGroupAgricSeven.getCheckedRadioButtonId() == R.id.photosynthesis_one) && hasPhotosynthesis) {
                agricScore += 10;

            } else {
                agricScore -= 10;

            }


            if ((radioGroupAgricEight.getCheckedRadioButtonId() == R.id.male_organ_two) && hasMaleOrgan) {
                agricScore += 10;

            } else {
                agricScore -= 10;

            }


            if ((radioGroupAgricNine.getCheckedRadioButtonId() == R.id.ruminant_one) && hasRumen) {
                agricScore += 10;

            } else {
                agricScore -= 10;

            }


            if ((radioGroupAgricTen.getCheckedRadioButtonId() == R.id.monogastric_three) && hasMonogastric) {
                agricScore += 10;

            } else {
                agricScore -= 10;

            }
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }

    public int getScores(){
        return agricScore;
    }
}
