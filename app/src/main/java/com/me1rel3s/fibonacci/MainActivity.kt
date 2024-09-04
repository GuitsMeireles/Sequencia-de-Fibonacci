package com.me1rel3s.fibonacci

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.me1rel3s.fibonacci.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Configurando a ação do botão "Verificar Fibonacci"
        binding.btCalculate.setOnClickListener {
            val input = binding.tietFibonacci.text.toString()
            if (input.isNotEmpty()) {
                val number = input.toInt()
                val result = isFibonacciNumber(number)
                binding.tvResult.text = result
            } else {
                binding.tvResult.text = "Por favor, insira um número."
            }
        }
    }

    // Função para gerar a sequência de Fibonacci até o limite
    private fun fibonacciSequence(limit: Int): List<Int> {
        val fibSeq = mutableListOf(0, 1)
        while (fibSeq.last() < limit) {
            val nextFib = fibSeq[fibSeq.size - 1] + fibSeq[fibSeq.size - 2]
            fibSeq.add(nextFib)
        }
        return fibSeq
    }

    // Função para verificar se um número pertence à sequência de Fibonacci
    private fun isFibonacciNumber(number: Int): String {
        val fibSeq = fibonacciSequence(number)
        return if (number in fibSeq) {
            "O número $number pertence à sequência de Fibonacci."
        } else {
            "O número $number NÃO pertence à sequência de Fibonacci."
        }
    }
}