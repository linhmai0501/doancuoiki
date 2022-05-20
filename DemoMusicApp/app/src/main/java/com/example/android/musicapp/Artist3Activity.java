package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Artist3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Đêm Mưa Và Anh", "Trịnh Thăng Bình", "https://p.scdn.co/mp3-preview/69b8b15e0bb4c5e4989501091bb94b3374a8cbad?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Đến", "Trịnh Thăng Bình", "https://p.scdn.co/mp3-preview/e8591e918321b5c542c496c1af43da2564281b22?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Đừng Cố Gắng", "Trịnh Thăng Bình", "https://p.scdn.co/mp3-preview/02ea7d725b93d723d0352f89d7ae29d4a6a56070?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Một Mình Tôi", "Trịnh Thăng Bình", "https://p.scdn.co/mp3-preview/25f228c9a672ebbcdf90f7df7cf637e4aefcdeb1?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Ngày Em Đi", "Trịnh Thăng Bình", "https://p.scdn.co/mp3-preview/b8354f4c770121a19d5e10f60b67369b3bfdc90f?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Sẽ Để Em Ra Đi", "Trịnh Thăng Bình", "https://p.scdn.co/mp3-preview/4b9678185aa0dbe6ed985c4f057d76989db04884?cid=2afe87a64b0042dabf51f37318616965"));


        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView artist1ListView = (ListView) findViewById(R.id.list);
        artist1ListView.setAdapter(adapter);
        artist1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Item selectedItem = (Item) artist1ListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(Artist3Activity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
        });

    }
}