package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TracksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Em gái mưa", "Hương Tràm","https://p.scdn.co/mp3-preview/092c659a5f2d0115708f9f0858e4064309b12182?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Mời anh vào Team em", "ChiPu", "https://p.scdn.co/mp3-preview/64e8e611d7c19b9dd7ef6077017f7b6e65f2af7e?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Người ấy", "Trịnh Thăng Bình", "https://p.scdn.co/mp3-preview/6bd84abebd90007eca4246a6045e0a1b9416dfaa?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Giấc mơ em cho", "Chi Dân", "https://p.scdn.co/mp3-preview/a6f49e12a39718c7a4180ba5de697215edf73b95?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Đưa em đi khắp thế gian", "Bích Phương", "https://p.scdn.co/mp3-preview/99c24498ed14b3e5b2e3bb561b7cddf28567e0af?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Anh đã quen với cô đơn", "Soobin Hoàng Sơn", "https://p.scdn.co/mp3-preview/d6b11576c3a482928e0f318f8b5c655c0ce7cfc0?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Khi em ngủ say", "Chi Dân", "https://p.scdn.co/mp3-preview/4c9381f7b15b2e74c232af4a8f70dfb19cba67cf?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Đi để trở về", "Soobin Hoàng Sơn", "https://p.scdn.co/mp3-preview/67bdc6b5e9dcebbbaa484f46b66a172687d647c5?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Bùa yêu", "Bích Phương", "https://p.scdn.co/mp3-preview/e8057e252ca359aaf5d6142d2936b8059a0b8896?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Yêu lại từ đầu", "Khắc Việt", "https://p.scdn.co/mp3-preview/fce63846e0b7ad7f743e9a6cf15f156af1309264?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Như Lời đồn", "Bảo Anh", "https://p.scdn.co/mp3-preview/31ccf003fa936be845dca3b79040910b6bd2fd0a?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Thả vào mưa", "Trung Quân", "https://p.scdn.co/mp3-preview/1e1483e9d8589dcdb4afcfc6f390f97373bd1cad?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Anh nguyện chết vì em", "Hồ Việt Trung", "https://p.scdn.co/mp3-preview/ed31bce9520132586db2ffdb91dc916619ee0b9b?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Câu chuyện Ngày mưa", "Bảo Anh", "https://p.scdn.co/mp3-preview/f295ee00c33e043d79aefebb340ba345b91f3429?cid=2afe87a64b0042dabf51f37318616965"));






        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView tracksListView = (ListView) findViewById(R.id.list);
        tracksListView.setAdapter(adapter);
        tracksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Item selectedItem = (Item) tracksListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(TracksActivity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
        });
    }
}
