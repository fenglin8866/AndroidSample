package com.xxh.summary.log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LogSaveViewModel : ViewModel() {
    fun getLogInfo(): Unit {
        viewModelScope.launch {

            /*withContext(Dispatchers.IO) {
                var mLogcatProc: Process? = null;
                var reader: BufferedReader? = null;
                try {
                    *//*
                     //第一个是Logcat ，也就是我们想要获取的log日志
                     //第二个是 -s 也就是表示过滤的意思
                     //第三个就是 我们要过滤的类型 W表示warm ，我们也可以换成 D ：debug， I：info，E：error等等
                     *//*
                    val runing = arrayOf("1", "2", "3")
                    Runtime.getRuntime().exec(runing)
                    reader = BufferedReader(InputStreamReader(mLogcatProc?.getInputStream()));
                    var line: String
                    while ((line = reader.readLine()) != null) {
                        if (line.indexOf("this is a test") > 0) {
                            //logcat打印信息在这里可以监听到
                            // 使用looper 把给界面一个显示
                            *//*Looper.prepare();
                            Toast.makeText(this, "监听到log信息", Toast.LENGTH_SHORT).show();
                            Looper.loop();*//*
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace();
                }
            }*/
        }
    }

    /*

签名者 1
类型: X.509
版本: 3
序列号: 0x85bdc271e316566a
主题: EMAILADDRESS=nubia@nubia.com.cn, CN=nubia, OU=nubia, O=nubia, L=Shenzhen, ST=GuangDong, C=CN
有效期始: Wed Dec 05 09:23:46 GMT+08:00 2012
有效期至: Sun Apr 22 09:23:46 GMT+08:00 2040
公钥类型: RSA
指数: 3
模数大小（位）: 2048
模数: 27536460264629326938365074806314739283791718855219306067413244813423487653539640904924422358641317195077949247248335518440307131499029283394883976637019853190491012589126985420757678943552384952983672539246060903157022373938052896640956081696346741721669048509605420207636308249162954355011000007251087939931488447892698665335911986998193349229896560682269778793231314376578164602854643214826573049001874085264900402869659576732394821195571364165983995404929699297890427896522963175300389529841082479236572859545933104573479995876769413698201753670611067503461104695442709098480324788865822851975121333178676952209093
签名算法: SHA1withRSA
签名 OID: 1.2.840.113549.1.1.5
MD5 签名: EB 17 8D F4 85 2F 1A 13 12 5F 48 E9 5E 6D 38 F1
SHA-1 签名: 22 F5 F7 AC 77 6B 7B DF 7F 83 67 F3 2B 81 0B 81 4B 4E 1A 31
SHA-256 签名: BD 94 12 6D 9A C1 A4 E5 F1 01 7B 70 F0 41 4C 04 0A B7 80 0C 78 1E 60 AE 45 2A 33 C7 10 80 CD E6



     */
}