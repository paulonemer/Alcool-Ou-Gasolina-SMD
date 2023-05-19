package com.example.alcoolougasolina

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("DataShare", Context.MODE_PRIVATE)

        val mySwitch = findViewById<Switch>(R.id.swPercentual)
        val valorSwitch = sharedPreferences.getBoolean("switch", false)
        mySwitch.isChecked = valorSwitch


        mySwitch.setOnClickListener(View.OnClickListener {

            val editor = sharedPreferences.edit()
            editor.putBoolean("switch", mySwitch.isChecked)
            editor.apply()
        })

        Log.d("PDM23","No onCreate, $percentual")




        fun compara(){

            val mySwitch = findViewById<Switch>(R.id.swPercentual)

            mySwitch.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    percentual=0.75
                } else {
                    percentual=0.70
                }
            }

            val valoralcoolet = findViewById<EditText>(R.id.edAlcool)
            val valoralcool = valoralcoolet.text.toString().toDoubleOrNull()

            val valorgasolinaet = findViewById<EditText>(R.id.edGasolina)
            val valorgasolina = valorgasolinaet.text.toString().toDoubleOrNull()

            if (valoralcool != null && valorgasolina != null) {
                if (valoralcool <= valorgasolina * percentual) {
                    Toast.makeText(this, "Álcool vale a pena", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Gasolina vale a pena", Toast.LENGTH_SHORT).show()
                }
            }
        }
        val btCalc: Button = findViewById(R.id.btCalcular)
        btCalc.setOnClickListener(View.OnClickListener {
            compara()
            Log.d("PDM23","No btCalcular, $percentual")
        })




    }
override fun onResume(){
    super.onResume()
    Log.d("PDM23","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.d("PDM23","No onStart")
}
override fun onPause(){
    super.onPause()
    Log.d("PDM23","No onPause")
}
override fun onStop(){
    super.onStop()
    Log.d("PDM23","No onStop")
}
override fun onDestroy(){
    super.onDestroy()
    Log.d("PDM23","onDestroy")
}



}