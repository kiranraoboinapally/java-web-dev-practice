
interface One {
    void methodOne();
    default void defaultMethodOne() {
        System.out.println("This is the default method in One.");
    }
}
interface Two {
    void methodTwo();
    default void defaultMethodTwo() {
        System.out.println("This is the default method in Two.");
    }
}


abstract class AbstractChildImpl implements One, Two {
    @Override
    public abstract void methodOne();

    @Override
    public abstract void methodTwo();
}

class ConcreteChild extends AbstractChildImpl {
    @Override
    public void methodOne() {
        System.out.println("Implemented methodOne in ConcreteChild.");
    }

    @Override
    public void methodTwo() {
        System.out.println("Implemented methodTwo in ConcreteChild.");
    }
}

class GrandParent {
    void showGrandParent() {
        System.out.println("GrandParent class method.");
    }
}


class Parent1 extends GrandParent {
    void showParent1() {
        System.out.println("Parent1 class method.");
    }
}

class Parent2 extends GrandParent {
    void showParent2() {
        System.out.println("Parent2 class method.");
    }
}

public class Demo {
    public static void main(String[] args) {
        ConcreteChild child = new ConcreteChild();
        child.methodOne();
        child.methodTwo();

        child.defaultMethodOne();
        child.defaultMethodTwo();

        Parent1 p1 = new Parent1();
        p1.showGrandParent();
        p1.showParent1();

        Parent2 p2 = new Parent2();
        p2.showGrandParent();
        p2.showParent2();
    }
}
