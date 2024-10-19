package com.example.mobilki1;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity3 extends AppCompatActivity {
    private ImageView img;
    private Button startBtn;
    private Button pauseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        img = findViewById(R.id.img_blink);
        startBtn = findViewById(R.id.start_tween);
        pauseBtn = findViewById(R.id.pause_tween);

        // Анимация мигания для изображения
        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink_animation);

        // Анимации для кнопок
        Animation slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        Animation slideDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.startAnimation(blinkAnimation);  // Запуск анимации для изображения
                startBtn.startAnimation(slideUpAnimation);  // Анимация для кнопки
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.clearAnimation();  // Остановка анимации для изображения
                pauseBtn.startAnimation(slideDownAnimation);  // Анимация для кнопки
            }
        });
    }
}