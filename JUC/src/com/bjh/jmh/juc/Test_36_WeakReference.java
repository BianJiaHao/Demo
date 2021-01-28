package com.bjh.jmh.juc;

import java.lang.ref.WeakReference;

/**
* 弱引用遭到gc就会回收
*/
public class Test_36_WeakReference {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        ThreadLocal<M> tl = new ThreadLocal<>();
        tl.set(new M());
        tl.remove();
    }
}
