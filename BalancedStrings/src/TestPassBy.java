public class TestPassBy {
    public static void main(String[] args){
        Integer i = 0;
        foo(i);
        System.out.println(i);
    }

    static void foo(Integer i){
        i = i + 1;
    }
}