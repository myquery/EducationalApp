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
public class IctFragment extends Fragment {

    //instantiate the interface to handle scores
    OnIctScoreListener onIctScoreListener;

    //initialise ict score count
    public static int ictScores = 0;

    //instantiate the radio groups per question set

    private RadioGroup radioGroupIctOne;
    private RadioGroup radioGroupIctTwo;
    private RadioGroup radioGroupIctThree;
    private RadioGroup radioGroupIctFour;
    private RadioGroup radioGroupIctFive;
    private RadioGroup radioGroupIctSix;
    private RadioGroup radioGroupIctSeven;
    private RadioGroup radioGroupIctEight;
    private RadioGroup radioGroupIctNine;
    private RadioGroup radioGroupIctTen;

    //instante the radioButton of the correct answer
    private RadioButton wan;
    private RadioButton html;
    private RadioButton programming;
    private RadioButton computer;
    private RadioButton device;
    private RadioButton www;
    private RadioButton process;
    private RadioButton xml;
    private RadioButton computerBrain;
    private RadioButton protocol;


    public IctFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_ict, container, false);

        Button button = view.findViewById(R.id.submit_quiz);


        //get the radioGroups by id
        radioGroupIctOne = view.findViewById(R.id.ict_group_one);
        radioGroupIctTwo = view.findViewById(R.id.ict_group_two);
        radioGroupIctThree = view.findViewById(R.id.ict_group_three);
        radioGroupIctFour = view.findViewById(R.id.ict_group_four);
        radioGroupIctFive = view.findViewById(R.id.ict_group_five);
        radioGroupIctSix = view.findViewById(R.id.ict_group_six);
        radioGroupIctSeven = view.findViewById(R.id.ict_group_seven);
        radioGroupIctEight = view.findViewById(R.id.ict_group_eight);
        radioGroupIctNine = view.findViewById(R.id.ict_group_nine);
        radioGroupIctTen = view.findViewById(R.id.ict_group_ten);

        //get the view from the layout, only the ones that are the correct answers
        wan = view.findViewById(R.id.wide_area_network);
        html = view.findViewById(R.id.hypertext_markup_language);
        programming = view.findViewById(R.id.xml_language);
        computer = view.findViewById(R.id.hardware_operation_system);
        device = view.findViewById(R.id.hard_disk_drive);
        www = view.findViewById(R.id.tim_berner);
        process = view.findViewById(R.id.program_execution);
        xml = view.findViewById(R.id.extensible_markup);
        computerBrain = view.findViewById(R.id.cpu);
        protocol = view.findViewById(R.id.wan);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitIctQuiz();
            }
        });

        return view;
    }

    private void submitIctQuiz() {
        boolean hasWan = wan.isChecked();
        boolean hasHtml = html.isChecked();
        boolean hasProgramming = programming.isChecked();
        boolean hasComputer = computer.isChecked();
        boolean hasDevice = device.isChecked();
        boolean hasWww = www.isChecked();
        boolean hasProcess = process.isChecked();
        boolean hasXml = xml.isChecked();
        boolean hasComputerBrain = computerBrain.isChecked();
        boolean hasProtocol = protocol.isChecked();


        //try each radioGroup child button to check if the selected radiobutton is the correct answer
        try {
            if ((radioGroupIctOne.getCheckedRadioButtonId() == R.id.chlorosis) && hasWan) {
                ictScores += 10;
            } else {
                ictScores -= 10;
            }

            if ((radioGroupIctTwo.getCheckedRadioButtonId() == R.id.legumes_soil_surface) && hasHtml) {
                ictScores += 10;
            } else {
                ictScores -= 10;
            }


            if ((radioGroupIctThree.getCheckedRadioButtonId() == R.id.beverage_three) && hasProgramming) {
                ictScores += 10;

            } else {
                ictScores -= 10;

            }

            if ((radioGroupIctFour.getCheckedRadioButtonId() == R.id.organic_two) && hasComputer) {
                ictScores += 10;

            } else {
                ictScores -= 10;

            }

            if ((radioGroupIctFive.getCheckedRadioButtonId() == R.id.loamy_one) && hasDevice) {
                ictScores += 10;

            } else {
                ictScores -= 10;

            }

            if ((radioGroupIctSix.getCheckedRadioButtonId() == R.id.fungal_one) && hasWww) {
                ictScores += 10;

            } else {
                ictScores -= 10;

            }

            if ((radioGroupIctSeven.getCheckedRadioButtonId() == R.id.photosynthesis_one) && hasProcess) {
                ictScores += 10;

            } else {
                ictScores -= 10;

            }


            if ((radioGroupIctEight.getCheckedRadioButtonId() == R.id.male_organ_two) && hasXml) {
                ictScores += 10;

            } else {
                ictScores -= 10;

            }


            if ((radioGroupIctNine.getCheckedRadioButtonId() == R.id.ruminant_one) && hasComputerBrain) {
                ictScores += 10;

            } else {
                ictScores -= 10;

            }


            if ((radioGroupIctTen.getCheckedRadioButtonId() == R.id.monogastric_three) && hasProtocol) {
                ictScores += 10;

            } else {
                ictScores -= 10;

            }
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;

        try {
            onIctScoreListener = (OnIctScoreListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "OnIctScoreListener is not defined");

        }
    }

    interface OnIctScoreListener {
        boolean onIctScore(int scores);
    }

    public int getScores(){
        return ictScores;
    }

}
