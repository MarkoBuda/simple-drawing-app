package hr.ferit.markobudimir.simpledrawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    private var drawingView: DrawingView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView = findViewById(R.id.drawingView)
        drawingView?.setSizeForBrush(20.toFloat())

        val ibBrush: ImageButton = findViewById(R.id.ibBrush)
        ibBrush.setOnClickListener {
            showBrushSizeChooserDialog()
        }
    }

    private fun showBrushSizeChooserDialog(){
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush size: ")
        val smallBtn: ImageButton = brushDialog.findViewById(R.id.ibSmallBrush)
        smallBtn.setOnClickListener {
            drawingView?.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }

        val mediumBtn: ImageButton = brushDialog.findViewById(R.id.ibMediumBrush)
        mediumBtn.setOnClickListener {
            drawingView?.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }

        val largeBtn: ImageButton = brushDialog.findViewById(R.id.ibLargeBrush)
        largeBtn.setOnClickListener {
            drawingView?.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }

        brushDialog.show()
    }
}