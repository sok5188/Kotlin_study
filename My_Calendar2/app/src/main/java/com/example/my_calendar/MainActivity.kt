package com.example.my_calendar

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import java.io.FileInputStream
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {
    lateinit var navController:NavController
    lateinit var calendarView:CalendarView
    lateinit var diaryTextView : TextView
    lateinit var save_Btn : Button
    lateinit var del_Btn : Button
    lateinit var edit_Btn : Button
    lateinit var textView2 :TextView
    lateinit var editText :EditText
    lateinit var fname : String
    lateinit var str : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calendarView=findViewById(R.id.calendarView);
        diaryTextView=findViewById(R.id.diaryText);
        save_Btn=findViewById(R.id.btn_save);
        del_Btn=findViewById(R.id.btn_del);
        edit_Btn=findViewById(R.id.btn_edit);
        textView2=findViewById(R.id.text2);
        editText=findViewById(R.id.editText);

        val intent = intent
        val name = intent.getStringExtra("userName")
        val userID = intent.getStringExtra("userID")

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            diaryTextView.visibility=View.VISIBLE
            save_Btn.visibility = View.VISIBLE
            editText.setVisibility(View.VISIBLE)
            textView2.visibility = View.INVISIBLE
            edit_Btn.setVisibility(View.INVISIBLE)
            del_Btn.visibility = View.INVISIBLE
            diaryTextView.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
            editText.setText("")
            checkDay(year, month, dayOfMonth, userID)
        }
        calendarView.setOnClickListener {

        }
        save_Btn.setOnClickListener {
            saveDiary(fname)
            str = editText.getText().toString()
            textView2.text = str
            save_Btn.visibility = View.INVISIBLE
            edit_Btn.setVisibility(View.VISIBLE)
            del_Btn.visibility = View.VISIBLE
            editText.setVisibility(View.INVISIBLE)
            textView2.visibility = View.VISIBLE
        }
    }


    fun checkDay(cYear: Int, cMonth: Int, cDay: Int, userID: String?) {
        fname = "" + userID + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt" //저장할 파일 이름설정
        var fin : FileInputStream? = null //FileStream fis 변수
        try {
            fin = openFileInput(fname)
            val fileData = ByteArray(fin.available())
            fin.read(fileData)
            fin.close()
            str = String(fileData)
            editText.setVisibility(View.INVISIBLE)
            textView2.setVisibility(View.VISIBLE)
            textView2.setText(str)
            save_Btn.setVisibility(View.INVISIBLE)
            edit_Btn.setVisibility(View.VISIBLE)
            del_Btn.setVisibility(View.VISIBLE)

            edit_Btn.setOnClickListener(View.OnClickListener {
                editText.setVisibility(View.VISIBLE)
                textView2.setVisibility(View.INVISIBLE)
                editText.setText(str)
                save_Btn.setVisibility(View.VISIBLE)
                edit_Btn.setVisibility(View.INVISIBLE)
                del_Btn.setVisibility(View.INVISIBLE)
                textView2.setText(editText.getText())
            })

            del_Btn.setOnClickListener(View.OnClickListener {
                textView2.setVisibility(View.INVISIBLE)
                editText.setText("")
                editText.setVisibility(View.VISIBLE)
                save_Btn.setVisibility(View.VISIBLE)
                edit_Btn.setVisibility(View.INVISIBLE)
                del_Btn.setVisibility(View.INVISIBLE)
                removeDiary(fname)
            })

            if (textView2.getText() == null) {
                textView2.setVisibility(View.INVISIBLE)
                diaryTextView.setVisibility(View.VISIBLE)
                save_Btn.setVisibility(View.VISIBLE)
                edit_Btn.setVisibility(View.INVISIBLE)
                del_Btn.setVisibility(View.INVISIBLE)
                editText.setVisibility(View.VISIBLE)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @SuppressLint("WrongConstant")
    fun removeDiary(readDay: String?) {
        var fout:FileOutputStream? = null
        try {
            fout = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS)
            val content = ""
            fout.write(content.toByteArray())
            fout.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun saveDiary(readDay: String?) {
        var fos: FileOutputStream? = null
        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS)
            val content: String = editText.getText().toString()
            fos.write(content.toByteArray())
            fos.close()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}