//Big O Notation - Time Complexity

fun bigO1(n: Int){
    println(n)
}

fun bigOn(n: Int){
    for (i in 1..n){
        println(i)
    }
}

fun bigOn2(n: Int){
    for (i in 1..n){
        for (j in 1..n){
            println("$i $j")
        }
    }
}

fun bigOlogn(n: Int){
    var tempN = n
    while (tempN>1){
        tempN = tempN.floorDiv(2)
        println(tempN)
    }
}

fun main(){
    println("O(1)")
    bigO1(8) // O(1)

    println("O(n)")
    bigOn(8) // O(n)

    println("O(n^2)")
    bigOn2(8) // O(n^2)

    println("O(log n)")
    bigOlogn(8) // O(log n)
}