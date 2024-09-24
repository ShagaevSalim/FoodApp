package com.example.foodappbymyself

import android.content.Intent
import android.health.connect.datatypes.ExerciseRoute.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.example.foodappbymyself.databinding.ActivityLocationBinding

class LocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countryList = arrayOf("Russia", "Brazil", "Scotland", "Turkey", "USA", "Japan")
        val adapter = ArrayAdapter(this@LocationActivity, android.R.layout.simple_list_item_1, countryList)

        binding.locationList.setAdapter(adapter)

        binding.locationList.setOnItemClickListener { parent, view, position, l ->
            val selectedLocation = parent.getItemAtPosition(position) as String
            showDialogAtPosition(selectedLocation)
        }


    }
    fun showDialogAtPosition(location : String){
        val dialogView = layoutInflater.inflate(R.layout.alert_dialog, null)

        val dialogBuilder = AlertDialog.Builder(this@LocationActivity)
        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()
        dialogView.findViewById<AppCompatButton>(R.id.btn_yes).setOnClickListener {

            startActivityWithLocation(location)
            dialog.dismiss()

        }

        dialogView.findViewById<AppCompatButton>(R.id.btn_cancel).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun startActivityWithLocation(location: Any) {
        val intent = Intent(this@LocationActivity, MainActivity :: class.java)
        startActivity(intent)
    }

}