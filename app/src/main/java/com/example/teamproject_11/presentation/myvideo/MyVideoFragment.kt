package com.example.teamproject_11.presentation.myvideo

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.teamproject_11.databinding.FragmentMyVideoBinding
import com.example.teamproject_11.presentation.home.main.HomeViewModel
import com.example.teamproject_11.presentation.home.model.HomeVideoModel
import com.example.teamproject_11.presentation.main.MainActivity
import com.google.android.material.snackbar.Snackbar


val deleteList = mutableListOf<HomeVideoModel>()
var fragmentMode : Int = 0
class MyVideoFragment : Fragment() {
    private val binding by lazy { FragmentMyVideoBinding.inflate(layoutInflater) }
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    //데이터가 갱신될 수 있도록 onResume()을 오버라이딩 해서 해당 리스트 갱신 메소드를 넣었습니다.
    override fun onResume() {
        super.onResume()
        viewModel.getMyVideoList(requireActivity())
        setBtnDelete()
    }

    private fun initView() {
        viewModel.getMyVideoList(requireActivity())
        viewModel.myVideoList.observe(viewLifecycleOwner){
            binding.myvideoRecyclerview.adapter = MyVideoAdapter(it, object : OnItemClick{
                override fun onItemClick(item: HomeVideoModel) {
                    (requireActivity() as MainActivity).openVideoDetailFromHome(item)
                }

                override fun onItemClickToDelete(item: HomeVideoModel) {
                    deleteList.add(item)
                }
            })
        }
        binding.myvideoRecyclerview.layoutManager = GridLayoutManager(this.context, 3)


        binding.btnDelete.setOnClickListener {
            val alert = AlertDialog.Builder(this@MyVideoFragment.context)
            val size = deleteList.size
            alert
                .setTitle("삭제")
                .setMessage("${size}개의 동영상을 리스트에서 삭제하시겠습니까?")
                .setPositiveButton("YES"
                ) { dialog, which -> deleteList.forEach{item ->
                    viewModel.deleteMyVideoItem(requireActivity(), item)
                }
                                    fragmentMode = 0
                                    viewModel.myvideoModeObserve()
                                    deleteList.clear()
                                    binding.btnDelete.visibility = View.GONE
                                    }
                .setNegativeButton("NO"){dialog, which ->}.create().show()
        }
    }
    private fun setBtnDelete(){
        viewModel.myVideoFragmentMode.observe(viewLifecycleOwner){
            if(it == 0){
                binding.btnDelete.visibility = View.GONE
            }
            else
                binding.btnDelete.visibility = View.VISIBLE
        }
    }
}

