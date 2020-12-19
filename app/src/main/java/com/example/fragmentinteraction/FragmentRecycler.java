package com.example.fragmentinteraction;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FragmentRecycler extends Fragment {

    View view;
    RecyclerView recyclerView;
    List<ModelBook> bookList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recycler, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        AdapterRecycler adapterRecycler = new AdapterRecycler(getContext(), bookList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapterRecycler);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bookList = new ArrayList<>();
        bookList.add(new ModelBook("qwerty", "wwww"));
        bookList.add(new ModelBook("qwerty1", "wwww1"));
        bookList.add(new ModelBook("qwerty2", "wwww2"));
        bookList.add(new ModelBook("qwerty3", "wwww3"));

    }

}