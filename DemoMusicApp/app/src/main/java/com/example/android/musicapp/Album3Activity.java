package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Album3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Thương em là điều anh không thể ngờ", "Noo Phước Thịnh", "https://p.scdn.co/mp3-preview/e18f1d5b7b501ef10d652c171bb8e759e7ef78cc?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Những kẻ mộng mơ", "Noo Phước Thịnh", "https://p.scdn.co/mp3-preview/0b0c536a89577d76aa15f2458548eadd9c57e563?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("I Don't Believe In You", "Noo Phước Thịnh", "https://p.scdn.co/mp3-preview/9437187bad802038e9e9e0c44db5f3c599673704?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Như Phút Ban Đầu", "Noo Phước Thịnh", "https://p.scdn.co/mp3-preview/3590aa63723c0893545362456e2ff590739a37a4?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Gạt đi nước mắt", "Noo Phước Thịnh", "https://p.scdn.co/mp3-preview/92a5781155a8b09ffa5862237323f3e1f6b783d5?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Gọi tên mùa xuân", "Noo Phước Thịnh", "https://p.scdn.co/mp3-preview/bdc74281ddc5216ed53f57e9e02b6be254e37bac?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Giã từ trong cơn mưa", "Noo Phước Thịnh", "https://p.scdn.co/mp3-preview/aaa6da0a1585a4dbeaadd33d9c55fb880a3b7306?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Đổi Thay", "Noo Phước Thịnh", "https://p.scdn.co/mp3-preview/c8fd91192f12a77408462d13a39ea5e41b33bb94?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Em sẽ hạnh phúc", "Noo Phước Thịnh", "https://p.scdn.co/mp3-preview/0e3ecab68e6fb0c7c26b4f6b9fda6edb0f02d470?cid=2afe87a64b0042dabf51f37318616965"));


        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView album1ListView = (ListView) findViewById(R.id.list);
        album1ListView.setAdapter(adapter);

       album1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Item selectedItem = (Item) album1ListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(Album3Activity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
       });
    }
}