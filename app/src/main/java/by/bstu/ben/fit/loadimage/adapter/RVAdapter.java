package by.bstu.ben.fit.loadimage.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import by.bstu.ben.fit.loadimage.R;
import by.bstu.ben.fit.loadimage.model.Image;

import com.bumptech.glide.Glide;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ImageViewHolder>{
    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView imgView;
        ImageViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            imgView = (ImageView)itemView.findViewById(R.id.imageView);
        }
    }

    List<Image> images;
    Context ctx;
    public RVAdapter(List<Image> images, Context context){
        this.images = images;
        ctx = context;
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_item, viewGroup, false);
        ImageViewHolder pvh = new ImageViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder imageViewHolder, int i) {
        Glide.with(ctx).load(images.get(i).url).into(imageViewHolder.imgView);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public Image getItem(int position) {
        return images.get(position);
    }

}
