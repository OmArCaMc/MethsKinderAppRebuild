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

// Define the topic 2 class that extends AppCompatActivity.
public class topic2screen extends AppCompatActivity {
    // Declare a button named back to return.
    Button back;
    // Declare buttons to each exercise.
    Button question1;
    Button question2;
    Button question3;
    Button question4;
    Button question5;
    Button question6;

    @Override
    // Method called when the activity is first created.
    protected void onCreate(Bundle savedInstanceState) {
        // Call the superclass constructor.
        super.onCreate(savedInstanceState);
        // Set the layout for the activity to 'activity_tema2'.
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tema2);

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

        question1 = (Button) findViewById(R.id.question1);
        question1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic2screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_2_1);
                intent.putExtra("ILLUSTRATION", R.drawable.question_2_1);
                intent.putExtra("OP1", R.drawable.generic_bird_asset);
                intent.putExtra("OP2", R.drawable.generic_snake_asset);
                intent.putExtra("OP3", R.drawable.generic_bear_asset);
                intent.putExtra("RightOp", 3);
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic2_1_asset);

                startActivity(intent);
            }
        });

        question2 = (Button) findViewById(R.id.question2);
        question2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic2screen.this, draggableImage.class);

                intent.putExtra("DRAGGABLE0", R.drawable.generic_squirrel_asset);
                intent.putExtra("FIXED0", R.drawable.generic_tree_asset_1);
                intent.putExtra("INSTRUCTION", R.string.Instruction_2_2);
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic2_2_asset);
                // above, below, left, right
                intent.putExtra("EXPECTED_POSITION", "below");
                startActivity(intent);
            }
        });

        question3 = (Button) findViewById(R.id.question3);
        question3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic2screen.this, draggableImage.class);

                intent.putExtra("DRAGGABLE0", R.drawable.generic_butterfly_asset);
                intent.putExtra("FIXED0", R.drawable.generic_flower5_asset);
                intent.putExtra("INSTRUCTION", R.string.Instruction_2_3);
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic2_3_asset);
                // above, below, left, right
                intent.putExtra("EXPECTED_POSITION", "above");
                startActivity(intent);
            }
        });

        question4 = (Button) findViewById(R.id.question4);
        question4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic2screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_2_4);
                intent.putExtra("ILLUSTRATION", R.drawable.question_2_4);
                intent.putExtra("OP1", R.drawable.generic_penguin_asset);
                intent.putExtra("OP2", R.drawable.generic_fox_asset);
                intent.putExtra("OP3", R.drawable.generic_monkey_2_asset);
                intent.putExtra("RightOp", 2);
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic2_4_asset);

                startActivity(intent);
            }
        });

        question5 = (Button) findViewById(R.id.question5);
        question5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic2screen.this, draggableImage.class);

                intent.putExtra("DRAGGABLE0", R.drawable.generic_banana_asset);
                intent.putExtra("FIXED0", R.drawable.generic_monkey_2_asset);
                intent.putExtra("INSTRUCTION", R.string.Instruction_2_5);
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic2_5_asset);
                // above, below, left, right
                intent.putExtra("EXPECTED_POSITION", "left");
                startActivity(intent);
            }
        });

        question6 = (Button) findViewById(R.id.question6);
        question6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic2screen.this, draggableImage.class);

                intent.putExtra("DRAGGABLE0", R.drawable.generic_grass_asset);
                intent.putExtra("FIXED0", R.drawable.generic_cow_2_asset);
                intent.putExtra("INSTRUCTION", R.string.Instruction_2_6);
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic2_6_asset);
                // above, below, left, right
                intent.putExtra("EXPECTED_POSITION", "right");
                startActivity(intent);
            }
        });

//        question6 = (Button) findViewById(R.id.question6);
//        question6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(topic2screen.this, SelectOptionMod.class);
//
//                intent.putExtra("INSTRUCTION", R.string.Instruction_2_6);
//                intent.putExtra("ILLUSTRATION", R.drawable.question_2_6);
//                intent.putExtra("OP1", R.drawable.generic_bird_asset);
//                intent.putExtra("OP2", R.drawable.generic_duck_asset);
//                intent.putExtra("OP3", R.drawable.generic_tiger_asset);
//                intent.putExtra("RightOp", 3);
//                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic2_6_asset);
//
//                startActivity(intent);
//            }
//        });
    }
}