//class WireKeyboard{
//
//    public void type(){
//        System.out.println("Typing with the wired Keyboard");
//    }
//}
//
//class Computer{
//    private WireKeyboard keybord=new WireKeyboard();
//    public void type(){
//        System.out.println("Typing with the wired Keyboard");
//    }
//}

import java.awt.*;
import java.security.Key;

interface Keyboard {
    void type();
}

class WiredKeyboard implements Keyboard {
    public void type() {
        System.out.println("Typing with wired Keyboard");
    }
}

class WirelessKeyboard implements Keyboard {
    public void type() {
        System.out.println("Typing with wireless Keyboard");
    }
}

class Computer {
    private Keyboard keyboard;
    public Computer(Keyboard keyboard){
        this.keyboard=keyboard;
    }
    public void startTyping()
    {keyboard.type();}

}
public class DependencyInvrsionDemo {
    public static void main(String[] args) {
        Keyboard keyboard = new WirelessKeyboard();
        Computer computer = new Computer(keyboard);
        computer.startTyping();
    }
}
