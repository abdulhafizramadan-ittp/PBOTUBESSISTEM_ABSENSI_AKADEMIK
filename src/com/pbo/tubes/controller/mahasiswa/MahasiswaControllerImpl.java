package com.pbo.tubes.controller.mahasiswa;

import com.pbo.tubes.model.Menu;
import com.pbo.tubes.model.user.Mahasiswa;
import com.pbo.tubes.view.MahasiswaView;

public class MahasiswaControllerImpl implements MahasiswaController {

    public Mahasiswa mahasiswa;
    private final MahasiswaView mahasiswaView = new MahasiswaView();

    public MahasiswaControllerImpl(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    @Override
    public void mahasiswaMenu() {
        do {
            Menu menu = mahasiswaView.mahasiswaMenu(mahasiswa);
            switch (menu) {
                case ABSENSI:
                    mahasiswaView.absensi();
                    mahasiswa.setAbsen(true);
                    break;
                case LIHAT_STATUS_ABSENSI:
                    mahasiswaView.lihatStatusAbsensi(mahasiswa);
                    break;
                case LOGOUT:
                    boolean isLogout = mahasiswaView.logoutView();
                    if (isLogout) {
                        return;
                    }
                    break;
            }
        } while (true);
    }

    @Override
    public void absensi() {
        mahasiswaView.absensi();
    }

    @Override
    public void lihatStatusAbsensi() {
        mahasiswaView.lihatStatusAbsensi(mahasiswa);
    }
}
