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

// Define the topic 3 class that extends AppCompatActivity.
public class topic3screen extends AppCompatActivity {
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
        // Set the layout for the activity to 'activity_tema3'.
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tema3);

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
                Intent intent = new Intent(topic3screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_3_1);
                intent.putExtra("ILLUSTRATION", R.drawable.question_3_1);
                intent.putExtra("OP1", R.drawable.generic_turtle_asset);
                intent.putExtra("OP2", R.drawable.generic_tiger_asset);
                intent.putExtra("OP3", R.drawable.generic_cat_asset);
                intent.putExtra("RightOp", 1); // Establece la opción correcta (ej. 1)
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic3_1_asset);
                intent.putExtra("SOUND_BUTTON_IMAGE", R.drawable.button_sound_asset);
                intent.putExtra("AUDIO_RESOURCE", R.raw.topic_1_question_3_audio);



                startActivity(intent);
            }
        });

        question2 = (Button) findViewById(R.id.question2);
        question2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic3screen.this, dragMultipleImagesTimeline.class);
                intent.putExtra("DRAGGABLE0", R.drawable.generic_egg1_asset);
                intent.putExtra("FRAME0", R.drawable.generic_nest_asset);
                intent.putExtra("DRAGGABLE1", R.drawable.generic_egg3_asset);
                intent.putExtra("FRAME1", R.drawable.generic_nest_asset);
                intent.putExtra("DRAGGABLE2", R.drawable.generic_egg5_asset);
                intent.putExtra("FRAME2", R.drawable.generic_nest_asset);
                intent.putExtra("INSTRUCTION", R.string.Instruction_3_2);
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic3_2_asset);
                intent.putExtra("SOUND_BUTTON_IMAGE", R.drawable.button_sound_asset);
                intent.putExtra("AUDIO_RESOURCE", R.raw.topic_1_question_3_audio);


                startActivity(intent);
            }
        });

        question3 = (Button) findViewById(R.id.question3);
        question3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic3screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_3_3);
                intent.putExtra("ILLUSTRATION", R.drawable.question_3_3);
                intent.putExtra("OP1", R.drawable.generic_egg2_asset);
                intent.putExtra("OP2", R.drawable.generic_egg3_asset);
                intent.putExtra("OP3", R.drawable.generic_egg4_asset);
                intent.putExtra("RightOp", 1); // Establece la opción correcta (ej. 1)
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic3_3_asset);
                intent.putExtra("SOUND_BUTTON_IMAGE", R.drawable.button_sound_asset);
                intent.putExtra("AUDIO_RESOURCE", R.raw.topic_1_question_3_audio);


                startActivity(intent);
            }
        });

        question4 = (Button) findViewById(R.id.question4);
        question4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic3screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_3_4);
                intent.putExtra("ILLUSTRATION", R.drawable.question_3_4);
                intent.putExtra("OP1", R.drawable.generic_sloth_asset);
                intent.putExtra("OP2", R.drawable.generic_snail_asset);
                intent.putExtra("OP3", R.drawable.generic_sheep_asset);
                intent.putExtra("RightOp", 3); // Establece la opción correcta (ej. 1)
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic3_4_asset);
                intent.putExtra("SOUND_BUTTON_IMAGE", R.drawable.button_sound_asset);
                intent.putExtra("AUDIO_RESOURCE", R.raw.topic_1_question_3_audio);



                startActivity(intent);
            }
        });

        question5 = (Button) findViewById(R.id.question5);
        question5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic3screen.this, dragMultipleImagesTimeline.class);
                intent.putExtra("DRAGGABLE0", R.drawable.generic_plant1_asset_transformed);
                intent.putExtra("FRAME0", R.drawable.generic_flower1_asset);
                intent.putExtra("DRAGGABLE1", R.drawable.generic_plant2_asset);
                intent.putExtra("FRAME1", R.drawable.generic_flower1_asset);
                intent.putExtra("DRAGGABLE2", R.drawable.generic_plant3_asset);
                intent.putExtra("FRAME2", R.drawable.generic_flower1_asset);
                intent.putExtra("INSTRUCTION", R.string.Instruction_3_5);
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic3_5_asset);
                intent.putExtra("SOUND_BUTTON_IMAGE", R.drawable.button_sound_asset);
                intent.putExtra("AUDIO_RESOURCE", R.raw.topic_1_question_3_audio);



                startActivity(intent);
            }
        });

        question6 = (Button) findViewById(R.id.question6);
        question6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic3screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_3_6);
                intent.putExtra("ILLUSTRATION", R.drawable.question_3_6);
                intent.putExtra("OP1", R.drawable.generic_day1_asset);
                intent.putExtra("OP2", R.drawable.generic_night1_asset);
                intent.putExtra("OP3", R.drawable.generic_night2_asset);
                intent.putExtra("RightOp", 1); // Establece la opción correcta (ej. 1)
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic3_6_asset);
                intent.putExtra("SOUND_BUTTON_IMAGE", R.drawable.button_sound_asset);
                intent.putExtra("AUDIO_RESOURCE", R.raw.topic_1_question_3_audio);



                startActivity(intent);
            }
        });
    }
}