package com.example.budgetapp

import SimpleAdapter
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var listView: ListView
    lateinit var title: String
    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        //Calendars:
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val c2 = Calendar.getInstance()
        val year2 = c2.get(Calendar.YEAR)
        val month2 = c2.get(Calendar.MONTH)
        val day2 = c2.get(Calendar.DAY_OF_MONTH)

        Log.e(tag, "year1: $year")
        Log.e(tag, "month1: $month")
        Log.e(tag, "month2: $month2")
        Log.e(tag, "day1: $day")

        Log.e(tag, "before onCreate()")

        super.onCreate(savedInstanceState)
        Log.e(tag, "after onCreate()")

        setContentView(R.layout.activity_main)
        Log.e(tag, "after setContentView()")

        this.setupUIViews()
        Log.e(tag, "after setupUIView()")

        this.initToolbar()
        Log.e(tag, "after initToolbar()")

        this.setupListView()
        Log.e(tag, "after setupListView()")

        //button click to show DatePickerDialog
        pickDateBtn.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _, mYear, mMonth, mDay ->
                    var monthSel = mMonth + 1
                    dateTv2.text = "$mDay/$monthSel/$mYear"
                },
                year,
                month,
                day
            )
            dpd.show()

            val dpd2 = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { _, mYear2, mMonth2, mDay2 ->
                    var monthSel2 = mMonth2 + 1
                    dateTv.text = "$mDay2/$monthSel2/$mYear2"
                },
                year2,
                month2,
                day2
            )
            dpd2.show()
        }
    }

        private fun setupUIViews(){
            toolbar = findViewById(R.id.ToolbarMain);
            Log.e(tag, "inside Util class, setupUiViews, before findViewById(lvMain)");
            listView = findViewById(R.id.lvMain);
        }

        private fun initToolbar(){
            setSupportActionBar(toolbar)
            getSupportActionBar()?.setTitle(" App")
        }

    private fun setupListView(){
        val title = resources.getStringArray(R.array.Main)
        val description=resources.getStringArray(R.array.Description)

            var simpleAdapter= SimpleAdapter(this, title, description)
            listView.setAdapter(simpleAdapter);
        }


    }



