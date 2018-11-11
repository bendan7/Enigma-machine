public class Machine extends Translator {

    private Translator[] elements;

    public void MachineInsertElement(Translator pb, Rotor r1 ,Rotor r2, Rotor r3 , Translator ref) {
        this.elements = new Translator[5];
        elements[0]=pb;
        elements[1]=r1;
        elements[2]=r2;
        elements[3]=r3;
        elements[4]=ref;
    }

    //this func get the rotor num that need to push 1 step forward
    //the value of rotor num should be 2,3. the first rotor push itself.
    public void incOffSet(int rotorNum)
    {
        Boolean double_step_flag=false;
        Rotor r;

        //Double stepping checking!!!!
        r=((Rotor)elements[2]);
        if(r.isDoubleStepping()){
            r.incOffset();
            r=((Rotor)elements[3]);
            r.incOffset();
            double_step_flag=true;
        }

        r=((Rotor)elements[rotorNum]);
        r.incOffset();
        if(r.isNotchEqualToOffset() && double_step_flag==false){
            r=((Rotor)elements[rotorNum+1]);
            r.incOffset();
        }



    }

    public char cipher(char c){

        int tmp = lettToIndex(c);

        //forward direction
        //todo: test without the plug board in the forward and revers
        for(int i=1 ; i<5 ; i++){
            System.out.println("tmp is: "+tmp);
            tmp = elements[i].permutationF(tmp);
            System.out.println("after the "+i+"element: "+tmp);
        }



        //revers direction: without the reflector
        for (int i=3 ; i>0 ; i--){
            tmp = elements[i].permutationR(tmp);
        }

        return indexToLett(tmp);
    }

    @Override
    public int permutationF(int x) {
        return 0;
    }
    @Override
    public int permutationR(int x) {
        return 0;
    }

}
