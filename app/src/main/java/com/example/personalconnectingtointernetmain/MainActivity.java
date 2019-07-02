package com.example.personalconnectingtointernetmain;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button click;
    public static TextView fetchedData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = findViewById(R.id.button);
        fetchedData = findViewById(R.id.fetched_data);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fetchedData process = new fetchedData();
                process.execute();

            }
        });


    }
}
