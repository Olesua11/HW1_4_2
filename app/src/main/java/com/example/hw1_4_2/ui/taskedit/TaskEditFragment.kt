package com.example.hw1_4_2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.hw1_4_2.MainActivity
import com.example.hw1_4_2.R

class TaskEditFragment : Fragment() {

    private lateinit var editTextTask: EditText
    private lateinit var buttonDone: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task_edit, container, false)

        editTextTask = view.findViewById(R.id.editTextTask)
        buttonDone = view.findViewById(R.id.buttonDone)

        val task = arguments?.getString("task")
        editTextTask.setText(task)

        buttonDone.setOnClickListener {
            val position = arguments?.getInt("position", -1)
            if (position != -1) {
                (activity as MainActivity).updateTask(position!!, editTextTask.text.toString())
            }
            activity?.onBackPressed()
        }

        return view
    }

    companion object {
        fun newInstance(bundle: Bundle): TaskEditFragment {
            val fragment = TaskEditFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}
