import scala.collection.mutable.ArrayBuffer

val partialMap = Array(
  Array('.','.','#','#','.','.','.','.','.','.','.'),
  Array('#','.','.','.','#','.','.','.','#','.','.'),
  Array('.','#','.','.','.','.','#','.','.','#','.'),
  Array('.','.','#','.','#','.','.','.','#','.','#'),
  Array('.','#','.','.','.','#','#','.','.','#','.'),
  Array('.','.','#','.','#','#','.','.','.','.','.'),
  Array('.','#','.','#','.','#','.','.','.','.','#'),
  Array('.','#','.','.','.','.','.','.','.','.','#'),
  Array('#','.','#','#','.','.','.','#','.','.','.'),
  Array('#','.','.','.','#','#','.','.','.','.','#'),
  Array('.','#','.','.','#','.','.','.','#','.','#')
)

def extendMap(partial: Array[Array[Char]]) = {
  val finalMap = ArrayBuffer[Array[Char]]()
  for (rowIndex <- partial.indices) {
    val elem = partial(rowIndex).concat(partialMap(rowIndex))
    finalMap.append(elem)
  }
  finalMap
}

def toboggan = {
  var row = 0
  var column = 0
  var tobogganMap = partialMap
  var treeCount = 0

  while (row <= tobogganMap.length-1) {
    if(tobogganMap(row)(column).equals('#')) treeCount += 1
    row += 1
    column += 3

    tobogganMap = if(column > tobogganMap(0).length-1) extendMap(tobogganMap).toArray else tobogganMap
  }
  treeCount
}

println("Trees found: " + toboggan)