package com.example.nickng.p05_ndpsongs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class showSong extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Song> song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO implement the Custom ListView
        setContentView(R.layout.activity_show_song);
        lv = (ListView) findViewById(R.id.lv);
        DBHelper db = new DBHelper(showSong.this);
        song = db.getAllSong();

        aa = new songArrayAdapter(this, R.layout.row, song);
        lv.setAdapter(aa);
        aa.notifyDataSetChanged();
        db.close();

    }
}
