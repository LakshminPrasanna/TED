package e.lakshmiprasanna.ted;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentPodcasts extends Fragment {

    RecyclerView recyclerView;
    List<Podcast> productList;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //getActivity().setTitle("TED Podcasts");

        View view = inflater.inflate(R.layout.fragment_podcasts, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        productList = new ArrayList<>();
        productList.add(
                new Podcast(
                        R.drawable.image1,
                        "Nice nature",
                        "Today"));
        productList.add(
                new Podcast(
                        R.drawable.image2,
                        "Nice nature",
                        "Today"));
        productList.add(
                new Podcast(
                        R.drawable.image3,
                        "Nice nature",
                        "Today"));
        productList.add(
                new Podcast(
                        R.drawable.image4,
                        "Nice nature",
                        "Today"));
        productList.add(
                new Podcast(
                        R.drawable.images,
                        "Nice nature",
                        "Today"));
        PodcastAdapter adapter = new PodcastAdapter(context, productList);

        recyclerView.setAdapter(adapter);
        return view;
    }
    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("TED Podcasts");

    }
}
