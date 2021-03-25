package com.example.counterapp

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
    // viewModel 은 activity 가 살아있을 때에만 효과가 있다.
    // 어떤 효과? viewModel 객체에 데이터를 담아 놓는 효과
    // 때문에 activity 가 어떤 시스템의 오류로 죽어버리면
    // 데이터도 같이 날아간다.
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count2 = savedInstanceState?.getInt("count")

        Log.d(TAG, "onSaveInstanceState: ${count2}")

        var tvCounter : TextView = findViewById(R.id.counter_text)
        var addButton : Button = findViewById(R.id.add_button)
        var subButton : Button = findViewById(R.id.sub_button)

//        tvCounter.text = "${viewModel.count}"

        // livedata 를 사용하여 데이터의 변화를 관찰하도록 설정
        // 어떤 데이터?
        // view model 에서 사용하고 있는 데이터
        viewModel.countLiveData.observe(this, Observer { count->
            tvCounter.text = "$count"
        })

        addButton.setOnClickListener {
//            viewModel.count++
//            tvCounter.text = "${viewModel.count}"
            viewModel.increaseCount()
        }

        subButton.setOnClickListener {
//            viewModel.count--
//            tvCounter.text = "${viewModel.count}"
            viewModel.decreaseCount()
        }

    }

    // activity 가 종료될 때 데이터를 bundle 에 저장할 때 사용
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt("count", viewModel.count)
//        Log.d(TAG, "onSaveInstanceState: ${viewModel.count}")
//    }
//
//    // bundle 에 담긴 데이터를 사용해서 복원할 때 사용하는 메소드
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        viewModel.count = savedInstanceState.getInt("count")
//        Log.d(TAG, "onRestoreInstanceState: ${viewModel.count}")
//
//    }



}