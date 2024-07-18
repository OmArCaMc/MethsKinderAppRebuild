package com.example.animate;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.animate.databinding.ActivitySelectOptionBinding;

public class SelectOption extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        DataSelectOption dataSelectOption = new DataSelectOption();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ActivitySelectOptionBinding binding  = DataBindingUtil.setContentView(this, R.layout.activity_select_option);

//        Intent intent = getIntent();
//        if (intent != null) {
//            dataSelectOption = new DataSelectOption();
//            dataSelectOption.setInstruction(intent.getStringExtra("INSTRUCTION"));
//            dataSelectOption.setPathIllustration(intent.getStringExtra("PATH_ILLUSTRATION"));
//        }

        binding.setData(dataSelectOption);
    }
}
