
trait SunSurface {

  type Surface = Position => Boolean


  def createSurface(positions: Seq[Position]): Surface = { position: Position => validPosition(position, positions)}

  def validPosition(p: Position, positions: Seq[Position]): Boolean = positions.contains(p)


}
