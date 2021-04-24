package com.goodautodeal.goodautodeal.views.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.goodautodeal.goodautodeal.ApplicationState;
import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivityContactUsBinding;
import com.goodautodeal.goodautodeal.helpers.Internet;
import com.goodautodeal.goodautodeal.helpers.UIHelper;
import com.goodautodeal.goodautodeal.viewmodels.DealerViewModel;
import com.goodautodeal.goodautodeal.webview.response.Response;

import javax.inject.Inject;

public class ContactUsActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    @Inject
    Internet internet;
    private ActivityContactUsBinding binding;
    private DealerViewModel dealerViewModel;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact_us);
        dealerViewModel = ViewModelProviders.of(this).get(DealerViewModel.class);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        ApplicationState.getApp().getApplicationComponent().injectInternet(this);
        init();
    }

    private void init() {
        binding.setOnClick(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack: {
                finish();
                break;
            }
            case R.id.btnSend: {

                if (internet.isNetworkAvailable(this)) {
                    if (validation()) {
                        dealerViewModel.getContactUs(binding.edtName.getText().toString(),
                                binding.edtEmail.getText().toString(), binding.edtPhone.getText().toString(),
                                binding.edtDesc.getText().toString());
                        getData();
                    }
                } else {
                    uiHelper.showLongToastInCenter(this, getString(R.string.no_interrnet_connection));
                }
                break;
            }
        }
    }

    private void getData() {
        dealerViewModel.getUserData().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(@Nullable Response response) {
                if (response.getResp().getCode() == 1 &&
                        response.getResp().getSuccess().equalsIgnoreCase("success")) {
                    uiHelper.showLongToastInCenter(ContactUsActivity.this, "Email Sent");
                }
            }
        });
    }

    public boolean validation() {
        boolean check = true;
        binding.txtName.setError(null);
        binding.txtEmail.setError(null);
        binding.txtPassword.setError(null);
        binding.Description.setError(null);

        if (binding.edtName.getText().toString().isEmpty()) {
            binding.txtName.setError("Name cannot be empty");
            check = false;
        } else if (binding.edtEmail.getText().toString().isEmpty()) {
            binding.txtEmail.setError("Email cannot be empty");
            check = false;
        } else if (binding.edtPhone.getText().toString().isEmpty()) {
            binding.txtPassword.setError("Phone cannot be empty");
            check = false;
        } else if (binding.edtDesc.getText().toString().isEmpty()) {
            binding.Description.setError("Description cannot be empty");
            check = false;
        }

        return check;
    }
}