package com.movie.it

import android.content.Context
import android.content.Intent
import android.icu.util.ULocale.ROOT
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.http.Url
import java.util.Locale.ROOT

class FriendFragment : Fragment() {
    lateinit var freindRecyclerView: RecyclerView
    lateinit var graphRecyclerView: RecyclerView
    //lateinit var  ArrayList<mydata> mMyData
    val profileList = arrayListOf(
        FriendProfile(R.drawable.profile_img,"김민정","영혼의 단짝",10),
        FriendProfile(R.drawable.profile_img,"김민정","영혼의 단짝",20),
        FriendProfile(R.drawable.profile_img,"김민정","영혼의 단짝",30),
        FriendProfile(R.drawable.profile_img,"김민정","영혼의 단짝",40),
        FriendProfile(R.drawable.profile_img,"김민정","영혼의 단짝",50),
        FriendProfile(R.drawable.profile_img,"김민정","영혼의 단짝",60),
        FriendProfile(R.drawable.profile_img,"김민정","영혼의 단짝",70),
        FriendProfile(R.drawable.profile_img,"김민정","영혼의 단짝",80),
        FriendProfile(R.drawable.profile_img,"김민정","영혼의 단짝",90),
    )
    val graphLists = arrayListOf(
        Graphs("홍길동","솜사탕","빼빼로"),
        Graphs("홍길동","솜사탕","빼빼로"),
        Graphs("홍길동","솜사탕","빼빼로"),
        Graphs("홍길동","솜사탕","빼빼로"),
        Graphs("홍길동","솜사탕","빼빼로"),
        Graphs("홍길동","솜사탕","빼빼로"),
        Graphs("홍길동","솜사탕","빼빼로"),
        Graphs("홍길동","솜사탕","빼빼로"),
        Graphs("홍길동","솜사탕","빼빼로"),
        Graphs("홍길동","솜사탕","빼빼로"),
        Graphs("홍길동","솜사탕","빼빼로"),
        Graphs("홍길동","솜사탕","빼빼로"),
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val friendadapter = MyFriendAdapter(context, profileList)
        freindRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_friend)
        freindRecyclerView.adapter = friendadapter

        val graphadapter = MyGraphAdapter(context, graphLists)
        graphRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_friend_graph)
        graphRecyclerView.layoutManager =
            LinearLayoutManager(context).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        graphRecyclerView.adapter = graphadapter

//        view.findViewById<Button>(R.id.button).setOnClickListener {
//            val intent = Intent(getActivity(), BadgeActivity::class.java)
//            startActivity(intent)
//        }
    }


}

class Graphs(val one:String, val two:String, val three:String)

class MyFriendAdapter(context: Context?, val profilesList:ArrayList<FriendProfile>) : RecyclerView.Adapter<MyFriendAdapter.CustomViewViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_friend_item,parent, false)
        return CustomViewViewHolder(view)
    }
    override fun getItemCount(): Int {
        return profilesList.size
    }
    override fun onBindViewHolder(holder: CustomViewViewHolder, position: Int) {
        holder.name.text=profilesList.get(position).name
        holder.level.text=profilesList.get(position).level
        holder.img.setImageResource(profilesList.get(position).img)
        holder.prog.setProgress(profilesList.get(position).prog)

    }

    class CustomViewViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.friend_item_img)
        val prog = itemView.findViewById<ProgressBar>(R.id.friend_item_progress)
        val name = itemView.findViewById<TextView>(R.id.friend_item_name)
        val level = itemView.findViewById<TextView>(R.id.friend_item_level)
        val title = itemView.findViewById<TextView>(R.id.friend_graph_title)
    }
}
class MyGraphAdapter(context: Context?, val graphList:ArrayList<Graphs>) : RecyclerView.Adapter<MyGraphAdapter.CustomViewViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_friend_graph,parent, false)
        return CustomViewViewHolder(view)
    }
    override fun getItemCount(): Int {
        return graphList.size
    }
    override fun onBindViewHolder(holder: CustomViewViewHolder, position: Int) {
        holder.one.text=graphList.get(position).one
        holder.two.text=graphList.get(position).two
        holder.three.text=graphList.get(position).three
    }

    class CustomViewViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val one = itemView.findViewById<TextView>(R.id.friend_graph_one)
        val two = itemView.findViewById<TextView>(R.id.friend_graph_two)
        val three = itemView.findViewById<TextView>(R.id.friend_graph_three)
    }
}
//class ViewModel {
////    val data = MutableLiveData<List<DocumentSnapshot>>()
//    val data = MutableLiveData<List<Profiles>>()
//    fun showText(view: View) {
//        Toast.makeText(view.context, "${text.get()}", Toast.LENGTH_SHORT).show()
//    }
//}