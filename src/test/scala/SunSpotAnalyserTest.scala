import org.scalatest.{Tag, FunSpec}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class SunSpotAnalyserTest extends FunSpec with ShouldMatchers{

  trait Solution extends SunSpotAnalyserDefinition with SunSurface {

  }


  describe("create list of positions") {
    it("should return the surface with the correct lenght") {
      new Solution {

        val list = createListOfPositionsFromSizeOfTheSurface(3)
        list.size should be(9)

      }
    }

    it("should return the surface with no lenght") {
      new Solution {

        val list = createListOfPositionsFromSizeOfTheSurface(0)
        list.size should be(0)

      }
    }

    it("should return the surface with all the positions") {
      new Solution {

        val list = createListOfPositionsFromSizeOfTheSurface(2)

        list should contain(Position(0,0))
        list should contain(Position(0,1))
        list should contain(Position(1,0))
        list should contain(Position(1,1))
        list should not (contain(Position(1,2)))


      }
    }
  }

  describe("valid positions") {

    it("should check all the valid positions") {
      new Solution {

        //val list = createListOfPositionsFromSizeOfTheSurface(2)

        surface(Position(0,0)) should be(true)
        surface(Position(1,0)) should be(true)
        surface(Position(0,1)) should be(true)
        surface(Position(1,1)) should be(true)

        surface(Position(-1,0)) should be(false)
        surface(Position(0,-1)) should be(false)
        surface(Position(-1,-1)) should be(false)
        surface(Position(2,2)) should be(false)
      }
    }
  }

  describe("neighbours") {
    it("should return all the neighbors for a Spot") {
      new Solution {
        val position = Position(1,1)

        val spot = Spot(position)

        spot.neighbors.size should be(8)
      }
    }

    it("should create the neighbors properly") {
      new Solution {
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
    it("should return all the legal neighbors for a central spot") {
      new Solution {
        override val listOfPositions = createListOfPositionsFromSizeOfTheSurface(3)

        val position = Position(1,1)

        val spot = Spot(position)

        spot.legalNeighbors.size should be(8)
      }
    }

    it("should return all the legal neighbors for a limit spot",Tag("wip")) {
      new Solution {
        override val listOfPositions = createListOfPositionsFromSizeOfTheSurface(3)

        val position = Position(0,0)

        val spot = Spot(position)

        //println(spot.legalNeighbors)
        spot.legalNeighbors.size should be(3)
      }
    }

  }
}
