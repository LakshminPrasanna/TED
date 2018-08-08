package e.lakshmiprasanna.ted;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PodcastAdapter extends RecyclerView.Adapter<PodcastAdapter.PodcastViewHolder> {
    Context mCtx;
    private List<Podcast> productList;

    public PodcastAdapter(Context mCtx, List<Podcast> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public PodcastAdapter.PodcastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_podcasts, parent, false);
        mCtx = parent.getContext();
        return new PodcastAdapter.PodcastViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final @NonNull PodcastAdapter.PodcastViewHolder holder, int position) {
        Podcast podcast = productList.get(position);
        holder.textView.setText(podcast.getTextView());
        holder.textView2.setText(podcast.getTextView2());
        holder.image.setImageResource((podcast.getImage()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class PodcastViewHolder extends RecyclerView.ViewHolder {

        TextView textView,textView2;
        ImageView image;
        public PodcastViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
            image = itemView.findViewById(R.id.ig_imageView);
        }
    }
}
