
trait SunSurface {


  type Surface = Position => Boolean

  type Sun = List[Spot]

  def createSurfaceFromSize(sizeOfTheSurface: Int): Surface = createSurface(createListOfPositionsFromSizeOfTheSurface(sizeOfTheSurface))

  def createListOfPositionsFromSizeOfTheSurface(size: Int): Seq[Position] = {
       for(
            x <- (0 to size-1);
            y <- (0 to size-1)) yield Position(x,y)
  }

  def createSurface(positions: Seq[Position]): Surface = { position: Position => validPosition(position, positions)}

  def validPosition(p: Position, positions: Seq[Position]): Boolean = positions.contains(p)


}
