package com.java8.flat;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ghl
 * @date 2021/1/11 13:39
 */
public class FlatMapTest {
    public static void main(String[] args) {
        List<AClass> aClassList1 = new ArrayList();
        AClass aClass = new AClass(1, "zhuoli1", "haha1");
        aClassList1.add(aClass);
        aClassList1.add(new AClass(2, "zhuoli2", "haha2"));
        aClassList1.add(new AClass(3, "zhuoli3", "haha3"));

        List<AClass> aClassList2 = new ArrayList();
        aClassList2.add(aClass);
        aClassList2.add(new AClass(5, "zhuoli5", "haha5"));
        aClassList2.add(new AClass(6, "zhuoli6", "haha6"));

        /**
         * 求交集
         * [AClass(id=1, name=zhuoli1, description=haha1)]
         */
        List<AClass> collect = aClassList1.stream().filter(a -> aClassList2.contains(a)).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("==============================");
        List<AClass> collect1 = aClassList1.stream().filter(aClassList2::contains).collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println("==============================");
        Set<AClass> collect2 = Stream.concat(aClassList1.stream(), aClassList2.stream()).collect(Collectors.toSet());
        System.out.println(collect2);
        System.out.println("==============================");
        // 并集
        List<AClass> collect3 = Stream.of(aClassList1, aClassList2).flatMap(a -> a.stream()).distinct().collect(Collectors.toList());
        System.out.println(collect3);
        System.out.println("==============================");
        List<AClass> collect4 = Stream.of(aClassList1, aClassList2).flatMap(Collection::stream).distinct().collect(Collectors.toList());
        System.out.println(collect4);
        System.out.println("==============================");
        // 差集
        List<AClass> collect5 = aClassList1.stream().filter(a -> !aClassList2.contains(a)).collect(Collectors.toList());
        System.out.println(collect5);
        System.out.println("==============================");
        // 合并多个list
        Map<Integer, List<AClass>> map = new HashMap<>();
        map.put(1, aClassList1);
        map.put(2, aClassList2);
        List<AClass> collect6 = map.values().stream().flatMap(m -> m.stream()).collect(Collectors.toList());
        System.out.println(collect6);
        System.out.println("==============================");
        List<List<AClass>> collect7 = map.values().stream().collect(Collectors.toList());
        System.out.println(collect7);
        System.out.println("==============================");
        List<AClass> collect8 = map.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect8);
        System.out.println("==============================");


        // 分享一个flatMap的复杂操作，实现List<Data1>和List<Data2>根据Id进行连接，将连接结果输出为一个List<OutputData>：
        List<Data2> listOfData2 = new ArrayList<>();
        listOfData2.add(new Data2(10501, "JOE", "Type1"));
        listOfData2.add(new Data2(10603, "SAL", "Type5"));
        listOfData2.add(new Data2(40514, "PETER", "Type4"));
        listOfData2.add(new Data2(59562, "JIM", "Type2"));
        listOfData2.add(new Data2(29415, "BOB", "Type1"));
        listOfData2.add(new Data2(61812, "JOE", "Type9"));
        listOfData2.add(new Data2(98432, "JOE", "Type7"));
        listOfData2.add(new Data2(62556, "JEFF", "Type1"));
        listOfData2.add(new Data2(10599, "TOM", "Type4"));

        List<Data1> listOfData1 = new ArrayList<Data1>();

        listOfData1.add(new Data1(10501, "JOE", 3000000));
        listOfData1.add(new Data1(10603, "SAL", 6225000));
        listOfData1.add(new Data1(40514, "PETER", 2005000));
        listOfData1.add(new Data1(59562, "JIM", 3000000));
        listOfData1.add(new Data1(29415, "BOB", 3000000));

        List<OutputData> collect9 = listOfData1.stream()
                .flatMap(x -> listOfData2.stream()
                        .filter(y -> y.getId() == x.getId())
                        .map(y -> new OutputData(y.getId(), x.getName(), y.getType(), x.getAmount())))
                .collect(Collectors.toList());
        System.out.println(collect9);

        System.out.println("==============================");

        // faltMapToInt 首先看一下flatMapToInt方法定义：IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);
        List<List<String>> lists = Arrays.asList(
                Arrays.asList("1", "2"),
                Arrays.asList("5", "6"),
                Arrays.asList("3", "4")
        );
        IntStream intStream = lists.stream().flatMapToInt(l -> l.stream().mapToInt(s -> Integer.parseInt(s)));
//        intStream.forEach(i-> System.out.println(i));
//        int sum = intStream.peek(System.out::println).sum();
//        System.out.println(sum);
        List<Integer> collect10 = intStream.boxed().collect(Collectors.toList());
        System.out.println(collect10);
        System.out.println("==============================");

        List<List<List<String>>> listString = Arrays.asList(
                Arrays.asList(
                        Arrays.asList("1", "2", "3"),
                        Arrays.asList("12", "12", "13"),
                        Arrays.asList("22", "22", "23")
                ),
                Arrays.asList(
                        Arrays.asList("10", "20", "30"),
                        Arrays.asList("120", "120", "130"),
                        Arrays.asList("220", "220", "230")
                )
        );
        System.out.println(listString);
        List<Integer> collect11 = listString.stream()
                .flatMapToInt(a -> a.stream().flatMapToInt(b -> b.stream().mapToInt(c -> Integer.parseInt(c))))
                .boxed()
                .collect(Collectors.toList());
        System.out.println(collect11);
        System.out.println("==============================");
    }
}


@Data
@AllArgsConstructor
class Data1 {
    private int id;
    private String name;
    private int amount;
}

@Data
@AllArgsConstructor
class Data2 {
    private int id;
    private String name;
    private String type;
}

@Data
@AllArgsConstructor
class OutputData {
    private int id;
    private String name;
    private String type;
    private int amount;
}


class AClass {
    private int id;
    private String name;
    private String nickname;

    public AClass(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "AClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AClass aClass = (AClass) o;
        return id == aClass.id && Objects.equals(name, aClass.name) && Objects.equals(nickname, aClass.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nickname);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
