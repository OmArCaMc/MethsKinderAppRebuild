package com.example.animate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.animate.databinding.ActivitySelectOptionBinding;

public class SelectOption extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        DataSelectOption dataSelectOption = new DataSelectOption();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ActivitySelectOptionBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_select_option);
        binding.setLifecycleOwner(this);

        Intent intent = getIntent();
        if (intent != null) {
//            dataSelectOption = new DataSelectOption();
            setInstruction(intent.getIntExtra("INSTRUCTION", 0));
            setIllustration(intent.getIntExtra("ILLUSTRATION", 0));
            setOp1(intent.getIntExtra("OP1", 0));
            setOp2(intent.getIntExtra("OP2", 0));
            setOp3(intent.getIntExtra("OP3", 0));
            dataSelectOption.instruction.set(intent.getIntExtra("INSTRUCTION", 0));
            dataSelectOption.pathIllustration.set(intent.getIntExtra("PATH_ILLUSTRATION", 0));
        }
        binding.setData(dataSelectOption);
    }
    public void setIllustration(int resourceId){
        ImageView illustrationView = findViewById(R.id.illustration);
        illustrationView.setImageResource(resourceId);
    }
    public void setInstruction(int resourceId){
        TextView textView = findViewById(R.id.instruction);
        textView.setText(resourceId);
    }
    public void setOp1(int resourceId){
        ImageView imageView = findViewById(R.id.op1);
        imageView.setImageResource(resourceId);
    }
    public void setOp2(int resourceId){
        ImageView imageView = findViewById(R.id.op2);
        imageView.setImageResource(resourceId);
    }
    public void setOp3(int resourceId){
        ImageView imageView = findViewById(R.id.op3);
        imageView.setImageResource(resourceId);
    }
}
