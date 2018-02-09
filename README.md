# Simple KMeans in Scala

## PSEUDOCODE

* generate data
  - dimensions
  - bounds
* select 2 initial centroids
* group remaining points to nearest centroid
* loop to calculate cluster means as centroids & group all points to nearest cluster

## SPEC

### package object variables

define types for the data we are handling.
```
type DataPoint = List[Double]
type DataSet = List[DataPoint]
```

kmeans configuration
```
val runs: Int
val iterations: Int
```

data configuration
```
val dimensions: Int
val pointBounds: Int
val percentPoints: Double

val expectedPoints: Int
```

### KMeans members
methods
```
def generateData: DataSet
def euclideanDistance: Double
def trainKMeans: (Double, Map[DataPoint, DataSet])
 - def createClusters: Map[DataPoint, DataSet]
 - def recalculateCentroids: Map[DataPoint, DataSet]
```
