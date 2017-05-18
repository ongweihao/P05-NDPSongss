package com.example.nickng.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15041867 on 18/5/2017.
 */

public class songArrayAdapter extends ArrayAdapter<Song>{

    Context context;
    ArrayList<Song> songs;
    int resource;
    ImageView iv1, iv2, iv3, iv4, iv5;

    public songArrayAdapter(Context context, int resource, ArrayList<Song> notes) {
        super(context, resource, notes);
        this.context = context;
        this.songs = songs;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);
        TextView tvTop = (TextView) rowView.findViewById(R.id.textViewTop);
        TextView tvBottom = (TextView) rowView.findViewById(R.id.textViewBottom);
        TextView tvMiddle = (TextView) rowView.findViewById(R.id.textViewMiddle);
        ImageView iv1 = (ImageView) rowView.findViewById(R.id.imageView1);
        ImageView iv2 = (ImageView) rowView.findViewById(R.id.imageView2);
        ImageView iv3 = (ImageView) rowView.findViewById(R.id.imageView3);
        ImageView iv4 = (ImageView) rowView.findViewById(R.id.imageView4);
        ImageView iv5 = (ImageView) rowView.findViewById(R.id.imageView5);


        //Match the UI components with Java variables

        Song song = songs.get(position);
        String title = song.getTitle();
        String singer = song.getSingers();
        int year = song.getYear();

        tvTop.setText(year);
        tvMiddle.setText(title);
        tvBottom.setText(singer);
        int stars = song.getStars();

        //Check if the property for starts >= 5, if so, "light" up the stars
        if(stars==5) {
            iv5.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }else if(stars==1) {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
            iv2.setImageResource(android.R.drawable.btn_star_big_off);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }else if(stars==2) {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }else if(stars==3) {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }else if(stars==4) {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }


        return rowView;
    }
}
