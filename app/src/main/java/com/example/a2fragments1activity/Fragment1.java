package com.example.a2fragments1activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    EditText firstName,lastName,rollNo,email,department;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_1, container, false);
        Button btn=view.findViewById(R.id.btn);
        rollNo=view.findViewById(R.id.rollNO);
        firstName=view.findViewById(R.id.firstName);
        lastName=view.findViewById(R.id.lastName);
        email=view.findViewById(R.id.email);
        department=view.findViewById(R.id.department);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("first name",firstName.getText().toString());
                bundle.putString("last name",lastName.getText().toString());
                bundle.putString("roll no",rollNo.getText().toString());
                bundle.putString("email",email.getText().toString());
                bundle.putString("department",department.getText().toString());
                Toast.makeText(getContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                rollNo.setText("");
                firstName.setText("");
                lastName.setText("");
                email.setText("");
                department.setText("");
                Fragment2 fragment2=new Fragment2();
                fragment2.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame,fragment2).commit();
            }
        });






//        getFragmentManager().beginTransaction().replace(R.id.frame,new Fragment2()).commit();
        return view;
    }

}