package com.example.taapesh.rx_demo.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.taapesh.rx_demo.model.Github;
import com.example.taapesh.rx_demo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private static final String DEFAULT_LOCATION = "Somewhere, Universe";
    List<Github> mItems;

    public CardAdapter() {
        super();
        mItems = new ArrayList<Github>();
    }

    public void addData(Github github) {
        mItems.add(github);
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Github github = mItems.get(i);
        final String location = github.getLocation();
        viewHolder.login.setText(github.getLogin());
        viewHolder.location.setText(location != null ? location : DEFAULT_LOCATION);
        viewHolder.repos.setText("repos: " + github.getPublicRepos());
        viewHolder.blog.setText("blog: " + github.getBlog());

        // Load repo avatar
        Context context = viewHolder.avatar.getContext();
        int size = dpToPx(65f, context);
        Picasso
            .with(context)
            .load(github.getAvatarUrl())
            .resize(size, size)
            .into(viewHolder.avatar);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView login;
        public TextView location;
        public TextView repos;
        public TextView blog;
        public ImageView avatar;

        public ViewHolder(View itemView) {
            super(itemView);
            login = (TextView) itemView.findViewById(R.id.login);
            location = (TextView) itemView.findViewById(R.id.location);
            repos = (TextView) itemView.findViewById(R.id.repos);
            blog = (TextView) itemView.findViewById(R.id.blog);
            avatar = (ImageView) itemView.findViewById(R.id.avatar);
        }
    }

    public static int dpToPx(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }
}
