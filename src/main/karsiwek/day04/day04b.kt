package day04

var validInput: String = """
    pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980
    hcl:#623a2f

    eyr:2029 ecl:blu cid:129 byr:1989
    iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm

    hcl:#888785
    hgt:164cm byr:2001 iyr:2015 cid:88
    pid:545766238 ecl:hzl
    eyr:2022

    iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719
""".trimIndent()

fun isPassportValidWithDataCheck(passport: String) : Boolean{
    return passport.split(("\n"))
        .flatMap { row -> row.split(" ") }
        .map { elem -> elem.trim() }
        .filter { elem -> elem.isNotEmpty() }
        .filter { elem -> hasValidRules(elem) }
        .map { elem -> elem.split(":")[0] }
        .containsAll(validFields);


}

fun hasValidRules(elem: String) : Boolean{
    val key = elem.split(":")[0];
    var value = elem.split(":")[1];

    if (key == "byr") {
        return value.toInt()>=1920 && value.toInt()<=2002;
    } else if (key == "iyr") {
        return value.toInt()>=2010 && value.toInt()<=2020;
    } else if (key == "eyr") {
        return value.toInt()>=2020 && value.toInt()<=2030;
    } else if (key == "hgt") {
        println(value)
        if(value.subSequence(value.length-2, value.length) == "cm"){
            value = value.substring(0, value.length-2);
            return value.toInt()>=150 && value.toInt()<=193;
        } else if (value.subSequence(value.length-2, value.length) == "in"){
            value = value.substring(0, value.length-2);
            return value.toInt()>=59 && value.toInt()<=76;
        }
    } else if (key == "hcl") {
        return value.matches("#[0-9a-f]{6}".toRegex());
    } else if (key == "ecl") {
        return "amb blu brn gry grn hzl oth".split(" ").contains(value);
    } else if (key == "pid") {
        return value.matches("[0-9]{9}".toRegex());
    }
    return false;

}

fun solveWithCheck(passports: String): Int {
    return passports
        .split("\n\n")
        .map { passport -> isPassportValidWithDataCheck(passport) }
        .filter { elem -> elem }
        .size;
}


fun main(args: Array<String>) {
    System.out.println(solveWithCheck(input));
}
