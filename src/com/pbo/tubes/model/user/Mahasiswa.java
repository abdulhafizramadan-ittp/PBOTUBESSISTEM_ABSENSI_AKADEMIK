package com.pbo.tubes.model.user;

import com.pbo.tubes.model.Level;

public class Mahasiswa extends User {
    boolean isAbsen;

    public Mahasiswa(String name, String email, String password) {
        super(name, email, password, Level.Mahasiswa);
        this.isAbsen = false;
    }

    public boolean isAbsen() {
        return isAbsen;
    }

    public void setAbsen(boolean absen) {
        isAbsen = absen;
    }
}
