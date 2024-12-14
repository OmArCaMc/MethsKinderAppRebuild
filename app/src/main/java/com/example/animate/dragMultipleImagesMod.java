package com.example.animate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.ViewGroup;
import org.w3c.dom.Text;

import java.util.Random;

public class dragMultipleImagesMod extends AppCompatActivity {
    // Declare attributes / assets
    ImageView draggable1;
    ImageView draggable2;
    ImageView draggable3;
    ImageView frame1;
    ImageView frame2;
    ImageView frame3;
    Button back;
    Button sound;
    Button check;
    private int[][] correlations;
    private int[][] positions;
    private int [][] views;
    private Handler pauseHandler;

    // Define feedback layout views
    private View feedbackLayout;
    private ImageView feedbackImage;
    private TextView feedbackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Expand to all screen
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_drag_multiple_images_mod);

        // Set the back button small modularization
        int backButtonImage = getIntent().getIntExtra("BACK_BUTTON_IMAGE", 0);
        setBackButtonImage(backButtonImage);

        int soundButtonImage = getIntent().getIntExtra("SOUND_BUTTON_IMAGE", 0);
        setSoundButtonImage(soundButtonImage);

        // Inflate and add the feedback layout to the root layout
        feedbackLayout = getLayoutInflater().inflate(R.layout.feedback_layout, null);
        ViewGroup rootLayout = findViewById(android.R.id.content);
        rootLayout.addView(feedbackLayout);

        // Get references to feedback components
        feedbackImage = feedbackLayout.findViewById(R.id.feedbackImage);
        feedbackText = feedbackLayout.findViewById(R.id.feedbackText);

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

    private void setBackButtonImage(int resourceId) {
        Button back = findViewById(R.id.backBttn);
        back.setBackgroundResource(resourceId);
    }

    private void setSoundButtonImage(int resourceId) {
        Button sound = findViewById(R.id.soundBttn);
        sound.setBackgroundResource(resourceId);
    }

    private void setCorrelations(){
        Intent intent = getIntent();
        if (intent != null) {
            correlations = new int[2][3];
            correlations[0][0] = intent.getIntExtra("DRAGGABLE0", 0);
            correlations[0][1] = intent.getIntExtra("DRAGGABLE1", 0);
            correlations[0][2] = intent.getIntExtra("DRAGGABLE2", 0);
            correlations[1][0] = intent.getIntExtra("FRAME0", 0);
            correlations[1][1] = intent.getIntExtra("FRAME1", 0);
            correlations[1][2] = intent.getIntExtra("FRAME2", 0);
        }
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

    private void setInstruction(){
        Intent intent = getIntent();
        if(intent != null){
            TextView instructionView = findViewById(R.id.instruction);
            int instructionText = intent.getIntExtra("INSTRUCTION", 0);
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

    private boolean checkAnswers(){
        for (int i=0; i < 3; ++i){
            ImageView draggable = findViewById(correlations[0][i]);
            if(!isOverlapping(draggable)){
                return false;
            }
        }
        return true;
    }

    private void setViews(){
        views = new int [2][3];
        views[0][0] = R.id.draggable_0;
        views[0][1] = R.id.draggable_1;
        views[0][2] = R.id.draggable_2;
        views[1][0] = R.id.frame_0;
        views[1][1] = R.id.frame_1;
        views[1][2] = R.id.frame_2;
    }

    private void generateLayout(){
        boolean[] pickedFrames = new boolean[3];
        boolean[] pickedDrag = new boolean[3];
        positions = new int[2][3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            int index;
            do {
                index = random.nextInt(3); // Pick a random index
            } while (pickedDrag[index]); // Ensure the index has not been picked

            // Assign the element from the original array to the new array
            ImageView draggable = findViewById(views[0][index]);
            draggable.setImageResource(correlations[0][i]);
            correlations[0][i] = views[0][index];
            setDraggable(draggable);
//            positions[0][i] = correlations[0][index];
            pickedDrag[index] = true; // Mark this index as picked
        }
        for (int i = 0; i < 3; i++) {
            int index;
            do {
                index = random.nextInt(3); // Pick a random index
            } while (pickedFrames[index]); // Ensure the index has not been picked
            ImageView frame = findViewById(views[1][index]);
            frame.setImageResource(correlations[1][i]);
            correlations[1][i] = views[1][index];

            // Assign the element from the original array to the new array
//            positions[1][i] = correlations[1][index];
            pickedFrames[index] = true; // Mark this index as picked
        }
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

                        // Bring the view to the front
                        v.bringToFront();
                        v.getParent().requestLayout();
                        v.invalidate();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        v.setX(event.getRawX() + dX);
                        v.setY(event.getRawY() + dY);
                        lastAction = MotionEvent.ACTION_MOVE;
                        break;

                    case MotionEvent.ACTION_UP:
                        if (lastAction == MotionEvent.ACTION_DOWN) {
                            v.performClick();
                        } else{

                        }
                        break;

                    default:
                        return false;
                }
                return true;
            }
        });
    }
    private boolean isOverlapping(View view1) {
        Rect rect1 = new Rect();
        Rect rect2 = new Rect();
        ImageView view2 = null;
        int v1Id = view1.getId();
        for (int i=0; i < 3; ++i){
            int correllationsId = correlations[0][i];
            if(correllationsId == v1Id){
                Log.d("MyTag", "Pegó");
                view2 = findViewById(correlations[1][i]);
                view1.getHitRect(rect1);
                view2.getHitRect(rect2);
                return Rect.intersects(rect1, rect2);
            }
        }
        return false;
    }

    private void showFeedbackAnimation(boolean isCorrect, String feedbackMessage) {
        feedbackImage.setImageResource(isCorrect ? R.drawable.generic_happy_emoji : R.drawable.generic_sad_emoji);
        feedbackText.setText(feedbackMessage);

        feedbackLayout.setVisibility(View.VISIBLE);
        feedbackLayout.setTranslationY(-feedbackLayout.getHeight());

        feedbackLayout.animate()
                .translationY(0)
                .setDuration(500)
                .withEndAction(() -> feedbackLayout.postDelayed(() -> {
                    feedbackLayout.animate()
                            .translationY(-feedbackLayout.getHeight())
                            .setDuration(500)
                            .withEndAction(() -> feedbackLayout.setVisibility(View.GONE))
                            .start();
                }, 3000))
                .start();
    }
}
