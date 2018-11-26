package com.example.igorkovasyo.a1laba;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<User> users;

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvEmail, tvPhone;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.item);
            tvEmail = itemView.findViewById(R.id.surname);
            tvPhone = itemView.findViewById(R.id.subitem);
        }
    }

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View postView = inflater.inflate(R.layout.list_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(postView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        User item = users.get(position);
        holder.tvName.setText(item.getName());
        holder.tvPhone.setText(item.getSurname());
        holder.tvEmail.setText(item.getPhone());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
