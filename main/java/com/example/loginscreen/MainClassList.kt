package com.example.loginscreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainClassList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_class_list)

        val schoolSwitch = findViewById<Switch>(R.id.idSchoolSwitch)
        val degreeSpinner = findViewById<Spinner>(R.id.idDegreeSpinner)
        val certSpinner = findViewById<Spinner>(R.id.idCertSpinner)
        val txtCertificate = findViewById<TextView>(R.id.idCertTxt)
        val txtDegree = findViewById<TextView>(R.id.idDegreeTxt)
        val nextButton = findViewById<Button>(R.id.idNextButton)

        val firstName = findViewById<EditText>(R.id.idFirstName)
        val lastName = findViewById<EditText>(R.id.idLastName)
        val phone = findViewById<EditText>(R.id.idPhoneInput)

        val spnMonth = findViewById<Spinner>(R.id.idMonthSpinner)
        val dayInput = findViewById<EditText>(R.id.idDayInput)
        val yearInput = findViewById<EditText>(R.id.idYearInput)


        firstName.requestFocus()

        schoolSwitch.setOnCheckedChangeListener {buttonView, isChecked ->
            if (isChecked) {
                degreeSpinner.visibility = View.VISIBLE
                txtDegree.visibility = View.VISIBLE
                certSpinner.visibility = View.GONE
                txtCertificate.visibility = View.GONE
            } else {
                degreeSpinner.visibility = View.GONE
                txtDegree.visibility = View.GONE
                certSpinner.visibility = View.VISIBLE
                txtCertificate.visibility = View.VISIBLE
            }
        }

        nextButton.setOnClickListener {
            if (checkData()) {
                var verifyBirth = ""
                verifyBirth = spnMonth.selectedItem.toString() + "/" + dayInput.text.toString() + "/" + yearInput.text.toString()

                val nextScreen = Intent(this@MainClassList, ChooseClass::class.java)
                nextScreen.putExtra("FirstName", firstName.text.toString())
                nextScreen.putExtra("LastName", lastName.text.toString())
                nextScreen.putExtra("Phone", phone.text.toString())
                nextScreen.putExtra("BirthDate", verifyBirth)

                if (degreeSpinner.visibility == View.VISIBLE) {
                    nextScreen.putExtra("isDegreeCert", "Degree")
                    nextScreen.putExtra("degreeCert", degreeSpinner.selectedItem.toString())

                } else {
                    nextScreen.putExtra("isDegreeCert", "Certificate")
                    nextScreen.putExtra("degreeCert", certSpinner.selectedItem.toString())
                }
                startActivity(nextScreen)
            }
        }
    }


    private fun checkData(): Boolean {
        val firstName = findViewById<EditText>(R.id.idFirstName)
        val lastName = findViewById<EditText>(R.id.idLastName)
        val phone = findViewById<EditText>(R.id.idPhoneInput)
        val dayInput = findViewById<EditText>(R.id.idDayInput)
        val yearInput = findViewById<EditText>(R.id.idYearInput)


        if (firstName.text.toString().isEmpty()) {
            firstName.error = "Invalid First Name"
            firstName.requestFocus()
            return false
        }

        if (lastName.text.toString().isEmpty()) {
            lastName.error = "Invalid Last Name"
            lastName.requestFocus()
            return false
        }

        if (phone.text.toString().isEmpty()) {
            phone.error = "Invalid Phone Number"
            phone.requestFocus()
            return false
        }

        if (dayInput.text.toString().isEmpty()) {
            dayInput.error = "Invalid Date Selection"
            dayInput.requestFocus()
            return false
        }
        if (yearInput.text.toString().isEmpty()) {
            yearInput.error = "Invalid Date Selection"
            yearInput.requestFocus()
            return false
        }

        return true



    }
}
