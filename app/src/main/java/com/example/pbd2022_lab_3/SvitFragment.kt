package com.example.pbd2022_lab_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SvitFragment : Fragment() {


    private var recyclerView: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: CheckRecyclerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_svit, container, false)

        recyclerView = view.findViewById(R.id.recycler_view_svit)
        layoutManager = LinearLayoutManager(view.context)
        recyclerView?.layoutManager = layoutManager
        adapter = CheckRecyclerAdapter(view.context)
        recyclerView?.adapter = adapter

        val donateButton = view.findViewById<Button>(R.id.donate_button)

        donateButton.setOnClickListener{
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.activityMain, NewSvitVisitFragment())?.addToBackStack(null)?.commit()
        }

        return view
    }

}