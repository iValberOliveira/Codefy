package com.example.codefy;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.codefy.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    GridView listPodcastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listPodcastView = findViewById(R.id.features_podcast_grid);

        ArrayList<Podcast> PodcastList = new ArrayList<Podcast>();
        PodcastList.add(new Podcast( "Maycon Software", "Teste", "teste"));
        PodcastList.add(new Podcast( "Maycon Software", "Teste", "teste"));
        PodcastList.add(new Podcast( "Maycon Software", "Teste", "teste"));


        PodcastAdapter adapter = new PodcastAdapter(this, PodcastList);
        listPodcastView.setAdapter(adapter);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

