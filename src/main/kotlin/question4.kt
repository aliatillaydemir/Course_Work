

fun main(args: Array<String>) {
    val str = "acc?7??sss?3rr1?????5"
    println(questionsMarks(str))
}


fun questionsMarks(str: String): String {

    val regexExpres = """.*\?.*\?.*\?.*"""
    var i = 0

    var answerResult = "true"        //first initial...
    var pairs = false
    var initValue:Int
    var sum:Int
    var restStr:String

    while (i<str.length && answerResult == "true"){

        if (str[i].isDigit()){
            initValue = str[i].toString().toInt()
            sum = 10-initValue
            restStr = str.substring(i+1)

            if (restStr.contains(sum.toString())){
                pairs = true
                val regex = (regexExpres+sum.toString()).toRegex()
                if (!regex.containsMatchIn(restStr)){
                    answerResult = "false"
                }
            }
        }
        i+=1
    }
    if (!pairs){
        answerResult="false"
    }
    return answerResult

}





