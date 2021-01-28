package com.bjh.composite;

public class Client {
    public static void main(String[] args) {
        //从小到大创建对象 学校
        OrganizationComponent university = new University("衡水学院", "中国顶尖大学");

        //创建 学院
        OrganizationComponent computerCollege = new College("计算机学院","计算机学院牛哦屁");
        OrganizationComponent infoEngineerCollege = new College("信息工程","信息工程学院牛哦屁");

        //创建各个学院下面的系
        computerCollege.add(new Department("软件工程","软件工程牛皮"));
        computerCollege.add(new Department("网络工程","网络工程牛皮"));
        computerCollege.add(new Department("计算机科学与技术","计算机科学与技术牛皮"));

        infoEngineerCollege.add(new Department("通信工程","通信工程牛皮"));
        infoEngineerCollege.add(new Department("信息工程","信息工程牛皮"));

        //将学院加入到学习中
        university.add(computerCollege);
        university.add(infoEngineerCollege);

        university.print();

    }
}
