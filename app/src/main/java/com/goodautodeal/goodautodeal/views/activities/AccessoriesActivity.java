package com.goodautodeal.goodautodeal.views.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.goodautodeal.goodautodeal.R;
import com.goodautodeal.goodautodeal.constants.ConstUtils;
import com.goodautodeal.goodautodeal.databinding.ActivityAccessoriesBinding;
import com.goodautodeal.goodautodeal.views.adapters.AccessoriesAdapter;
import com.goodautodeal.goodautodeal.views.models.AccessoriesModel;

import java.util.ArrayList;

public class AccessoriesActivity extends AppCompatActivity {
    private ActivityAccessoriesBinding binding;
    private ArrayList<AccessoriesModel> data = new ArrayList<>();
    private AccessoriesAdapter accessoriesAdapter;
    private String isActivityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_accessories);

        init();
    }

    private void init() {
        isActivityName = getIntent().getStringExtra(ConstUtils.ValueKey);
        setRecyclerView(isActivityName);

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setRecyclerView(String name) {
        accessoriesAdapter = new AccessoriesAdapter(this);

        if (name.equalsIgnoreCase("comfort")) {
            //comfort
            binding.textView.setText("Comfort");
            data.add(new AccessoriesModel("Navigation"));
            data.add(new AccessoriesModel("Dual-zone Electronic Climate"));
            data.add(new AccessoriesModel("Smart Suspension"));
            data.add(new AccessoriesModel("Digital Cockpit"));
            data.add(new AccessoriesModel("Bluetooth"));
            data.add(new AccessoriesModel("Climate Control"));
            data.add(new AccessoriesModel("Auxiliary Point/Aux cable"));
            data.add(new AccessoriesModel("Cruise Control"));
            data.add(new AccessoriesModel("12v Power Socket in Center Console"));
            data.add(new AccessoriesModel("Adjustable Steering Column"));
            data.add(new AccessoriesModel("Front Center Armrest"));
            data.add(new AccessoriesModel("USB Connectivity"));
            data.add(new AccessoriesModel("Rear Entertainment System"));
            data.add(new AccessoriesModel("Wifi Hotspot"));
            data.add(new AccessoriesModel("Air Condition"));

        } else if (name.equalsIgnoreCase("safety")) {
            //security
            binding.textView.setText("Safety");
            data.add(new AccessoriesModel("Parking Aid/Sensor"));
            data.add(new AccessoriesModel("Anti - Theft Alarm"));
            data.add(new AccessoriesModel("Rain sensor"));
            data.add(new AccessoriesModel("Tool kit"));
            data.add(new AccessoriesModel("On board diagnostics"));
            data.add(new AccessoriesModel("ABS/EBD"));
            data.add(new AccessoriesModel("Driver/front passenger side airbags"));
            data.add(new AccessoriesModel("Driver/Passenger airbags "));
            data.add(new AccessoriesModel("Tyre pressure monitoring system"));
            data.add(new AccessoriesModel("Warning triangle and first aid kit"));
            data.add(new AccessoriesModel("Locking wheel bolts"));
            data.add(new AccessoriesModel("Remote central locking"));
            data.add(new AccessoriesModel("Track pack"));
            data.add(new AccessoriesModel("Back Camera"));
            data.add(new AccessoriesModel("ISOFIX mounts"));
            data.add(new AccessoriesModel("Blindspot warning alert"));
            data.add(new AccessoriesModel("360 degree camera"));

        } else if (name.equalsIgnoreCase("interior")) {
            //interior
            binding.textView.setText("Interior");
            data.add(new AccessoriesModel("Auto dimming rear view mirror"));
            data.add(new AccessoriesModel("Tyre Pressure Monitoring Display"));
            data.add(new AccessoriesModel("Heated Seats"));
            data.add(new AccessoriesModel("Leather Seats"));
            data.add(new AccessoriesModel("DAB Digital radio"));
            data.add(new AccessoriesModel("Multi function steering wheel"));
            data.add(new AccessoriesModel("DVD player"));
            data.add(new AccessoriesModel("Car Mats"));
            data.add(new AccessoriesModel("Sports seats"));
            data.add(new AccessoriesModel("MP3 player"));
            data.add(new AccessoriesModel("Home link"));

        } else if (name.equalsIgnoreCase("exterior")) {
            //exterior
            binding.textView.setText("Exterior");
            data.add(new AccessoriesModel("Alloy Wheel"));
            data.add(new AccessoriesModel("Electric + heated door mirrors"));
            data.add(new AccessoriesModel("Headlight washer jets"));
            data.add(new AccessoriesModel("Heated windscreen washer jets"));
            data.add(new AccessoriesModel("LED lights"));
            data.add(new AccessoriesModel("LED fog lights"));
            data.add(new AccessoriesModel("Metallic paint"));

        } else if (name.equalsIgnoreCase("others")) {
            //others
            binding.textView.setText("Others");
            data.add(new AccessoriesModel("Panoramic Roof"));
            data.add(new AccessoriesModel("Run flat tyres"));
            data.add(new AccessoriesModel("Real time traffic information"));
            data.add(new AccessoriesModel("Stop/start button"));
            data.add(new AccessoriesModel("Hill start assist"));
            data.add(new AccessoriesModel("Engine immobiliser"));
            data.add(new AccessoriesModel("Keyless ignition"));
            data.add(new AccessoriesModel("Electric Windows"));
        }

        accessoriesAdapter.setData(data);
        binding.recyclerview.setAdapter(accessoriesAdapter);
    }
}