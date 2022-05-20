package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Album1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Chạy Ngay đi", "Sơn Tùng", "https://p.scdn.co/mp3-preview/58083612fecd3c8a58800886c83b967fa9bac4e6?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Nơi Này có anh", "Sơn Tùng", "https://p.scdn.co/mp3-preview/b84f4b7976899b427dd20ee3320d427dc299a4b3?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Lạc trôi", "Sơn Tùng", "https://p.scdn.co/mp3-preview/7387dbbb34ade6095ebc91edff96a7da73a4253c?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Chúng ta không thuộc về nhau", "Sơn Tùng", "https://p.scdn.co/mp3-preview/c92bfe2052c0563c1b6292a07bc81b6d2a28bf20?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Âm thầm bên em", "Sơn Tùng", "https://p.scdn.co/mp3-preview/ef0d505ab5cdf41f4eba6ca070cf0045bc16acf8?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Không phải dạng vừa đâu", "Sơn Tùng", "https://p.scdn.co/mp3-preview/200ff9858229af7dd19b37ce30583db31e37c1f9?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Em của ngày hôm qua", "Sơn Tùng", "https://p.scdn.co/mp3-preview/81ea1a19864a09306e4a01af97c12641944ce8b1?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Nắng ấm xa dần", "Sơn Tùng", "https://p.scdn.co/mp3-preview/690a2a6b36bda51cda06be44066cfabd54b25634?cid=2afe87a64b0042dabf51f37318616965"));

        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView album1ListView = (ListView) findViewById(R.id.list);
        album1ListView.setAdapter(adapter);

       album1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Item selectedItem = (Item) album1ListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(Album1Activity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
       });
    }
}