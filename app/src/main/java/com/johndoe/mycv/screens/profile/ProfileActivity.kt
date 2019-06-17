package com.johndoe.mycv.screens.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.johndoe.mycv.R
import com.johndoe.mycv.screens.education.EducationActivity
import com.johndoe.mycv.screens.work.WorkExperienceActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileActivity : AppCompatActivity() {

    // Lazy Inject ViewModel
    val viewModel: ProfileViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Temporary states
        this.findViewById<View>(R.id.view_profile).visibility= View.VISIBLE
        this.findViewById<View>(R.id.view_loading).visibility= View.INVISIBLE
        this.findViewById<View>(R.id.view_error).visibility= View.INVISIBLE

        // Temporary actions
        this.findViewById<Button>(R.id.button_work).setOnClickListener {
            val intent = Intent(this@ProfileActivity, WorkExperienceActivity::class.java)
            startActivity(intent) }

        this.findViewById<Button>(R.id.button_education).setOnClickListener {
            val intent = Intent(this@ProfileActivity, EducationActivity::class.java)
            startActivity(intent) }
    }
}
