import kotlin.math.ceil
import kotlin.math.roundToInt

data class Parking(
    val vehicles: MutableSet<Vehicle>,
    val maxVehicles: Int = 20,
) {
    private var totalVehicles = 0
    private var totalEarnings = 0
    private var vehiclesRecord: Pair<Int, Int> = Pair(totalVehicles, totalEarnings)
    private val parkingLots: MutableList<Parkable> = mutableListOf()

    init {
        for (i in 1..maxVehicles) {
            parkingLots.add(Parkable())
        }
    }

    private fun isParked(vehicle: Vehicle): Boolean {
        val taken = parkingLots.takeWhile { it.parkedVehicle }
        taken.forEach {
            if (it.vehicle!! == vehicle)
                return true
        }
        return false
    }

    fun checkIn(vehicle: Vehicle): Boolean {
        if (isParked(vehicle)) {
            println("Is Parked.")
            return false
        }
        parkingLots.forEach {
            if (!it.parkedVehicle) {
                it.addVehicle(vehicle)
                return true
            }
        }
        return false
    }

    fun checkOut(vehicle: Vehicle) {
        try {
            parkingLots.forEach {
                if (it.parkedVehicle) {
                    if (it.vehicle!! == vehicle) {
                        val totalPrice =
                            calculateFee(it.vehicle!!.type, it.parkedTime, it.vehicle!!.discountCard != null)
                        it.removeVehicle(totalPrice, ::onSuccess)
                    } else {
                        onError()
                    }
                }
            }
        } catch (error: Exception) {
            onError()
        }
    }

     fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean): Int {
        if (parkedTime > 120) {
            val blocks = (parkedTime.toFloat() - 120) / 15
            val roundBlocks = (ceil(blocks)).toInt()
            val totalPrice = when (type) {
                VehicleType.CAR -> VehicleType.CAR.price + (roundBlocks * 5)
                VehicleType.MOTORCYCLE -> VehicleType.MOTORCYCLE.price + (roundBlocks * 5)
                VehicleType.BUS -> VehicleType.BUS.price + (roundBlocks * 5)
                VehicleType.MINI_BUS -> VehicleType.MINI_BUS.price + (roundBlocks * 5)
            }
            return if (hasDiscountCard) {
//                println("${(totalPrice * 0.85).roundToInt()}")
                (totalPrice * 0.85).roundToInt()
            } else {
//                println("$totalPrice")
                return totalPrice
            }
        } else {
            val totalPrice = when (type) {
                VehicleType.CAR -> VehicleType.CAR.price
                VehicleType.MOTORCYCLE -> VehicleType.MOTORCYCLE.price
                VehicleType.BUS -> VehicleType.BUS.price
                VehicleType.MINI_BUS -> VehicleType.MINI_BUS.price
            }
            return if (hasDiscountCard) {
//                println("${(totalPrice * 0.85).roundToInt()}")
                (totalPrice * 0.85).roundToInt()
            } else {
//                println("$totalPrice")
                return totalPrice
            }
        }
    }

    private fun onSuccess(totalPrice: Int) {
        vehiclesRecord = Pair(totalVehicles + 1,totalEarnings + totalPrice)
        println("Your fee is $$totalPrice, Come back soon.")
    }

    private fun onError() = "Sorry, the check-out failed."


    fun vehiclesList() {
        parkingLots.forEach {
            if (it.vehicle != null) {
                println("Occupied By: ${it.vehicle?.plate}.")
            }else {
                println("Empty Place.")
            }
        }
    }
    fun getRecord() {
        println("${vehiclesRecord.first} vehicles have checked out and have earnings of $${vehiclesRecord.second}")
    }
}



