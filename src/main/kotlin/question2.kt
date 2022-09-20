
fun main(args: Array<String>){

    val array = arrayOf<Int>(1000000000 ,2000000002 ,2000002000 ,1003400004 ,1005600005)
    println(aVeryBigSum(array))

}

fun aVeryBigSum(array: Array<Int>):Long {  //! double return.
    var sum: Long = 0
    array.forEach {
        sum += it
    }
    return sum
}
