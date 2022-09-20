
fun main(args: Array<String>){
    var numb : Int = 0
    println(firstFactorial(numb))

}

private fun firstFactorial(num: Int) = (2..num).fold(1, Int::times) //single Line

/**
fun firstFactorial(num: Int): Int {  //recursive function is the most effective way.

    return if(num == 1 || num ==0){  if the number is 0 or 1, the result is 1.
        1
    }else{
        num * firstFactorial(num - 1) //recursion
    }

}
*/