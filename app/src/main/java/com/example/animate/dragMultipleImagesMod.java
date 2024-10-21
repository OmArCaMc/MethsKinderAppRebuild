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
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    Button check;
    private int[][] correlations;
    private int[][] positions;
    private int [][] views;
    private Handler pauseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Expand to all screen
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_drag_multiple_images_mod);

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



//        draggable1 = findViewById(R.id.draggable_0);
//        draggable1.setImageResource(positions[0][0]);
//        draggable2 = findViewById(R.id.draggable_1);
//        draggable2.setImageResource(positions[0][1]);
//        draggable3 = findViewById(R.id.draggable_2);
//        draggable3.setImageResource(positions[0][2]);
//        frame1 = findViewById(R.id.frame_0);
//        frame1.setImageResource(positions[1][0]);
//        frame2 = findViewById(R.id.frame_1);
//        frame2.setImageResource(positions[1][1]);
//        frame3 = findViewById(R.id.frame_2);
//        frame2.setImageResource(positions[1][2]);

//        correlations[0][0] = R.id.draggable_0;
//        correlations[0][1] = R.id.draggable_1;
//        correlations[0][2] = R.id.draggable_2;
//        correlations[1][0] = R.id.frame_0;
//        correlations[1][1] = R.id.frame_1;
//        correlations[1][2] = R.id.frame_2;
//        setViews();


        // Set up dragging for the draggable image
//        setDraggable(draggable1); setDraggable(draggable2);
//        setDraggable(draggable3);
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
                    answersAreIncorrect();
                } else {
                    answersAreCorrect();
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
}
