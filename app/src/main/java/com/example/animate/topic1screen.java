package com.example.animate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class topic1screen extends AppCompatActivity {
    Button back;
    Button question1;
    Button question2;
    Button question3;
    Button question4;
    Button question5;
    Button question6;

    @Override
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

        back = (Button) findViewById(R.id.backBttn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity and go back to the previous activity.
                finish();
            }
        });

        question1 = (Button) findViewById(R.id.question1);
        question1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic1screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_1_1);
                intent.putExtra("ILLUSTRATION", R.drawable.question_1_1);
                intent.putExtra("OP1", R.drawable.generic_cow_asset);
                intent.putExtra("OP2", R.drawable.generic_cow_asset_2);
                intent.putExtra("OP3", R.drawable.generic_cow_asset_3);
                intent.putExtra("RightOp", 2); // Establece la opción correcta (ej. 1)
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic1_1_asset);
                intent.putExtra("SOUND_BUTTON_IMAGE", R.drawable.button_sound_asset);

                startActivity(intent);
            }
        });

        question2 = (Button) findViewById(R.id.question2);
        question2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic1screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_1_2);
                intent.putExtra("ILLUSTRATION", R.drawable.question_1_2);
                intent.putExtra("OP1", R.drawable.generic_bear_asset);
                intent.putExtra("OP2", R.drawable.generic_panda_asset);
                intent.putExtra("OP3", R.drawable.generic_squirrel_asset);
                intent.putExtra("RightOp", 1); // Establece la opción correcta (ej. 1)
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic1_2_asset);
                intent.putExtra("SOUND_BUTTON_IMAGE", R.drawable.button_sound_asset);


                startActivity(intent);
            }
        });

        question3 = (Button) findViewById(R.id.question3);
        question3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic1screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_1_3);
                intent.putExtra("ILLUSTRATION", R.drawable.question_1_3);
                intent.putExtra("OP1", R.drawable.generic_monkey_1_asset);
                intent.putExtra("OP2", R.drawable.generic_pig_asset);
                intent.putExtra("OP3", R.drawable.generic_lion_asset);
                intent.putExtra("RightOp", 3); // Establece la opción correcta (ej. 1)
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic1_3_asset);
                intent.putExtra("SOUND_BUTTON_IMAGE", R.drawable.button_sound_asset);


                startActivity(intent);
            }
        });

        question4 = (Button) findViewById(R.id.question4);
        question4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic1screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_1_4);
                intent.putExtra("ILLUSTRATION", R.drawable.question1_4);
                intent.putExtra("OP1", R.drawable.generic_forest1_asset);
                intent.putExtra("OP2", R.drawable.generic_forest2_asset);
                intent.putExtra("OP3", R.drawable.generic_forest3_asset);
                intent.putExtra("RightOp", 1); // Establece la opción correcta (ej. 1)
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic1_4_asset);
                intent.putExtra("SOUND_BUTTON_IMAGE", R.drawable.button_sound_asset);


                startActivity(intent);
            }
        });

        question5 = (Button) findViewById(R.id.question5);
        question5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic1screen.this, dragMultipleImagesMod.class);
                intent.putExtra("DRAGGABLE0", R.drawable.generic_giraffe_asset);
                intent.putExtra("FRAME0", R.drawable.generic_elephant_asset);
                intent.putExtra("DRAGGABLE1", R.drawable.generic_dog_asset);
                intent.putExtra("FRAME1", R.drawable.generic_fox_asset);
                intent.putExtra("DRAGGABLE2", R.drawable.generic_tucan_asset);
                intent.putExtra("FRAME2", R.drawable.generic_duck_asset);
                intent.putExtra("INSTRUCTION", R.string.Instruction_1_5);
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic1_5_asset);
                intent.putExtra("SOUND_BUTTON_IMAGE", R.drawable.button_sound_asset);


                startActivity(intent);
            }
        });

        question6 = (Button) findViewById(R.id.question6);
        question6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic1screen.this, dragMultipleImagesMod.class);
                intent.putExtra("DRAGGABLE0", R.drawable.generic_strawberry_asset);
                intent.putExtra("FRAME0", R.drawable.generic_red_apple_asset);
                intent.putExtra("DRAGGABLE1", R.drawable.generic_green_apple_asset);
                intent.putExtra("FRAME1", R.drawable.generic_watermelon_asset);
                intent.putExtra("DRAGGABLE2", R.drawable.generic_lemon_asset);
                intent.putExtra("FRAME2", R.drawable.generic_banana_asset);
                intent.putExtra("INSTRUCTION", R.string.Instruction_1_6);
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic1_6_asset);
                intent.putExtra("SOUND_BUTTON_IMAGE", R.drawable.button_sound_asset);


                startActivity(intent);
            }
        });
    }
}