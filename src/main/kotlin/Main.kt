import java.util.*

fun main() {
    val car = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val moto = Vehicle("BB222BB", VehicleType.MOTORCYCLE,Calendar.getInstance())
    val miniBus = Vehicle("CC333CC", VehicleType.MINI_BUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus = Vehicle("DD444DD", VehicleType.BUS, Calendar.getInstance())
    val car2 = Vehicle("AA1111A", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car3 = Vehicle("AA1112A", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car4 = Vehicle("AA1115A", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car5 = Vehicle("AA1114A", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val moto2 = Vehicle("BB224BB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto3 = Vehicle("BB22aBB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto4 = Vehicle("BB220BB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto5 = Vehicle("BB221BB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto6 = Vehicle("BB222BB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto7 = Vehicle("BA2211B", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto8 = Vehicle("BC221BB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto9 = Vehicle("BBD21BB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto10 = Vehicle("BE221BB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val moto11 = Vehicle("BF221BB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val bus2 = Vehicle("DD444FD", VehicleType.BUS, Calendar.getInstance())
    val bus3 = Vehicle("DD444GD", VehicleType.BUS, Calendar.getInstance())
    val miniBus2 = Vehicle("CC333CE", VehicleType.MINI_BUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val miniBus3 = Vehicle("CC333GE", VehicleType.MINI_BUS,Calendar.getInstance())


    val parking = Parking(mutableSetOf())

    val extraVehicles = listOf(
        car, moto, miniBus, bus, car2, car3, car4, car5,
        moto2, moto3, moto4, moto5,
        moto6, moto7, moto8, moto9, moto10, moto11, bus2, bus3,
        miniBus2, miniBus3
    )

    parking.calculateFee(VehicleType.CAR,180,false)
    extraVehicles.forEach {
        if (parking.checkIn(it)) println("Welcome to AlkeParking!")
        else println("Sorry, the check-in failed")
    }

    val car15 = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    parking.checkIn(car15)

    parking.checkOut(moto)

    parking.vehiclesList()
    parking.getRecord()
}

