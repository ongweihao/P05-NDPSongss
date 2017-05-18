package com.example.nickng.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class modifySong extends AppCompatActivity {

    TextView tvId;
    EditText etTitle3, etSinger3, etYear3;
    Button btnUpdate, btnDelete, btnCancel;
    RadioGroup rg;
    Song data;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);

        tvId = (TextView)findViewById(R.id.tvSongId);
        etTitle3 = (EditText) findViewById(R.id.etSongTitle3);
        etSinger3 = (EditText) findViewById(R.id.editTextSingers3);
        etYear3 = (EditText) findViewById(R.id.editTextYears3);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnCancel = (Button)findViewById(R.id.btnCancel);
        rg = (RadioGroup)findViewById(R.id.rgStars3);

        int selected = rg.getCheckedRadioButtonId();
        final RadioButton rb = (RadioButton)findViewById(selected);

        i = getIntent();

        data = (Song) i.getSerializableExtra("data");

        tvId.setText("" + data.get_id());
        etTitle3.setText(data.getTitle());
        etSinger3.setText(data.getSingers());
        etYear3.setText("" + data.getYear());

        int stars = data.getYear();


        if (stars == 1) {
            rb.setChecked(true);
        } else if (stars == 2) {
            rb.setChecked(true);
        } else if (stars == 3) {
            rb.setChecked(true);
        } else if (stars == 4) {
            rb.setChecked(true);
        } else if (stars == 5) {
            rb.setChecked(true);
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(modifySong.this);
                data.setTitle(etTitle3.getText().toString());
                data.setSingers(etSinger3.getText().toString());
                data.setYear(Integer.parseInt(etYear3.getText().toString()));
                dbh.updateSong(data);
                dbh.close();
                setResult(RESULT_OK, i);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(modifySong.this);
                dbh.deleteNote(data.get_id());
                dbh.close();
                setResult(RESULT_OK, i);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
