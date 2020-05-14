val palavras = arrayListOf(
    "BASTÃO",
    "BOLA",
    "ENERGÉTICO",
    "HALTER",
    "IOGA",
    "LANCHONETE",
    "LUVA",
    "MOCHILA",
    "SUPINO",
    "TAEKWONDO",
    "TATAME",
    "TOALHA",
    "TOUCA",
    "ÓCULOS","RATO","CUBO"
)

val cacaPalavras = arrayOf(
    arrayOf("T", "T", "E", "B", "U", "E", "T", "Ó", "L", "C"),
    arrayOf("A", "M", "U", "A", "L", "N", "O", "C", "A", "U"),
    arrayOf("E", "B", "I", "S", "U", "E", "A", "U", "N", "B"),
    arrayOf("K", "O", "O", "T", "V", "R", "L", "L", "C", "O"),
    arrayOf("W", "L", "G", "Ã", "A", "G", "H", "O", "H", "T"),
    arrayOf("O", "A", "A", "O", "I", "É", "A", "S", "O", "A"),
    arrayOf("N", "D", "H", "A", "L", "T", "E", "R", "N", "T"),
    arrayOf("D", "M", "O", "C", "H", "I", "L", "A", "E", "A"),
    arrayOf("O", "T", "T", "O", "U", "C", "A", "T", "T", "M"),
    arrayOf("S", "U", "P", "I", "N", "O", "R", "O", "E", "E")
)

fun main() {

    // 4 movimentos procurar
    // linha a linha direita esq -> esq direita
    // linha e descer a coluna inteira -> linha e subir a coluna inteira
    // linha e coluna
    // linha e descer linha -1 coluna +1

    linhaALinha()
    linhaColunaCimaBaixo()
    linhaColunaBaixoCima()

    println("Achei todas ?: ${palavras.size == 0}")


}

fun linhaALinha() {
    for (i in 0..9) {
        var concat = ""
        for (j in 0..9) {
            concat += cacaPalavras[i][j]
            procuraLinhaHorizontalEsqDir(concat)
        }
    }

    for (i in 0..9) {
        var concat = ""
        for (j in 0..9) {
            concat += cacaPalavras[i][j]
            procuraLinhaHorizontalDirEsq(concat)
        }
    }
}

fun linhaColunaCimaBaixo(){
    for(j in 0..9){
        var concat = ""
        for(i in 0..9){
            concat += cacaPalavras[i][j]
            procuraColumaCimaBaixoaPalavra(concat)
        }
    }
}

fun linhaColunaBaixoCima(){
    for(j in 9 downTo 0){
        var concat = ""
        for(i in 9 downTo 0){
            concat += cacaPalavras[i][j]
            procuraColumaBaixoCimaPalavra(concat)
        }
    }
}

fun procuraColumaBaixoCimaPalavra(str : String) {

    val encontradoCBP = mutableListOf<String>()
    palavras.forEach {
        if (str.reversed().contains(it)) {
            encontradoCBP.add(it)
            println("Encontrado: $it")

        }
    }
    encontradoCBP.forEach {
        palavras.remove(it)
    }
}


fun procuraColumaCimaBaixoaPalavra(str : String) {
    val encontradoCBP = mutableListOf<String>()
    palavras.forEach {
        if (str.contains(it)) {
            encontradoCBP.add(it)
            println("Encontrado: $it")

        }
    }
    encontradoCBP.forEach {
        palavras.remove(it)
    }
}

fun procuraLinhaHorizontalEsqDir(str: String) {
    val encontradoHED = mutableListOf<String>()
    palavras.forEach {
        if (str.contains(it)) {
            encontradoHED.add(it)
            println("Encontrado: $it")

        }
    }
    encontradoHED.forEach {
        palavras.remove(it)
    }
}

fun procuraLinhaHorizontalDirEsq(str: String) {
    val encontradoHDE = mutableListOf<String>()
    palavras.forEach {
        if (str.contains(it.reversed())) {
            encontradoHDE.add(it)
            println("100 % match $it")

        }
    }
    encontradoHDE.forEach {
        palavras.remove(it)
    }
}