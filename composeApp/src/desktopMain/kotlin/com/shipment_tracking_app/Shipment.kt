package com.shipment_tracking_app

class Shipment(
    id: String,
    status: String,
    shippingUpdate: ShippingUpdate
    ) {
    var id = id
    var status = status
    var notes = mutableListOf<String>()
        private set
    var updateHistory = mutableListOf<ShippingUpdate>()
        private set
    var expectedDeliveryDate: String? = null
    var currentLocation: String? = null
    var trackers = mutableListOf<TrackerViewHelper>()

    fun addNote(note: String) {
        notes.add(note)
    }

    fun addUpdate(update: ShippingUpdate) {
        updateHistory.add(update)
    }
}