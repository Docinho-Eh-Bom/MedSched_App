package com.example.medsched_app.screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.medsched_app.R;

public class RegisterMedicFragment extends Fragment {
    private EditText crm_input, speciality_input;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_medic, container, false);
        crm_input = view.findViewById(R.id.crm_input);
        speciality_input = view.findViewById(R.id.speciality_input);
        return view;
    }

    public String getCrm() {
        return crm_input.getText().toString();
    }

    public String getSpeciality() {
        return speciality_input.getText().toString();
    }
}
