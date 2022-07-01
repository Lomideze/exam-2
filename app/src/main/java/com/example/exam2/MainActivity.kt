package com.example.exam2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exam2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            val anagram = binding.AnagramInput.text.toString()

            if (anagram.isNotEmpty()) {
                list.add(anagram)
                binding.AnagramInput.setText("")
            }

        }

        binding.outputBtn.setOnClickListener {
            groupAnagrams(strs = list)
            binding.anagramCount.text = groupAnagrams(strs = list).size.toString()
        }

    }
    private fun groupAnagrams(strs: MutableList<String>): List<List<String>> {
        val resultingMap = mutableMapOf<Map<Char, Int>, List<String>>()

        strs.forEach { str ->
            val key = mutableMapOf<Char, Int>()

            str.forEach {
                key[it] = (key[it] ?: 0) +1
            }

            resultingMap[key] = (resultingMap[key] ?: listOf<String>()) + str
        }
        return resultingMap.values.toList()
    }
}