package com.amigo.practice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val todoList=mutableListOf(
            Todo("Will you marry me omi ji",false),
            Todo("Can we go on a date",false),
            Todo("Momos khayega",false),
            Todo("Pahado me chlege",false),
            Todo("Ice cream khayega",false)
        )

        val adapter= TodoAdapter(todoList)
        val rvTodos=findViewById<RecyclerView>(R.id.rvTodos)
        rvTodos.adapter=adapter
        rvTodos.layoutManager= LinearLayoutManager(this)

        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            val title=findViewById<EditText>(R.id.etNewTodo).text.toString()
            val todo=Todo(title,false)
            todoList.add(todo)

            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}