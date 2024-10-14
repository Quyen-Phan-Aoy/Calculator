package project1.com.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var currentNumber = ""
    private var operator = ""
    private var firstNumber = ""
    private var secondNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.display)

        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)

        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnSub: Button = findViewById(R.id.btnSub)
        val btnMul: Button = findViewById(R.id.btnMul)
        val btnDiv: Button = findViewById(R.id.btnDiv)
        val btnEqual: Button = findViewById(R.id.btnEqual)

        val btnC: Button = findViewById(R.id.btnC)
        val btnCE: Button = findViewById(R.id.btnCE)
        val btnDot: Button = findViewById(R.id.btnDot)

        // Số và dấu chấm
        btn0.setOnClickListener { appendToDisplay("0") }
        btn1.setOnClickListener { appendToDisplay("1") }
        btn2.setOnClickListener { appendToDisplay("2") }
        btn3.setOnClickListener { appendToDisplay("3") }
        btn4.setOnClickListener { appendToDisplay("4") }
        btn5.setOnClickListener { appendToDisplay("5") }
        btn6.setOnClickListener { appendToDisplay("6") }
        btn7.setOnClickListener { appendToDisplay("7") }
        btn8.setOnClickListener { appendToDisplay("8") }
        btn9.setOnClickListener { appendToDisplay("9") }
        btnDot.setOnClickListener { appendToDisplay(".") }

        // Phép tính
        btnAdd.setOnClickListener { setOperator("+") }
        btnSub.setOnClickListener { setOperator("-") }
        btnMul.setOnClickListener { setOperator("*") }
        btnDiv.setOnClickListener { setOperator("/") }

        // Các nút chức năng
        btnEqual.setOnClickListener { calculate() }
        btnC.setOnClickListener { clearEntry() }
        btnCE.setOnClickListener { clearAll() }
    }

    private fun appendToDisplay(value: String) {
        currentNumber += value
        display.text = currentNumber
    }

    private fun setOperator(op: String) {
        if (currentNumber.isNotEmpty()) {
            firstNumber = currentNumber
            operator = op
            currentNumber = ""
        }
    }

    private fun calculate() {
        if (operator.isNotEmpty() && currentNumber.isNotEmpty()) {
            secondNumber = currentNumber
            val result = when (operator) {
                "+" -> firstNumber.toDouble() + secondNumber.toDouble()
                "-" -> firstNumber.toDouble() - secondNumber.toDouble()
                "*" -> firstNumber.toDouble() * secondNumber.toDouble()
                "/" -> {
                    if (secondNumber != "0") {
                        firstNumber.toDouble() / secondNumber.toDouble()
                    } else {
                        display.text = "Error"
                        return
                    }
                }
                else -> 0.0
            }
            display.text = result.toString()
            currentNumber = result.toString()
            operator = ""
        }
    }

    private fun clearEntry() {
        currentNumber = ""
        display.text = "0"
    }

    private fun clearAll() {
        currentNumber = ""
        firstNumber = ""
        secondNumber = ""
        operator = ""
        display.text = "0"
    }
}
