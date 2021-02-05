package com.movie.it

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.movie.it.databinding.FragmentFriendBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FriendFragment : Fragment() {
    private var _binding: FragmentFriendBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentFriendBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = requireContext()

        binding.apply {
            setHorizontalRecyclerViewConfig(binding.recyclerviewFriendGraph)
            val grapAdapter = MyGraphAdapter(context,graphLists)
            binding.recyclerviewFriendGraph.adapter = grapAdapter

            setVerticalRecyclerViewConfig(binding.recyclerviewFriend)
            val friendAdapter = MyFriendAdapter(context,profileList)
            binding.recyclerviewFriend.adapter = friendAdapter
        }
    }


    private fun setHorizontalRecyclerViewConfig(recyclerView: RecyclerView) {
        val context = requireContext()
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
    private fun setVerticalRecyclerViewConfig(recyclerView: RecyclerView) {
        val context = requireContext()
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

}

class Graphs(val one:String, val two:String, val three:String,var title:String="시청 시간이\n가장 많은 사람")

class MyFriendAdapter(context: Context?, val profilesList:ArrayList<FriendProfile>) : RecyclerView.Adapter<MyFriendAdapter.CustomViewViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_friend_item,parent, false)
        return CustomViewViewHolder(view)
    }
    override fun getItemCount(): Int {
        return profilesList.size
    }
    override fun onBindViewHolder(holder: CustomViewViewHolder, position: Int) {
        holder.name.text=profilesList.get(position).username
        holder.level.text=profilesList.get(position).level
        holder.img.setImageResource(profilesList.get(position).img)
        holder.prog.setProgress(profilesList.get(position).prog)
        holder.percent.text=profilesList.get(position).prog.toString()+"%"
    }

    class CustomViewViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.friend_item_img)
        val prog = itemView.findViewById<ProgressBar>(R.id.friend_item_progress)
        val name = itemView.findViewById<TextView>(R.id.friend_item_name)
        val level = itemView.findViewById<TextView>(R.id.friend_item_level)
        val percent = itemView.findViewById<TextView>(R.id.friend_item_percent)
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
        holder.title.text=graphList.get(position).title
    }

    class CustomViewViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.friend_graph_title)
        val one = itemView.findViewById<TextView>(R.id.friend_graph_one)
        val two = itemView.findViewById<TextView>(R.id.friend_graph_two)
        val three = itemView.findViewById<TextView>(R.id.friend_graph_three)
    }
}