package subtask3

class StringParser {


    // TODO: Complete the following function
//    fun main(args: Array<String>){
//        getResult("It's a <simple> [input] (string)")
//        print("as")
//    }

    fun getResult(inputString: String): Array<String> {
        val bracketRound = listOf('(', ')')
        val bracketSquare = listOf('[', ']')
        val braketTriangle = listOf('<', '>')
        val firstBracketArray = listOf('(', '[', '<')
//        val inputString =
        val arraySymbolChar = inputString.toCharArray()
        var result = mutableListOf<String>()
        var buffer: StringBuffer? = null
        var countStart = 0
//        getStingInBracket("asdasd[[]]][][][][]", bracketRound)
        for (i in arraySymbolChar.indices) {
            when (arraySymbolChar[i]) {
                '(' -> result.add(getStingInBracket(inputString.substring(i + 1), bracketRound))
                '[' -> result.add(getStingInBracket(inputString.substring(i + 1), bracketSquare))
                '<' -> result.add(getStingInBracket(inputString.substring(i + 1), braketTriangle))
            }
        }
        return result.toTypedArray()
    }

    fun getStingInBracket(str: String, blanket: List<Char>): String {

        val buffer = StringBuffer()
        var countRepeat = 0

        for (index in str.indices) {
            if (str[index] == blanket[0]) countRepeat++
            if (str[index] == blanket[1]) {
                if (countRepeat == 0)
                    return buffer.toString()
                else countRepeat--
            }
            buffer.append(str[index])
        }
        buffer.setLength(buffer.length - 1)

        return buffer.toString()
    }

}
