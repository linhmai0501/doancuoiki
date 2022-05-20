package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Album2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Có một nơi như thế", "Phan Mạnh Quỳnh","https://p.scdn.co/mp3-preview/f9386d748b4b79211b6ef15a277afe3dd0ca6f54?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Huyền Thoại", "Phan Mạnh Quỳnh", "https://p.scdn.co/mp3-preview/ae6543021cfbafc43d25fc8e44f09ebbb368ed08?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Chờ ngày giông bão", "Phan Mạnh Quỳnh", "https://p.scdn.co/mp3-preview/78b923e77204ec0a71ec4ba4f78ce417da9ebd5c?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Người Khác (Piano R&B Version)", "Phan Mạnh Quỳnh", "https://p.scdn.co/mp3-preview/11cfb8d4ba30518fe95cd4fbb0deaca1708c91e5?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Hồi ức", "Phan Mạnh Quỳnh", "https://p.scdn.co/mp3-preview/0c5538c343f458ba9dc5483c61ef07ce567feec8?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Tri kỷ", "Phan Mạnh Quỳnh", "\thttps://p.scdn.co/mp3-preview/aca1c9803299eb5efd1730c4e2c0f3736e07c488?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Con Tim Vỡ Tan", "Phan Mạnh Quỳnh","https://p.scdn.co/mp3-preview/388e45d9c154e45d666e776981288b74745b77ca?cid=2afe87a64b0042dabf51f37318616965" ));
        items.add(new Item("Anh ghét làm bạn em", "Phan Mạnh Quỳnh", "https://p.scdn.co/mp3-preview/95e2d703dfc65b15d1979c9f423942cd2a31a2d1?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Có chàng trai viết lên cây", "Phan Mạnh Quỳnh", "https://p.scdn.co/mp3-preview/d2c6258a482a23c250c3730741a4558bce2d9813?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Nước ngoài", "Phan Mạnh Quỳnh", "https://p.scdn.co/mp3-preview/e3bb0a92bdb6ad636bf3a02c11350241f683ed3b?cid=2afe87a64b0042dabf51f37318616965"));

        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView album1ListView = (ListView) findViewById(R.id.list);
        album1ListView.setAdapter(adapter);

        album1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Item selectedItem = (Item) album1ListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(Album2Activity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
        });
    }
}