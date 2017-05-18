package com.example.nickng.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class modifySong extends AppCompatActivity {

    TextView tvId;
    EditText etTitle, etSinger, etYear;
    Button btnUpdate, btnDelete, btnCancel;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);

        tvId = (TextView)findViewById(R.id.tvSongId);
        etTitle = (EditText) findViewById(R.id.etSongTitle);
        etSinger = (EditText) findViewById(R.id.etSinger);
        etYear = (EditText) findViewById(R.id.etYear);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        btnCancel = (Button)findViewById(R.id.btnCancel);

        final Intent i = getIntent();
        data = (Song)i.getSerializableExtra("data");

        tvId.setText(data.get_id());
        etTitle.setText(data.getTitle());
        etSinger.setText(data.getSingers());
        etYear.setText(data.getYear());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(modifySong.this);
                data.setTitle(etTitle.getText().toString());
                data.setSingers(etSinger.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
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
