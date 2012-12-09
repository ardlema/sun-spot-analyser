import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class SunSurfaceTest extends Spec with ShouldMatchers {

  trait SunSurface1 extends SunSurface {

  }

  describe("create list of positions") {
    it("should return the surface with the correct lenght") {
      new SunSurface1 {

        val listOfPositions = createListOfPositionsFromSizeOfTheSurface(3)
        listOfPositions.size should be(9)

      }
    }

    it("should return the surface with no lenght") {
      new SunSurface1 {

        val listOfPositions = createListOfPositionsFromSizeOfTheSurface(0)
        listOfPositions.size should be(0)

      }
    }

    it("should return the surface with all the positions") {
      new SunSurface1 {

        val listOfPositions = createListOfPositionsFromSizeOfTheSurface(2)

        listOfPositions should contain(Position(0,0))
        listOfPositions should contain(Position(0,1))
        listOfPositions should contain(Position(1,0))
        listOfPositions should contain(Position(1,1))
        listOfPositions should not (contain(Position(1,2)))


      }
    }
  }

  describe("valid positions") {

    it("should check all the valid positions") {
      new SunSurface1 {

        val surface = createSurfaceFromSize(2)

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

}
