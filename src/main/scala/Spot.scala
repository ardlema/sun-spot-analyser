case class Spot(position: Position, heat: Int = 0) extends SunSurface {

  def changePosition(newX: Int, newY: Int) = Spot(position.move(newX, newY),heat)

  def upleft = changePosition(-1,-1)

  def up = changePosition(-1,0)

  def upright = changePosition(-1,1)

  def left = changePosition(0,-1)

  def right = changePosition(0,1)

  def downleft = changePosition(1,-1)

  def down = changePosition(1,0)

  def downright = changePosition(1,1)

  def isLegal = surface(position)

  def neighbors: List[Spot] = upleft :: up :: upright :: left :: right :: downleft :: down :: downright :: List()

  def legalNeighbors: List[Spot] = {
    for (neighbor <- neighbors if neighbor.isLegal) yield neighbor
  }


}
