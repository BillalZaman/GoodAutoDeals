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

//    public void getRegister(String _name, String _email, String _cellno,
//                            String _city, String _postcode, String address,
//                            String _password) {
//        userRepository.getRegister(_name, _email, _cellno, _city, _postcode, address, _password);
//    }

    public void getRegister(UserInfoModel userInfoModel) {
        userRepository.getRegister(userInfoModel);
    }

    public LiveData<Response> getUserData() {
        return userRepository.getMainResponseLifeData();
    }

    public void clear() {
        userRepository.clear();
    }
}


