package com.dstu.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dstu.myapplication.R;
import com.dstu.myapplication.models.Abiturient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileInformationFragment extends Fragment {

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    TextView fi;
    TextView school;
    TextView email;
    TextView date;
    TextView phone;
    TextView city;
    TextView directions;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_profile, container, false);

        //ImageView imageView = (ImageView)view.findViewById(R.id.imageView5);
        //Glide.with(this).load("https://ec.donstu.ru/site/ci/base/captcha").into(imageView);
        myRef = FirebaseDatabase.getInstance().getReference();
        fi = (TextView)view.findViewById(R.id.textView31);
        school = (TextView)view.findViewById(R.id.textView12);
        email = (TextView)view.findViewById(R.id.textView14);
        date = (TextView)view.findViewById(R.id.textView16);
        phone = (TextView)view.findViewById(R.id.textView13);
        city = (TextView)view.findViewById(R.id.textView7);
        directions = (TextView)view.findViewById(R.id.textView18);
        myRef.child("abiturients").child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Abiturient abiturient = dataSnapshot.getValue(Abiturient.class);
                fi.setText(abiturient.getName()+" "+abiturient.getSurname());
                date.setText(abiturient.getDate());
                email.setText(abiturient.getMail());
                phone.setText(user.getPhoneNumber());
                city.setText(abiturient.getCity());
                school.setText(abiturient.getSchool());
                directions.setText(abiturient.getDirections());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
        }
}
