package com.example.nickng.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class showSong extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Song> song;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO implement the Custom ListView
        setContentView(R.layout.activity_show_song);

        btn = (Button)findViewById(R.id.btnShowAll);

        lv = (ListView) findViewById(R.id.lv);
        DBHelper db = new DBHelper(showSong.this);
        song = db.getAllSong();

        aa = new songArrayAdapter(this, R.layout.row, song);
        lv.setAdapter(aa);
        aa.notifyDataSetChanged();
        db.close();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(showSong.this);
                song.clear();
                song.addAll(dbh.get5Songs());
                dbh.close();
                lv.setAdapter(aa);
                aa.notifyDataSetChanged();
            }
        });
   lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       @Override
       public void onItemClick(AdapterView<?> parent, View view, int
               position, long identity)  {

               Intent i = new Intent(showSong.this,
                   modifySong.class);
               Song data = song.get(position);

//           int id = data.get_id();
//           String title = data.getTitle();
//           String singer = data.getSingers();
//           int years = data.getYear();
//           int stars = data.getStars();

//           Song target = new Song(title,singer,years,stars);
           i.putExtra("data", data);
           startActivity(i);

       }
   });

    }
}
