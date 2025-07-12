package com.shipment_tracking_app

class ShippingUpdate (
    val status: String,
    val shipmentId: String,
    val timestamp: String,
    val otherInfo: String? = null
    ){

}