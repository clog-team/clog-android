package com.movie.it.my

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.movie.it.BadgeActivity
import com.movie.it.R
import com.movie.it.databinding.FragmentMyBinding
import com.movie.it.record.RecordActivity
import com.movie.it.wishlist.WishListActivity

class MyFragment : Fragment() {

    private var _binding: FragmentMyBinding? = null
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.apply {
            wishlistBtn.setOnClickListener {
                startActivity(Intent(context, WishListActivity::class.java))
            }
            recordlistBtn.setOnClickListener {
                startActivity(Intent(context, RecordActivity::class.java))
            }
            bedgelistBtn.setOnClickListener {
                startActivity(Intent(context, BadgeActivity::class.java))
            }

            settingPiechart(genrePieView, makeGenreData())
            settingPiechart(ratingPieView, makeRatingData())

        }

    }

    fun settingPiechart(pieChart: PieChart, yValues: ArrayList<PieEntry>) {

        pieChart.apply {
            setNoDataText("")
            description = null
            setTouchEnabled(false)
            setDrawSlicesUnderHole(false)
            holeRadius = 0f
            legend.isEnabled = false
            isDrawHoleEnabled = false
            setEntryLabelColor(Color.WHITE)
        }

        val context = requireContext()
        val colors = arrayOf(
            ContextCompat.getColor(context, R.color.b1),
            ContextCompat.getColor(context, R.color.b2),
            ContextCompat.getColor(context, R.color.b3),
            ContextCompat.getColor(context, R.color.b4),
            ContextCompat.getColor(context, R.color.b5)
        )
        pieChart.clear()
        val pieDataSet = PieDataSet(yValues, null)
        pieDataSet.colors = colors.asList()
        pieDataSet.setDrawValues(false)
        val pieData = PieData(pieDataSet)
        pieChart.data = pieData

//
//        pieChart.setUsePercentValues(false)
//        pieChart.legend.isEnabled = false
//        pieChart.setUsePercentValues(false)
//        pieChart.description = null
//        pieChart.setDrawHoleEnabled(false)
//        pieChart.setDragDecelerationFrictionCoef(0f);
//        pieChart.setHoleColor(Color.WHITE);
//        pieChart.setTransparentCircleRadius(0f);
//
//
//        val dataSet = PieDataSet(yValues,"");
//        dataSet.setSliceSpace(0f);
//        dataSet.setSelectionShift(0f);
//        val colors = arrayOf(11198968,7522541,3911136,35024,17269)
//        dataSet.setColors(colors.asList())
//
//        val data =  PieData((dataSet));
//        data.setValueTextSize(0f);
//        pieChart.setData(data);
    }


    private fun makeGenreData(): ArrayList<PieEntry> {
        val yValues = ArrayList<PieEntry>()
        yValues.add(PieEntry(34f, "코미디"))
        yValues.add(PieEntry(23f, "액션"))
        yValues.add(PieEntry(14f, "드라마"))
        yValues.add(PieEntry(35f, "호러"))
        yValues.add(PieEntry(40f, "애니매이션"))
        return yValues
    }

    private fun makeRatingData(): ArrayList<PieEntry> {
        val yValues = ArrayList<PieEntry>()
        yValues.add(PieEntry(34f, "5"))
        yValues.add(PieEntry(23f, "4.5"))
        yValues.add(PieEntry(35f, "3.5"))
        yValues.add(PieEntry(40f, "2"))
        yValues.add(PieEntry(10f, "1.5"))
        return yValues
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}