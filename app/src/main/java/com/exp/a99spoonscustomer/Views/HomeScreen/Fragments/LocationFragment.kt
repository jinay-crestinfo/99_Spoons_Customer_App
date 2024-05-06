package com.exp.a99spoonscustomer.Views.HomeScreen.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.exp.a99spoonscustomer.databinding.FragmentLocationBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class LocationFragment : Fragment() {
    lateinit var binding: FragmentLocationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationBinding.inflate(layoutInflater)
        mapSetUp(savedInstanceState)
        return binding.root
    }

    private fun mapSetUp(savedInstanceState: Bundle?) {
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync {
            val markerPosition = LatLng(
                32.721423920190325,
                -117.16761493354197
            )
            val markerOptions = MarkerOptions()
                .position(markerPosition)
                .title("Marker Title")
                .snippet("Marker Snippet")
            it.addMarker(markerOptions)
            it.moveCamera(CameraUpdateFactory.newLatLngZoom(markerPosition, 15f))
        }
    }

}