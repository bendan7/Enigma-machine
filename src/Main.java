import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        //plugboard test
        {
//        PlugBoard pb = new PlugBoard();
//        pb.addPair('S','W');
//        pb.addPair('A','Q');
//        pb.addPair('N','P');
//        pb.addPair('V','Y');
//        pb.addPair('F','O');
//        pb.addPair('U','X');
//        pb.addPair('M','K');
//        pb.addPair('C','L');
//        pb.addPair('H','T');
//        pb.addPair('Z','I');
//        pb.print();
        }
        Machine m = new Machine();
        PlugBoard pb = new PlugBoard();
        Reflector ref =new Reflector();
        Rotor c = new Rotor(3,1,16,m);
        Rotor b = new Rotor(2,2,4,m);
        Rotor a = new Rotor(1,3,21,m);
        m.MachineInsertElement(pb,a,b,c,ref);


        while (true){
            System.out.println("enter num:");
            Scanner in = new Scanner(System.in);
            System.out.println(m.cipher(in.next().charAt(0)));

//            int num = in.nextInt();
//            //System.out.println( r.permutation(c.permutation(b.permutation(a.permutation(num)))));
//            int tmp = ref.permutationF(c.permutationF(b.permutationF(a.permutationF(num))));
//            tmp =a.permutationR(b.permutationR(c.permutationR(tmp))) ;
//            System.out.println(tmp);


        }




    }
}
