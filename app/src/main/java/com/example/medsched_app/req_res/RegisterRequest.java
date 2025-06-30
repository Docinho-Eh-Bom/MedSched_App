package com.example.medsched_app.req_res;

public class RegisterRequest {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String role;

    //role fields
    //patient
    private String cpf;
    private String cellphone;
    //medic
    private String crm;
    private String speciality;

    public RegisterRequest(String firstName, String lastName, String email, String password, String role, String cpf, String cellphone, String crm, String speciality){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password ;
        this.role = role;
        this.cpf = cpf;
        this.cellphone = cellphone;
        this.crm = crm;
        this.speciality = speciality;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
