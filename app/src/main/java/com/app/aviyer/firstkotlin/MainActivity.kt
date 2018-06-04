package com.app.aviyer.firstkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val initialTextViewTranslationy = textViewProgress;

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                textViewProgress.text = progress.toString();

                val translationDistance = (initialTextViewTranslationy + progress *
                        resources.getDimension(R.dimen.animstep) * -1);

                textViewProgress.animate().translationY(translationDistance);
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}
