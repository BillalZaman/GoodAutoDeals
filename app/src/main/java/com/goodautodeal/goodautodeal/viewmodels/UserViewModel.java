package com.goodautodeal.goodautodeal.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.goodautodeal.goodautodeal.respository.UserRepository;
import com.goodautodeal.goodautodeal.views.models.UserInfoModel;
import com.goodautodeal.goodautodeal.webview.response.Response;

/**
 * Created by Bilal Zaman on 12/04/21.
 */
public class UserViewModel extends AndroidViewModel {
    UserRepository userRepository;
    private MutableLiveData<ViewModelStatus> isLoading;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public MutableLiveData<ViewModelStatus> getIsLoading() {
        return isLoading = userRepository.getStatus();
    }

    public void getLogin(String email, String password) {
        userRepository.getLogin(email, password);
    }

    public void getRegister(UserInfoModel userInfoModel) {
        userRepository.getRegister(userInfoModel);
    }

    public void getChangePassword(String oldPassword, String newPassword) {
        userRepository.getChangePassword(oldPassword, newPassword);
    }

    public void getUserProfile() {
        userRepository.getUser();
    }

    public void getDealerList() {
        userRepository.getDealerList();
    }

    public LiveData<Response> getUserData() {
        return userRepository.getMainResponseLifeData();
    }

    public void clear() {
        userRepository.clear();
    }
}


