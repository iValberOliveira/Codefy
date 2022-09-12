package com.example.codefy;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.navigation.fragment.NavHostFragment;

import com.example.codefy.databinding.FragmentSecondBinding;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    SeekBar seekBar;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView edt_title_podcast = view.findViewById(R.id.edt_title_podcast);
        TextView edt_author_podcast = view.findViewById(R.id.edt_author_podcast);
        TextView edt_duration = view.findViewById(R.id.duration);
        TextView edt_current_duration = view.findViewById(R.id.currentDuration);

        ImageView imageView = (ImageView)  view.findViewById(R.id.podcast_cover);
        ImageView btn_player = (ImageView) view.findViewById(R.id.btn_player);

        seekBar = view.findViewById(R.id.seekBar2);


        edt_title_podcast.setText(getArguments().getString("podcast_title_selected"));
        edt_author_podcast.setText(getArguments().getString("podcast_author_selected"));
        imageView.setImageResource(getArguments().getInt("podcast_cover_selected"));

        MediaPlayer podcast_player = new MediaPlayer();
        String url = getArguments().getString("podcast_audio_path_selected");
        try {
            podcast_player.setDataSource(url);
            podcast_player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
            podcast_player.prepareAsync();


        } catch (IOException e) {
            e.printStackTrace();
        }



        btn_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(podcast_player.isPlaying()){
                    podcast_player.pause();
                }else{
                    podcast_player.start();
                }
            }
        });
        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_FirstFragment);

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}