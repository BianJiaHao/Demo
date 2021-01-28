package com.bjh.disruptor;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.EventTranslatorTwoArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.util.concurrent.Executors;

public class Main02 {

    public static void main(String[] args) {

        LongEventFactory factory = new LongEventFactory();

        int ringBufferSize = 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory,ringBufferSize, DaemonThreadFactory.INSTANCE);

        disruptor.handleEventsWith(new LongEventHandler());

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        EventTranslator<LongEvent> translator1 = new EventTranslator<LongEvent>() {
            public void translateTo(LongEvent longEvent, long l) {
                longEvent.setValue(888L);
            }
        };

        ringBuffer.publishEvent(translator1);

        System.out.println("----------------------");

        EventTranslatorOneArg<LongEvent,Long> translator2 = new EventTranslatorOneArg<LongEvent, Long>() {
            public void translateTo(LongEvent longEvent, long l, Long aLong) {
                longEvent.setValue(aLong);
            }
        };

        ringBuffer.publishEvent(translator2,777L);

        System.out.println("----------------------");

        EventTranslatorTwoArg<LongEvent,Long,Long> translator3 = new EventTranslatorTwoArg<LongEvent, Long, Long>() {
            public void translateTo(LongEvent longEvent, long l, Long aLong, Long aLong2) {
                longEvent.setValue(aLong);
            }
        };

        ringBuffer.publishEvent(translator3,1000L,1500L);

    }
}
