package com.shipment_tracking_app

open class StatusUpdateStrategy: ShipmentUpdateStrategy {
    override fun updateShipment(update: ShippingUpdate, shipmentId: String) {
        val shipment = getShipment(shipmentId)
        shipment.status = update.status
        shipment.addUpdate(update)
    }

    override fun updateToString(update: ShippingUpdate): String {
        return when (update.status) {
            "created" -> "A new shipment has been created"
            "delivered" -> "The shipment has been delivered to the consumer"
            "lost" -> "The shipment has been lost"
            "canceled" -> "The shipment was canceled by the consumer"
            else -> throw IllegalArgumentException("Unknown status ${update.status}")
        }
    }
}