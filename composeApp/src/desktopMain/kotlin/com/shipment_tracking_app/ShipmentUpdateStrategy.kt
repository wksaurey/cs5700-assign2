package com.shipment_tracking_app

interface ShipmentUpdateStrategy {
    fun updateToString(update: ShippingUpdate): String
    fun updateShipment(update: ShippingUpdate, shipmentId: String)
}