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
import com.example.medsched_app.model.Consult;

import java.util.List;

public class ConsultAdapter extends RecyclerView.Adapter<ConsultAdapter.ConsultViewHolder> {

    private List<Consult> consultList;
    private Context context;

    public ConsultAdapter(Context context, List<Consult> consultList) {
        this.context = context;
        this.consultList = consultList;
    }

    @NonNull
    @Override
    public ConsultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_consult, parent, false);
        return new ConsultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsultViewHolder holder, int position) {
        Consult consult = consultList.get(position);
        holder.dateText.setText("Data: " + consult.date);

        String patientName = consult.patient != null ? consult.patient.firstName + " " + consult.patient.lastName : consult.patientId;
        holder.patientText.setText("Paciente: " + patientName);

        holder.statusText.setText("Status: " + consult.status);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ConsultDetailActivity.class);
            intent.putExtra("consult_Date", consult.date);
            intent.putExtra("consult_Patient", patientName);
            intent.putExtra("consult_Medic", consult.medic != null ? consult.medic.firstName + " " + consult.medic.lastName : consult.medicId);
            intent.putExtra("consult_Status", consult.status);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return consultList.size();
    }

    public static class ConsultViewHolder extends RecyclerView.ViewHolder {
        TextView dateText, patientText, statusText;

        public ConsultViewHolder(@NonNull View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.consult_Date);
            patientText = itemView.findViewById(R.id.consult_Patient);
            statusText = itemView.findViewById(R.id.consult_Status);
        }
    }
}
