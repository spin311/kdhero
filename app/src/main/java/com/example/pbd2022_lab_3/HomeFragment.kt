package com.example.pbd2022_lab_3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var listener: MyFragmentListener? = null
    private var coins: Int = 0
    private var achievements: Array<Int> = arrayOf(0)
    private var recyclerView: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    interface MyFragmentListener {
        fun onMyVariableSet(myVariable: Int)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        val sharedPref = view?.context?.getSharedPreferences("userId", Context.MODE_PRIVATE)
        val user = sharedPref?.getString("userId", "0")
        val don = when(user) {
            "1" -> DataFile.user1
            "2" -> DataFile.user2
            "3" -> DataFile.user3
            else -> null
        }
        if(don != null) {
            coins = don.noOfCoins
            achievements= don.achievements
        }
        listener?.onMyVariableSet(coins)



        val kri = don?.bloodDon?.size
        val zob = don?.dentist?.size
        val svit = don?.svit?.size

        val kriCount = view.findViewById<TextView>(R.id.kdCounter)
        val zobCount = view.findViewById<TextView>(R.id.zobCounter)
        val svitCount = view.findViewById<TextView>(R.id.svitCounter)

        kriCount.text = kri.toString().plus(" X")
        zobCount.text = zob.toString().plus(" X")
        svitCount.text = svit.toString().plus(" X")

        recyclerView = view.findViewById(R.id.achievementsRecyclerView)
        layoutManager = LinearLayoutManager(view.context)
        recyclerView?.layoutManager = layoutManager
        adapter = RecyclerAdapter(achievements)
        recyclerView?.adapter = adapter
        return view
    }

}