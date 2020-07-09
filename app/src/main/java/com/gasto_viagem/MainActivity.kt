package com.gasto_viagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

// implements da interface View.OnClickListener
class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // id do elemento +  chamar setOnClickListener e passar a activity como parametro
        buttonCalculete.setOnClickListener(this)
    }

    // override de View.OnClickListener, método para gerenciar os eventos de click da activity
    override fun onClick(view: View) {
        val id = view.id

        if (id == R.id.buttonCalculete) {
            calculate()
        }
    }

    private fun calculate() {
        if (validation()) {
            try {
                // id + text + toString , sempre usar toString
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val total = (distance * price) / autonomy

                textTotal.text = "R$ ${"%.2f".format(total)}"
            }catch (nf : NumberFormatException){
                Toast.makeText(this,"Dados incorretos",Toast.LENGTH_LONG).show()
            }

        }else{
            Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_LONG).show()
        }
    }

    private fun validation(): Boolean {

        return (editDistance.text.toString() != "" && editDistance.text.toString() != "" && editDistance.text.toString() != "")
    }
}