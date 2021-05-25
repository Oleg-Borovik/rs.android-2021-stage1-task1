package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val bracketRound = listOf('(', ')')
        val bracketSquare = listOf('[', ']')
        val bracketTriangle = listOf('<', '>')

        val result = mutableListOf<String>()

        inputString.toCharArray().forEachIndexed { index, symbol ->
            when (symbol) {
                '(' -> result.add(getStingInBracket(inputString.substring(index + 1), bracketRound))
                '[' -> result.add(getStingInBracket(inputString.substring(index + 1), bracketSquare))
                '<' -> result.add(getStingInBracket(inputString.substring(index + 1), bracketTriangle))
            }
        }

        return result.toTypedArray()
    }

    private fun getStingInBracket(str: String, blanket: List<Char>): String {

        val buffer = StringBuffer()
        var countRepeat = 0

        for (index in str.indices) {
            if (str[index] == blanket[0]) countRepeat++
            if (str[index] == blanket[1]) {
                if (countRepeat == 0)
                    return buffer.toString()
                else
                    countRepeat--
            }
            buffer.append(str[index])
        }

        buffer.setLength(buffer.length - 1)

        return buffer.toString()
    }

}
