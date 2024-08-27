package com.example.jetpackdemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackdemo.ui.theme.JetpackDemoTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "Start")

//        GlobalScope.launch {
//            Log.i("TAG", "Start GlobalScope")
//            delay(1000)
//            Log.i("TAG", "End Global Scope")
//        }
//        GlobalScope.launch {
//            Log.i("TAG", "Start GlobalScope 2")
//            delay(1000)
//            Log.i("TAG", "End Global Scope 2")
//        }

//        GlobalScope.launch{
//            Log.i("TAG", "Start GlobalScope")
//            var job = launch {
//                Log.i("TAG", "Start Launch")
//                delay(3000)
//                Log.i("TAG", "End Launch")
//            }
////            job.join()
//
//            var a = async {
//                Log.i("TAG", "Start async")
//                delay(2000)
//                Log.i("TAG", "End async")
//                compute()
//            }
////            Log.i("TAG", "async ${a.await()}")
//            joinAll(job, a)
//            Log.i("TAG", "End Global Scope")
//        }

//        CoroutineScope(Dispatchers.IO).launch{
//            Log.d("TAG", "Start IO")
//            delay(1000)
//            withContext(Dispatchers.Main){
//                //update UI
//            }
//            Log.d("TAG", "End IO")
//        }

        GlobalScope.launch{
            val job = launch{
                try{
                    for(i in 0.. 10){
                        println(i)
//                        Thread.sleep(1000)
                        delay(1000)
//                        compute()
                    }
                }finally {
                    println("cancelled")
                }
            }
            delay(1500)
            println("Cancel job")
            job.cancel()
        }


        runBlocking {
            var job = launch {
                Log.i("TAG", "Start Launch")
                delay(3000)
                Log.i("TAG", "End Launch")
            }

            var job2 = launch {
                Log.i("TAG", "Start Launch 2")
                delay(3000)
                Log.i("TAG", "End Launch 2")
            }
            Log.i("TAG", "End runBlocking")
        }

        Log.d("TAG", "End")
    }

    suspend fun compute(){
        Log.d("TAG", "Start Compute")
        delay(1000)
        Log.d("TAG", "End Compute")
        1
    }

}
