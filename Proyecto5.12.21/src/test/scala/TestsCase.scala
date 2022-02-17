import org.scalatest.FunSuite

class TestsCase extends FunSuite {
  test("Suma ") {
    assert(Recursion.sum(List(1,5,10,15)) == 31)
    assert(Recursion.sum(List(-1,-10,-15,-20)) == -46)
    assert(Recursion.sum(List(999999999, 999999999)) > 999999999)
  }

}
