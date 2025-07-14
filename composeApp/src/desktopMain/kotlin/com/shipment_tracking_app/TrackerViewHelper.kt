package com.shipment_tracking_app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.StateFlow

class TrackerViewHelper(
    var shipmentId: String,
    ): Observer{
    val shipment = TrackingSimulator.findShipment(shipmentId)
    var shipmentStatus = shipment?.status
    var shipmentLocation = shipment?.currentLocation ?: "unknown"
    var expectedDelivery = shipment?.expectedDeliveryDate ?: "--"
    var statusUpdates = shipment?.updateHistory
    var notes = shipment?.notes

    override fun startTracking() {
        TrackingSimulator.findShipment(shipmentId)?.registerTracker(this)
    }

    override fun stopTracking() {
        TrackingSimulator.findShipment(shipmentId)?.removeTracker(this)
    }

    override fun newUpdate() {
        TODO("Not yet implemented")
    }
}