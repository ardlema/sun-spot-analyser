
class SunSurfaceResolver(theNumberOfResults: Int = 0, theSizeOfTheGrid: Int = 0, listOfSpaceDelimitedNumbers: List[Int] = List())
  extends SunSurface{

  val listOfPositions = createListOfPositionsFromSizeOfTheSurface(theSizeOfTheGrid)

  val surface = createSurface(listOfPositions)

  def createListOfPositionsFromSizeOfTheSurface(size: Int): Seq[Position] = {
    for(
      x <- (0 to size-1);
      y <- (0 to size-1)) yield Position(x,y)
  }

  def getResultsAsList(theNumberOfResults: Int, theSizeOfTheGrid: Int, listOfSpaceDelimitedNumbers: List[Int]): List[Spot] = {

       List()
  }
}
