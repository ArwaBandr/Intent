package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    androidx.compose.material3.Button(onClick = {
                        takePicture()
                        //etAlarm("ggg",8,22)
                    }) {
                        androidx.compose.material3.Text(text ="open")
                    }
                }
            }
        }
    }


     fun openActivity2(){
        try {
            val intent = Intent( this, MainActivity2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }catch (e:Exception){
            println(e)
        }
    }


    fun setAlarm(message:String,hour:Int,min:Int){
        try{
            val intent =Intent(android.provider.AlarmClock.ACTION_SET_ALARM).apply{
                putExtra(android.provider.AlarmClock.EXTRA_MESSAGE,message)
                putExtra(android.provider.AlarmClock.EXTRA_HOUR,hour)
                putExtra(android.provider.AlarmClock.EXTRA_MINUTES,min)


            }
            startActivity(intent)

        }catch (e:Exception){
            println(e)
        }
    }
    fun takePicture(){
        try {
            val intent =Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)

            startActivity(intent)
        }catch (e:Exception){
            println(e)
        }
    }
}










