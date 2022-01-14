import java.util.*

class Parkable {
    var vehicle: Vehicle? = null
    var parkedVehicle: Boolean = false

    fun addVehicle(vehicle: Vehicle): Boolean {
        this.vehicle = vehicle
        this.vehicle!!.checkInTime = Calendar.getInstance()
        this.parkedVehicle = true
        return true
    }

    fun removeVehicle(totalPrice: Int, onSuccess: (Int) -> Unit) {
        this.vehicle = null
        this.parkedVehicle = false
        onSuccess(totalPrice)
    }

    val parkedTime: Long
        get() = ((Calendar.getInstance().timeInMillis - this.vehicle?.checkInTime!!.timeInMillis) / 60000)

}