package com.example.websitemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.websitemaker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        code=getIntent().getStringExtra("code");

        binding.vertical.setOnLongClickListener(longClickListener);

        binding.webLayout.setOnDragListener(dragListener);

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
                case DragEvent.ACTION_DRAG_ENTERED:
                    final View view1=(View) dragEvent.getLocalState();
                    if(view1.getId()==R.id.vertical){
                        Toast.makeText(MainActivity.this, "Drag Success", Toast.LENGTH_SHORT).show();
                    }
                    break;
                    case DragEvent.ACTION_DRAG_EXITED:
                    break;
                    case DragEvent.ACTION_DROP:
                        break;
            }
            return false;
        }
    };
}