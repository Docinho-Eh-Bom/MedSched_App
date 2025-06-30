package com.example.medsched_app.screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.medsched_app.R;

public class RegisterPatientFragment extends Fragment {
    public EditText cpf_input, cellphone_input;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_patient, container, false);
        cpf_input = view.findViewById(R.id.cpf_input);
        cellphone_input = view.findViewById(R.id.cellphone_input);
        return view;
    }

    public String getCpf() {
        return cpf_input.getText().toString();
    }

    public String getCellphone() {
        return cellphone_input.getText().toString();
    }
}

