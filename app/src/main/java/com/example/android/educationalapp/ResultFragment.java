package com.example.android.educationalapp;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {

    OnResultListerner onResultListerner;

   int resultIctScores = 0;
   int resultAgricScores = 0;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_result, container, false);

        return view;





    }

    @Override
    public void onResume() {
        super.onResume();

        final int agricScore = QuizCategoryFragment.agricScore;
        final int resultIctScores = IctFragment.ictScores;
    }

    public static ResultFragment newInstance(int agricScores, int ictScore ){

        ResultFragment results =new ResultFragment();
        //Supply the construction argument for this fragment
        Bundle result = new Bundle();
        result.putInt("agricScores", ictScore);
        result.putInt("ictScores", agricScores);
        results.setArguments(result);
        return(results);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try{

            onResultListerner = (OnResultListerner) activity;

        }catch (ClassCastException e){

            throw new ClassCastException(activity.toString() + "OnResultListerner is not defined");
        }
    }

    public interface OnResultListerner{
        void onReSult(int scores);

    }

}
