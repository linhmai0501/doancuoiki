package com.example.android.musicapp;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.io.IOException;

public class NowPlayingActivity extends AppCompatActivity implements View.OnClickListener,
        View.OnTouchListener, MediaPlayer.OnCompletionListener,
        MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnInfoListener {
    //    Button play, pause;
//    MediaPlayer mediaPlayer;
    Button play, pause;
    Button preview, nextl;
    SeekBar seekBar;
    Player player;
    int flag;
    String url ="";
    ProgressDialog progressDialog;
    private MediaPlayer mediaPlayer;
    private int lengthOfAudio;
    private final Handler handler = new Handler();

    private final Runnable r = new Runnable() {
        @Override
        public void run() {
            updateSeekProgress();

        }
    };

    //For progress
    ImageView ivEqualizer;
    CircularProgressBar cpStreamingMusic;
    TextView tvSpentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_now);

//        play = (Button) findViewById(R.id.play_button);
//        pause = (Button) findViewById(R.id.play_pause);
//        mediaPlayer = new MediaPlayer();
//
        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView itemFirstLine = (TextView) findViewById(R.id.item_first_line);
            TextView itemSecondLine = (TextView) findViewById(R.id.item_second_line);

            itemFirstLine.setText(extras.getString("FIRSTLINE"));
            itemSecondLine.setText(extras.getString("SECONDLINE"));
            url = extras.getString("LINK");
        }
//           // mediaPlayer = (MediaPlayer) MediaPlayer.create(NowPlayingActivity.this, Uri.parse(extras.getString("LINK")));
//            play.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    try {
//                        mediaPlayer = new MediaPlayer();
//                        //mediaPlayer.setDataSource(extras.getString("LINK"));
//                        mediaPlayer.setDataSource("https://paymentdone.000webhostapp.com/despacito.mp3");
//                        mediaPlayer.prepare();
//                        mediaPlayer.start();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            });
//            pause.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    mediaPlayer.pause();
//                }
//            });
//        }
//    }
        progressDialog = new ProgressDialog(this);
        flag = 0;
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        mediaPlayer = new MediaPlayer();

        cpStreamingMusic = (CircularProgressBar) findViewById(R.id.cp_streaming_music);
        ivEqualizer = (ImageView) findViewById(R.id.iv_equalizer);
        tvSpentTime = (TextView) findViewById(R.id.tv_spent_time);
        play = (Button) findViewById(R.id.play_button);
        pause = (Button) findViewById(R.id.play_pause);
        preview = (Button) findViewById(R.id.play_preview);
        nextl = (Button) findViewById(R.id.play_next);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        preview.setOnClickListener(this);
        nextl.setOnClickListener(this);
        seekBar.setOnTouchListener(this);
//        cpStreamingMusic.setOnTouchListener(this);
        mediaPlayer.setOnBufferingUpdateListener(this);
        mediaPlayer.setOnCompletionListener(this);

        mediaPlayer.setOnInfoListener(this);
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        seekBar.setSecondaryProgress(i);
        System.out.println(i);
//        cpStreamingMusic.setProgress(i);

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        seekBar.setProgress(0);
        cpStreamingMusic.setProgressWithAnimation(0);
        pauseAudio();
    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {

        switch (what) {
            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
//                progressDialog.show();

                break;
            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
//                progressDialog.dismiss();

                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.iv_play:
//                if (flag == 0) {
//                    //  new Player().execute(URL);
//                    player = new Player();
//                    player.execute(url);
//
//                } else {
//                    if (mediaPlayer != null) {
//
//                        playAudio();
//
//                    }
//                }
            case R.id.play_button:
                if (flag == 0) {
                    //  new Player().execute(URL);
                    player = new Player();
                    player.execute(url);

                } else {
                    if (mediaPlayer != null) {

                        playAudio();

                    }
                }
                break;
            case R.id.play_preview:
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 5000);
                break;
            case R.id.play_next:
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 5000);
                break;
            case R.id.play_pause:
                mediaPlayer.pause();
                break;
            default:
                break;
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {

        if (mediaPlayer.isPlaying()) {
            SeekBar tmpSeekBar = (SeekBar) v;
            mediaPlayer.seekTo((lengthOfAudio / 100) * tmpSeekBar.getProgress());
        } else {
            SeekBar tmpSeekBar = (SeekBar) v;
            mediaPlayer.seekTo((lengthOfAudio / 100) * tmpSeekBar.getProgress());
        }
        return false;
    }

    private void updateSeekProgress() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                seekBar.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / lengthOfAudio) * 100));
                cpStreamingMusic.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / lengthOfAudio) * 100));

                tvSpentTime.setText(AppUtil.milliSecondsToTimer((long) mediaPlayer.getCurrentPosition()) + "/" + AppUtil.milliSecondsToTimer((long) lengthOfAudio));

                handler.postDelayed(r, 1000);
            }
        }
    }

    class Player extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {

            Boolean prepared;

            try {
                mediaPlayer.setDataSource(params[0]);
                mediaPlayer.prepare();
                lengthOfAudio = mediaPlayer.getDuration();

                prepared = true;

            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                Log.d("IllegarArgument", e.getMessage());
                prepared = false;
                e.printStackTrace();
            } catch (SecurityException e) {
                // TODO Auto-generated catch block
                prepared = false;
                e.printStackTrace();
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                prepared = false;
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                prepared = false;
                e.printStackTrace();
            }

            return prepared;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            progressDialog.dismiss();
            if (aBoolean) {
                flag = 1;
            } else {
                flag = 0;
            }
            playAudio();

        }
    }

    private void playAudio() {

        if (mediaPlayer != null) {
            mediaPlayer.start();
            updateSeekProgress();

            // change background
            Drawable drawable = AppUtil.getDrawableByState(NowPlayingActivity.this, AppUtil.MEDIA_STATE.PLAYING);
            ivEqualizer.setImageDrawable(drawable);
        }
    }

    private void pauseAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();

            // change background
            Drawable drawable = AppUtil.getDrawableByState(NowPlayingActivity.this, AppUtil.MEDIA_STATE.NONE);
            ivEqualizer.setImageDrawable(drawable);
        }
    }
}
