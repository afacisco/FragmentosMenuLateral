package com.juanfra.fragmentosmenulateral

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

/*
Autor: Juan Francisco Sánchez González
Fecha: 30/11/2024
Clase: Actividad que contiene un Navigation Drawer y que utiliza 3 fragments para cargar el contenido de la interfaz.
 Los elementos del menú lateral harán el reemplazo de los fragmentos en la activity.
*/

class MainActivity : AppCompatActivity() {

    // Controles a utilizar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Inicializar DrawerLayout y NavigationView
        drawerLayout = findViewById(R.id.main)
        navigationView = findViewById(R.id.navigation_view)

        // Cargamos el fragmento de inicio en la actividad
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, FragmentHome())
        transaction.commit()

        // Manejar las selecciones del menú
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Acción al seleccionar "Home"
                    showToast(getString(R.string.op_home_toast))
                    // Reemplazamos el fragmento
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FragmentHome()).commit()
                }
                R.id.nav_profile -> {
                    // Acción al seleccionar "Profile"
                    showToast(getString(R.string.op_profile_toast))
                    // Reemplazamos el fragmento
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FragmentProfile()).commit()
                }
                R.id.nav_settings -> {
                    // Acción al seleccionar "Settings"
                    showToast(getString(R.string.op_settings_toast))
                    // Reemplazamos el fragmento
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FragmentSettings()).commit()
                }
            }
            // Cerrar el panel después de seleccionar una opción
            drawerLayout.closeDrawers()
            true
        }
    }

    // Mostrar mensaje Toast con la opción pulsada en el menú
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}