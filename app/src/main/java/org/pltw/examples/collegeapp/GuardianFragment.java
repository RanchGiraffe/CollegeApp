package org.pltw.examples.collegeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GuardianFragment extends android.support.v4.app.Fragment {

    TextView mFMText;
    TextView mFMText2;
    TextView occupTextView;
    EditText mFMEdit;
    EditText mFMEdit2;
    EditText occupEditText;
    Guardian mGuardian;
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_guardian, container, false);
        mFMText = (TextView) rootView.findViewById(R.id.textView2);
        mFMText2 = (TextView) rootView.findViewById(R.id.textView3);

        mFMEdit = (EditText) rootView.findViewById(R.id.editText);
        mFMEdit2 = (EditText) rootView.findViewById(R.id.editText2);

        Guardian mGuardian = new Guardian();

        mFMText.setText(mGuardian.getFirstName());
        mFMText2.setText(mGuardian.getLastName());

        button = (Button) rootView.findViewById(R.id.Button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFMText.setText(mFMEdit.getText());
                mFMText2.setText(mFMEdit2.getText());
                occupTextView.setText(occupEditText.getText());

            }

        });

        return rootView;
    }
}