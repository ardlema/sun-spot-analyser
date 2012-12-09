import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class SpotTest extends Spec with ShouldMatchers {

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

    it("should create the neighbors properly") {
      new SunSurface1 {
        val position = Position(1,1)

        val spot = Spot(position)

        assert(spot.upleft == Spot(Position(0,0)))
        assert(spot.up == Spot(Position(0,1)))
        assert(spot.upright == Spot(Position(0,2)))
        assert(spot.left == Spot(Position(1,0)))
        assert(spot.right == Spot(Position(1,2)))
        assert(spot.downleft == Spot(Position(2,0)))
        assert(spot.down == Spot(Position(2,1)))
        assert(spot.downright == Spot(Position(2,2)))

      }
    }
  }

  describe("legal neighbours") {
    it("should return all the legal neighbors for a Spot") {
      new SunSurface1 {
        val position = Position(1,1)

        val spot = Spot(position)

        spot.legalNeighbors.size should be(1)
      }
    }

  }
}
