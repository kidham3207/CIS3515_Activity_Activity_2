package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value

    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    private val textSizeResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result -> if(result.resultCode == RESULT_OK){
            val secletedSize = result.data?.getIntExtra("textSize",16)
        lyricsDisplayTextView.textSize = secletedSize?.toFloat() ?: 16f
        lyricsDisplayTextView.text = getString(R.string.lyrics)

        if(secletedSize != null){
            lyricsDisplayTextView.textSize = secletedSize.toFloat()
        }
        else{
            lyricsDisplayTextView.textSize = 16f
        }
    }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        textSizeSelectorButton.setOnClickListener {
            val intent = Intent(this, TextSizeActivity ::class.java)
            textSizeResultLauncher.launch(intent)
        }


    }
}