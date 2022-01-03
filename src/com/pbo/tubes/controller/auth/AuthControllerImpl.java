package com.pbo.tubes.controller.auth;

import com.pbo.tubes.controller.mahasiswa.MahasiswaController;
import com.pbo.tubes.controller.mahasiswa.MahasiswaControllerImpl;
import com.pbo.tubes.model.Menu;
import com.pbo.tubes.model.user.Mahasiswa;
import com.pbo.tubes.model.user.User;
import com.pbo.tubes.view.AuthView;

import java.util.List;

public class AuthControllerImpl implements AuthController {

    private final List<User> listUser;
    private final AuthView authView;

    public AuthControllerImpl(List<User> listUser, AuthView authView) {
        this.listUser = listUser;
        this.authView = authView;
    }

    @Override
    public void register() {
        User newUser = authView.registerView();

        for (User userItem : listUser) {
            if (
                userItem.getName().equals(newUser.getName()) &&
                userItem.getPassword().equals(newUser.getPassword())
            ) {
                authView.registerFailedView();
                return;
            }
        }

        listUser.add(newUser);
        authView.registerSuccessView();
    }

    @Override
    public void login() {
        List<String> loginRequest = authView.loginView();
        for (User userItem : listUser) {
            if (
                userItem.getEmail().equals(loginRequest.get(0)) &&
                userItem.getPassword().equals(loginRequest.get(1))
            ) {
                MahasiswaController mahasiswaController = new MahasiswaControllerImpl(new Mahasiswa(userItem.getName(), userItem.getEmail(), userItem.getPassword()));
                mahasiswaController.mahasiswaMenu();
                return;
            }
        }
        authView.loginFailedView();
    }

    @Override
    public void exit() {
        boolean isLogout = authView.logoutView();
        if (isLogout) {
            System.exit(0);
        }
    }
}
