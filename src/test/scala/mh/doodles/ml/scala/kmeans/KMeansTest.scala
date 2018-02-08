package mh.doodles.ml.scala.kmeans

import org.scalatest.{FlatSpec, Matchers}

class KMeansTest extends FlatSpec with Matchers {
  val kmeans: KMeans = new KMeans()

  "generatePoints" should "return a List of distinct points with length `expectedPoints`" in {
    kmeans.generatePoints.distinct.lengthCompare(expectedPoints) shouldBe 0
  }
  it should "return a non-empty list" in{
    kmeans.generatePoints.nonEmpty shouldBe true
  }
}
