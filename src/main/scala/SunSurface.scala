
trait SunSurface {


  type Surface = Position => Boolean

  type Sun = List[Spot]

  val surface = createSurface(List(Position(1,1),Position(0,0)))

  def createSurface(positions: List[(Position)]): Surface = { position: Position => validPosition(position, positions)}

  def validPosition(p: Position, positions: List[Position]): Boolean = positions.contains(p)


}
