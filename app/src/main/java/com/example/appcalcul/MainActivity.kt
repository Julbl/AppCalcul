package com.example.appcalcul

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var math_operation: TextView;
    private lateinit var result_text: TextView;
    private lateinit var btn_0: Button;
    private lateinit var btn_1: Button;
    private lateinit var btn_2: Button;
    private lateinit var btn_3: Button;
    private lateinit var btn_4: Button;
    private lateinit var btn_5: Button;
    private lateinit var btn_6: Button;
    private lateinit var btn_7: Button;
    private lateinit var btn_8: Button;
    private lateinit var btn_9: Button;
    private lateinit var minus_btn: Button;
    private lateinit var plus_btn: Button;
    private lateinit var mult_btn: Button;
    private lateinit var devide_btn: Button;
    private lateinit var bracket_open_btn: Button;
    private lateinit var bracket_close_btn: Button;
    private lateinit var clear_btn: Button;
    private lateinit var back_btn: Button;
    private lateinit var equal_btn: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        math_operation = findViewById(R.id.math_operation) as TextView
        result_text = findViewById(R.id.result_text) as TextView
        btn_0 = findViewById(R.id.btn_0) as Button
        btn_1 = findViewById(R.id.btn_1) as Button
        btn_2 = findViewById(R.id.btn_2) as Button
        btn_3 = findViewById(R.id.btn_3) as Button
        btn_4 = findViewById(R.id.btn_4) as Button
        btn_5 = findViewById(R.id.btn_5) as Button
        btn_6 = findViewById(R.id.btn_6) as Button
        btn_7 = findViewById(R.id.btn_7) as Button
        btn_8 = findViewById(R.id.btn_8) as Button
        btn_9 = findViewById(R.id.btn_9) as Button
        minus_btn = findViewById(R.id.minus_btn) as Button
        plus_btn = findViewById(R.id.plus_btn) as Button
        mult_btn = findViewById(R.id.mult_btn) as Button
        devide_btn = findViewById(R.id.devide_btn) as Button
        bracket_open_btn = findViewById(R.id.bracket_open_btn) as Button
        bracket_close_btn = findViewById(R.id.bracket_close_btn) as Button
        clear_btn = findViewById(R.id.clean_btn) as Button
        back_btn = findViewById(R.id.back_btn) as Button
        equal_btn = findViewById(R.id.equal_btn) as Button

        btn_0.setOnClickListener{setTextFields("0")}
        btn_1.setOnClickListener{setTextFields("1")}
        btn_2.setOnClickListener{setTextFields("2")}
        btn_3.setOnClickListener{setTextFields("3")}
        btn_4.setOnClickListener{setTextFields("4")}
        btn_5.setOnClickListener{setTextFields("5")}
        btn_6.setOnClickListener{setTextFields("6")}
        btn_7.setOnClickListener{setTextFields("7")}
        btn_8.setOnClickListener{setTextFields("8")}
        btn_9.setOnClickListener{setTextFields("9")}
        minus_btn.setOnClickListener{setTextFields("-")}
        plus_btn.setOnClickListener{setTextFields("+")}
        mult_btn.setOnClickListener{setTextFields("*")}
        devide_btn.setOnClickListener{setTextFields("/")}
        bracket_open_btn.setOnClickListener{setTextFields("(")}
        bracket_close_btn.setOnClickListener{setTextFields(")")}

        clear_btn.setOnClickListener{
            math_operation.text = ""
            result_text.text = ""
        }

        back_btn.setOnClickListener {
            val str = math_operation.text.toString()
            if(str.isNotEmpty())
                math_operation.text = str.substring(0,str.length - 1)
            result_text.text = ""
        }

        equal_btn.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()
        } catch(e:Exception) {
            Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }

    fun setTextFields(str: String) {
        if(result_text.text != ""){
            math_operation.text = result_text.text
            result_text.text = ""
        }

        math_operation.append(str)

    }
}
