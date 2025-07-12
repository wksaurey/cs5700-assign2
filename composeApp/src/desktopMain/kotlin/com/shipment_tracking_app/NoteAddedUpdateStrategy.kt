package com.shipment_tracking_app

class NoteAddedUpdateStrategy: ShipmentUpdateStrategy {
    override fun updateToString(update: ShippingUpdate): String {
        return "A note was added by the shipper to the shipment"
    }
    override fun updateShipment(update: ShippingUpdate, shipmentId: String) {
        val shipment = TrackingSimulator.findShipment(shipmentId)
        if (shipment == null) {
            throw IllegalArgumentException("No shipment with id $shipmentId")
        }
        if (update.otherInfo !is String) {
            throw IllegalArgumentException("Missing note for $update")
        }
        shipment.status = update.status
        shipment.addNote(update.otherInfo)
        shipment.addUpdate(update)
    }
}