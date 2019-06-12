package com.johndoe.mycv.screens.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.johndoe.mycv.R
import com.johndoe.mycv.screens.education.EducationActivity
import com.johndoe.mycv.screens.work.WorkExperienceActivity

class ProfileActivity : AppCompatActivity() {

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
