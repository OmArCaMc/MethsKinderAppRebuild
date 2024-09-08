package com.example.animate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Define the topic 1 class that extends AppCompatActivity.
public class topic1screen extends AppCompatActivity {
    // Declare a button named back to return.
    Button back;
    Button question1;
    Button question2;

    @Override
    // Method called when the activity is first created.
    protected void onCreate(Bundle savedInstanceState) {
        // Call the superclass constructor.
        super.onCreate(savedInstanceState);
        // Set the layout for the activity to 'activity_tema1'.
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tema1);

        // Set a listener to apply window insets correctly.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Assign the button 'backBttn' to the variable 'back'.
        back = (Button) findViewById(R.id.backBttn);
        // Set a listener for the click event of the 'back' button.
        back.setOnClickListener(new View.OnClickListener() {
            @Override

            // Method called when the button is clicked.
            public void onClick(View v) {
                // Finish the current activity and go back to the previous activity.
                finish();
            }
        });

        // Assign question1 button
        question1 = (Button) findViewById(R.id.question1);
        // Set listener
        question1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic1screen.this, draggableImage.class);
                startActivity(intent);
            }
        });

        question2 = (Button) findViewById(R.id.question2);
        question2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic1screen.this, dragMultipleImages.class);
                startActivity(intent);
            }
        });
    }
}