package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the Albums category
        ImageView albums = (ImageView) findViewById(R.id.albums);

        // Set a click listener on that View
        albums.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Albums category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link AlbumsActivity}
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);

                // Start the new activity
                startActivity(albumsIntent);
            }
        });

        // Find the View that shows the Artists category
        ImageView artists = (ImageView) findViewById(R.id.artists);

        // Set a click listener on that View
        artists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Artists category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ArtistsActivity}
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);

                // Start the new activity
                startActivity(artistsIntent);
            }
        });

        // Find the View that shows the Playlist category
        ImageView playlist = (ImageView) findViewById(R.id.playlist);

        // Set a click listener on that View
        playlist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Playlist category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PlaylistActivity}
                Intent playlistIntent = new Intent(MainActivity.this, PlaylistActivity.class);

                // Start the new activity
                startActivity(playlistIntent);
            }
        });

        // Find the View that shows the Tracks category
        ImageView tracks = (ImageView) findViewById(R.id.tracks);

        // Set a click listener on that View
        tracks.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Tracks category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link TracksActivity}
                Intent tracksIntent = new Intent(MainActivity.this, TracksActivity.class);

                // Start the new activity
                startActivity(tracksIntent);
            }
        });
    }
}