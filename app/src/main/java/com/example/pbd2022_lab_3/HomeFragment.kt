package com.example.pbd2022_lab_3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
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
    private var poslji = "User not found"
    private var achievements: Array<Int> = arrayOf(0)
    private var recyclerView: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    interface MyFragmentListener {
        fun onMyVariableSet(myVariable: String)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = context as MyFragmentListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnDataPass")
        }
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
            poslji = don.username.plus(" ").plus(coins.toString()).plus(" 🪙")

        }

        listener?.onMyVariableSet(poslji)



        val kri = don?.bloodDon?.size
        val zob = don?.dentist?.size
        val svit = don?.svit?.size
        val doStopnje = 100 - coins % 100
        val bloodBtn = view.findViewById<TextView>(R.id.kdBtn)

        bloodBtn.setOnClickListener {
            val bloodFragment = BloodMainFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.activityMain, bloodFragment)
            transaction.commit()
        }
        val toothBtn = view.findViewById<TextView>(R.id.zobBtn)

//        toothBtn.setOnClickListener {
//            val toothFragment = ToothMainFragment()
//            val transaction = parentFragmentManager.beginTransaction()
//            transaction.replace(R.id.activityMain, toothFragment)
//            transaction.commit()
//        }
        val svitBtn = view.findViewById<TextView>(R.id.svitBtn)

        svitBtn.setOnClickListener {
            val svitFragment = SvitFragment()
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.activityMain, svitFragment)
            transaction.commit()
        }
        val doStopnjeText = view.findViewById<TextView>(R.id.textViewCoin)
        val kriCount = view.findViewById<TextView>(R.id.kdCounter)
        val zobCount = view.findViewById<TextView>(R.id.zobCounter)
        val svitCount = view.findViewById<TextView>(R.id.svitCounter)
        val progress = view.findViewById<ProgressBar>(R.id.progressBar)
        val prog = coins % 100
        if(prog < 30) {
            progress.progressTintList = ContextCompat.getColorStateList(view.context, R.color.red)
        }
        else if(prog < 60) {
            progress.progressTintList = ContextCompat.getColorStateList(view.context, R.color.blue)
        }
        else {
            progress.progressTintList = ContextCompat.getColorStateList(view.context, R.color.green)
        }

        progress.progress = prog
        doStopnjeText.text = doStopnje.toString()
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