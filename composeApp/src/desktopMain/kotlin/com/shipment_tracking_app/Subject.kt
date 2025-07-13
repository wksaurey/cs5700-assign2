package com.shipment_tracking_app

interface Subject {
    fun registerTracker(tracker: Observer)
    fun removeTracker(tracker: Observer)
    fun notifyTrackers()
}