package InterfacesАndAbstraction.Lab._4_SayHelloExtended;

public class European extends BasePerson {


    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
