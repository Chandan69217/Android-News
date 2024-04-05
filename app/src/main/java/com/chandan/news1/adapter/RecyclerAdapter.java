package com.chandan.news1.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chandan.news1.News;
import com.chandan.news1.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Executors;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.VH> {
    private Context context;
   // private String url = "https://etimg.etb2bimg.com/thumb/msid-107452506,imgsize-39714,width-1200,height=765,overlay-ethealth/industry/redcliffe-labs-launches-be-your-own-sheroes-learn-prevent-screen-campaign-for-cervical-cancer.jpg";
    private Bitmap image;
    private InputStream in;
    private News headlines;


    public RecyclerAdapter(Context context,News values){
        this.context = context;
        headlines = values;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.headline_layout,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
       // Log.d("ArticleLength",String.valueOf(headlines.getArticles().size()) + headlines.getTotalResults());
        String url = headlines.getArticles().get(holder.getAdapterPosition()).geturlToImage();
        Handler handler = new Handler(Looper.getMainLooper());
        Executors.newSingleThreadExecutor().execute(()->{
            try {
                in = new URL(url).openStream();
            } catch (IOException e) {
                Log.e("IO",e.toString());
            }

            image = BitmapFactory.decodeStream(in);
            handler.post(()->{
                holder.setImage(image);
            });

        });

        holder.setAuthorName(headlines.getArticles().get(holder.getAdapterPosition()).getAuthor());
        holder.setTitle(headlines.getArticles().get(holder.getAdapterPosition()).getTitle());
        holder.setContent(headlines.getArticles().get(holder.getAdapterPosition()).getContent());
        holder.setTimeDate(headlines.getArticles().get(holder.getAdapterPosition()).getPublishedAt());

    }

    @Override
    public int getItemCount() {
        return headlines.getArticles().size();
    }

    public class VH extends RecyclerView.ViewHolder{
        private RoundedImageView image;
        private TextView author_name;
        private TextView title;
        private TextView content;
        private TextView time_date;
        public VH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.news_image);
            author_name = itemView.findViewById(R.id.author_name);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            time_date = itemView.findViewById(R.id.time_date);
        }
        public void setImage(Bitmap image){
            this.image.setImageBitmap(image);
        }
        public void setAuthorName(String authorName){
            this.author_name.setText(authorName);
        }
        public void setTitle(String title){
            this.title.setText(title);
        }
        public void setContent(String content){
            this.content.setText(content);
        }
        public void setTimeDate(String timeDate){
            this.time_date.setText(timeDate);
        }

    }
}
