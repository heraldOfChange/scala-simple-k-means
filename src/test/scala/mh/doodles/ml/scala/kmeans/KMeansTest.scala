package mh.doodles.ml.scala.kmeans

import org.scalatest.{ FlatSpec, Matchers }

class KMeansTest extends FlatSpec with Matchers {
  val kmeans: KMeans = new KMeans()

  "generatePoints" should "return a List of distinct points with length `expectedPoints`" in {
    kmeans.generatePoints.distinct.lengthCompare(expectedPoints) shouldBe 0
  }
  it should "return a non-empty list" in {
    kmeans.generatePoints.nonEmpty shouldBe true
  }

  "euclideanDistance" should "work for single dimension changes ie: List(1,2) and List(1,6)" in {
    val sampleData: DataSet = List(List(1.0, 2.0), List(1.0, 6.0))
    kmeans.euclideanDistance(sampleData) shouldBe 4.0
  }
  it should "work for alternating dimension changes ie: List(2,3) and List(6,-6)" in {
    val sampleData: DataSet = List(List(2.0, 3.0), List(6.0, -6.0))
    kmeans.euclideanDistance(sampleData) shouldBe 9.848857801796104
  }

  "refineClusters" should "return a map with count of `kValue` clusters" in {
    kmeans.trainKMeans(kmeans.generatePoints)._2.keySet.size shouldBe kValue
  }
}
