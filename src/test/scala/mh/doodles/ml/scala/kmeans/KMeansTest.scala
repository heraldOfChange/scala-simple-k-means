package mh.doodles.ml.scala.kmeans

import org.scalatest.{FlatSpec, Matchers}

class KMeansTest extends FlatSpec with Matchers {
  val kmeans: KMeans = new KMeans()

  "generatePoints" should "return a List of distinct points with length `expectedPoints`" in {
    kmeans.generatePoints.distinct.lengthCompare(expectedPoints) shouldBe 0
  }
  it should "return a non-empty list" in {
    kmeans.generatePoints.nonEmpty shouldBe true
  }

  "euclideanDistance" should "work for single dimension changes ie: List(1,2) and List(1,6)" in {
    val sample1: DataPoint = List(1, 2)
    val sample2: DataPoint = List(1, 6)
    kmeans.euclideanDistance(sample1, sample2) shouldBe 4
  }
  it should "work for alternating dimension changes ie: List(2,3) and List(6,-6)" in {
    val sample1: DataPoint =  List(2, 3)
    val sample2: DataPoint = List(6, -6)
    kmeans.euclideanDistance(sample1, sample2) shouldBe 9.848857801796104
  }
}
