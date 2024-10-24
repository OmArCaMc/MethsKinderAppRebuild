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
import android.widget.TextView;

import java.util.Random;

public class draggableImage extends AppCompatActivity {
    ImageView draggableImage;
    ImageView fixedImage;
    Button back;
    Button check;

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
        Log.d("TAG", "Correlations");
        setCorrelations();
        Log.d("TAG", "Instruccion");
        setInstruction();
        Log.d("TAG", "BackListener");
        setBackListener();
        Log.d("TAG", "Views");
        setViews();
        Log.d("TAG", "Layuot");
        generateLayout();
        Log.d("TAG", "CheckListener");
        setCheckListener();
        Log.d("TAG", "Termino CheckListener");
        this.pauseHandler = new Handler(Looper.getMainLooper());
        Log.d("TAG", "Fin de onCreate");
    }

    private void setCorrelations() {
        Intent intent = getIntent();
        if (intent != null) {
            correlations = new int[2][1];
            correlations[0][0] = intent.getIntExtra("DRAGGABLE0", 0);
            correlations[1][0] = intent.getIntExtra("FIXED0", 0);
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
                    answersAreIncorrect();
                } else {
                    answersAreCorrect();
                }
            }
        });
    }

    private boolean checkAnswers(){
        // TODO: Revisar posicion de imagen segun corresponda
        // Podria haber una variable que indique la posicion en la que
        // debe quedar la imagen arrastrable con respecto a la otra
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

        ImageView frame = findViewById(views[1][0]);
        frame.setImageResource(correlations[1][0]);
        correlations[1][0] = views[1][0];
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
}