package com.example.wazeinthandler

import android.telecom.InCallService
import android.telecom.Call

class WazeInCallService : InCallService() {
    override fun onCallAdded(call: Call) {
        super.onCallAdded(call)
    }

    override fun onCallRemoved(call: Call) {
        super.onCallRemoved(call)
    }
}
