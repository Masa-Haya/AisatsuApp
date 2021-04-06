package jp.techacademy.masayuki.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    Log.d("UI_PARTS", "$hour:$minute")

                    val time = "$hour:$minute"

                    if(time >= "2:00" && time <= "9:59" ){
                        textView.text = "おはよう"
                    }else if(time >= "10:00" && time <= "17:59" ){
                        textView.text = "こんにちは"
                    }else if(time >= "18:00" && time <= "1:59" ){
                        textView.text = "こんばんは"
                    }

                },
                13, 0, true)
        timePickerDialog.show()

    }
}