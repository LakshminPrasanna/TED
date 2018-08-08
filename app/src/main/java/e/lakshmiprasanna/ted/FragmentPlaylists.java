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

public class FragmentPlaylists extends Fragment {
    RecyclerView recyclerView;
    List<Product> productList;
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // getActivity().setTitle("TED Playlists");

        View view = inflater.inflate(R.layout.fragment_playlists, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        productList = new ArrayList<>();
        productList.add(
                new Product(
                        1,
                        R.drawable.image1,
                        "Nice nature",
                        "0 talks",
                        "00:00:00"));
        productList.add(
                new Product(
                        1,
                        R.drawable.image2,
                        "Nice nature",
                        "0 talks",
                        "00:00:00"));
        productList.add(
                new Product(
                        1,
                        R.drawable.image3,
                        "Nice nature",
                        "0 talks",
                        "00:00:00"));
        productList.add(
                new Product(
                        1,
                        R.drawable.image4,
                        "Nice nature",
                        "0 talks",
                        "00:00:00"));
        productList.add(
                new Product(
                        1,
                        R.drawable.images,
                        "Nice nature",
                        "0 talks",
                        "00:00:00"));
        PlaylistAdapter adapter = new PlaylistAdapter(context, productList);

        recyclerView.setAdapter(adapter);
        return view;

    }
    public void onResume(){
        super.onResume();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle("TED Playlists");

    }
}
