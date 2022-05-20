package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Album4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);

        ArrayList<Item> items = new ArrayList<Item>();

        items.add(new Item("Câu chuyện đầu năm", "Hà Thu", "https://phannam.000webhostapp.com/tinh_ca/Câu%20Chuyện%20Đầu%20Năm%20-%20Hà%20Thu%20-%20Bài%20hát,%20lyrics.MP3"));
        items.add(new Item("Không bao giờ quên anh", "Cẩm Ly", "https://phannam.000webhostapp.com/tinh_ca/Không%20Bao%20Giờ%20Quên%20Anh%20-%20Cẩm%20Ly%20-%20Bài%20hát,%20lyrics.MP3"));
        items.add(new Item("Mẹ ơi mai con về", "Hương Lan", "https://phannam.000webhostapp.com/tinh_ca/Mẹ%20Ơi%20Mai%20Con%20Về%20(Có%20Căn%20Nhà%20Nằm%20Nghe%20Nắng%20Mưa%20OST)%20-%20Hương%20Lan%20-%20Bài%20hát,%20lyrics.MP3"));
        items.add(new Item("Nhật ký đời tôi", "Giao Linh", "https://phannam.000webhostapp.com/tinh_ca/Nhật%20ký%20đời%20tôi%20-%20Giao%20Linh%20-%20Bài%20hát,%20lyrics.MP3"));
        items.add(new Item("Thuyền xa bến đỗ", "Thanh Tuyền", "https://phannam.000webhostapp.com/tinh_ca/Thuyền%20Xa%20Bến%20Đỗ%20-%20Thanh%20Tuyền%20-%20Bài%20hát,%20lyrics.MP3"));
        items.add(new Item("Về đâu mái tóc người thương", "Trường Vũ", "https://phannam.000webhostapp.com/tinh_ca/Về%20Đâu%20Mái%20Tóc%20Người%20Thương%20-%20Trường%20Vũ,%20Mai%20Thiên%20Vân%20-%20Bài%20hát,%20lyrics.MP3"));
        items.add(new Item("Đường tình đôi ngã", "Tuấn Vũ, Giao Linh", "https://phannam.000webhostapp.com/tinh_ca/Đường%20Tình%20Đôi%20Ngã%20-%20Tuấn%20Vũ,%20Giao%20Linh%20-%20Bài%20hát,%20lyrics.MP3"));
        items.add(new Item("Đập vỡ cây đàn", "Quang Lê", "https://phannam.000webhostapp.com/tinh_ca/Đập%20Vỡ%20Cây%20Đàn%20-%20Quang%20Lê%20-%20Bài%20hát,%20lyrics.MP3"));
        items.add(new Item("Đắp mộ cuộc tình", "Lê Sang", "https://phannam.000webhostapp.com/tinh_ca/Đắp%20Mộ%20Cuộc%20Tình%20-%20Lê%20Sang%20-%20Bài%20hát,%20lyrics.MP3"));



        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView album1ListView = (ListView) findViewById(R.id.list);
        album1ListView.setAdapter(adapter);

        album1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Item selectedItem = (Item) album1ListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(Album4Activity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
        });
    }
}