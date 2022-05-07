package com.example.assessmentapplication.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assessmentapplication.databinding.FragmentFirstBinding
import com.example.assessmentapplication.util.Contact
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = initJsonReader()?.let {
            ContactsAdapter(it)
        }
        binding.rvContacts.adapter = adapter
        binding.rvContacts.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun initJsonReader(): List<Contact>? {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val type = Types.newParameterizedType(List::class.java, Contact::class.java)
        val jsonAdapter: JsonAdapter<List<Contact>> = moshi.adapter(type)
        val myjson =
            context?.assets?.open("data.json")?.bufferedReader().use { it?.readText() ?: "" }
        return jsonAdapter.fromJson(myjson)
    }

}