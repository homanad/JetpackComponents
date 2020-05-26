package com.hmman.myapplication

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class FilteringWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        return try {
            for (i in 1..3000) {
                Log.i("mytag", "$i filtering")
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}