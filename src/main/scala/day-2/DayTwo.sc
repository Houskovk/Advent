import scala.collection.mutable.ArrayBuffer

val corruptedData = List("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")

val deconstructedList = ArrayBuffer[Array[String]]()

for(data <- corruptedData) deconstructedList += data.split(": ")

def decodePassword(policy: String, password: String): Boolean = {
  val indexOne = policy.indexOf('-')
  val indexTwo = policy.indexOf(' ')
  val min = policy.substring(0,indexOne).toInt
  val max = policy.substring(indexOne+1,indexTwo).toInt
  val character = policy.charAt(indexTwo+1)

  password.count(_ == character) >= min && password.count(_ == character) <= max
}

var passwordCount = 0

for (row <- deconstructedList.indices) {
  val policy = deconstructedList(row)(0)
  val password = deconstructedList(row)(1)

  if(decodePassword(policy, password)) passwordCount += 1
}

println(passwordCount)