
lateinit var str: String
lateinit var result: String

fun main(args: Array<String>){

    str = "u__hello_world123"
    result = validation(str)
    println(result)
}

fun validation(str: String):String {

    val wordLength = str.length in 4..25  //boolean 1
    val firstLetter = str.first().isLetter()  // boolean 2
    val letNumUnderscore = isContain(str)     // boolean 3
    val underScore = str.last().toString() =="_" //boolean 4

    return if(wordLength && firstLetter && letNumUnderscore && !underScore){
        "true"
    }else{
        "false"
    }

}

private fun isContain(str: String): Boolean {
        var isCharacter = false
        val characters = ('0'..'9') + ('a'..'z') + ('A'..'Z') + ('_')  //in ascii a-z -> 97-122 A-Z -> 65-90
        val control = str.filter { chr ->  //filtering
            chr in characters
        }

        if(str == control)
            isCharacter = true

        return isCharacter
}

