package com.example.nickng.p05_ndpsongs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSingers, etYear,;
    Button btnInsert, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = (EditText)findViewById(R.id.etSongTitle);
        etSingers =(EditText)findViewById(R.id.etSinger);
        etYear = (EditText)findViewById(R.id.etYear);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the RadioGroup object
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroupStars);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId = rg.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                int selectedRB = Integer.parseInt(rb.getText().toString());
            }
        });

    }
}
