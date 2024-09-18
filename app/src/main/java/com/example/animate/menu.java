package com.example.animate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class menu extends AppCompatActivity {
    Button tema1Button;
    Button tema2Button;
    Button tema3Button;
    Button tema4Button;
    Button tema5Button;
    Button tema6Button;
    Button tema7Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tema1Button = (Button) findViewById(R.id.Tema1);
        tema1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, topic1screen.class);
                startActivity(intent);
            }
        });

        tema2Button = (Button) findViewById(R.id.Tema2);
        tema2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, topic2screen.class);
                startActivity(intent);
            }
        });

        tema3Button = (Button) findViewById(R.id.Tema3);
        tema3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, topic3screen.class);
                startActivity(intent);
            }
        });

        tema4Button = (Button) findViewById(R.id.Tema4);
        tema4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, topic4screen.class);
                startActivity(intent);
            }
        });

        tema5Button = (Button) findViewById(R.id.Tema5);
        tema5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, topic5screen.class);
                startActivity(intent);
            }
        });

        tema6Button = (Button) findViewById(R.id.Tema6);
        tema6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, topic6screen.class);
                startActivity(intent);
            }
        });

        tema7Button = (Button) findViewById(R.id.Tema7);
        tema7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, topic7screen.class);
                startActivity(intent);
            }
        });
    }
}