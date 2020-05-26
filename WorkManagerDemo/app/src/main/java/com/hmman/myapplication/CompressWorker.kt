package com.hmman.myapplication

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class CompressWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        return try {
            for (i in 1..200) {
                Log.i("mytag", "$i compressing")
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}