package com.leo.testingmvvm.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.leo.testingmvvm.R;
import com.leo.testingmvvm.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NicePlace> nicePlaceList = new ArrayList<>();
    private Context context;

    public RecyclerAdapter(List<NicePlace> nicePlaceList, Context context) {
        this.nicePlaceList = nicePlaceList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).mName.setText(nicePlaceList.get(position).getTitle());
        //set image
        RequestOptions options = new RequestOptions().error(R.drawable.ic_launcher_background);
        Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(nicePlaceList.get(position).getImageUri())
                .into(((ViewHolder)holder).imageView);


    }

    @Override
    public int getItemCount() {
        return nicePlaceList.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView mName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.image_id);
            mName =itemView.findViewById(R.id.name_textView);
        }
    }
}
