package com.example.intentandroidmeetup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button nameBtn = findViewById(R.id.buttonName);
    EditText nameedittext = findViewById(R.id.editTextName);
    Button emailBtn = findViewById(R.id.buttonEmail);
    EditText emailedittext = findViewById(R.id.editTextName);
    Button locationBtn = findViewById(R.id.buttonLocation);
    EditText locationedittext = findViewById(R.id.editTextLocation);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String name_btn = nameedittext.getText().toString();
                Context context = MainActivity.this;
                
            }
        });

    }
}
