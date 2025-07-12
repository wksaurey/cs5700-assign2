package com.shipment_tracking_app

abstract class StatusUpdateStrategy: ShipmentUpdateStrategy {
    abstract override fun updateToString(): String
    override fun updateShipment(shipment: Shipment) {
//        shipment.status = this.status
//        shipment.updateHistory.add(this)
    }
}