package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Artist1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Dưới những cơn mưa", "Mr.siro", "https://p.scdn.co/mp3-preview/b748e814ba4d6ca04a95d0237155e2a13fbacb59?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Lắng nghe nước mặt", "Mr.siro", "https://p.scdn.co/mp3-preview/3a0d853744044a7237cb526d60c2464dbf96d241?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Bức tranh từ nước mắt", "Mr.siro", "https://p.scdn.co/mp3-preview/649d713bf7c2d93bddeda41cc8544c91c8a3bceb?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Gương mặt lạ lẫm", "Mr.siro", "https://p.scdn.co/mp3-preview/139f69b768a8c98822af93b6909aba949ae0571b?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Người con gái không thể quên", "Mr.siro", "https://p.scdn.co/mp3-preview/b6c76b712f9461150204027dca1a7a44ab015cba?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Marry Me", "Mr.siro", "https://p.scdn.co/mp3-preview/2cb8490f85098adbafdac6399ffeabda7004428e?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Chỉ có một người để yêu trên thế gian", "Mr.siro", "https://p.scdn.co/mp3-preview/6974394b2a9c1ab049e72c572042e9d8d977204b?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("mâmma","Linh","https://p.scdn.co/mp3-preview/6974394b2a9c1ab049e72c572042e9d8d977204b?cid=2afe87a64b0042dabf51f37318616965"));


        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView artist1ListView = (ListView) findViewById(R.id.list);
        artist1ListView.setAdapter(adapter);
        artist1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Item selectedItem = (Item) artist1ListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(Artist1Activity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
        });

    }
}