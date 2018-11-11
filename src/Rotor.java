public class Rotor extends Translator {

    private int notch;
    private int place;
    private int offset;
    private String permutation ;
    Machine machine;


    //config the rotor num, offset and it place int the machine
    // rotorNum: 1-5 , offset: 0-25
    public Rotor(int place, int RotorNum, int offset ,Machine m) {
        switch (RotorNum){
            case 1:
                permutation = new String("EKMFLGDQVZNTOWYHXUSPAIBRCJ");
                notch = 17;
                break;
            case 2:
                permutation = new String("AJDKSIRUXBLHWTMCQGZNPYFVOE");
                notch = 5;
                break;
            case 3:
                permutation = new String("BDFHJLCPRTXVZNYEIWGAKMUSQO");
                notch = 22;
                break;
            case 4:
                permutation = new String("ESOVPZJAYQUIRHXLNFTGKDCMWB");
                notch = 10;
                break;
            case 5:
                permutation = new String("VZBRGITYUPSDNHLXAWMJQOFECK");
                notch = 0;
                break;
        }
        this.offset=offset;
        this.place=place;
        this.machine=m;
    }


    public void incOffset(){
        this.offset=Math.floorMod(++offset, 26);
    }

    public int permutationF(int x) {
        //inc the offset only for the rightmost rotor every step
        if(place==1){
            //offset = Math.floorMod(++offset, 26);
            machine.incOffSet(1);
        }


//        //if the notch is pass
//        if(offset==notch) {
//            if (this.place == 3) {
//            }  //if it the leftmost rotor do nothing
//            else {
//                machine.incOffSet(place + 1);
//            }
//        }



        int tmp = Math.floorMod(x+offset, 26);

        System.out.println("offset: "+offset);
        System.out.println("lett: "+ tmp);
        return Math.floorMod((lettToIndex(permutation.charAt(tmp))-offset), 26);

    }

    public int permutationR (int x){
        char t =indexToLett(Math.floorMod(x+offset, 26));

        for (int i=0; i<permutation.length(); i++){
            if(permutation.charAt(i)==t){
                return Math.floorMod(i-offset, 26);
            }
        }
        System.out.println("error");
        return -1;
    }

    public boolean isNotchEqualToOffset(){
        return notch==offset;
    }

    protected boolean isDoubleStepping(){
        return  notch-1 == offset;
    }
}
