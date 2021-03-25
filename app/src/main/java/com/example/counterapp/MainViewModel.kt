package com.example.counterapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(private val handle: SavedStateHandle) : ViewModel() {
    // handle 사용
    private var count = handle.get<Int>("count") ?: 0
        // setter 를 override 한다.
        // count 변수의 값이 바뀔 때마다
        // value 에 저장한다.
        set(value) {
            countLiveData.value = value
            // 이 값을 확정 짓겠다.
            field = value
            handle.set("count", value)
        }

    val countLiveData = MutableLiveData<Int>()

    // count 를 변경시킬 메소드
    fun increaseCount() {
        count++
//        countLiveData.value = count
    }

    fun decreaseCount() {
        count--
//        countLiveData.value = count
    }
}