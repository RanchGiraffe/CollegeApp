package org.pltw.examples.collegeapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.Calendar;
import java.util.List;

public class ProfileFragment extends android.support.v4.app.Fragment {

    TextView mPText;
    TextView mPText2;
    Profile mProfile = new Profile();
    EditText mPEdit;
    EditText mPEdit2;
    Button button;
    DatePicker dob;
    Calendar calendar = Calendar.getInstance();
    int WITHIN_8_YEARS = 2011;
    String TAG = "Profile Fragment";




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

                try {
                    if (dob.getYear() <= WITHIN_8_YEARS) {
                        int year = dob.getYear();
                        int month = dob.getMonth();
                        int day = dob.getDayOfMonth();

                        calendar.set(year, month, day);
                        mProfile.setDob(year, month, day);
                    }
                    else throw new AgeException("Who are you, Michael Kearney?");
                } catch (AgeException e) {
                Log.i(TAG, e.joinMessageAndYear(e.getMessage(), dob.getYear()));
            }
                mProfile.setFirstName(mPEdit.getText().toString());
                mProfile.setLastName(mPEdit2.getText().toString());
        }});

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        String email = sharedPreferences.getString(ApplicantActivity.EMAIL_PREF, null);
        if (mProfile.getEmail() == null) {
            mProfile.setEmail(email);
        }
        String whereClause = "email = '" + email + "'";
        DataQueryBuilder query = DataQueryBuilder.create();
        query.setWhereClause(whereClause);
        Backendless.Data.of(Profile.class).find(query, new AsyncCallback<List<Profile>>() {
            @Override
            public void handleResponse(List<Profile> profile) {
                if (!profile.isEmpty()) {
                    String profileId = profile.get(0).getObjectId();
                    Log.d(TAG, "Object ID: " + profileId);
                    mProfile.setObjectId(profileId);
                }
            }
            @Override
            public void handleFault(BackendlessFault fault) {
                Log.e(TAG, "Failed to find profile: " + fault.getMessage());
            }
        });

        Backendless.Data.of(Profile.class).save(mProfile, new AsyncCallback<Profile>() {
            @Override
            public void handleResponse(Profile response) {
                Log.i(TAG, "Saved profile to Backendless");
            }
            public void handleFault(BackendlessFault fault) {
                Log.i(TAG, "Failed to save profile!" + fault.getMessage());
            }
        });
    }
}
