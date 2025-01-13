class Cafe {

  def bill(order: Array[String]): BigDecimal = {
    var totalPrice: BigDecimal = 0
    var serviceChargeType: String = "No Charge"
    for(item <- order) {
      item match {
        case "Cola" => totalPrice = totalPrice + 0.5
        case "Coffee" => totalPrice = totalPrice + 1
        case "Cheese Sandwich" => {
          totalPrice = totalPrice + 2
          if(serviceChargeType == "No Charge") {
            serviceChargeType = "Cold Charge"
          }
        }
        case "Steak Sandwich" => {
          totalPrice = totalPrice + 4.5
          if(serviceChargeType == "No Charge" || serviceChargeType == "Cold Charge") {
            serviceChargeType = "Hot Charge"
          }
        }
      }
    }
    serviceChargeType match {
      case "No Charge" => totalPrice
      case "Hot Charge" => {
        val hotServiceCharge: BigDecimal = if(totalPrice*0.2 > 20) 20 else totalPrice*0.2
        totalPrice + hotServiceCharge
      }
      case "Cold Charge" => {
        val coldServiceCharge: BigDecimal = totalPrice*0.1
        totalPrice + coldServiceCharge
      }
    }
  }

}
