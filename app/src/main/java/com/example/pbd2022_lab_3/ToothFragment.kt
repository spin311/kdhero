package com.example.pbd2022_lab_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ToothFragment : Fragment() {


    private var recyclerView: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: ToothRecyclerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tooth, container, false)

        recyclerView = view.findViewById(R.id.recycler_view_tooth)
        layoutManager = LinearLayoutManager(view.context)
        recyclerView?.layoutManager = layoutManager
        adapter = ToothRecyclerAdapter(view.context)
        recyclerView?.adapter = adapter

        val donateButton = view.findViewById<Button>(R.id.donate_button)

        donateButton.setOnClickListener{
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.activityMain, NewToothVisitFragment())?.addToBackStack(null)?.commit()
        }

        return view
    }

}