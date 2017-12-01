package org.pltw.examples.collegeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileFragment extends android.support.v4.app.Fragment {

    TextView mPText;
    TextView mPText2;
    Profile mProfile;
    EditText mPEdit;
    EditText mPEdit2;
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        mPText = (TextView) rootView.findViewById(R.id.textView2);
        mPText2 = (TextView) rootView.findViewById(R.id.textView3);

        mPEdit = (EditText) rootView.findViewById(R.id.editText);
        mPEdit2 = (EditText) rootView.findViewById(R.id.editText2);

        mProfile = new Profile();

        mPText.setText(mProfile.getFirstName());
        mPText2.setText(mProfile.getLastName());

        button = (Button) rootView.findViewById(R.id.Button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPText.setText(mPEdit.getText());
                mPText2.setText(mPEdit2.getText());
            }

        });

        return rootView;
    }
}
