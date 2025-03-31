  package com.amigo.recyclerviewandfragment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

  class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val todoList=mutableListOf(
            Todo("Registered?",false),
            Todo("Registration Fees Paid?",false),
            Todo("Form Filled?",false),
            Todo("Form Fees Paid?",false),
            Todo("Tution Fees Pais?",false)
        )

        val adapter= TodoAdapter(todoList)
        val rvTodos=findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos.adapter=adapter
        rvTodos.layoutManager= LinearLayoutManager(this)

        findViewById<Button>(R.id.btnADD).setOnClickListener {
            val title=findViewById<EditText>(R.id.etNewTodo).text.toString()
            val todo= Todo(title,false)
            todoList.add(todo)
            adapter.notifyItemInserted( todoList.size-1)
        }

        findViewById<Button>(R.id.btnFragmentActivity).setOnClickListener {
            Intent(this, FragmentActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}