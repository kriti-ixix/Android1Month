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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerDemo extends AppCompatActivity {

    RecyclerView recyclerView; MyAdapter adapter;
    int[] images = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five,
    R.drawable.six, R.drawable.seven};

    String[] text = {"One", "Two", "Three", "Four", "Five", "Six", "Seven"};

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
            TextView textView; ImageView imageView;
            LinearLayout linearLayout;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.customTextView);
                imageView = itemView.findViewById(R.id.customImageView);
                linearLayout = itemView.findViewById(R.id.linearLayout);
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
            int image = images[position];
            String t = text[position];

            holder.textView.setText(t);
            holder.imageView.setImageResource(image);

            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i = holder.getAdapterPosition();
                    text[i] = "Clicked!";
                    images[i] = R.drawable.one;
                    Toast.makeText(RecyclerDemo.this, "Clicked", Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return images.length;
        }
    }

}