package com.application.newsapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class NewsDetailsActivity extends AppCompatActivity {

    String title, desc, content, imageUrl, url;

    private TextView titleTv, subDescTv, contentTv;
    private ImageView newsTv;
    private Button readNewsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        title= getIntent().getStringExtra("title");
        desc= getIntent().getStringExtra("desc");
        content= getIntent().getStringExtra("content");
        imageUrl= getIntent().getStringExtra("image");
        url= getIntent().getStringExtra("url");

        titleTv=findViewById(R.id.idIVTitle);
        subDescTv=findViewById(R.id.idIVSubTitle);
        contentTv=findViewById(R.id.idIVContent);
        newsTv=findViewById(R.id.idIVNews);
        readNewsBtn=findViewById(R.id.idBtnReadNews);

        titleTv.setText(title);
        subDescTv.setText(desc);
        contentTv.setText(content);
        Picasso.get().load(imageUrl).into(newsTv);
        readNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}