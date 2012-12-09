
trait SunSurface {

  case class Position(x: Int, y: Int) {
    def move(newx: Int, newy: Int) = copy(x = x + newx, y = y + newy)
  }

  type Surface = Position => Boolean


  case class Spot(position: Position) {

    def changePosition(newX: Int, newY: Int) = Spot(position.move(newX, newY))

    def upleft = changePosition(-1,-1)

    def up = changePosition(-1,0)

    def upright = changePosition(-1,1)

    def left = changePosition(0,-1)

    def right = changePosition(0,1)

    def downleft = changePosition(1,-1)

    def down = changePosition(1,0)

    def downright = changePosition(1,1)

    def neighbors: List[Spot] = upleft :: up :: upright :: left :: right :: downleft :: down :: downright :: List()


  }


}
