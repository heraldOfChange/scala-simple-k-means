package mh.doodles.ml.scala

package object kmeans {
  // type definition
  type DataPoint = List[Double]
  type DataSet = List[DataPoint]

  // KMeans configuration
  val kCount: Int = 2
  val runs: Int = 10
  val iterations: Int = 1000

  // Data configuration
  val dimensions: Int = 2
  val pointBounds: Int = 10
  val percentPoints: Double = 0.1

  // expected number of generated points based on Data configuration
  val expectedPoints: Int = (percentPoints * Math.pow(pointBounds + 1, dimensions)).toInt
}
