package com.xxh.learn.kotlin.coroutines

/*fun main() {
    //getType<Int>()
    FlowOper.test()
}*/


 inline fun <reified T> getType() {
    println(T::class)
}

//class java.lang.Integer (Kotlin reflection is not available)

inline fun <reified T> getType(a:String , b :String ){
    val s="nihao you shen wen yao chu li ma bu yong mei shi hao de ke yi le " +
            "ni xian qu wan ba yi hui zai hui lai hao hao you " +
            "meiju fanxing fan she zhujie hai hao you she mei shi yao chu li you ni shen me shi " +
            "zhidaole xixi haha Content home bin java Spaces main Word Book " +
            "readme lai xie zuo ye 无法识别 您的 logitech 设备， 只有识别后才能使用 如果你的键盘能正常使用，而您链接到电脑的另一个usb输入设备不是键盘，则可以退出此应用" +
            "无法识别您的设备，只有识别你的设备后才能使用，如果你的键盘能正常使用，而你链接到电脑的另一个usb输入设备不是键盘则可以退出此应用 " +
            "无法识别到你的设备 如果识别到你的设备，在菜单中显示蓝牙 您是立即安装更新，还是今晚再试 " +
            "未来在哪里我终是忍不住去猜  三模两系统无线蓝牙机械键盘 使用说明书 感受设计模式演变过asdjasdjasddaasddssd" +
            "addias Stream 天下的人们都是说你不仁"
}

