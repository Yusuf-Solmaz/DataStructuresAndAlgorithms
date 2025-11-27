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

fun bigONFactorial(n: Int){
    if (n == 1){
        println(1)
        return
    }
    for (i in 1..n){
        println(i)
        bigONFactorial(n-1) //recursive func
    }
}

fun calculateFactorial(n: Int): Int{
    if (n == 1 || n == 0){
        return 1
    }else if (n<0){
        throw NumberFormatException("n can not be negative")
    }
    return n.times(calculateFactorial(n -1))
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

    println("O(n!)")
    bigONFactorial(8) // O(n!)

    println("Calculate Factorial")
    println(calculateFactorial(5)) // O(n)
}