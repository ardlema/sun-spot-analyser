import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class SunSurfaceTest extends Spec with ShouldMatchers {

  trait SunSurface1 extends SunSurface {

  }

  describe("surface") {
    it("should create the surface") {
      new SunSurface1 {

        def isLegal = surface(Position(1,1))
        assert(isLegal)


      }
    }
  }


}
