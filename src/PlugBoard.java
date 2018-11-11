import java.util.Vector;

public class PlugBoard extends Translator {
    private int counter;
    private int[] plugs = new int[26];

    public PlugBoard() {
        init();
    }

    public boolean init(){
        this.counter = 0;
        for (int i=0; i<26 ; i++){
            plugs[i]=-1;
        }
        return true;
    }
    public boolean addPair(char a, char b){
        if (counter==10){
            System.out.println("Too many pairs: only 10 allowed");
            return false;
        }
        if(plugs[lettToIndex(a)]!=-1 || plugs[lettToIndex(b)]!=-1){
            System.out.println("Already chosen");
            return false;
        }

        plugs[lettToIndex(a)]=counter;
        plugs[lettToIndex(b)]=counter;
        counter++;

        return true;
    }

    public void print(){
        for (int i=0;i<26; i++){
            System.out.println(indexToLett(i)+": "+plugs[i]);
        }
    }

    @Override
    public int permutationF(int x) {
        //if the letter wasn't plug
        if(plugs[x]==-1)
            return x;

        int p= plugs[x];
        for (int i=0; i<26 ; i++){
            if(i==x); //pass on this iteration: find the other pair
            else if(plugs[i]==p)
                return i;
        }

        return -1;
    }

    @Override
    //the same like the forward func
    public int permutationR(int x) {
        return permutationF(x);
    }
}


