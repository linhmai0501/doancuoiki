package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Album7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Xuống Phố Mùa Thu", "Mỹ Tâm", "https://p.scdn.co/mp3-peview/de661631f9982b2a32bdf0c8e1423b4b17ca4736?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Sẽ Không Như Thế", "Mỹ Tâm", "https://p.scdn.co/mp3-preview/75c1f13bf21d0c746bda25c60b444a3386ea2561?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Tình Ơi", "Mỹ Tâm", "https://p.scdn.co/mp3-preview/28a933721bf33d4753b9afefc323d16b52d16411?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Sương Đêm", "Mỹ Tâm", "https://p.scdn.co/mp3-preview/1fca9fa0cad5410e8406769a966a2fd42a376322?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Nói Với Em", "Mỹ Tâm", "https://p.scdn.co/mp3-preview/201bdf57798e813473f4d66aa3da1d54ab820ff3?cid=2afe87a64b0042dabf51f37318616965"));

        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView album1ListView = (ListView) findViewById(R.id.list);
        album1ListView.setAdapter(adapter);

        album1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Item selectedItem = (Item) album1ListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(Album7Activity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
        });
    }
}