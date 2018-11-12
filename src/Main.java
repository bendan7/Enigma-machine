import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File config_file = new File("config.txt");
        File input_file = new File("input.txt");

        int[] rotors_numbers= new int[3];
        int[] rotors_sett= new int[3];
        int[] rotors_offset= new int[3];
        String input =new String();


        //init plug board
        PlugBoard pb = new PlugBoard();

        // read config.txt
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("config.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine =new String();
            int i=0;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                if(strLine.isEmpty() || strLine.charAt(0)=='#'){ ;}   //ignore line that start with # or empty line
                else {

                    //config plugboard
                    if(i>0 && i<11){
                        if(strLine.length()>3){
                            if(!pb.addPair(strLine.charAt(2),strLine.charAt(3)))
                                return ;                    // error in adding pairs to plugboard
                        }
                    }

                    //config rotor number
                    if(i>11 && i<15){
                        rotors_numbers[i-12]=Character.getNumericValue(strLine.charAt(2));
                    }

                    //config ROTORS SETTING (inner offset)
                    if(i>15 && i<19){
                        rotors_sett[i-16]=strLine.charAt(2)-65;
                    }

                    //config offset
                    if(i>19 && i<23){
                        rotors_offset[i-20]=strLine.charAt(2)-65;
                    }

                    i++;  // inc line number
                }
                }

            //Close the CONFIG stream
            in.close();

            //read input.txt
             fstream = new FileInputStream("input.txt");
            // Get the object of DataInputStream
             in = new DataInputStream(fstream);
             br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null){
                //read the input string
                input =strLine;
            }
            //Close the INPUT stream
            in.close();
        }
        catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        Machine m = new Machine();

        //init rotors:
        //1=RIGHT 2=MIDDLE 3=LEFT
        Rotor RIGHT = new Rotor(1,rotors_numbers[2],rotors_offset[2],rotors_sett[2],m);
        Rotor MID = new Rotor(2,rotors_numbers[1],rotors_offset[1],rotors_sett[1],m);
        Rotor LEFT = new Rotor(3,rotors_numbers[0],rotors_offset[0],rotors_sett[0],m);
        Reflector ref =new Reflector();
        m.MachineInsertElement(pb,RIGHT,MID,LEFT,ref);

        // cipher LOOP
        for(int j=0; j<input.length() ; j++){
            System.out.println(m.cipher(input.charAt(j)));

            
        }
//        while (true){
//            System.out.println("enter num:");
//            Scanner in = new Scanner(System.in);
//            System.out.println(m.cipher(in.next().charAt(0)));
//
//        }

    }
}
