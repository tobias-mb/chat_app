package fi.oamk.chat

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SettingsActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        tvEmail = findViewById(R.id.email)

        supportActionBar?.apply {
            title="Settings"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val currentUser = intent.getParcelableExtra<FirebaseUser>("currentUser")
        tvEmail.setText(currentUser?.email)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun logout(view: View) {
        FirebaseAuth.getInstance().signOut()
        tvEmail.setText("")
    }
}