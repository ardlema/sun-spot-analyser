
class SunTemperatureCalculator(temperatures: List[Int]) extends SunSurfaceResolver {

  //val sun = createSun(listOfPositions, temperatures)

  def createSun(positions: List[Position], temps: List[Int]): List[Spot] = {



    //for (position <- positions) yield Spot(Position(position.x, position.y), temps)

    List()

  }

  def obtainSunTemperatureFromSpots(spots: List[Spot]): List[Spot] = {

    def totalHeatOfTheNeighbors(listOfNeighbors: List[Spot]) {
      listOfNeighbors.foldLeft(0)(_ + _.heat)
    }

    /*  for (spot <- spots ;
           neighbors <- spot.legalNeighbors;
           totalHeat = totalHeatOfTheNeighbors(neighbors)
        ) yield Spot(Position(spot._1, totalHeat))*/

    List()


  }


}
