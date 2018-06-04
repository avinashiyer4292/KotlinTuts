package com.app.aviyer.firstkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val initialTextViewTranslationy = textViewProgress.translationY;

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                textViewProgress.text = progress.toString();

                val translationDistance = (initialTextViewTranslationy + progress *
                        resources.getDimension(R.dimen.animstep) * -1);

                textViewProgress.animate().translationY(translationDistance);
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

                Log.d("On start tracking","Start now!!!");
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

                Log.d("On stop tracking","Stop now!!!");
            }
        })
        reset_btn.setOnClickListener(View.OnClickListener {
            seekBar.progress=0
            textViewProgress.animate().setDuration(500).rotationBy(360f).translationY(initialTextViewTranslationy);
        })
    }
}
