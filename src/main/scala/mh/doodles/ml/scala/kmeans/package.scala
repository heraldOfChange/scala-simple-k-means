package mh.doodles.ml.scala

package object kmeans {
  // type definition
  type DataPoint = List[Double]
  type DataSet = List[DataPoint]

  // KMeans configuration
  val runs: Int = 3
  val iterations: Int = 100

  // Data configuration
  val dimensions: Int = 2
  val pointBounds: Int = 10
  val percentPoints: Double = 0.1

  val expectedPoints: Int = (percentPoints * Math.pow(pointBounds + 1, dimensions)).toInt // expected number of generated points
}
