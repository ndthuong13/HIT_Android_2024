package com.example.jetpackdemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity2 : ComponentActivity() {

    fun simpleFlow(): Flow<Int> {
        return flow {
            for (i in 0..2) {
                delay(1000)
                emit(i)
            }
        }
    }

    fun simpleFlow2(): Flow<Int> {
        return flow {
            try {
                for (i in 0..4) {
                    delay(300)
                    emit(i)
                }
            } catch (e: CancellationException) {
                Log.i("TAG", "CancellationException")
            } finally {
                Log.i("TAG", "finally")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("TAG", "Start Flow")
        CoroutineScope(Dispatchers.Main).launch {
            //simpleFlow().collect { Log.i("TAG", "$it") }
            //flowOf(2,4,6).collect { Log.i("TAG", "$it") }
            //listOf(3,5,7).asFlow().collect { Log.i("TAG", "$it") }

            //simpleFlow2().take(2).collect { Log.i("TAG", "$it") }
//            simpleFlow2().transform { value ->
//                if (value % 2 == 0)
//                    emit(value)
//                else {
//                    emit(value + 10)
//                    delay(300)
//                    emit(value + 20)
//                }
//            }.collect { Log.i("TAG", "$it") }
            //simpleFlow2().map { -it }.collect { Log.i("TAG", "$it") }
//            var total = simpleFlow2().reduce { a,b -> a +b}
//            Log.i("TAG", "$total")
            // Log.i("TAG", "${simpleFlow2().toList()}")
            //filter fold ...
        }

        CoroutineScope(Dispatchers.Main).launch {
            val channel = Channel<Int>()
            val job = launch {
                for (i in 0..2)
                    channel.send(i)
            }

            for (i in 0..2) {
                val receive = channel.receive()
                Log.i("TAG", "$receive")
            }
        }


        Log.i("TAG", "End Flow")
    }
}