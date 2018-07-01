package com.example.android.educationalapp;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class CategoryMenuFragment extends Fragment {

    private Spinner spinner;
     int selectedId =  0;

    OnSpinnerChangedListener onSpinnerChangedListener;
    public interface OnSpinnerChangedListener{
        public void onSpinnerChanged(int spinnerId);
    }

    public CategoryMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


       ArrayList<String> quizCategory = new ArrayList<>();

        quizCategory.add("Agriculture");
        quizCategory.add("ICT");



        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getContext(),  android.R.layout.simple_spinner_dropdown_item, quizCategory);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_category_menu, container, false);

        spinner =  view.findViewById(R.id.sort_by_spinner);

         spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                 onSpinnerChangedListener.onSpinnerChanged(i);
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {

             }
         });


        spinner.setAdapter(adapter);



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try{
            onSpinnerChangedListener = (OnSpinnerChangedListener) activity;
        }catch (ClassCastException e){

            throw new ClassCastException(activity.toString()+ "OnSpinnerChangedListener is not defined");

        }
    }
}
