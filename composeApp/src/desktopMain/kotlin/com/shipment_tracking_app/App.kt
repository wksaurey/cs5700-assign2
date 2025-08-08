package com.shipment_tracking_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        var shipmentId by remember { mutableStateOf("") }
        // var shipmentViews by remember { mutableStateOf(mutableListOf<TrackerViewHelper>()) }
        val shipmentViews = remember { mutableStateListOf<TrackerViewHelper>() }

        val textFieldHeight = 56.dp

        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize()
                .background(Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                TextField(
                    value = shipmentId,
                    onValueChange = { shipmentId = it },
                    label = { Text(text = "Track Shipment") },
                    placeholder = { Text(text = "Enter Shipment ID") },
                    modifier = Modifier
                        .weight(1f)
                        .height(textFieldHeight),
                    singleLine = true,
                )
                Button(
                    onClick = {
                        println("Entered shipment $shipmentId")
                        if (shipmentViews.find { it.shipmentId.value == shipmentId } != null) {
                            println("Already tracking shipment $shipmentId")
                        } else if (TrackingSimulator.findShipment(shipmentId) == null) {
                            println("Shipment $shipmentId not found")
                        } else {
                            val trackerView = TrackerViewHelper(mutableStateOf<String>(shipmentId))
                            trackerView.startTracking()
                            shipmentViews += trackerView
                        }
                        shipmentId = ""
                    },
                    modifier = Modifier.height(textFieldHeight),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text("Track")
                }
            }
            TrackerView(shipmentViews, onRemoveShipmentView = {shipmentId: String ->
                shipmentViews.removeAll { it.shipmentId.toString() == shipmentId }
            })
        }
    }
}