package com.example.websitemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.websitemaker.databinding.ActivityNavigationBarBinding;

public class NavigationBar extends AppCompatActivity {
    ActivityNavigationBarBinding binding;
    StringBuilder code= new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityNavigationBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        String title="Hello";
        Dialog dialog=new Dialog(NavigationBar.this);
        dialog.setContentView(R.layout.nav_dialogbox);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
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
                n_title.setVisibility(View.VISIBLE);
                n_items.setVisibility(View.GONE);
                dd_items.setVisibility(View.GONE);
                img_url.setVisibility(View.GONE);
                dialog.show();
               done_btn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       String navbar_title=n_title.getText().toString();
                       if(!navbar_title.isEmpty()){
                           code.append("<nav class=\"navbar navbar-light bg-light\">\n  <div class=\"container-fluid\">\n" +
                                   " <span class=\"navbar-brand mb-0 h1\">"+navbar_title+"</span>\n  </div> \n </nav>");
                           dialog.dismiss();
                               nextActivity();
                       }
                   }
               });

            }
        });

        binding.nav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_url.setVisibility(View.VISIBLE);
                n_title.setVisibility(View.GONE);
                dialog.show();

                done_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url=img_url.getText().toString();
                        if(!url.isEmpty()){
                            code.append("<nav class=\"navbar navbar-light bg-light\">\n" +
                                    "  <div class=\"container\">\n" +
                                    "    <a class=\"navbar-brand\" href=\"#\">\n" +
                                    "      <img src=\""+url+"\" alt=\"\" width=\"30\" height=\"24\">\n" +
                                    "    </a>\n" +
                                    "  </div>\n" +
                                    "</nav>");
                            dialog.dismiss();
                                nextActivity();
                        }
                    }
                });
            }
        });

        binding.nav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_url.setVisibility(View.VISIBLE);
                n_items.setVisibility(View.GONE);
                dd_items.setVisibility(View.GONE);
                n_title.setVisibility(View.VISIBLE);
                dialog.show();

                done_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String navbar_title=n_title.getText().toString();
                        String url=img_url.getText().toString();
                            code.append("nav class=\"navbar navbar-light bg-light\">\n" +
                                    "  <div class=\"container-fluid\">\n" +
                                    "    <a class=\"navbar-brand\" href=\"#\">\n" +
                                    "      <img src=\""+url+"\" alt=\"\" width=\"30\" height=\"24\" class=\"d-inline-block align-text-top\">\n"+
                                    navbar_title+"</a>\n" +
                                    "  </div>\n" +
                                    "</nav>");
                            dialog.dismiss();
                            nextActivity();
                        }
                });
            }
        });

        binding.nav4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_url.setVisibility(View.GONE);
                dd_items.setVisibility(View.GONE);
                n_items.setVisibility(View.VISIBLE);
                n_title.setVisibility(View.VISIBLE);
                dialog.show();

                done_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String navbar_title=n_title.getText().toString();
                        String it1=item1.getText().toString();
                        String it2=item2.getText().toString();
                        String it3=item3.getText().toString();

                            code.append("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n" +
                                    "  <div class=\"container-fluid\">\n" +
                                    "    <a class=\"navbar-brand\" href=\"#\">"+navbar_title+"</a>\n" +
                                    "    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                                    "      <span class=\"navbar-toggler-icon\"></span>\n" +
                                    "    </button>\n" +
                                    "    <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n" +
                                    "      <ul class=\"navbar-nav\">\n" +
                                    "        <li class=\"nav-item\">\n" +
                                    "          <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">"+it1+"</a>\n" +
                                    "        </li>\n" +
                                    "        <li class=\"nav-item\">\n" +
                                    "          <a class=\"nav-link\" href=\"#\">"+it2+"</a>\n" +
                                    "        </li>\n" +
                                    "        <li class=\"nav-item\">\n" +
                                    "          <a class=\"nav-link\" href=\"#\">"+it3+"</a>\n" +
                                    "        </li>\n" +
                                    "      </ul>\n" +
                                    "    </div>\n" +
                                    "  </div>\n" +
                                    "</nav>");
                            dialog.dismiss();
                            nextActivity();
                    }
                });
            }
        });

        binding.nav5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_url.setVisibility(View.GONE);
                dd_items.setVisibility(View.VISIBLE);
                n_items.setVisibility(View.VISIBLE);
                n_title.setVisibility(View.VISIBLE);
                dialog.show();

                done_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String navbar_title=n_title.getText().toString();
                        String count=dropdown_count.getText().toString();
                        String it1=item1.getText().toString();
                        String it2=item2.getText().toString();
                        String it3=item3.getText().toString();
                        Toast.makeText(NavigationBar.this, navbar_title, Toast.LENGTH_SHORT).show();
                        StringBuilder stringBuilder=new StringBuilder();
                            for(int i=1;i<=Integer.valueOf(count);i++){
                                stringBuilder.append("<li><a class=\"dropdown-item\" href=\"#\">"+"item"+i+"</a></li>\n");
                            }
                            code.append("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n" +
                                    "  <div class=\"container-fluid\">\n" +
                                    "    <a class=\"navbar-brand\" href=\"#\">"+navbar_title+"</a>\n" +
                                    "    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                                    "      <span class=\"navbar-toggler-icon\"></span>\n" +
                                    "    </button>\n" +
                                    "    <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\n" +
                                    "      <ul class=\"navbar-nav\">\n" +
                                    "        <li class=\"nav-item\">\n" +
                                    "          <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">"+it1+"</a>\n" +
                                    "        </li>\n" +
                                    "        <li class=\"nav-item\">\n" +
                                    "          <a class=\"nav-link\" href=\"#\">"+it2+"</a>\n" +
                                    "        </li>\n" +
                                    "        <li class=\"nav-item\">\n" +
                                    "          <a class=\"nav-link\" href=\"#\">"+it3+"/a>\n" +
                                    "        </li>\n" +
                                    "        <li class=\"nav-item dropdown\">\n" +
                                    "          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownMenuLink\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n" +
                                    "            Dropdown link\n" +
                                    "          </a>\n" +
                                    "          <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">"+stringBuilder+"</ul>\n" +
                                    "        </li>\n" +
                                    "      </ul>\n" +
                                    "    </div>\n" +
                                    "  </div>\n" +
                                    "</nav>");
                            dialog.dismiss();
                        nextActivity();

                    }
                });
            }
        });

        binding.nav6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                n_items.setVisibility(View.GONE);
                dd_items.setVisibility(View.GONE);
                img_url.setVisibility(View.GONE);
                n_title.setVisibility(View.VISIBLE);

                done_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String navbar_title=n_title.getText().toString();
                        if(!navbar_title.isEmpty()){
                            code.append("<nav class=\"navbar navbar-light bg-light\">\n" +
                                    "  <div class=\"container-fluid\">\n" +
                                    "    <a class=\"navbar-brand\">"+navbar_title+"</a>\n" +
                                    "    <form class=\"d-flex\">\n" +
                                    "      <input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n" +
                                    "      <button class=\"btn btn-outline-success\" type=\"submit\">Search</button>\n" +
                                    "    </form>\n" +
                                    "  </div>\n" +
                                    "</nav>");
                            dialog.dismiss();
                            nextActivity();
                        }
                    }
                });
            }
        });
    }
    private void nextActivity() {
        Intent intent=new Intent(NavigationBar.this,MainActivity.class);
        intent.putExtra("code", (CharSequence) code);
        startActivity(intent);
    }
}