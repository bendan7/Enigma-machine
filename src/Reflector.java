public class Reflector extends Translator {

    String permutation ;

    public Reflector() {
        this.permutation = new String("YRUHQSLDPXNGOKMIEBFZCWVJAT");
    }

    @Override
    public int permutationF(int x) {
        return lettToIndex(permutation.charAt(x));

    }

    @Override
    //the same like the forward func
    public int permutationR(int x) {
        return permutationF(x);
    }
}
