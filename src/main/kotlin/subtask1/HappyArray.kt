package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {

        val happyArray = sadArray.toMutableList()
        var countElement = 1

        while (countElement < happyArray.size - 1) {

            if (happyArray.size == 2) break

            if (countElement == 0) countElement = 1

            if ((happyArray[countElement - 1] + happyArray[countElement + 1]) < happyArray[countElement]) {
                happyArray.removeAt(countElement)
                countElement--
            } else {
                countElement++
            }
        }

        return happyArray.toIntArray()
    }
}
