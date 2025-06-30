package com.example.medsched_app.screen;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medsched_app.R;
import com.example.medsched_app.model.Patient;

import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientViewHolder> {

    private List<Patient> patientList;
    private Context context;

    public PatientAdapter(Context context, List<Patient> patientList) {
        this.context = context;
        this.patientList = patientList;
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_patient, parent, false);
        return new PatientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        Patient patient = patientList.get(position);
        holder.nameText.setText(patient.firstName + " " + patient.lastName);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PatientDetailActivity.class);
            intent.putExtra("name", patient.firstName + " " + patient.lastName);
            intent.putExtra("cpf", patient.cpf);
            intent.putExtra("cellphone", patient.cellphone);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    public static class PatientViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;

        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.patient_Name);
        }
    }
}
