package com.example.medsched_app.retroft;

import com.example.medsched_app.model.Medic;
import com.example.medsched_app.model.Patient;
import com.example.medsched_app.req_res.ConsultRequest;
import com.example.medsched_app.req_res.ConsultResponse;
import com.example.medsched_app.req_res.LoginRequest;
import com.example.medsched_app.req_res.LoginResponse;
import com.example.medsched_app.req_res.RegisterRequest;
import com.example.medsched_app.req_res.RegisterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MedSchedApi {
    //login
    @POST("/login")
    Call<LoginResponse> login(@Body LoginRequest request);

    //register user
    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequest request);

    //create consult
    @POST("/consults")
    Call<ConsultResponse> createConsult(@Body ConsultRequest request);

    //list consult
    @GET("/consults")
    Call<List<ConsultResponse>> getConsults();

    //list medics
    @GET("/medics")
    Call<List<Medic>> getMedics();

    //list patients
    @GET("/patients")
    Call<List<Patient>> getPatients();
}
