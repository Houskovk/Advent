val expenseList = List(1721, 979, 366, 299, 675, 1456)
val sumNeeded = 2020
var finalAmount = 1

for(expense <- expenseList if expenseList.contains(sumNeeded - expense)) finalAmount *= expense

println(finalAmount)