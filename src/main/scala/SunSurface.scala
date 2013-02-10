
trait SunSurface extends SunSpotAnalyserDefinition {

  lazy val surface: Surface = createSurface(listOfPositions)

  val listOfPositions = createListOfPositionsFromSizeOfTheSurface(2)


  def createListOfPositionsFromSizeOfTheSurface(size: Int): Seq[Position] = {
    for(
      x <- (0 to size-1);
      y <- (0 to size-1)) yield Position(x,y)
  }

  def getResultsAsList(theNumberOfResults: Int, theSizeOfTheGrid: Int, listOfSpaceDelimitedNumbers: List[Int]): List[Spot] = {

    List()
  }


}
