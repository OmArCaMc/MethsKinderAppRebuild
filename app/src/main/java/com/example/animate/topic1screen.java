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
                Intent intent = new Intent(topic1screen.this, dragMultipleImagesMod.class);
                intent.putExtra("DRAGGABLE0", R.drawable.bear_asset);
                intent.putExtra("FRAME0", R.drawable.generic_tree_asset_1);
                intent.putExtra("DRAGGABLE1", R.drawable.bunny);
                intent.putExtra("FRAME1", R.drawable.bunny);
                intent.putExtra("DRAGGABLE2", R.drawable.lion);
                intent.putExtra("FRAME2", R.drawable.lion);
                intent.putExtra("INSTRUCTION", "Instruccion radical");
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic1_4_asset);

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

        question3 = (Button) findViewById(R.id.question3);
        question3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic1screen.this, matchingActivityNoMod.class);
                startActivity(intent);
            }
        });

        question4 = (Button) findViewById(R.id.question4);
        question4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic1screen.this, SelectOptionMod.class);

                intent.putExtra("INSTRUCTION", R.string.Instruction_1_1);
                intent.putExtra("ILLUSTRATION", R.drawable.monkey2_asset);
                intent.putExtra("OP1", R.drawable.monkey2_asset);
                intent.putExtra("OP2", R.drawable.bird_asset);
                intent.putExtra("OP3", R.drawable.tucan_asset);
                intent.putExtra("RightOp", 1); // Establece la opción correcta (ej. 1)
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic1_4_asset);


                startActivity(intent);
            }
        });

        question5 = (Button) findViewById(R.id.question5);
        question5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(topic1screen.this, draggableImage.class);

                intent.putExtra("DRAGGABLE0", R.drawable.monkey_asset);
                intent.putExtra("FIXED0", R.drawable.generic_tree_asset_1);
                intent.putExtra("INSTRUCTION", "Instruccion radical");
                intent.putExtra("BACK_BUTTON_IMAGE", R.drawable.back_topic1_4_asset);
                // above, below, left, right
                intent.putExtra("EXPECTED_POSITION", "above");
                startActivity(intent);
            }
        });
    }
}