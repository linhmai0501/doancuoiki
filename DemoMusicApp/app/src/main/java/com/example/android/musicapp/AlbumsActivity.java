package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);
        ArrayList<Item> songs = new ArrayList<Item>();

        songs.add(new Item("Những bài hát hay nhất của Sơn Tùng", "Sơn Tùng", ""));
        songs.add(new Item("Những bài hát hay nhất của Phan Mạnh Quỳnh", "Phan Mạnh Quỳnh", ""));
        songs.add(new Item("Những bài hát hay nhất của Noo Phước Thịnh", "Noo Phước Thịnh", ""));
        songs.add(new Item("Nhạc bất hữu", "Nhiều ca sĩ", ""));
        songs.add(new Item("Đã đến lúc", "Nhiều ca sĩ", ""));
        songs.add(new Item("Ngàn năm thương nhớ", "Nhiều ca sĩ", ""));
        songs.add(new Item("Tứ Quý Sài Gòn", "Nhiều ca sĩ", ""));

        ItemAdapter adapter = new ItemAdapter(this, songs);
        ListView albumsListView = (ListView) findViewById(R.id.list);
        albumsListView.setAdapter(adapter);
        albumsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                if(i == 0){
                Intent nowPlayingIntent = new Intent(AlbumsActivity.this, Album1Activity.class);
                startActivity(nowPlayingIntent);}
                else if(i == 1){
                    Intent nowPlayingIntent = new Intent(AlbumsActivity.this, Album2Activity.class);
                    startActivity(nowPlayingIntent);}
                else if(i == 2){
                    Intent nowPlayingIntent = new Intent(AlbumsActivity.this, Album3Activity.class);
                    startActivity(nowPlayingIntent);}
                else if(i == 3){
                    Intent nowPlayingIntent = new Intent(AlbumsActivity.this, Album4Activity.class);
                    startActivity(nowPlayingIntent);}
                else if(i == 4){
                    Intent nowPlayingIntent = new Intent(AlbumsActivity.this, Album5Activity.class);
                    startActivity(nowPlayingIntent);}
                else if(i == 5){
                    Intent nowPlayingIntent = new Intent(AlbumsActivity.this, Album6Activity.class);
                    startActivity(nowPlayingIntent);}
                else if(i == 6){
                    Intent nowPlayingIntent = new Intent(AlbumsActivity.this, Album7Activity.class);
                    startActivity(nowPlayingIntent);}
            }
        });
    }
}

