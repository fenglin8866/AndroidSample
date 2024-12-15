package com.xxh.learn.java.daggertest.test4;

import java.util.Set;

import javax.inject.Inject;

public class Bar {
    private Set<String> stringSet;

    @Inject
    Bar(Set<String> strings) {
        stringSet=strings;
        /*assert strings.contains("ABC");
        assert strings.contains("DEF");
        assert strings.contains("GHI");*/
    }

    public Set<String> getStringSet() {
        return stringSet;
    }
}
