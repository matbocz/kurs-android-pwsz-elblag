package com.example.listy2;

public class Auto {
    private String nazwa;
    private String rok;

    public Auto(String nazwa, String rok) {
        this.nazwa = nazwa;
        this.rok = rok;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
        this.rok = rok;
    }
}
