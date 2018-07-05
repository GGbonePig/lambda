package com.example.lambda.demo;

import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        People wangzhijian=new People(22,"wangzhijian","man");
        People shanpeng =new People(28,"shanpeng","man");
        People bianbo=new People(24,"biaobo","man");
        ArrayList<People> person=new ArrayList<>();
        person.add(wangzhijian);
        person.add(shanpeng);
        person.add(bianbo);
        SocketImplFactory factory = MuSocketImpl::new;
        person.sort(Comparator.comparing(People::getAge));
        List<List<Integer>> aList = new ArrayList<>();
        aList.forEach(list ->  aList.add(list));
        int sum = aList.stream()
                .mapToInt(list -> list.size())
                .sum();
    }
}
