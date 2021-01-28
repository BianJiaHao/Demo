package com.bjh.iterator;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<College> colleges = new ArrayList<>();

        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();

        colleges.add(computerCollege);
        colleges.add(infoCollege);

        OutPutImpl outPut = new OutPutImpl(colleges);
        outPut.printCollege();
    }
}
