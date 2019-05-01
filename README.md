# KMeans Algorithm
 
generate data
  - dimensions
  - bounds
* select K=2 initial centroids
* group remaining points to nearest centroid
* loop to calculate cluster means as centroids & group all points to nearest cluster

### Define types for the data we are handling.
```
type DataPoint = List[Double]
type DataSet = List[DataPoint]
```

### mh/doodles/ml/scala/kmeans/package.scala configuration
```
// KMeans configuration
val kCount: Int
val runs: Int
val iterations: Int

// Data configuration
val dimensions: Int
val pointBounds: Int
val percentPoints: Double

val expectedPoints: Int
```

### mh/doodles/ml/scala/kmeans/KMeans.scala members
```
def generateData: DataSet
def euclideanDistance: Double
def trainKMeans: (Double, Map[DataPoint, DataSet])
 - def createClusters: Map[DataPoint, DataSet]
 - def recalculateCentroids: Map[DataPoint, DataSet]
```
