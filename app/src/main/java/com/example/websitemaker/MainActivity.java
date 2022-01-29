package com.example.websitemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.websitemaker.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String code;
    List<View> text_list = new ArrayList<View>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        code=getIntent().getStringExtra("code");

        binding.nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FooterActivity.class);
                intent.putExtra("code",code);
                startActivity(intent);
            }
        });

        binding.vertical.setOnLongClickListener(longClickListener);
        binding.horizontal.setOnLongClickListener(longClickListener);
        binding.buttons.setOnLongClickListener(longClickListener);
        binding.cards.setOnLongClickListener(longClickListener);
        binding.txtArea.setOnLongClickListener(longClickListener);

        binding.webLayout.setOnDragListener(dragListener);

        binding.webLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=1;i<=text_list.size();i++) {
                    if (view.getId() == i){
                        Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    View.OnLongClickListener longClickListener=new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data=ClipData.newPlainText("","");
            View.DragShadowBuilder shadowBuilder=new View.DragShadowBuilder(view);
            view.startDrag(data,shadowBuilder,view,0);
            return true;
        }
    };

    View.OnDragListener dragListener=new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            int event = dragEvent.getAction();

            switch (event){
                case DragEvent.ACTION_DROP:
                    final View view1=(View) dragEvent.getLocalState();
                    if(view1.getId()==R.id.txt_area){
                        EditText textView=new EditText(MainActivity.this);
                        textView.setLayoutParams(new ViewGroup.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        textView.setX(dragEvent.getX());
                        textView.setY(dragEvent.getY());
                        binding.webLayout.addView(textView);
                        textView.setText("text - area"+(text_list.size()+1));
                        text_list.add(textView);
                        textView.setId(text_list.size());
                    }
                    else if(view1.getId()==R.id.buttons){

                    }
            }
            return true;
        }
    };
}