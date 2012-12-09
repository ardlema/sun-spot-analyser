
case class Position(x: Int, y: Int) {
  def move(newx: Int, newy: Int) = copy(x = x + newx, y = y + newy)
}
