package com.shipment_tracking_app

interface Observer {
    fun newUpdate()
    fun startTracking()
    fun stopTracking()
}