package com.example.android.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);



        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Mr.Siro", "7 tracks",""));
        items.add(new Item("Khắc Việt", "5 tracks",""));
        items.add(new Item("Trịnh Thăng Bình", "6 tracks",""));
        items.add(new Item("Bích Phương", "5 tracks",""));
        items.add(new Item("Châu Khải Phong", "6 tracks",""));



        final ItemAdapter adapter = new ItemAdapter(this, items);
        ListView artistsListView = (ListView) findViewById(R.id.list);
        artistsListView.setAdapter(adapter);
        artistsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
        public void onItemClick(AdapterView<?> parent, View view,
        int position, long id) {
                if (position==0){
                    Intent nowPlayingIntent = new Intent(ArtistsActivity.this, Artist1Activity.class);
                    startActivity(nowPlayingIntent);}
                else if (position==1){
                    Intent nowPlayingIntent = new Intent(ArtistsActivity.this, Artist2Activity.class);
                    startActivity(nowPlayingIntent);}
                else if (position==2){
                    Intent nowPlayingIntent = new Intent(ArtistsActivity.this, Artist3Activity.class);
                    startActivity(nowPlayingIntent);}
                else if (position==3){
                    Intent nowPlayingIntent = new Intent(ArtistsActivity.this, Artist4Activity.class);
                    startActivity(nowPlayingIntent);}
                else if (position==4){
                    Intent nowPlayingIntent = new Intent(ArtistsActivity.this, Artist5Activity.class);
                    startActivity(nowPlayingIntent);}



            }
        });
    }
}
