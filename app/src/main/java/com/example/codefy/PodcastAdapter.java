package com.example.codefy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PodcastAdapter extends ArrayAdapter<Podcast> {


    public PodcastAdapter(Context context, ArrayList<Podcast> podcastList) {
        super(context, 0, podcastList);
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listPodcastView = convertView;
        if (listPodcastView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listPodcastView = LayoutInflater.from(getContext()).inflate(R.layout.podcast_feature_card, parent, false);
        }
        Podcast podcast = getItem(position);
        TextView podcast_title = listPodcastView.findViewById(R.id.edt_podcast_title);
        TextView podcast_author = listPodcastView.findViewById(R.id.edt_podcast_author);
        podcast_title.setText(podcast.getPodcast_title());
        podcast_author.setText(podcast.getPodcast_author());
        return listPodcastView;
    }


}
