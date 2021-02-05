package com.movie.it.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.movie.it.R

class MyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


         val pieView = (PieView)findViewById(R.id.pie_view);
        ArrayList<PieHelper> pieHelperArrayList = new ArrayList<PieHelper>();
        pieView.setDate(pieHelperArrayList);
        pieView.selectedPie(2); //optional
        pieView.setOnPieClickListener(listener) //optional
        pieView.showPercentLabel(false); //optional


        return inflater.inflate(R.layout.fragment_my, container, false)
    }

}