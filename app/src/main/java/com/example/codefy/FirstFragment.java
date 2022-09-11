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

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);


        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        ArrayList<PodcastModel> podcastModelList = new ArrayList<PodcastModel>();
        podcastModelList.add(0, new PodcastModel( "Maycon Software", "Maycodes ep.38", "teste"));
        podcastModelList.add(1, new PodcastModel( "Universidade dos dados", "Não teste seu código!", "teste"));

        PodcastAdapter adapter = new PodcastAdapter(this.getContext(), podcastModelList);
        binding.featuresPodcastGrid.setAdapter(adapter);

        binding.featuresPodcastGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bundle bundle = new Bundle();
                bundle.putString("position", String.valueOf(i));
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}