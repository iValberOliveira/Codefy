package com.example.codefy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.navigation.fragment.NavHostFragment;

import com.example.codefy.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private GridView podcastGridView;
    private PodcastAdapter podcastAdapter;
    private PodcastModel podcastSelected;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);


        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        ArrayList<PodcastModel> podcastModelList = new ArrayList<PodcastModel>();
        podcastModelList.add(0, new PodcastModel( "Fronteiras da Engenharia de Software", "26. Contribuição em Projetos de Código Aberto (PARTE 1), com Igor Steinmacher ", R.drawable.ep26, "https://anchor.fm/s/248c0568/podcast/play/53541872/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2022-5-15%2F07e2207f-9fc2-badb-0735-2d27199e1551.mp3"));
        podcastModelList.add(1, new PodcastModel( "Fronteiras da Engenharia de Software", "25. Estudos Secundários em Engenharia de Software, com Katia Felizardo (UTFPR)", R.drawable.ep25, "https://anchor.fm/s/248c0568/podcast/play/53541872/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2022-5-15%2F07e2207f-9fc2-badb-0735-2d27199e1551.mp3"));
        podcastModelList.add(2, new PodcastModel( "Fronteiras da Engenharia de Software", "24. Engenharia de Requisitos, com Marcos Kalinowski (PUC-Rio)", R.drawable.ep24, "https://anchor.fm/s/248c0568/podcast/play/53541872/https%3A%2F%2Fd3ctxlq1ktw2nl.cloudfront.net%2Fstaging%2F2022-5-15%2F07e2207f-9fc2-badb-0735-2d27199e1551.mp3"));

        PodcastAdapter adapter = new PodcastAdapter(this.getContext(), podcastModelList);
        binding.featuresPodcastGrid.setAdapter(adapter);

        binding.featuresPodcastGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PodcastModel podcastSelected = adapter.getItem(i);
                Bundle b = new Bundle();
                b.putString("podcast_title_selected", podcastSelected.getPodcast_title());
                b.putString("podcast_author_selected", podcastSelected.getPodcast_author());
                b.putInt("podcast_cover_selected", podcastSelected.getPodcast_cover());
                b.putString("podcast_audio_path_selected", podcastSelected.getPodcast_audio_path());
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment, b);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}