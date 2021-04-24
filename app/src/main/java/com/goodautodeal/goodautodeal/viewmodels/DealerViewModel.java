package com.goodautodeal.goodautodeal.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.goodautodeal.goodautodeal.respository.DealerViewRepository;
import com.goodautodeal.goodautodeal.webview.response.Response;

/**
 * Created by Bilal Zaman on 22/04/21.
 */
public class DealerViewModel extends AndroidViewModel {
    DealerViewRepository dealerViewRepository;
    private MutableLiveData<ViewModelStatus> isLoading;

    public DealerViewModel(@NonNull Application application) {
        super(application);
        dealerViewRepository = new DealerViewRepository(application);
    }

    public MutableLiveData<ViewModelStatus> getIsLoading() {
        return isLoading = dealerViewRepository.getStatus();
    }

    public void getDealerProfile() {
        dealerViewRepository.getDealerProfile();
    }

    public void getDealerDashboard() {
        dealerViewRepository.getDealerDashboard();
    }

    public void getContactUs(String name, String email, String num, String message) {
        dealerViewRepository.getContactUs(name, email, num, message);
    }

    public LiveData<Response> getUserData() {
        return dealerViewRepository.getMainResponseLifeData();
    }

    public void clear() {
        dealerViewRepository.clear();
    }
}
