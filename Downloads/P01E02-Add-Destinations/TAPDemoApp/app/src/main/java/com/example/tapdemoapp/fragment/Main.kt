package com.example.tapdemoapp.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tapdemoapp.R


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Main.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Main.newInstance] factory method to
 * create an instance of this fragment.
 */
class Main : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main,container,false)
    }

}
