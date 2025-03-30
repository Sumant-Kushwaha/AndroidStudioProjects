package com.amigo.recyclerview

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
        var todoList = mutableListOf(
            todo("Follow Android dev", false),
            todo("Will you marry me", false),
            todo("Want to learn android dev", false),
            todo("Want to learn android dev", false),
            todo("Want to learn android dev", false),
            todo("Want to learn android dev", false),
            todo("Want to learn android dev", false)
        )

        val adapter = todoAdapter(todoList)
        val rvtodos = findViewById<RecyclerView>(R.id.rvTodos)
        rvtodos.adapter = adapter
        rvtodos.layoutManager= LinearLayoutManager(this)

        findViewById<Button>(R.id.btnAddTodo).setOnClickListener {
            val title=findViewById<EditText>(R.id.etAddTodo).text.toString()
            val todo= todo(title,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}