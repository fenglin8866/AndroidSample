package com.xxh.learn.kotlin.basic.interaction;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import java.util.List;

public interface IBNovel {
    void getRecom(int count, Function1<? super List<String>, Unit> callback);
}
