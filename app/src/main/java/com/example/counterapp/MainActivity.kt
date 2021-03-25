package com.example.counterapp

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
    // viewModel 은 activity 가 살아있을 때에만 효과가 있다.
    // 어떤 효과? viewModel 객체에 데이터를 담아 놓는 효과
    // 때문에 activity 가 어떤 시스템의 오류로 죽어버리면
    // 데이터도 같이 날아간다.
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tvCounter : TextView = findViewById(R.id.counter_text)
        var addButton : Button = findViewById(R.id.add_button)
        var subButton : Button = findViewById(R.id.sub_button)

        tvCounter.text = "${viewModel.count}"

        addButton.setOnClickListener {
            viewModel.count++
            tvCounter.text = "${viewModel.count}"
        }

        subButton.setOnClickListener {
            viewModel.count--
            tvCounter.text = "${viewModel.count}"
        }


        registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                Log.d(TAG, "onActivityCreated: ")

            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

            }

            override fun onActivityDestroyed(activity: Activity) {
            }

        })

    }
}