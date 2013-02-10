
trait SunSpotAnalyserDefinition {

  type Surface = Position => Boolean

  val surface: Surface

  def createSurface(positions: Seq[Position]): Surface = { position: Position => validPosition(position, positions)}

  def validPosition(p: Position, positions: Seq[Position]): Boolean = {"Positions: "+positions
    positions.contains(p)
  }

  case class Position(x: Int, y: Int) {
    def move(newx: Int, newy: Int) = copy(x = x + newx, y = y + newy)
  }

  case class Spot(position: Position, heat: Int = 0) {

    def upleft = changePosition(-1,-1)

    def up = changePosition(-1,0)

    def upright = changePosition(-1,1)

    def left = changePosition(0,-1)

    def right = changePosition(0,1)

    def downleft = changePosition(1,-1)

    def down = changePosition(1,0)

    def downright = changePosition(1,1)

    def changePosition(newX: Int, newY: Int) = Spot(position.move(newX, newY),heat)

    def neighbors: List[Spot] = upleft :: up :: upright :: left :: right :: downleft :: down :: downright :: List()

    def legalNeighbors: List[Spot] = {
      for (neighbor <- neighbors if isLegal(neighbor.position)) yield neighbor
    }

    def isLegal(neighbor: Position) = surface(neighbor)


  }







}
