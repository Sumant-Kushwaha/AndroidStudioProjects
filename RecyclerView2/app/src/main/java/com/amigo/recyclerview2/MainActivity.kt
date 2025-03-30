package com.amigo.recyclerview2

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
            Todo("Want to do Something",false),
            Todo("Have you learnt android development",false)
        )

        val adapter= TodoAdapter(todoList)
        val rvTodo=findViewById<RecyclerView>(R.id.rvTodo)
        rvTodo.adapter=adapter
        rvTodo.layoutManager= LinearLayoutManager(this)

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            val titile=findViewById<EditText>(R.id.etAddTodo).text.toString()
            val todo= Todo(titile,false)
            todoList.add(todo)

            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}