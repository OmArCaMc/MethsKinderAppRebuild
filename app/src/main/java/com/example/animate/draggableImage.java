package com.example.animate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class draggableImage extends AppCompatActivity {
    ImageView draggableImage;
    ImageView fixedImage;
    Button back;
    Button check;
    String expectedPosition;

    private int[][] correlations;
    private int[][] positions;
    private int[][] views;
    private Handler pauseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the superclass constructor.
        super.onCreate(savedInstanceState);
        // Expand to all screen
        EdgeToEdge.enable(this);
        // Set the layout for the activity to 'activity_draggableimage'.
        setContentView(R.layout.activity_draggableimage);

        // Handle window insets as before
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            v.setPadding(insets.getInsets(WindowInsetsCompat.Type.systemBars()).left,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).right,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
            return insets;
        });
        setCorrelations();
        setInstruction();
        setBackListener();
        setViews();
        generateLayout();
        setCheckListener();
        this.pauseHandler = new Handler(Looper.getMainLooper());
    }

    private void setCorrelations() {
        Intent intent = getIntent();
        if (intent != null) {
            correlations = new int[2][1];
            correlations[0][0] = intent.getIntExtra("DRAGGABLE0", 0);
            correlations[1][0] = intent.getIntExtra("FIXED0", 0);
            expectedPosition = intent.getStringExtra("EXPECTED_POSITION");
        }
    }

    private void setBackListener() {
        back = findViewById(R.id.backBttn);
        Intent intent = getIntent();
        int backButtonImage = intent.getIntExtra("BACK_BUTTON_IMAGE", 0);
        back.setBackgroundResource(backButtonImage);
        back.setOnClickListener(v -> finish());
    }

    private void setInstruction(){
        Intent intent = getIntent();
        if(intent != null){
            TextView instructionView = findViewById(R.id.instruction);
            String instructionText = intent.getStringExtra("INSTRUCTION");
            instructionView.setText(instructionText);
        }
    }

    private void setCheckListener(){
        check = findViewById(R.id.check_bttn);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity and go back to the previous activity.
                boolean isCorrect = checkAnswers();
                if(!isCorrect){
                    showFeedbackAnimation(false, "Vuelve a intentarlo");
                } else {
                    showFeedbackAnimation(true, "¡Excelente trabajo!");
                }
            }
        });
    }

    private boolean checkAnswers() {
        if (expectedPosition == null) return false;

        // Get positions of the images
        float draggableX = draggableImage.getX();
        float draggableY = draggableImage.getY();
        float fixedX = fixedImage.getX();
        float fixedY = fixedImage.getY();

        // Calculate center positions
        float draggableCenterY = draggableY + (draggableImage.getHeight() / 2);
        float fixedCenterY = fixedY + (fixedImage.getHeight() / 2);

        // Tolerance for slight position difference
        final float tolerance = 50.0f;

        // Check based on expected position
        switch (expectedPosition) {
            case "above":
                // Check if the draggable image is completely above the fixed image
                Log.d("TAG", "Above Check: " + (draggableY + draggableImage.getHeight() - tolerance) + " < " + fixedY);
                return (draggableY + draggableImage.getHeight() - tolerance) < fixedY;
            case "below":
                // Check if the draggable image is completely below the fixed image
                Log.d("TAG", "Below Check: " + draggableCenterY + " > " + (fixedCenterY + tolerance));
                return draggableCenterY > (fixedCenterY + tolerance);
            case "left":
                // Check if the draggable image is completely left of the fixed image
                Log.d("TAG", "Left Check: " + fixedX + " > " + (draggableX + draggableImage.getWidth() - tolerance));
                return fixedX > (draggableX + draggableImage.getWidth() - tolerance);
            case "right":
                // Check if the draggable image is completely right of the fixed image
                Log.d("TAG", "Right Check: " + (fixedX + fixedImage.getWidth() + tolerance) + " < " + draggableX);
                return (fixedX + fixedImage.getWidth() + tolerance) < draggableX;
            default:
                return false;
        }
    }

    private void answersAreCorrect(){
        TextView feedback = findViewById(R.id.feedBack);
        feedback.setText(R.string.feedback_correct);
    }

    private void answersAreIncorrect(){
        TextView feedback = findViewById(R.id.feedBack);
        feedback.setText(R.string.feedback_incorrect);
        this.pauseHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                feedback.setText("");
                recreate();
            }
        }, 3000);
    }

    private void setViews(){
        views = new int [2][1];
        views[0][0] = R.id.draggable_0;
        views[1][0] = R.id.fixed_0;
    }

    private void generateLayout(){
        // Assign the element from the original array to the new array
        ImageView draggable = findViewById(views[0][0]);
        draggable.setImageResource(correlations[0][0]);
        correlations[0][0] = views[0][0];
        setDraggable(draggable);
        this.draggableImage = draggable;

        ImageView frame = findViewById(views[1][0]);
        frame.setImageResource(correlations[1][0]);
        correlations[1][0] = views[1][0];
        this.fixedImage = frame;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setDraggable(ImageView imageView) {
        imageView.setOnTouchListener(new View.OnTouchListener() {
            float dX, dY;
            int lastAction;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = v.getX() - event.getRawX();
                        dY = v.getY() - event.getRawY();
                        lastAction = MotionEvent.ACTION_DOWN;
                        break;

                    case MotionEvent.ACTION_MOVE:
                        v.setX(event.getRawX() + dX);
                        v.setY(event.getRawY() + dY);
                        lastAction = MotionEvent.ACTION_MOVE;
                        break;

                    case MotionEvent.ACTION_UP:
                        if (lastAction == MotionEvent.ACTION_DOWN)
                            v.performClick();
                        break;

                    default:
                        return false;
                }
                return true;
            }
        });
    }

    private void showFeedbackAnimation(boolean isCorrect, String feedbackMessage) {
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

}