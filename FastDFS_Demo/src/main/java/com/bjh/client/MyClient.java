package com.bjh.client;

import com.bjh.utils.FastDFSClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

public class MyClient {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/bianjiahao/Downloads/dubbo-governance.log");
            InputStream inputStream = new FileInputStream(file);
            String fileName = UUID.randomUUID().toString()+".jpg";
            String[] result = FastDFSClient.uploadFile(inputStream, fileName);
            System.out.println(Arrays.toString(result));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
