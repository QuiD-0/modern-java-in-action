package defaultMethod;

public interface Interface {

    default void defaultMethod() {
        System.out.println("Default Method");
    }

    void otherMethod();
}
