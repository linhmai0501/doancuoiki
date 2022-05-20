package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Album6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Ây Da Ây Da", "Lương Bích Hữu", "https://p.scdn.co/mp3-preview/5e48d570642c2055138236ba8c7389f835714041?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Đừng Gặp Hôm Nay Anh Nhé", "Lương Bích Hữu", "https://p.scdn.co/mp3-preview/c6a35cd6c561b3f02e19c0d40e5b30beb13c3f79?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Vẽ Trái Tim", "Lương Bích Hữu", "https://p.scdn.co/mp3-preview/1aa235fb16503353b9a504c0f141e69ce3ac9398?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Yêu Thầm", "Lương Bích Hữu", "https://p.scdn.co/mp3-preview/f54ef7a385c24543a09229e8959bbab9fc480823?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Nước Mắt Tương Phùng", "Lương Bích Hữu", "https://p.scdn.co/mp3-preview/03c259f84d24ce1557ab4c1179d73f4a4f8d3f6a?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Xin Đừng Rời Xa", "Lương Bích Hữu", "https://p.scdn.co/mp3-preview/9082f71ab3a3be102db580049c51a656f33e62e0?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Anh Sẽ Vui... Nếu", "Tuấn Hưng", "https://p.scdn.co/mp3-preview/821b1668a962f385675d5fa77e5417351de3c1e6?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Bởi Vì Sao", "Tuấn Hưng", "https://p.scdn.co/mp3-preview/d47de83682b1f0a04c1003dded0e036acdd1b9d9?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Cô Gái Đáng Yêu", "Tuấn Hưng", "https://p.scdn.co/mp3-preview/a6ebddd4670c73aed03b38dd5409b72864c96f52?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Ảo Giác", "Tuấn Hưng", "https://p.scdn.co/mp3-preview/ef665a25cf7fbbd9b067dfaa37de3feb83eb24c0?cid=2afe87a64b0042dabf51f37318616965"));

        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView album1ListView = (ListView) findViewById(R.id.list);
        album1ListView.setAdapter(adapter);

        album1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Item selectedItem = (Item) album1ListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(Album6Activity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
        });
    }
}