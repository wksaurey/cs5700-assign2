package com.shipment_tracking_app

class LocationUpdateStrategy: ShipmentUpdateStrategy {
    override fun updateToString(update: ShippingUpdate): String {
        return "The shipment has arrived at a new location ${update.otherInfo}"
    }

    override fun updateShipment(update: ShippingUpdate, shipmentId: String) {
        val shipment = getShipment(shipmentId)
        if (update.otherInfo !is String) {
            throw IllegalArgumentException("Missing location for $update")
        }
        shipment.status = update.status
        shipment.currentLocation = update.otherInfo
        shipment.addUpdate(update)
    }
}