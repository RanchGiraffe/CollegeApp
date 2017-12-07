package org.pltw.examples.collegeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class ProfileFragment extends android.support.v4.app.Fragment {

    TextView mPText;
    TextView mPText2;
    Profile mProfile;
    EditText mPEdit;
    EditText mPEdit2;
    Button button;
    DatePicker dob;
    Calendar calendar = Calendar.getInstance();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        mPText = (TextView) rootView.findViewById(R.id.textView2);
        mPText2 = (TextView) rootView.findViewById(R.id.textView3);

        mPEdit = (EditText) rootView.findViewById(R.id.editText);
        mPEdit2 = (EditText) rootView.findViewById(R.id.editText2);

        dob = (DatePicker) rootView.findViewById(R.id.DOB);

        mProfile = new Profile();

        mPText.setText(mProfile.getFirstName());
        mPText2.setText(mProfile.getLastName());

        button = (Button) rootView.findViewById(R.id.Button1);


        dob.init(mProfile.getDob().get(Calendar.YEAR), mProfile.getDob().get(Calendar.MONTH), mProfile.getDob().get(Calendar.DAY_OF_MONTH), null);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                mPText.setText(mPEdit.getText());
                mPText2.setText(mPEdit2.getText());

                int year = dob.getYear();
                int month = dob.getMonth();
                int day = dob.getDayOfMonth();

                calendar.set(year, month, day);

                mProfile.setDob(year, month, day);
            }

        });

        return rootView;
    }
}
