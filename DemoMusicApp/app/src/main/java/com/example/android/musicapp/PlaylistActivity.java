package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_list);
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Đừng yêu nữa em mệt rồi", "MIN", "https://phannam.000webhostapp.com/Dung-Yeu-Nua-Em-Met-Roi-MIN.mp3"));
        items.add(new Item("Em mới là người yêu anh", "MIN","https://p.scdn.co/mp3-preview/324c59cfa431a3b5fa572a07cbb3048a34c18716?cid=2afe87a64b0042dabf51f37318616965"));
        items.add(new Item("Anh nhà ở đâu thế", "AMEE, B Ray", "https://phannam.000webhostapp.com/anh-nha-o-dau-the.MP3"));
        items.add(new Item("Một bước yêu vạn dặm đau", "Mr.siro", "https://phannam.000webhostapp.com/mot-buoc-yeu-van-dam-dau.MP3"));
        items.add(new Item("Bạc phận", "Jack,K-ICM", "https://phannam.000webhostapp.com/bac-phan.MP3"));
        items.add(new Item("Yêu em dại khờ", "Lou Hoàng", "https://phannam.000webhostapp.com/yeuemdaikho.MP3"));
        items.add(new Item("Cuộc vui cô đơn", "Lê Bảo Bình", "https://phannam.000webhostapp.com/cuocvuicodon.MP3"));
        items.add(new Item("Hồng Nhan", "Jack", "https://phannam.000webhostapp.com/hongnhan.MP3"));
        items.add(new Item("Xin một lần ngoại lệ", "Keyo", "https://phannam.000webhostapp.com/xinmotlanngoaile.MP3"));
        items.add(new Item("Em đã thấy anh cũng người ấy", "Hương Giang", "https://phannam.000webhostapp.com/Em-Da-Thay-Anh-Cung-Nguoi-Ay-Huong-Giang.mp3"));
        items.add(new Item("Đúng người đúng thời điểm", "Thanh Hưng", "https://phannam.000webhostapp.com/dungnguoi.MP3"));
        items.add(new Item("Em sẽ là cô dâu", "Minh Vương M4U, Huy Cung", "https://phannam.000webhostapp.com/emselacodau.MP3"));
        items.add(new Item("Anh ở đây mà", "Đức Phúc", "https://phannam.000webhostapp.com/anhodayma.MP3"));
        items.add(new Item("Anh đang ở đâu đấy anh", "Hương Giang", "https://phannam.000webhostapp.com/anhdangodaudayanh.MP3"));
        items.add(new Item("Nếu ta ngược lối", "Châu Khải Phong", "https://phannam.000webhostapp.com/neutanguocloi.MP3"));
        items.add(new Item("Không phải em đúng không", "Dương Hoàng yến", "https://phannam.000webhostapp.com/khongphaiemdungko.MP3"));





        ItemAdapter adapter = new ItemAdapter(this, items);
        final ListView playlistListView = (ListView) findViewById(R.id.list);
        playlistListView.setAdapter(adapter);


        playlistListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Item selectedItem = (Item) playlistListView.getItemAtPosition(position);
                Intent PlayingIntent = new Intent(PlaylistActivity.this, NowPlayingActivity.class);
                PlayingIntent.putExtra("FIRSTLINE", selectedItem.getFirstLine());
                PlayingIntent.putExtra("SECONDLINE", selectedItem.getSecondLine());
                PlayingIntent.putExtra("LINK", selectedItem.getLink());
                startActivity(PlayingIntent);
            }
        });
    }
}
