package com.example.guess_the_music.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.guess_the_music.R

import kotlinx.android.synthetic.main.fragment_game2.*
import kotlinx.android.synthetic.main.fragment_game2.ansText
import kotlinx.android.synthetic.main.fragment_game2.btn_home
import kotlinx.android.synthetic.main.fragment_game2.btn_play
import kotlinx.android.synthetic.main.fragment_game2.btn_sub
import kotlinx.android.synthetic.main.fragment_game2.countdown
import kotlinx.android.synthetic.main.fragment_game2.singerHint
import kotlinx.android.synthetic.main.fragment_game2.titleHint
import kotlinx.android.synthetic.main.fragment_game3.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Game2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Game2Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        btn_home.setOnClickListener{
            navController.navigate(R.id.action_game2Fragment_to_mainFragment)
        }
        btn_play.setOnClickListener {
            btn_play.visibility=View.INVISIBLE
            ansText.visibility=View.VISIBLE
            countdown.visibility=View.VISIBLE
            singerHint.visibility=View.VISIBLE
            titleHint.visibility=View.VISIBLE
            btn_sub.visibility=View.VISIBLE
        }
        btn_sub.setOnClickListener {
            saveAns()
        }
    }
    fun saveAns(){
        val ans=ansText.text.toString()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Game2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Game2Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}