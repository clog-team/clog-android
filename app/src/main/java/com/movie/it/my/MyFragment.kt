package com.movie.it.my

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.movie.it.R
import com.movie.it.databinding.FragmentMyBinding
import com.movie.it.record.RecordActivity
import com.movie.it.wishlist.WishListActivity

class MyFragment : Fragment() {

    private var _binding: FragmentMyBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    //      val pieView = (PieView)findViewById(R.id.pie_view);
//        ArrayList<PieHelper> pieHelperArrayList = new ArrayList<PieHelper>();
//        pieView.setDate(pieHelperArrayList);
//        pieView.selectedPie(2); //optional
//        pieView.setOnPieClickListener(listener) //optional
//        pieView.showPercentLabel(false); //optional

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.apply {
            wishlistBtn.setOnClickListener {
                startActivity(Intent(context, WishListActivity::class.java))
            }
            recordlistBtn.setOnClickListener {
                startActivity(Intent(context, RecordActivity::class.java))
            }
            bedgelistBtn.setOnClickListener {
//                startActivity(Intent(context, BadgeAcitivity::class.java))
            }
        }
//        genre_pie_view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}