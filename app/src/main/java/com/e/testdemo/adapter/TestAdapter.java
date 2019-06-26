package com.e.testdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e.testdemo.R;
import com.e.testdemo.models.Post;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyViewHolder> {

    private List<Post> DtaAdapter;
    Context context;
    @NonNull
    @Override
    public TestAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    public TestAdapter(List<Post> DtaAdapter, int recycler_item, Context applicationContext) {
        this.context = applicationContext;
        this.DtaAdapter= DtaAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.MyViewHolder myViewHolder, int position) {
        Post post = DtaAdapter.get(position);
        myViewHolder.textView1.setText(post.getTitle());






    }

    @Override
    public int getItemCount() {
        return DtaAdapter.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.name1);





        }
    }
}
