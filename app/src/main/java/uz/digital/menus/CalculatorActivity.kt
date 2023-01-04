package uz.digital.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        supportActionBar?.title = "Calculator"

        one.click { addExpression("1", true) }
        two.click { addExpression("2", true) }
        three.click { addExpression("3", true) }
        four.click { addExpression("4", true) }
        five.click { addExpression("5", true) }
        six.click { addExpression("6", true) }
        seven.click { addExpression("7", true) }
        eight.click { addExpression("8", true) }
        nine.click { addExpression("9", true) }
        zero.click { addExpression("0", true) }


        dot.click { addExpression(".", false) }
        plus.click { addExpression("+", false) }
        minus.click { addExpression("-", false) }
        mul.click { addExpression("*", false) }
        div.click { addExpression("/", false) }
        open.click { addExpression("(", false) }
        close.click { addExpression(")", false) }

        clear.click {
            tvExpression.text = ""
            tvResult.text = ""
        }

        equal.click {
            try {
                val expression = ExpressionBuilder(tvExpression.text.toString().trim()).build()
                tvResult.text = expression.evaluate().toString()
            } catch (e: Exception) {
                Toast.makeText(this, e.message.toString(), Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
        back.click {
            val text = tvExpression.text.toString().trim()
            if (text.isNotBlank()) {
                tvExpression.text = text.substring(0, text.length - 1)
            }
        }
    }

    private fun addExpression(string: String, isBtn: Boolean) {
        if (tvResult.text.isNotEmpty()) {
            tvExpression.text = ""
        }
        if (isBtn) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }

    private fun MaterialButton.click(action: (View) -> Unit) {
        this.setOnClickListener {
            action(it)
        }
    }
}