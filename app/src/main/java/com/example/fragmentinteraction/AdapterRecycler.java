package com.example.fragmentinteraction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder> {

    Context context;
    List<ModelBook> bookList = new ArrayList<>();

    public AdapterRecycler(Context context, List<ModelBook> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.task_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (bookList != null) {
            ModelBook modelBook = this.bookList.get(position);

            holder.textTitle.setText(modelBook.getTitle());
            holder.textAuthor.setText(modelBook.getAuthor());

        }
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textTitle;
        private TextView textAuthor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = (TextView) itemView.findViewById(R.id.titleView);
            textAuthor = (TextView) itemView.findViewById(R.id.authorView);

        }

    }

//    public void onChange(List<ModelBook> books) {
//        bookList.clear();
//        bookList.addAll(books);
//        notifyDataSetChanged();
//    }

}
