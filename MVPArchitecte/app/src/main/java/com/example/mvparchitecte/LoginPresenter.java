package com.example.mvparchitecte;

public class LoginPresenter {
    private LoginInterface loginInterface;

    public LoginPresenter(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

    public void login(User user){
        if(user.isValidEmail() && user.isValidPassword()){
            loginInterface.loginSuccess();
        }
        else{
            loginInterface.loginError();
        }
    }
}
