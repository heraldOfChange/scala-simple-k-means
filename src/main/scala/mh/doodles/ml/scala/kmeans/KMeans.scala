package mh.doodles.ml.scala.kmeans

import scala.annotation.tailrec
import scala.util.Random

class KMeans {

  /**
   * method used to generate some training data
   *
   * @return a `DataSet` or a `List[List[Double]]`
   */
  def generatePoints: DataSet = {
    @tailrec
    def generatePoint(ds: DataSet = List.empty): DataSet =
      if (ds.lengthCompare(expectedPoints) != 0)
        generatePoint((List.fill(dimensions) {
          (Random.nextDouble * (pointBounds * 2)) - pointBounds
        } :: ds).distinct)
      else ds

    generatePoint()
  }

  /**
   * method used to calculate the distance of some `DataPoints`
   *
   * @param dataSet a list of `DataPoints` to calculate the distance on
   * @return a non-negative `DataPoint` average distance as a Double
   */
  def euclideanDistance(dataSet: DataSet): Double =
    Math.sqrt {
      dataSet.transpose.map { dimensionValues =>
        Math.pow(dimensionValues.reduceLeft(_ - _), 2)
      }.sum
    }

  /**
   * method that takes two initial centroids and calculates the best possible cluster over iterations
   *
   * @param trainingData the `DataSet` containing `DataPoints` to run KMeans on
   * @return the most accurate cluster found using the KMeans approach
   */
  def trainKMeans(trainingData: DataSet): (Double, Map[DataPoint, DataSet]) = {
    def createClusters(centroids: DataSet): Map[DataPoint, DataSet] =
      trainingData.map { dataPoint =>
        centroids.reduceLeft { (a, b) =>
          if (euclideanDistance(List(a, dataPoint)) < euclideanDistance(List(b, dataPoint))) a else b
        } -> dataPoint
      }.groupBy(_._1).map(x => (x._1, x._2.map(_._2)))

    @tailrec
    def recalculateCentroids(clusters: Map[DataPoint, DataSet], iterations: Int): Map[DataPoint, DataSet] = {
      if (iterations > 0) {
        val result: DataSet = clusters.map { cluster =>
          val transposed: List[List[Double]] = cluster._2.transpose
          transposed.map(clusterAvg => clusterAvg.sum / cluster._2.size)
        }.toList
        recalculateCentroids(createClusters(result), iterations - 1)
      } else clusters
    }

    (for (r <- 0 to runs) yield {
      val rand = new Random(r)
      val initialCentroids: DataSet = rand.shuffle(trainingData).take(2)
      val initialClusters: Map[DataPoint, DataSet] = createClusters(initialCentroids)
      recalculateCentroids(initialClusters, iterations)
    }).map { trainingInstance =>
      val clusterDistribution = trainingInstance.mapValues(euclideanDistance).values.toList
      val clusterDistributionAvg = clusterDistribution.sum / clusterDistribution.size
      (clusterDistributionAvg, trainingInstance)
    }.reduceLeft((a, b) => if (a._1 < b._1) a else b)
  }
}
