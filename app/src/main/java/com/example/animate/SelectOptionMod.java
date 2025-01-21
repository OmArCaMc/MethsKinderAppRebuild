package com.example.animate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import android.media.MediaPlayer;


public class SelectOptionMod extends AppCompatActivity {

    Button back;
    Button sound;
    private int rightOp;
    private Handler pauseHandler;
    private MediaPlayer mediaPlayer;

    @Override protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        DataSelectOption dataSelectOption = new DataSelectOption();

        // Expand to all screen
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select_option);

        Intent intent = getIntent();
        if (intent != null) {
            setInstruction(intent.getIntExtra("INSTRUCTION", 0));
            setIllustration(intent.getIntExtra("ILLUSTRATION", 0));
            setRightOp(intent.getIntExtra("RightOp",0));
            // Generate random number between 0 - 99
            Random random = new Random();
            int randomNum = random.nextInt(100);
            setOptions(randomNum, intent);
            setBackButtonImage(intent.getIntExtra("BACK_BUTTON_IMAGE", 0));
            setSoundButtonImage(intent.getIntExtra("SOUND_BUTTON_IMAGE", 0));
            setupSoundButton(intent.getIntExtra("AUDIO_RESOURCE", 0));

        }
        setOnClickListeners();
        setBackListener();

        this.pauseHandler = new Handler(Looper.getMainLooper());
    }
    private void setBackButtonImage(int resourceId) {
        Button back = findViewById(R.id.backBttn);
        back.setBackgroundResource(resourceId);
    }
    private void setSoundButtonImage(int resourceId) {
        Button sound = findViewById(R.id.soundBttn);
        sound.setBackgroundResource(resourceId);
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

    private void setBackListener(){
        back = findViewById(R.id.backBttn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity and go back to the previous activity.
                finish();
            }
        });
    }

    private void optionClicked(int optionClicked){
        TextView feedback = findViewById(R.id.feedBack);

        if (optionClicked == this.rightOp){
            showFeedbackAnimation(true, "¡Excelente trabajo!");
        } else {
            showFeedbackAnimation(false, "Vuelve a intentarlo");
        }
        this.pauseHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                feedback.setText("");
            }
        }, 3000);
    }

    private void showFeedbackAnimation(boolean isCorrect, String feedbackMessage) {

        int audioResource = isCorrect ? R.raw.exc_trabajo : R.raw.vuelve_intentar;
        playAudio(audioResource);

        // Get the views
        LinearLayout feedbackLayout = findViewById(R.id.feedbackLayout);
        ImageView feedbackImage = findViewById(R.id.feedbackImage);
        TextView feedbackText = findViewById(R.id.feedbackText);

        // Set the emoji and feedback text
        feedbackImage.setImageResource(isCorrect ? R.drawable.generic_happy_emoji : R.drawable.generic_sad_emoji);
        feedbackText.setText(feedbackMessage);

        // Show the view of feedback and set initial position out of screen
        feedbackLayout.setVisibility(View.VISIBLE);
        feedbackLayout.setTranslationY(-feedbackLayout.getHeight());

        // Down animation
        feedbackLayout.animate()
                .translationY(0)
                .setDuration(500)
                .withEndAction(() -> {
                    // Wait 3 seconds and then hide the feedback
                    feedbackLayout.postDelayed(() -> {
                        feedbackLayout.animate()
                                .translationY(-feedbackLayout.getHeight())
                                .setDuration(500)
                                .withEndAction(() -> feedbackLayout.setVisibility(View.GONE))
                                .start();
                    }, 3000);
                })
                .start();
    }

    private void setOptions(int randomNum, Intent intent) {
        if (randomNum <= 17) {
            setOp1(intent.getIntExtra("OP1", 0));
            setOp2(intent.getIntExtra("OP2", 0));
            setOp3(intent.getIntExtra("OP3", 0));
        } else if (randomNum <= 34) {
            setOp1(intent.getIntExtra("OP1", 0));
            setOp2(intent.getIntExtra("OP3", 0));
            setOp3(intent.getIntExtra("OP2", 0));
            // Change right option
            if (rightOp == 2) {
                setRightOp(3);
            } else if (rightOp == 3) {
                setRightOp(2);
            }
        } else if (randomNum <= 50) {
            setOp1(intent.getIntExtra("OP2", 0));
            setOp2(intent.getIntExtra("OP1", 0));
            setOp3(intent.getIntExtra("OP3", 0));
            // Change right option
            if (rightOp == 1) {
                setRightOp(2);
            } else if (rightOp == 2) {
                setRightOp(1);
            }
        } else if (randomNum <= 66) {
            setOp1(intent.getIntExtra("OP2", 0));
            setOp2(intent.getIntExtra("OP3", 0));
            setOp3(intent.getIntExtra("OP1", 0));
            // Change right option
            if (rightOp == 1) {
                setRightOp(3);
            } else if (rightOp == 2) {
                setRightOp(1);
            } else {
                setRightOp(2);
            }
        } else if (randomNum <= 82) {
            setOp1(intent.getIntExtra("OP3", 0));
            setOp2(intent.getIntExtra("OP1", 0));
            setOp3(intent.getIntExtra("OP2", 0));
            // Change right option
            if (rightOp == 1) {
                setRightOp(2);
            } else if (rightOp == 2) {
                setRightOp(3);
            } else {
                setRightOp(1);
            }
        } else {
            setOp1(intent.getIntExtra("OP3", 0));
            setOp2(intent.getIntExtra("OP2", 0));
            setOp3(intent.getIntExtra("OP1", 0));
            // Change right option
            if (rightOp == 1) {
                setRightOp(3);
            } else if (rightOp == 3) {
                setRightOp(1);
            }
        }
    }

    private void setupSoundButton(int audioResource) {
        sound = findViewById(R.id.soundBttn);
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(audioResource);
            }
        });
    }

    private void playAudio(int audioResource) {
        // Si hay un audio reproduciéndose, lo detiene antes de iniciar uno nuevo
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, audioResource);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Liberar recursos del MediaPlayer cuando la actividad se destruye
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
