package com.shipment_tracking_app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import kotlinx.coroutines.flow.StateFlow
import org.jetbrains.compose.resources.MissingResourceException

class TrackerViewHelper(
    var shipmentId: State<String>
    ): Observer{

    val shipment = TrackingSimulator.findShipment(shipmentId.value)
    var shipmentStatus: State<String?> = mutableStateOf(shipment?.status)
    var shipmentLocation: State<String?> = mutableStateOf(shipment?.currentLocation)
    var expectedDeliveryDate: State<String?> = mutableStateOf(shipment?.expectedDeliveryDate)
    var statusUpdates: State<MutableList<ShippingUpdate>?> = mutableStateOf(shipment?.updateHistory)
    var notes: State<MutableList<String>?> = mutableStateOf(shipment?.notes)

    override fun startTracking() {
        shipment?.registerTracker(this)
    }

    override fun stopTracking() {
        TrackingSimulator.findShipment(shipmentId.toString())?.removeTracker(this)
    }

    override fun newUpdate() {
        print("Updating TVH from ${shipmentStatus.value} to ")
        shipmentStatus = mutableStateOf(shipment?.status)
        println(shipmentStatus.value)
        shipmentLocation = mutableStateOf(shipment?.currentLocation)
        expectedDeliveryDate = mutableStateOf(shipment?.expectedDeliveryDate)
        statusUpdates = mutableStateOf(shipment?.updateHistory)
        notes = mutableStateOf(shipment?.notes)
    }
}