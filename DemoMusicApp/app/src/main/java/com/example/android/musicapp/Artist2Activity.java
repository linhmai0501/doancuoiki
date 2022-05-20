package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Artist2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Anh Quên Mình Đã Chia Tay", "Khắc Việt", "https://p.scdn.co/mp3-preview/83569aee4bd0668079872bdc83b8cfe4fefd1bd1?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Baby Anh Yêu Em", "Khắc Việt", "https://p.scdn.co/mp3-preview/5a457fb61409998a76e0ce6fc55cc6c6c9045d09?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Chia Tay", "Khắc Việt", "https://p.scdn.co/mp3-preview/2f1b018be7e8dc7a9c7d62600c87afea349f8cb6?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Đêm Thu Tình Yêu", "Khắc Việt", "https://p.scdn.co/mp3-preview/495c97108b0b5b1d9c0f069dbc8a53315ec7bee8?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("I Miss You", "Khắc Việt", "	https://p.scdn.co/mp3-preview/9dbee5805ef187ad9a8e9ad7fb492b1f4a82d2a5?cid=2afe87a64b0042dabf51f37318616965"));


        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView artist1ListView = (ListView) findViewById(R.id.list);
        artist1ListView.setAdapter(adapter);
        artist1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Item selectedItem = (Item) artist1ListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(Artist2Activity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
        });

    }
}