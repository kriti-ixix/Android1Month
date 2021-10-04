package com.kriti.android1month;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerDemo extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] text = {"One", "Two", "Three", "Four", "Five", "Six", "Seven"};
    int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_demo);

        recyclerView = findViewById(R.id.recyclerView);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
    {

        class MyViewHolder extends RecyclerView.ViewHolder
        {
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }

        @NonNull
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}