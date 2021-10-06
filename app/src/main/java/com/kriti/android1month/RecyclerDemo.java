package com.kriti.android1month;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerDemo extends AppCompatActivity {

    RecyclerView recyclerView; MyAdapter adapter;
    String[] text = {"One", "Two", "Three", "Four", "Five", "Six", "Seven"};
    int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_demo);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
    {

        class MyViewHolder extends RecyclerView.ViewHolder
        {
            ImageView imageView;
            TextView textView;

            public MyViewHolder(@NonNull View itemView)
            {
                super(itemView);
                imageView = itemView.findViewById(R.id.customImageView);
                textView = itemView.findViewById(R.id.customTextView);
            }
        }

        @NonNull
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(RecyclerDemo.this);
            View view = inflater.inflate(R.layout.custom_layout, parent, false);
            return new MyAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position)
        {
            int displayImage = images[position];
            String displayText = text[position];

            holder.textView.setText(displayText);
            holder.imageView.setImageResource(displayImage);
        }

        @Override
        public int getItemCount() {
            return text.length;
        }
    }
}