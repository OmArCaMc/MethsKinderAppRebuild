package com.example.animate;

import android.os.Bundle;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Random;
import androidx.activity.EdgeToEdge;

import android.view.ViewGroup;

public class matchingActivityNoMod extends AppCompatActivity {
    // Declare button
    Button back,clear,check;
    private DrawView drawView;

    // Define feedback layout views
    private View feedbackLayout;
    private ImageView feedbackImage;
    private TextView feedbackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Expand to all screen
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_matching);

        // Set the back button small modularization
        int backButtonImage = getIntent().getIntExtra("BACK_BUTTON_IMAGE", 0);
        setBackButtonImage(backButtonImage);

        // Inflate and add the feedback layout to the root layout
        feedbackLayout = getLayoutInflater().inflate(R.layout.feedback_layout, null);
        ViewGroup rootLayout = findViewById(android.R.id.content);
        rootLayout.addView(feedbackLayout);

        // Get references to feedback components
        feedbackImage = feedbackLayout.findViewById(R.id.feedbackImage);
        feedbackText = feedbackLayout.findViewById(R.id.feedbackText);

        // Initialize custom DrawView for drawing paths
        drawView = new DrawView(this);
        ConstraintLayout layout = findViewById(R.id.main);
        layout.addView(drawView);

        // Back button functionality
        back = findViewById(R.id.backBttn);
        back.setOnClickListener(v -> finish());

        // Back button functionality
        check = findViewById(R.id.checkBttn);
        check.setOnClickListener(v -> showFeedbackAnimation(true, "Por favor, dile al profesor que le eche un vistazo"));

        // Set up the custom clean button
        clear  = findViewById(R.id.cleanBttn);
        clear.setOnClickListener(v -> {
            drawView.clearPaths();  // Call the function to clear the paths
        });
    }

    private void setBackButtonImage(int resourceId) {
        Button back = findViewById(R.id.backBttn);
        back.setBackgroundResource(resourceId);
    }

    // Custom view class to draw continuous paths
    private class DrawView extends View {
        private Paint paint = new Paint();
        private Path path = new Path();
        private ArrayList<Line> lines = new ArrayList<>();  // Store all lines

        public DrawView(matchingActivityNoMod context) {
            super(context);
            paint.setStrokeWidth(10f);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            for (Line line : lines) {
                paint.setColor(line.color);  // Set the color for the current line
                canvas.drawPath(line.path, paint);  // Draw each saved path with its color
            }
            paint.setColor(Color.BLACK);  // Default color for the current path
            canvas.drawPath(path, paint);  // Draw the current path as it's being created
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    // Start a new path at the touched position
                    path.moveTo(x, y);
                    return true;

                case MotionEvent.ACTION_MOVE:
                    // Add a line segment to the current path
                    path.lineTo(x, y);
                    invalidate();  // Redraw to show the current path
                    return true;

                case MotionEvent.ACTION_UP:
                    // When finger is lifted, save the path with a random color and start a new one
                    lines.add(new Line(new Path(path), getRandomColor()));  // Save the completed path with a random color
                    path.reset();  // Reset path for the next drawing
                    invalidate();
                    return true;
            }
            return false;
        }

        // Method to get a random color
        private int getRandomColor() {
            Random random = new Random();
            return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }

        public void clearPaths() {
            lines.clear();  // Clear all stored lines
            invalidate();  // Refresh the view
        }
    }

    // Helper class to store a path with a color
    private class Line {
        Path path;
        int color;

        Line(Path path, int color) {
            this.path = path;
            this.color = color;
        }
    }

    private void showFeedbackAnimation(boolean isCorrect, String feedbackMessage) {
        feedbackImage.setImageResource(isCorrect ? R.drawable.generic_thoughtful_emoji : R.drawable.generic_thoughtful_emoji);
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
