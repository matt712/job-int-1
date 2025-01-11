import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class CafeTest extends AnyFlatSpec with should.Matchers {

  val testCafe = new Cafe()

  "Cafe.bill" should "return correct prices for cola" in {
    testCafe.bill(Array("Cola")) should be(0.5)
  }

  "Cafe.bill" should "return correct prices for coffee" in {
    testCafe.bill(Array("Coffee")) should be(1)
  }

  "Cafe.bill" should "return correct prices for Cheese Sandwich with service charge" in {
    testCafe.bill(Array("Cheese Sandwich")) should be(2.2)
  }

  "Cafe.bill" should "return correct prices for Steak Sandwich with service charge" in {
    testCafe.bill(Array("Steak Sandwich")) should be (5.4)
  }

  "Cafe.bill" should "return correct price for order with multiple items with cold service charge" in {
    testCafe.bill(Array("Cola", "Coffee", "Cheese Sandwich")) should be (3.85)
  }

  "Cafe.bill" should "return correct price for order with multiple items with hot service charge" in {
    testCafe.bill(Array("Cola", "Coffee", "Steak Sandwich")) should be (7.2)
  }

  "Cafe.bill" should "return correct price for order with multiple items with hot service charge and 2 sandwiches" in {
    testCafe.bill(Array("Cola", "Coffee", "Steak Sandwich", "Cheese Sandwich")) should be (9.6)
  }

  "Cafe.bill" should "return price with £20 max service charge for hot service charge" in {
    var massiveOrder = Array("Steak Sandwich")
    for(i <- 1 to 29) {
      massiveOrder = massiveOrder :+ "Steak Sandwich"
    }
    testCafe.bill(massiveOrder) should be (155)
  }

}
