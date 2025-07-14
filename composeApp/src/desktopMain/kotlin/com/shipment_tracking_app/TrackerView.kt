package com.shipment_tracking_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TrackerView(shipmentViews: List<TrackerViewHelper>, onRemoveShipmentView: (String) -> Unit) {
    LazyColumn (
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ){
        items(shipmentViews) {
            Card (
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier.fillMaxWidth()
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text("Tracking Shipment ${it.shipmentId}", fontSize = 20.sp)
                        IconButton(onClick = {
                            onRemoveShipmentView(it.shipmentId)
                            println("Removing TrackerViewHelper ${it.shipmentId}")
                        }) {
                            Text("✕", fontWeight = FontWeight.Bold)
                        }
                    }
                    Text("Status: ${it.shipmentStatus}")
                }
            }
        }
    }
}