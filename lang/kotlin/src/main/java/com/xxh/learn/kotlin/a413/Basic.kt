package com.xxh.learn.kotlin.a413

class Basic {

}

inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}

inline fun <T> T.also(block: (T) -> Unit): T {
    block(this)
    return this
}

inline fun <R, T> with(re: T, block: (T) -> R): R {
    return block(re)
}

inline fun <R, T> with2(re: T, block: T.() -> R): R {
    return re.block()
}

inline fun <T, R> T.let(block: (T) -> R): R {
    return block(this)
}

inline fun <R> run(block: () -> R): R {
    return block()
}

inline fun <R, T> T.run(block: T.() -> R): R {
    return block()
}


