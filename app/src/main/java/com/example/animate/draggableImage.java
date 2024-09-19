package com.example.animate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.MotionEvent;

public class draggableImage extends AppCompatActivity {
    ImageView draggableImage;
    ImageView fixedImage;
    Button back;

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

        back = findViewById(R.id.backBttn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity and go back to the previous activity.
                finish();
            }
        });

        // Initialize the images
        draggableImage = findViewById(R.id.monkey_asset);
        fixedImage = findViewById(R.id.generic_tree_asset_1);

        // Set up dragging for the draggable image
        setDraggable(draggableImage);
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