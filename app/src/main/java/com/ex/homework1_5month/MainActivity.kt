package com.ex.homework1_5month

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ex.homework1_5month.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),CounterView {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        presenter.attachContract(this)
        binding.apply {
            btnPlus.setOnClickListener {
                presenter.onIncrement()
            }

            btnMinus.setOnClickListener {
                presenter.onDecrement()
            }
        }

    }

    override fun showResult(count: Int)= with(binding) {
        tvRes.text = count.toString()

    }

    override fun showMessage(message: String) {
        Toast.makeText(this, "Поздравляем", Toast.LENGTH_SHORT).show()
    }

    override fun changeColor(color: Int) {
        binding.tvRes.setTextColor(color)
    }

    override fun onDestroy() {
        presenter.detachContract()
        super.onDestroy()
    }


}