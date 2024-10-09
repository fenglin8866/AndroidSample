package com.xxh.learn.kotlin.basic.interaction;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ANovel implements IANovel {
    @Override
    public void getRecom(int count, @NotNull Function1<? super List<String>, Unit> callback) {

    }
}
