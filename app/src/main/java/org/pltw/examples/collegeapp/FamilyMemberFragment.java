package org.pltw.examples.collegeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class FamilyMemberFragment extends android.support.v4.app.Fragment {

    TextView mFMText;
    TextView mFMText2;
    EditText mFMEdit;
    FamilyMember mFamilyMember;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_family_member, container, false);
        mFMText = (TextView) rootView.findViewById(R.id.textView2);
        mFMText2 = (TextView) rootView.findViewById(R.id.textView3);
        mFamilyMember = new FamilyMember();

        mFMText.setText(mFamilyMember.getFirstName());
        mFMText2.setText(mFamilyMember.getLastName());

        return rootView;
    }
}