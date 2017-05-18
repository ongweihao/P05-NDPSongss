package com.example.nickng.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSingers, etYear;
    Button btnInsert, btnShowList;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = (EditText)findViewById(R.id.etSongTitle);
        etSingers =(EditText)findViewById(R.id.etSinger);
        etYear = (EditText)findViewById(R.id.etYear);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnShowList = (Button)findViewById(R.id.btnShow);
        db = new DBHelper(MainActivity.this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                String singers = etSingers.getText().toString();
                String year = etYear.getText().toString();
                Integer intYear = Integer.parseInt(year);

                // Get the RadioGroup object
                RadioGroup rg = (RadioGroup) findViewById(R.id.rgStars);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId = rg.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                int selectedRB = Integer.parseInt(rb.getText().toString());

                db.insertSong(title,singers,intYear,selectedRB);
                Toast.makeText(MainActivity.this,"Insert Successful", Toast.LENGTH_LONG).show();
                db.close();

            }
        });
        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,showSong.class);
                startActivity(i);
            }
        });

    }
}
