package com.example.websitemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.websitemaker.databinding.ActivityNavigationBarBinding;

public class NavigationBar extends AppCompatActivity {
    ActivityNavigationBarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);
        binding=ActivityNavigationBarBinding.inflate(getLayoutInflater());

        getSupportActionBar().hide();

        String title="Hello";
        StringBuilder code= new StringBuilder();
        Dialog dialog=new Dialog(NavigationBar.this);
        dialog.setContentView(R.layout.nav_dialogbox);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);

        EditText n_title,img_url,item1,item2,item3,dropdown_count;
        LinearLayout n_items,dd_items;
        Button done_btn;

        n_title=dialog.findViewById(R.id.nav_title);
        img_url=dialog.findViewById(R.id.image_url);
        item1=dialog.findViewById(R.id.item_1);
        item2=dialog.findViewById(R.id.item_2);
        item3=dialog.findViewById(R.id.item3);
        dropdown_count=dialog.findViewById(R.id.drop_count);

        n_items=dialog.findViewById(R.id.nav_items);
        dd_items=dialog.findViewById(R.id.dropdown_items);

        done_btn=dialog.findViewById(R.id.done);


        code.append("<!DOCTYPE html>\n<html>\n<head>\n<title>"+title+"</title>\n</head>\n<body>");

        binding.nav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
               String navbar_title=n_title.getText().toString();
               done_btn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       if(!navbar_title.isEmpty()){
                           code.append("<nav class=\"navbar navbar-light bg-light\">\n  <div class=\"container-fluid\">\n" +
                                   " <span class=\"navbar-brand mb-0 h1\">"+navbar_title+"</span>\n  </div> \n </nav>");
                       }
                   }
               });

            }
        });

        binding.nav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                img_url.setVisibility(View.VISIBLE);
                String navbar_title=n_title.getText().toString();
                String url=img_url.getText().toString();

                done_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!navbar_title.isEmpty() && !url.isEmpty()){
                            code.append("<nav class=\"navbar navbar-light bg-light\">\n" +
                                    "  <div class=\"container\">\n" +
                                    "    <a class=\"navbar-brand\" href=\"#\">\n" +
                                    "      <img src=\""+url+"\" alt=\"\" width=\"30\" height=\"24\">\n" +
                                    "    </a>\n" +
                                    "  </div>\n" +
                                    "</nav>");
                        }
                    }
                });

            }
        });
    }
}