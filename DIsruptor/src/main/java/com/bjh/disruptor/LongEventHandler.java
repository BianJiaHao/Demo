package com.bjh.disruptor;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> {
    public static long count = 0;

    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        count ++;
        System.out.println("[" + Thread.currentThread().getName() + "]" + longEvent + "序号 ： " + l);
    }
}
