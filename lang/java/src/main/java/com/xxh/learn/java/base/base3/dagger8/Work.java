package com.xxh.learn.java.base.base3.dagger8;


import javax.inject.Inject;
import java.util.Map;

public class Work {

    @Inject
    public Tool tool;

   //  @Inject
   // public Set<Tool> toolSet;

    @Inject
    public Map<String,Tool> toolMap;

    public Work() {
    }
}
