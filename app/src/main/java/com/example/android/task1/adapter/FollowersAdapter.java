package com.example.android.task1.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.task1.R;
import com.example.android.task1.activites.ProfileActivity;
import com.example.android.task1.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by world on 2018/02/08.
 */

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.FollowersViewHolder> {

    // static int variable to represent follower list item image, name and description
    private static final int TYPE_WITH_BIO = 2;

    // static int variable to represent follower list item image and name without description
    private static final int TYPE_NO_BIO = 1;


    Context context;
    List<User> userArrayList;

    public FollowersAdapter(Context context, List<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @Override
    public FollowersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.follower_list_item, parent, false);

        return new FollowersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FollowersViewHolder holder, int position) {

        int viewType = getItemViewType(position);

        if (viewType == TYPE_WITH_BIO) {
            holder.followeBioItem.setVisibility(View.VISIBLE);
        }

        User user = userArrayList.get(position);
        holder.followerNameItem.setText(user.getName());
        holder.followeBioItem.setText("" + user.getDescription());
        Picasso.with(context).load(user.getProfileImageUrl()).into(holder.followerProfileItem);

    }

    @Override
    public int getItemViewType(int position) {

        // variable used later in @onBindViewHolder method that represent  item state
        int viewType;

        /* check if the current follower has description or not
        * if it has description return int that represents this state
         * if not return the another state
         * */

        if (userArrayList.get(position).getDescription() != null) {

            viewType = TYPE_WITH_BIO;

        } else {

            viewType = TYPE_NO_BIO;
        }

        // this int contain the state that can used in @onBindViewHolder
        return viewType;
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class FollowersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView followerProfileItem;
        TextView followerNameItem, followeBioItem;

        public FollowersViewHolder(View itemView) {
            super(itemView);

            followerProfileItem = itemView.findViewById(R.id.followerProfileItem);
            followerNameItem = itemView.findViewById(R.id.followerNameItem);
            followeBioItem = itemView.findViewById(R.id.followerBioItem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            // position variable used to take the current position when user clicked
            int postion = getAdapterPosition();

            if (postion != RecyclerView.NO_POSITION) {

                User user = userArrayList.get(postion);
                Intent intent = new Intent(context, ProfileActivity.class);

                intent.putExtra("Follower",user);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }

        }
    }


}

