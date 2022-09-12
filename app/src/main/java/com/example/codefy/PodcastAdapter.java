package com.example.codefy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PodcastAdapter extends BaseAdapter {
    private List<PodcastModel> podcasts;
    private LayoutInflater mInflater;
    public PodcastAdapter(Context context, List<PodcastModel> PodcastModelList){
    this.podcasts = PodcastModelList;
    mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return podcasts.size();
    }

    @Override
    public PodcastModel getItem(int i) {
        return podcasts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listPodcastView = convertView;
        if (listPodcastView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listPodcastView = mInflater.inflate(R.layout.podcast_feature_card, null);
        }
        PodcastModel podcastModel = (PodcastModel) getItem(position);
        TextView podcast_title = listPodcastView.findViewById(R.id.edt_podcast_title);
        TextView podcast_author = listPodcastView.findViewById(R.id.edt_podcast_author);
        ImageView podcast_cover = listPodcastView.findViewById(R.id.icon_back);
        podcast_title.setText(podcastModel.getPodcast_title());
        podcast_author.setText(podcastModel.getPodcast_author());
        podcast_cover.setImageResource(podcastModel.getPodcast_cover());
        return listPodcastView;
    }


}
