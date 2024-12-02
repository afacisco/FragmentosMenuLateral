package com.juanfra.fragmentosmenulateral

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/*
Autor: Juan Francisco Sánchez González
Fecha: 30/11/2024
Clase: Clase (Lógica) del fragmento Settings
*/

class FragmentSettings : Fragment() {

    // Sobrescribimos onCreateView para inflar el layout del fragmento
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

}