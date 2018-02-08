# Simple KMeans in Scala

## PSEUDOCODE

* generate data
  - dimensions
  - bounds
* select 2 initial centroids
* group remaining points to nearest centroid
  - square distance sqrt((x1-y1)^2 + (xn - yn)^2)
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
```

### KMeans members
methods
```
def generateData: DataSet
def squareDistance: Double
def refineClusters: Map[DataPoint, DataSet]
```
