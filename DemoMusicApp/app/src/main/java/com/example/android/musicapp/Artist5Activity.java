package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Artist5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Anh Không May Mắn", "Châu Khải Phong", "https://p.scdn.co/mp3-preview/a780733019fd9922b57202112d100d6a8dfca8dd?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Anh Sẽ Để Em Ra Đi", "Châu Khải Phong", "https://p.scdn.co/mp3-preview/c2bd67cffd3f30e14a9862385f6af457258771a5?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Anh Sẽ Mãi Bên Em", "Châu Khải Phong", "https://p.scdn.co/mp3-preview/09646e24f20ea47e927f9c423cc5d18724405a2d?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Anh Sẽ Tập Quên", "Châu Khải Phong", "https://p.scdn.co/mp3-preview/2a8b07ad71e9e858e29f814d49371c84eeb442dc?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Anh Thích Em Như Xưa", "Châu Khải Phong", "https://p.scdn.co/mp3-preview/98d77c0e6d135461b9f94387b771b60c07b856a7?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Anh Xin Lỗi Em", "Châu Khải Phong", "https://p.scdn.co/mp3-preview/45a9bce4b67fc43b41220e1620d27cdddec5c083?cid=2afe87a64b0042dabf51f37318616965"));
        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView artist1ListView = (ListView) findViewById(R.id.list);
        artist1ListView.setAdapter(adapter);
        artist1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Item selectedItem = (Item) artist1ListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(Artist5Activity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
        });

    }
}