package startup;

public interface Comparable<T> {
    int compareTo(T obj);
    int pi = 3;
    static Employee func()
    {
        return new Employee("tom",100);
    }

    default void hello()
    {
        System.out.println("test");
    }
}
