package hw1;

import java.util.List;

public class MarksGenerator {
    public static List<Integer> illegalInts(){
        return List.of(0,1,6,7);
    }
    public static List<Integer> ints(){
        return List.of(-1,0,1,2,3,5,6);
    }
}
