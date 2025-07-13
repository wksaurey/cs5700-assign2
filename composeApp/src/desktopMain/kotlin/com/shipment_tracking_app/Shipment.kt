package com.shipment_tracking_app

class Shipment(
    id: String,
    ): Subject {
    var id = id
    var status = ""
    var notes = mutableListOf<String>()
        private set
    var updateHistory = mutableListOf<ShippingUpdate>()
        private set
    var expectedDeliveryDate: String? = null
    var currentLocation: String? = null
    private var trackers = mutableListOf<Observer>()

    fun addNote(note: String) {
        notes.add(note)
    }

    fun addUpdate(update: ShippingUpdate) {
        updateHistory.add(update)
        notifyTrackers()
    }

    override fun registerTracker(tracker: Observer) {
        trackers.add(tracker)
    }

    override fun removeTracker(tracker: Observer) {
        trackers.remove(tracker)
    }

    override fun notifyTrackers() {
        println(updateHistory.last().toString())
    }
}