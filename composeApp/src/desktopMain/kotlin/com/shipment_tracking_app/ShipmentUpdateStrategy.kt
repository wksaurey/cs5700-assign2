package com.shipment_tracking_app

interface ShipmentUpdateStrategy {
    fun updateToString(update: ShippingUpdate): String
    fun updateShipment(update: ShippingUpdate, shipmentId: String)
    fun getShipment(shipmentId: String): Shipment {
        val shipment = TrackingSimulator.findShipment(shipmentId)
        if (shipment == null) {
            throw IllegalArgumentException("Shipment with id $shipmentId not found")
        }
        return shipment
    }
}