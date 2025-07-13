package com.shipment_tracking_app

interface TimeUpdateStrategy: ShipmentUpdateStrategy {
    override fun updateShipment(update: ShippingUpdate, shipmentId: String) {
        val shipment = getShipment(shipmentId)
        if (update.otherInfo == null) {
            throw IllegalArgumentException("Missing updated delivery date for update $update")
        }
        shipment.status = update.status
        shipment.expectedDeliveryDate = update.otherInfo
        shipment.addUpdate(update)
    }

    override fun updateToString(update: ShippingUpdate): String {
        return when (update.status) {
            "shipped" -> "The shipment has been shipped"
            "delayed" -> "The shipment has been delayed"
            else -> throw IllegalArgumentException("Unknown status ${update.status}")
        }
    }
}