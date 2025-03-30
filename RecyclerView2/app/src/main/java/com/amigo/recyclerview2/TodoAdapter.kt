package com.amigo.recyclerview2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    val todos: List<Todo>
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodoViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.todo_layout,parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: TodoViewHolder,
        position: Int
    ) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.tvTitle).text=todos[position].title
            findViewById<CheckBox>(R.id.cbChecked).isChecked=todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    inner class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}