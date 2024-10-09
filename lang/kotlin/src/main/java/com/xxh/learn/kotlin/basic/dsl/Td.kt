package com.xxh.learn.kotlin.basic.dsl

import com.xxh.learn.kotlin.basic.dsl.HtmlDsl

@HtmlDsl
class Td {
    var content=""
    fun html()="\n\t\t<td>$content</td>"
}