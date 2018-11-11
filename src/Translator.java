public abstract class Translator {



    protected int lettToIndex(char c){
        int i =(int) c-65;
        return i;
    }
    protected char indexToLett(int i){
        int c =i+65;

        return (char)c;
    }


    public abstract int permutationF(int x);
    public abstract int permutationR(int x);
}
