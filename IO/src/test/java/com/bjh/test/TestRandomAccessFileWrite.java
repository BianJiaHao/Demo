package com.bjh.test;

import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Obito
 * @Date 2021/1/24 下午5:59
 * 测试文件NIO
 */
public class TestRandomAccessFileWrite {

    static  String path = "/Users/bianjiahao/Desktop";

    @Test
    public void testRandomAccessFileWrite() throws Exception{

        RandomAccessFile raf = new RandomAccessFile(path, "rw");

        raf.write("hello mashibing\n".getBytes());
        raf.write("hello bianjiahao\n".getBytes());
        System.out.println("----- writed -----");
        System.in.read();

        raf.seek(4);
        raf.write("ooxx".getBytes());

        System.out.println("----- seek -----");
        System.in.read();

        FileChannel rafChannel = raf.getChannel();

        // mmap 堆外  和文件映射的   byte  not  objtect
        MappedByteBuffer map = rafChannel.map(FileChannel.MapMode.READ_WRITE, 0, 4096);

        /**
         * 不是系统调用 但是数据会到达内核的pagecache
         * 曾经我们是需要out.write()  这样的系统调用，才能让程序的data 进入内核的pagecache
         * 曾经必须有用户态内核态切换
         * mmap的内存映射，依然是内核的pagecache体系所约束的！！！
         * 换言之，丢数据
         * 你可以去github上找一些 其他C程序员写的jni扩展库，使用linux内核的Direct IO
         * 直接IO是忽略linux的pagecache
         * 是把pagecache  交给了程序自己开辟一个字节数组当作pagecache，动用代码逻辑来维护一致性/dirty。。。一系列复杂问题
         */
        map.put("@@@".getBytes());

        System.out.println("----- map put -----");
        System.in.read();

        // 相当于 flush
//        map.force();

        raf.seek(0);

        ByteBuffer buffer = ByteBuffer.allocate(8192);

        int read = rafChannel.read(buffer);   //buffer.put()
        System.out.println(buffer);
        buffer.flip();
        System.out.println(buffer);

        for (int i = 0; i < buffer.limit(); i++) {
            Thread.sleep(200);
            System.out.print(((char)buffer.get(i)));
        }
    }
}
