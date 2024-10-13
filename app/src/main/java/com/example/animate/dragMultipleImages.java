package com.example.animate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class dragMultipleImages extends AppCompatActivity {
    // Declare attributes / assets
    ImageView monkey;
    ImageView monkey2;
    ImageView panda;
    ImageView bear;
    ImageView tucan;
    ImageView bird;
    ImageView frame1;
    ImageView frame2;
    ImageView frame3;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_multiple_images);

        // Handle window insets as before
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            v.setPadding(insets.getInsets(WindowInsetsCompat.Type.systemBars()).left,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).right,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
            return insets;
        });

        back = findViewById(R.id.backBttn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity and go back to the previous activity.
                finish();
            }
        });

//        frame1 = findViewById(R.id.frame1_asset);
//        frame2 = findViewById(R.id.frame2_asset);
//        frame3 = findViewById(R.id.frame3_asset);

        monkey = findViewById(R.id.monkey_asset);
        monkey2 = findViewById(R.id.monkey2_asset);
        panda = findViewById(R.id.panda_asset);
        bear = findViewById(R.id.bear_asset);
        tucan = findViewById(R.id.tucan_asset);
        bird = findViewById(R.id.bird_asset);

        // Set up dragging for the draggable image
        setDraggable(monkey); setDraggable(monkey2);
        setDraggable(panda); setDraggable(bear);
        setDraggable(tucan); setDraggable(bird);
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
}
