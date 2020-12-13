package day05


fun getMissingNum(input: String) {
    var occupied = input.trim().split("\n")
        .map { el -> el.trim() }
        .filter { el -> el.isNotBlank() }
        .map { el -> parseSeat(el) }

    for(i in 0..1024) {
        if(!occupied.contains(i)){
            println(i);
        }
    }
}


fun main(args: Array<String>) {
    getMissingNum(input);
}

