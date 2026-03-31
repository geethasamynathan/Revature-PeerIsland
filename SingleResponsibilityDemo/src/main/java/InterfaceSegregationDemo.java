interface  Printable {
    void print();
}
interface  Scanable {
    void scan();
}
interface Faxable{
    void fax();
}

class  BasicPrinter implements Printable{

    public void print() {
        System.out.println("Printing...");
    }
}

class  AdvancedPrinter implements Printable,Scanable,Faxable
{
    public void print() {
        System.out.println("Printing...");
    }
    public void scan() {
        System.out.println("Scan the image...");
    }
    public void fax() {
        System.out.println("sending Fax xzy ...");
    }
}


public class InterfaceSegregationDemo {
}
