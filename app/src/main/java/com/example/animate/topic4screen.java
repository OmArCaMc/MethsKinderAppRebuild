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

// Define the topic 4 class that extends AppCompatActivity.
public class topic4screen extends AppCompatActivity {
    // Declare a button named back to return.
    Button back;
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
        // Set the layout for the activity to 'activity_tema4'.
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tema4);

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
                Intent intent = new Intent(topic4screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_4_1);
                intent.putExtra("ILLUSTRATION", R.drawable.question_4_1_bg);
                intent.putExtra("OP1", R.drawable.question_4_1_op1);
                intent.putExtra("OP2", R.drawable.question_4_1_op2);
                intent.putExtra("OP3", R.drawable.question_4_1_op3);
                intent.putExtra("RightOp", 1); // Establece la opción correcta (ej. 1)
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic4_1_asset);


                startActivity(intent);
            }
        });

        question2 = (Button) findViewById(R.id.question2);
        question2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic4screen.this, dragMultipleImagesMod.class);
                intent.putExtra("DRAGGABLE0", R.drawable.question_4_2_1_1);
                intent.putExtra("FRAME0", R.drawable.question_4_2_1_2);
                intent.putExtra("DRAGGABLE1", R.drawable.question_4_2_2_1);
                intent.putExtra("FRAME1", R.drawable.question_4_2_2_2);
                intent.putExtra("DRAGGABLE2", R.drawable.question_4_2_3);
                intent.putExtra("FRAME2", R.drawable.question_4_2_3);
                intent.putExtra("INSTRUCTION", R.string.Instruction_4_2);
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic4_2_asset);
                startActivity(intent);
            }
        });

        question3 = (Button) findViewById(R.id.question3);
        question3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic4screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_4_3);
                intent.putExtra("ILLUSTRATION", R.drawable.question_4_3_bg);
                intent.putExtra("OP1", R.drawable.question_4_3_op1);
                intent.putExtra("OP2", R.drawable.question_4_3_op2);
                intent.putExtra("OP3", R.drawable.question_4_3_op3);
                intent.putExtra("RightOp", 3); // Establece la opción correcta (ej. 1)
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic4_3_asset);


                startActivity(intent);
            }
        });

        question4 = (Button) findViewById(R.id.question4);
        question4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic4screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_4_4);
                intent.putExtra("ILLUSTRATION", R.drawable.question_4_4_bg);
                intent.putExtra("OP1", R.drawable.question_4_4_op_1);
                intent.putExtra("OP2", R.drawable.question_4_4_op_2);
                intent.putExtra("OP3", R.drawable.question_4_4_op_4);
                intent.putExtra("RightOp", 1); // Establece la opción correcta (ej. 1)
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic4_4_asset);


                startActivity(intent);
            }
        });

        question5 = (Button) findViewById(R.id.question5);
        question5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic4screen.this, dragMultipleImagesMod.class);
                intent.putExtra("DRAGGABLE0", R.drawable.question_4_5_draggable_1);
                intent.putExtra("FRAME0", R.drawable.question_4_5_static_1);
                intent.putExtra("DRAGGABLE1", R.drawable.question_4_5_draggable_2);
                intent.putExtra("FRAME1", R.drawable.question_4_5_static_2);
                intent.putExtra("DRAGGABLE2", R.drawable.generic_egg3_asset);
                intent.putExtra("FRAME2", R.drawable.generic_nest_asset);
                intent.putExtra("INSTRUCTION", R.string.Instruction_4_5);
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic4_5_asset);
                startActivity(intent);
            }
        });

        question6 = (Button) findViewById(R.id.question6);
        question6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic4screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_4_6);
                intent.putExtra("ILLUSTRATION", R.drawable.question_4_6);
                intent.putExtra("OP1", R.drawable.question_4_6_op_1);
                intent.putExtra("OP2", R.drawable.question_4_6_op_2);
                intent.putExtra("OP3", R.drawable.question_4_6_op_3);
                intent.putExtra("RightOp", 3); // Establece la opción correcta (ej. 1)
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic4_6_asset);


                startActivity(intent);
            }
        });
    }
}