import java.util.Scanner;


public class Main {

    public static void main(String[] args) {



        Machine m = new Machine();

        //init plug board
        PlugBoard pb = new PlugBoard();
        pb.addPair('Z','U');
        pb.addPair('H','L');
        pb.addPair('C','Q');
        pb.addPair('W','M');
        pb.addPair('O','A');
        pb.addPair('P','Y');
        pb.addPair('E','B');
        pb.addPair('T','R');
        pb.addPair('D','N');
        pb.addPair('V','I');



        //init rotors:
        //1=RIGHT 2=MIDDLE 3=LEFT
        Rotor RIGHT = new Rotor(1,4,13,23,m);
        Rotor MID = new Rotor(2,5,14,8,m);
        Rotor LEFT = new Rotor(3,2,2,18,m);
        Reflector ref =new Reflector();
        m.MachineInsertElement(pb,RIGHT,MID,LEFT,ref);


        while (true){
            System.out.println("enter num:");
            Scanner in = new Scanner(System.in);
            System.out.println(m.cipher(in.next().charAt(0)));

        }

    }
}
