import org.scalatest.{Tag, FunSpec}
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class SunSurfaceResolverTest extends FunSpec with ShouldMatchers {

  trait SunSurface1 extends SunSurfaceResolver {

  }

  describe("create the Sun") {
    it("should create the Sun with heats values") {
      new SunSurface1 {

        override val temperatures = List(1,2,5,3)

        val spot00 = sun(0)

        spot00.position should be(Position(0,0))
        spot00.heat should be(1)

        val spot01 = sun(1)

        spot01.position should be(Position(0,1))
        spot01.heat should be(2)

        val spot10 = sun(2)

        spot10.position should be(Position(1,0))
        spot10.heat should be(5)

        val spot11 = sun(3)

        spot11.position should be(Position(1,1))
        spot11.heat should be(3)

      }
    }
  }

  describe("obtain total heat of the neighbors") {
    it("should return the proper heat for a neighbor") {
      new SunSurface1 {
        override val listOfPositions = createListOfPositionsFromSizeOfTheSurface(3)

        val position = Position(2,1)

        val spot = Spot(position)

        spot.legalNeighbors.size should be(5)
      }
    }

    it("should get the heat of a spot") {
      new SunSurface1 {
        override val listOfPositions = createListOfPositionsFromSizeOfTheSurface(3)

        override val temperatures = List(3,1,2,4,5,2,4,0,1)

        val totalHeat00 = getHeatFromSpot(sun(0))
        val totalHeat01 = getHeatFromSpot(sun(1))
        val totalHeat02 = getHeatFromSpot(sun(2))
        val totalHeat10 = getHeatFromSpot(sun(3))
        val totalHeat11 = getHeatFromSpot(sun(4))
        val totalHeat12 = getHeatFromSpot(sun(5))
        val totalHeat20 = getHeatFromSpot(sun(6))
        val totalHeat21 = getHeatFromSpot(sun(7))
        val totalHeat22 = getHeatFromSpot(sun(8))

        totalHeat00 should be(3)
        totalHeat01 should be(1)
        totalHeat02 should be(2)
        totalHeat10 should be(4)
        totalHeat11 should be(5)
        totalHeat12 should be(2)
        totalHeat20 should be(4)
        totalHeat21 should be(0)
        totalHeat22 should be(1)

      }
    }

    it("should work out the total heat of the neighbors",Tag("wip")) {
      new SunSurface1 {
        override val listOfPositions = createListOfPositionsFromSizeOfTheSurface(3)

        override val temperatures = List(3,1,2,4,5,2,4,0,1)

        val totalHeat00 = totalHeatOfTheNeighbors(sun(0).legalNeighbors)

        totalHeat00 should be(10)

      }
    }
  }

  describe("obtain the sun temperatures") {
    it("should work out the temperatures of the sun") {
      new SunSurface1 {

        override val listOfPositions = createListOfPositionsFromSizeOfTheSurface(3)

        override val temperatures = List(3,1,2,4,5,2,4,0,1)

        val sunTemperatures = obtainSunTemperatureFromSpots

        val spot00 = sunTemperatures(0)
        spot00.heat should be(13)

        val spot01 = sunTemperatures(1)

        spot01.heat should be(17)

        val spot02 = sunTemperatures(2)

        spot02.heat should be(10)

        val spot10 = sunTemperatures(3)

        spot10.heat should be(17)

        val spot11 = sunTemperatures(4)

        spot11.heat should be(22)

        val spot12 = sunTemperatures(5)

        spot12.heat should be(11)

        val spot20 = sunTemperatures(6)

        spot20.heat should be(13)

        val spot21 = sunTemperatures(7)

        spot21.heat should be(16)

        val spot22 = sunTemperatures(8)

        spot22.heat should be(8)

      }
    }


    it("should order by heat the temperatures of the sun", Tag("wip")) {
      new SunSurface1 {
        override val listOfPositions = createListOfPositionsFromSizeOfTheSurface(3)

        override val temperatures = List(3,1,2,4,5,2,4,0,1)

        val orderSpots = spotsOrderByHeat

        orderSpots(0) should be(Spot(Position(1,1),22))
        orderSpots(1) should be(Spot(Position(0,1),17))
        orderSpots(2) should be(Spot(Position(1,0),17))
        orderSpots(3) should be(Spot(Position(2,1),16))
        orderSpots(4) should be(Spot(Position(0,0),13))
        orderSpots(5) should be(Spot(Position(2,0),13))
        orderSpots(6) should be(Spot(Position(1,2),11))
        orderSpots(7) should be(Spot(Position(0,2),10))
        orderSpots(8) should be(Spot(Position(2,2),8))

      }
    }
  }

  /*describe("number of results") {
    it("shouldn't return results") {
      new SunSurface1 {

        val hottestPoints = getResultsAsList(0, 3, List(4,2,3,2,2,1,3,2,1))

        hottestPoints.size should be(0)

      }
    }

    it("should return 3 results") {
      new SunSurface1 {

        val hottestPoints = getResultsAsList(3, 3, List(4,2,3,2,2,1,3,2,1))

        hottestPoints.size should be(3)

      }
    }

  }*/


}
