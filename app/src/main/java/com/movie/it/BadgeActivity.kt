package com.movie.it

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.internal.UnsafeAllocator.create
import java.net.URI.create

class BadgeActivity : AppCompatActivity() {
//    var adapter: BadgeAdapter? = null
//    var badgeList = ArrayList<Badge>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_badge)

        // load foods
//        badgeList.add(Badge(R.drawable.ic_baseline_search_24))
//        badgeList.add(Badge(R.drawable.ic_baseline_search_24))
//        badgeList.add(Badge(R.drawable.ic_baseline_search_24))
//        badgeList.add(Badge(R.drawable.ic_baseline_search_24))
//        badgeList.add(Badge(R.drawable.ic_baseline_search_24))
//        badgeList.add(Badge(R.drawable.ic_baseline_search_24))
//        badgeList.add(Badge(R.drawable.ic_baseline_search_24))
//        adapter = BadgeAdapter(this, badgeList)
//        findViewById<GridView>(R.id.badge_gridview).adapter = adapter
    }


}
//data class Badge(var img:Int)
//class BadgeAdapter : BaseAdapter {
//    var foodsList = ArrayList<Badge>()
//    var context: Context? = null
//
//    constructor(context: Context, foodsList: ArrayList<Badge>) : super() {
//        this.context = context
//        this.foodsList = foodsList
//    }
//
//    override fun getCount(): Int {
//        return foodsList.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return foodsList[position]
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        val food = this.foodsList[position]
//
//        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        var foodView = inflator.inflate(R.layout.badge_item, null)
//        foodView.findViewById<ImageView>(R.id.badgeImg).setImageResource(food.img!!)
//        //foodView.badgeImg.setImageResource(food.img!!)
//
//        return foodView
//    }
//}