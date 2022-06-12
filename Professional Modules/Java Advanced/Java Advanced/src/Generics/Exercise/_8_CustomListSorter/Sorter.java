package Generics.Exercise._8_CustomListSorter;

public class Sorter <T extends Comparable<T>> {

    static void sort(CustomList list){
        list.sort();
    }

}
