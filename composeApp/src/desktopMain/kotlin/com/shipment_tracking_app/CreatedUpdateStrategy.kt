package com.shipment_tracking_app

class CreatedUpdateStrategy: StatusUpdateStrategy() {
    override fun getShipment(shipmentId: String): Shipment {
        val shipment = Shipment(shipmentId)
        TrackingSimulator.addShipment(shipment)
        return shipment
    }
}