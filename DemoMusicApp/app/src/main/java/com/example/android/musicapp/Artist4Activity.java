package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Artist4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Anh Không Giữ", "Bích Phương", "https://p.scdn.co/mp3-preview/dd8d334a2aa74e5a4099e65ca3785a87c0e56edb?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Bí Mật Cuối Cùng Của Em", "Bích Phương", "https://p.scdn.co/mp3-preview/96d5b235e776dcc51886b7ef2b72bfb5e5321c67?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Cớ Sao Giờ Lại Chia Xa", "Bích Phương", "https://p.scdn.co/mp3-preview/f3514ef96d2dd0bd8f5d2d7a2a0db38e764f48d7?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Còn Thương Rau Đắng Mọc Sau Hè", "Bích Phương", "https://p.scdn.co/mp3-preview/06565b28542de5700db309bb8be4b5bbb8f707c8?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("", "Dù Chỉ Là Người Tình", "https://p.scdn.co/mp3-preview/3163c59fe52aad2fea0e66e6d43ed87e3bff9c5d?cid=2afe87a64b0042dabf51f37318616965"));

        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView artist1ListView = (ListView) findViewById(R.id.list);
        artist1ListView.setAdapter(adapter);
        artist1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Item selectedItem = (Item) artist1ListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(Artist4Activity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
        });

    }
}