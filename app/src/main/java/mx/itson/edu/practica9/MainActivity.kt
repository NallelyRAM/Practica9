package mx.itson.edu.practica9

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


//COMANDO PARA SACAR EL CERTIFICADO
//signingReport

//CERTIFICADO DE LA APLICACIÓN
//SHA1: 1B:B5:85:75:7A:F8:0D:57:0B:6D:C4:6A:71:5F:9E:2B:2F:16:87:AA


class MainActivity : AppCompatActivity() {
    lateinit var mGoogleSignInClient: GoogleSignInClient
    val RC_SIGN_IN = 343
    val LOG_OUT = 234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        // Build a GoogleSignInClient with the options specified by gso.
         mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        val sing_in_button: Button = findViewById(R.id.singn_in_button)

        sing_in_button.setOnClickListener {
            val singInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(singInIntent, RC_SIGN_IN)
        }
    }
}