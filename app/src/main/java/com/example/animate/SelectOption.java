package com.example.animate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.example.animate.databinding.ActivitySelectOptionBinding;

public class SelectOption extends AppCompatActivity {

    private int rightOp;
    private Handler pauseHandler;

    @Override protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        DataSelectOption dataSelectOption = new DataSelectOption();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_select_option);

        // Expand to all screen
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select_option);
//        binding.setLifecycleOwner(this);

        Intent intent = getIntent();
        if (intent != null) {
//            dataSelectOption = new DataSelectOption();
            setInstruction(intent.getIntExtra("INSTRUCTION", 0));
            setIllustration(intent.getIntExtra("ILLUSTRATION", 0));
            setOp1(intent.getIntExtra("OP1", 0));
            setOp2(intent.getIntExtra("OP2", 0));
            setOp3(intent.getIntExtra("OP3", 0));
            setRightOp(intent.getIntExtra("RightOp",0));
        }
        setOnClickListeners();
        this.pauseHandler = new Handler(Looper.getMainLooper());
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
    public void setRightOp(int rightOp){
        this.rightOp = rightOp;
    }

    private void setOnClickListeners(){
        ImageButton op1 = findViewById(R.id.op1);
        ImageButton op2 = findViewById(R.id.op2);
        ImageButton op3 = findViewById(R.id.op3);

        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionClicked(1);
            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionClicked(2);
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionClicked(3);
            }
        });
    }
    private void optionClicked(int optionClicked){
        TextView feedback = findViewById(R.id.feedBack);

        if (optionClicked == this.rightOp){
            feedback.setText(R.string.feedback_correct);
        } else {
            feedback.setText(R.string.feedback_incorrect);
        }
        this.pauseHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                feedback.setText("");
            }
        }, 3000);
    }

}
