package com.xxh.learn.kotlin.basic.dsl

class Test {
}

fun table(block: Table.()->Unit):String{
    val table= Table()
    table.block()
    return table.html()
}

fun main() {
    val html = table {
        tr {
            td {
                "Apple"
            }
            td {
                "Orange"
            }
            td {
                "Grape"
            }
        }
        tr {
            td {
                "Pear"
            }
            td {
                "Banana"
            }
            td {
                "Watermelon"
            }
        }
    }
    println(html)

   /* ————————————————
    版权声明：本文为CSDN博主「Mr YiRan」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/ChenYiRan123456/article/details/128744279*/


}