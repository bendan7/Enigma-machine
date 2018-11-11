public abstract class Translator {



    protected int lettToIndex(char c){
        int i =(int) c-65;
        return i;
    }
    protected char indexToLett(int i){
        //if the index too is bigger the Z
        i= Math.floorMod(i, 26);
        int c =i+65;

        return (char)c;
    }


    public abstract int permutationF(int x);
    public abstract int permutationR(int x);
}
