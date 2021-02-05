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
        FriendProfile(R.drawable.profile_img_1,"김민정","밥은 먹고 다니냐",30),
        FriendProfile(R.drawable.profile_img_3,"박영민","누구냐 넌?!",12),
        FriendProfile(R.drawable.profile_img_1,"신윤섭","헤이 브라더!",58),
        FriendProfile(R.drawable.profile_img_4,"이주영","그대 눈동자에 건배",64),
        FriendProfile(R.drawable.profile_img_2,"김채린","내안에 너있다",91),
        FriendProfile(R.drawable.profile_img_3,"이채정","헤이 브라더!",56),
        FriendProfile(R.drawable.profile_img_2,"김유정","그대 눈동자에 건배",73),
        FriendProfile(R.drawable.profile_img_1,"김민채","누구냐 넌?!",28),
        FriendProfile(R.drawable.profile_img_4,"김유진","밥은 먹고 다니냐",46),
    )
    val graphLists = arrayListOf(
        Graphs("김민정","이주영","김유정"),
        Graphs("박영민","김채린","신윤섭","시청 시간이\n가장 적은 사람"),
        Graphs("이채정","신윤섭","이민영","가장 별점을\n짜게 준 사람"),
        Graphs("김채린","김유정","이주영","내 별점을\n가장 많이 맞춘 사람")
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