package alcala.jose.asignacion4_calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val calculate : Button = findViewById(R.id.btnCalcular)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Evento button clic o clicklistener
        calculate.setOnClickListener{
            //Variables
            val weight : EditText = findViewById(R.id.etPeso)
            val height : EditText = findViewById(R.id.etEstatura)
            val label: TextView=findViewById(R.id.tvResultado)
            val range: TextView=findViewById(R.id.tvRange)
            val txtPeso=weight.text.toString()
            val peso=txtPeso.toDouble()
            val txtAltura=height.text.toString()
            val altura=txtAltura.toDouble()

            val imc = peso / (altura * altura)

            range.text = when {
                imc < 18.5 -> "Bajo peso"
                imc <= 24.9 -> "Normal"
                imc <= 29.9 -> "Sobrepeso"
                imc <= 34.9 -> "Obesidad grado 1"
                imc <= 39.9 -> "Obesidad grado 2"
                else -> "Obesidad grado 3"
            }

            val txtIMC=imc.toString()
            label.text=txtIMC
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}