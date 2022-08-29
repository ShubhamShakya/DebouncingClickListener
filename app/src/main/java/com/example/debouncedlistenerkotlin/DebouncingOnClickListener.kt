package com.example.debouncedlistenerkotlin

import android.view.View
import android.widget.Toast

class DebouncingOnClickListener(
    private val intervalMillis: Long,
    private val doClick: ((View) -> Unit)
) : View.OnClickListener {
    companion object {
        @JvmStatic
        var enabled = true
        private val ENABLE_AGAIN =
            Runnable { enabled = true }
    }

    override fun onClick(v: View) {
        if (enabled) {
            enabled = false
            v.postDelayed(ENABLE_AGAIN,intervalMillis)
            doClick(v)
        }
    }

    //private fun View.postDelayed2(delayMillis: Long, action: () -> Unit) = postDelayed(action, delayMillis)
}

 fun View.setOnCLick(intervalMillis: Long = 0, doClick: (View) -> Unit) =
    setOnClickListener(DebouncingOnClickListener(intervalMillis = intervalMillis, doClick = doClick))

/*
fun testDebouncingOnClickListener(v: View) {
    v.setOnCLick {
        Toast.makeText(v.context, "No double click any more! ", Toast.LENGTH_SHORT).show()
    }
    v.setOnCLick(500) {
        Toast.makeText(v.context, "No double click any more! ", Toast.LENGTH_SHORT).show()
    }
}*/
