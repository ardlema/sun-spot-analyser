import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class SunSurfaceResolverTest extends Spec with ShouldMatchers {

  trait SunSurface1 extends SunSurfaceResolver {

  }

  describe("number of results") {
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

  }


}
