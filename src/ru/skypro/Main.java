package ru.skypro;

public class Main {

    public static void main(String[] args) {

        String item = "re1";
        String item2 = "re3";
        String item3 = "re2";
        StringArray stringList = new StringArray();
        StringArray stringList2 = new StringArray();
        stringList.add(item);
        stringList.add(item2);
        stringList.add(item3);
        stringList2.add(item2);


        stringList.add(1, item3);
        stringList.add(2, item2);


        stringList.set(2, item3);
        stringList.remove(0);

        System.out.println(stringList.contains(item));
        System.out.println(stringList.contains(item2));

        System.out.println(stringList.indexOf(item));
        System.out.println(stringList.get(0));
        System.out.println(stringList.equals(stringList2));

        System.out.println(stringList.isEmpty());
        stringList.clear();
        System.out.println(stringList.isEmpty());

        stringList2.toArray();


    }
}
