//TODO: Change this trait to an Object an implement and apply method
// with variadic syntax that allows the user to pass in the list of
// temperatures (we can then infer the list of positions from this value)

trait SunSurfaceResolver extends SunSurface {
  val temperatures = List(0,2,1,2)

  lazy val sun = createSun(listOfPositions, temperatures)

  def createSun(positions: Seq[Position], temps: List[Int]): Seq[Spot] = {
    val spotsWithoutTemps = for (position <- positions) yield Spot(Position(position.x, position.y), 0)
    for (index <- 0 until temps.size) yield Spot(spotsWithoutTemps(index).position, temps(index))
  }

  def totalHeatOfTheNeighbors(listOfNeighbors: Seq[Spot]): Int = listOfNeighbors.foldLeft(0)(_ + getHeatFromSpot(_))

  def obtainSunTemperatureFromSpots: Seq[Spot] =
    for (spot <- sun) yield Spot(spot.position, spot.heat + totalHeatOfTheNeighbors(spot.legalNeighbors))

  def getHeatFromSpot(spot: Spot): Int = sun.find(s => s.position == spot.position).head.heat

  lazy val spotsOrderByHeat = obtainSunTemperatureFromSpots.sortBy(- _.heat)
}
