package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Album5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Đã Đến Lúc", "Soobin Hoàng Sơn", "https://p.scdn.co/mp3-preview/38e703c29514a70ddd75b0d53bb7b6e7c61cacde?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Đẹp Nhất Là Em", "Soobin Hoàng Sơn", "https://p.scdn.co/mp3-preview/dbe3a5c217703c0a010a7fae8b0810b24a4d5e0f?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Vài Lần Đón Đưa", "Soobin Hoàng Sơn", "https://p.scdn.co/mp3-preview/d241fb29f0cbab5044bcc59479e50a35de1cf5f5?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Ngày Mai Em Đi", "Soobin Hoàng Sơn", "https://p.scdn.co/mp3-preview/7aa477d85a9a9226c3a0f20263a927bf1cb401c7?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Đi Để Trở Về", "Soobin Hoàng Sơn", "https://p.scdn.co/mp3-preview/67bdc6b5e9dcebbbaa484f46b66a172687d647c5?cid=2afe87a64b0042dabf51f"));
        items.add(new Item("Anh Hứa Yêu Em", "Minh Vương M4U", "https://p.scdn.co/mp3-preview/bd41f1bc301c8d6ea147afb34bc5d7d01f364068?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Anh Rất Yêu Em", "Minh Vương M4U", "https://p.scdn.co/mp3-preview/397354347eb777e47248c0d06144a0127570b70e?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Anh Vẫn Còn Yêu Em", "Minh Vương M4U", "https://p.scdn.co/mp3-preview/624bc17d810b720b1c23c283512e2a4536e2055f?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Anh Yêu Em Nhiều Lắm", "Minh Vương M4U", "https://p.scdn.co/mp3-preview/64278ac7180c651173a56d4381e7671f1935482c?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Bài Ca Tình Yêu", "Minh Vương M4U", "https://p.scdn.co/mp3-preview/1d2e3cae729aa91e76aa0981c48415c8093c0e67?cid=2afe87a64b0042dabf51f37318616965"));


        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView album1ListView = (ListView) findViewById(R.id.list);
        album1ListView.setAdapter(adapter);

        album1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Item selectedItem = (Item) album1ListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(Album5Activity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
        });
    }
}