package com.dstu.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dstu.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileEditFragment extends Fragment {

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;

    FirebaseUser user = mAuth.getInstance().getCurrentUser();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.personal_profile_edit, container, false);
        getActivity().setTitle("Ваш профиль");

        myRef = FirebaseDatabase.getInstance().getReference();

        final EditText name = (EditText)view.findViewById(R.id.textView7);
        final EditText surname = (EditText)view.findViewById(R.id.textView12);
        final EditText mail = (EditText)view.findViewById(R.id.textView13);
        final EditText password = (EditText)view.findViewById(R.id.textView14);
        final EditText verificate_password = (EditText)view.findViewById(R.id.textView16);
        final EditText date = (EditText)view.findViewById(R.id.textView17);
        final EditText school = (EditText)view.findViewById(R.id.textView18);
        Button button  = (Button)view.findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (password.getText().toString() == verificate_password.getText().toString()) {
                    myRef.child("abiturients").child(user.getUid()).child("name").setValue(name.getText().toString());
                    myRef.child("abiturients").child(user.getUid()).child("surname").setValue(surname.getText().toString());
                    myRef.child("abiturients").child(user.getUid()).child("mail").setValue(mail.getText().toString());
                    myRef.child("abiturients").child(user.getUid()).child("password").setValue(password.getText().toString());
                    myRef.child("abiturients").child(user.getUid()).child("verificate_password").setValue(verificate_password.getText().toString());
                    myRef.child("abiturients").child(user.getUid()).child("date").setValue(date.getText().toString());
                    myRef.child("abiturients").child(user.getUid()).child("school").setValue(school.getText().toString());
                    Toast.makeText(getActivity(), "Данные сохранены", Toast.LENGTH_SHORT).show();
               // } else {
               //     Toast.makeText(getActivity(), "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                //}
            }
        });



        return view;
    }
}
