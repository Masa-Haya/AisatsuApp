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

                    if(time.compareTo("2:0") >= 0 && time.compareTo("9:59") <= 0 ){
                        textView.text = "おはよう"
                    }else if(time.compareTo("10:0") >= 0 && time.compareTo("17:59") <= 0 ){
                        textView.text = "こんにちは"
                    }else if(time.compareTo("18:0") >= 0 || time.compareTo("1:59") <= 0 ){
                        textView.text = "こんばんは"
                    }

                },
                13, 0, true)
        timePickerDialog.show()

    }
}