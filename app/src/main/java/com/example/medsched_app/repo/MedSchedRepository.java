package com.example.medsched_app.repo;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.medsched_app.db_room.ConsultDao;
import com.example.medsched_app.db_room.MedSchedDatabase;
import com.example.medsched_app.db_room.MedicDao;
import com.example.medsched_app.db_room.PatientDao;
import com.example.medsched_app.model.Consult;
import com.example.medsched_app.model.Medic;
import com.example.medsched_app.model.Patient;
import com.example.medsched_app.req_res.ConsultRequest;
import com.example.medsched_app.req_res.ConsultResponse;
import com.example.medsched_app.req_res.LoginRequest;
import com.example.medsched_app.req_res.LoginResponse;
import com.example.medsched_app.req_res.RegisterRequest;
import com.example.medsched_app.req_res.RegisterResponse;
import com.example.medsched_app.retroft.MedSchedApi;
import com.example.medsched_app.retroft.RetrofitClient;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;

public class MedSchedRepository {
    private final MedSchedApi api;
    private final MedicDao medicDao;
    private final PatientDao patientDao;
    private  final ConsultDao consultDao;

    public MedSchedRepository(Context context){
        MedSchedDatabase db = MedSchedDatabase.getInstance(context);
        this.api = RetrofitClient.getInstance().getApi();
        this.medicDao = db.medicDao();
        this.patientDao = db.patientDao();
        this.consultDao = db.consultDao();
    }

    //login and register
    public LoginResponse login(String email, String password){
        try{
            Response<LoginResponse> response = api.login(new LoginRequest(email, password)).execute();
            return response.body();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public RegisterResponse register(RegisterRequest request){
        try{
            Response<RegisterResponse> response = api.register(request).execute();
            //return response.body();
            if (!response.isSuccessful()){
                Log.e("API", "Erro HTTP: " + response.code() + " - " + response.message());
            }
        } catch (IOException e) {
            Log.e("API_ERROR", "Erro na requisição", e);
            e.printStackTrace();
        }
        return null;
    }

    //medics
    public void fetchAndSaveMedics(){
        AsyncTask.execute(() ->{
            try{
                Response<List<Medic>> response = api.getMedics().execute();
                if(response.isSuccessful() && response.body() != null){
                    medicDao.insertAll(response.body());
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }

    public List<Medic> getLocalPatients(){
        return medicDao.getAll();
    }

    //patients
    public void fetchAndSavePatients(){
        AsyncTask.execute(() ->{
            try{
                Response<List<Patient>> response = api.getPatients().execute();
                if(response.isSuccessful() && response.body() != null){
                    patientDao.insertAll(response.body());
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }

    public List<Patient> getLocalPatient(){
        return patientDao.getAll();
    }

    //consults (list and create)

    public void createConsult(ConsultRequest request){
        AsyncTask.execute(() -> {
            try{
                api.createConsult(request).execute();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }

    public void fetchAndSaveConsults(){
        AsyncTask.execute(() -> {
            try {
                Response<List<ConsultResponse>> response = api.getConsults().execute();
                if(response.isSuccessful() && response.body() != null){
                    List<Consult> flattened = ConsultMapToRoom.mapResponseToConsults(response.body());
                    consultDao.insertAll(flattened);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }

    public List<Consult> getLocalConsult(){
        return consultDao.getAll();
    }
}
