package day07


fun getTotalBags(map: Map<String, List<String>>, colour: String): Int {
    if(map.containsKey(colour)) {
        return map.get(colour)!!.map {1+getTotalBags(map, it) }.sum();
    }
    return 0;

}

fun main(args: Array<String>) {
    System.out.println(getTotalBags(parse(input), "shinygold"));
}