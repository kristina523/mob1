package com.example.mobilki1;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.animation.ObjectAnimator;
import android.animation.AnimatorSet;


public class MainActivity2 extends AppCompatActivity {
    private ImageView animationIV;
    private Button startBtn;
    private Button pauseBtn;
    private AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        animationIV = findViewById(R.id.animImageView);
        startBtn = findViewById(R.id.startButton);
        pauseBtn = findViewById(R.id.pauseButton);

        frameAnimation = (AnimationDrawable) animationIV.getDrawable();

        startBtn.setOnClickListener(v -> {
            animateButton(startBtn);  // Добавляем анимацию нажатия на кнопку
            if (!frameAnimation.isRunning()) {
                frameAnimation.start();
            }
        });

        pauseBtn.setOnClickListener(v -> {
            animateButton(pauseBtn);  // Добавляем анимацию нажатия на кнопку
            if (frameAnimation.isRunning()) {
                frameAnimation.stop();
            }
        });
    }

    // Анимация для кнопок
    private void animateButton(Button button) {
        // Анимация вращения на 360 градусов
        ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(button, "rotation", 0f, 360f);
        rotateAnim.setDuration(500);  // Длительность анимации 500 мс

        // Анимация прозрачности от 0.5 до 1 (изменение видимости)
        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(button, "alpha", 0.5f, 1f);
        alphaAnim.setDuration(500);  // Та же длительность

        // Объединяем обе анимации
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rotateAnim, alphaAnim);  // Выполняем одновременно
        animatorSet.start();
    }
}