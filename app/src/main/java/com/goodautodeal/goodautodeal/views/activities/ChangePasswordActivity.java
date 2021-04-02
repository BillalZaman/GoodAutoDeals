package com.goodautodeal.goodautodeal.views.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivityChangePasswordBinding;

public class ChangePasswordActivity extends AppCompatActivity {
    private ActivityChangePasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_change_password);

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
            case R.id.btnChangePassword: {
                if (validation()) {
                    Toast.makeText(this, "Your Password has been changed. Please logged in again to continue", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            }
        }
    }

    private boolean validation() {
        boolean check = true;
        binding.txtOldPassword.setError(null);
        binding.txtNewPassword.setError(null);
        binding.txtConfirmPassword.setError(null);

        if (binding.edtOldPassword.getText().toString().isEmpty()) {
            binding.txtOldPassword.setError(getString(R.string.field_empty));
            check = false;

        } else if (binding.edtNewPassword.getText().toString().isEmpty()) {
            binding.txtNewPassword.setError(getString(R.string.field_empty));
            check = false;

        } else if ((binding.edtConfirmPassword.getText().toString().isEmpty())) {
            binding.txtConfirmPassword.setError(getString(R.string.field_empty));
            check = false;

        } else if ((binding.edtNewPassword.getText().toString().length() < 6)) {
            binding.txtNewPassword.setError(getString(R.string.minimum_character));
            check = false;

        } else if ((binding.edtConfirmPassword.getText().toString().length() < 6)) {
            binding.txtConfirmPassword.setError(getString(R.string.minimum_character));
            check = false;

        } else if (!binding.edtNewPassword.getText().toString().equals((binding.edtConfirmPassword.getText().toString()))) {
            binding.edtConfirmPassword.setError(getString(R.string.password_mismatch));
            check = false;
        }

        return check;

    }

}