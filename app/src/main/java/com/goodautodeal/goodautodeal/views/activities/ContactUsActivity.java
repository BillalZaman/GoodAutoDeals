package com.goodautodeal.goodautodeal.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.databinding.ActivityContactUsBinding;

public class ContactUsActivity extends AppCompatActivity {
    private ActivityContactUsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_contact_us);

        init();
    }

    private void init() {
        binding.setOnClick(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.imgBack:{
                finish();
                break;
            }
            case R.id.btnSend:{
                if (validation()) {
                    Toast.makeText(this, "Email Sent.", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    public boolean validation(){
        boolean check = true;
        binding.txtName.setError(null);
        binding.txtEmail.setError(null);
        binding.txtPassword.setError(null);
        binding.Description.setError(null);

        if (binding.edtName.getText().toString().isEmpty()){
            binding.txtName.setError("Name cannot be empty");
            check = false;
        }  else if (binding.edtEmail.getText().toString().isEmpty()){
            binding.txtEmail.setError("Email cannot be empty");
            check = false;
        } else if (binding.edtPhone.getText().toString().isEmpty()){
            binding.txtPassword.setError("Phone cannot be empty");
            check = false;
        } else if (binding.edtDesc.getText().toString().isEmpty()){
            binding.Description.setError("Description cannot be empty");
            check = false;
        }

        return check;
    }
}