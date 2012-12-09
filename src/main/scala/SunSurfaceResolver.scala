
class SunSurfaceResolver(theNumberOfResults: Int = 0, theSizeOfTheGrid: Int = 0, listOfSpaceDelimitedNumbers: List[Int] = List())
  extends SunSurface{

  val surface = createSurfaceFromSize(theSizeOfTheGrid)

  def getResultsAsList(theNumberOfResults: Int, theSizeOfTheGrid: Int, listOfSpaceDelimitedNumbers: List[Int]): List[Spot] = {

       List()
  }
}
