import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class SunSurfaceTest extends Spec with ShouldMatchers {

  trait SunSurface1 extends SunSurface {

  }

  describe("neighbours") {
    it("should return all the neighbors for a Spot") {
      new SunSurface1 {
        val position = Position(1,1)

        val spot = Spot(position)

        spot.neighbors.size should be(8)
      }
    }
  }
}
