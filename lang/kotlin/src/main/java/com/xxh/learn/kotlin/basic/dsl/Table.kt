package com.xxh.learn.kotlin.basic.dsl

@HtmlDsl
class Table {
    private val children=ArrayList<Tr>()

    fun tr(block: Tr.()->Unit){
        val tr= Tr()
        tr.block()
        children.add(tr)
    }
    fun html():String{
        val builder=StringBuilder()
        builder.append("<table>")
        for (childTag in children){
            builder.append(childTag.html())
        }
        builder.append("\n</table>")
        return builder.toString()
    }
}