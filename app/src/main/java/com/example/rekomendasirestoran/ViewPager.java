package com.example.rekomendasirestoran;
//10120805
//Muhammad Afwa F Muaja
//IF-2

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewPager extends AppCompatActivity {

    Button BtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_layout);
        Button btnnext = findViewById(R.id.btnnext);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewPager.this, MainActivity.class));
                finish();
            }
        });

        setupViewPager();
    }

    private void setupViewPager() {
        Adapter adapter = new Adapter(this);
        View ViewPager = findViewById(R.id.viewpager);

    }

    private class Adapter extends PagerAdapter{
        Context context;
        LayoutInflater inflater;

        public Adapter(Context context) {
            this.context = context;
        }

        //list img
        int[] list_img = {
            R.drawable.blue,
            R.drawable.elmo,
            R.drawable.kaws,

        };

        //list judul
        int[] list_judul = {
                R.string.judul_1,
                R.string.judul_2,
                R.string.judul_3,
        };

        //list deskripsi
        int[] list_deskripsi = {
                R.string.desk_1,
                R.string.desk_2,
                R.string.desk_3,
        };

        //list color bg
        int[] list_bg = {
                getResources().getColor(R.color.biru),
                getResources().getColor(R.color.hitam),
                getResources().getColor(R.color.pink),
        };

        @Override
        public int getCount() {
            return list_judul.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return (view == object);
        }


        @Override
        public Object instantiateItem(@NonNull View container, int position) {
            inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.item_layout, (ViewGroup) container,false);
            LinearLayout linearLayout = view.findViewById(R.id.item_layout);
            ImageView imageview = findViewById(R.id.img);
            TextView judul = findViewById(R.id.judul);
            TextView desk = findViewById(R.id.deskripsi);

            linearLayout.setBackgroundColor(list_bg[position]);
            imageview.setImageResource(list_img[position]);
            judul.setText(list_judul[position]);
            desk.setText(list_deskripsi[position]);
            ((ViewGroup) container).addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((LinearLayout)object);
        }
    }
}