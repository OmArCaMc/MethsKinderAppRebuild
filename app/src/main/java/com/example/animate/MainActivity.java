package com.example.animate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView start;
    ImageView exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        start = (ImageView) findViewById(R.id.startBttn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectOption.class);
                intent.putExtra("INSTRUCTION", R.string.Instruction_1_1);
                intent.putExtra("ILLUSTRATION", R.drawable.illustration_1_1);
                intent.putExtra("OP1", R.drawable.bird);
                intent.putExtra("OP2", R.drawable.bunny);
                intent.putExtra("OP3", R.drawable.lion);
                startActivity(intent);
            }
        });

        // NO es buena practica tener boton para salir de la app (app movil)
        exit = (ImageView) findViewById(R.id.exitBttn);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Solo "mata" esta actividad, si se crearon otras esas siguen activas. Es mas como un boton de "atras"
                finish();
                System.exit(0);
            }
        });
    }
}