package mastermind

import javax.crypto.SecretKey

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    var rightPosition:Int  = 0
    var wrongPosition:Int  = 0
    var unmatchedGuess = emptyList<Char>().toMutableList()
    var unmatchedSecret = emptyList<Char>().toMutableList()


    for (i in 0 .. 3) {

        if (secret[i] == guess[i]){
            rightPosition++
        }
        else {
            unmatchedGuess.add(guess[i])
            unmatchedSecret.add(secret[i])
        }

    }

    for (guess in unmatchedGuess) {

       if (unmatchedSecret.remove(guess)){
           wrongPosition++
       }
    }


    return Evaluation(rightPosition,wrongPosition)
}
