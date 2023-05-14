package ma.enset.ga_find_alphabets;

import java.util.Random;

public class Individual implements Comparable{
    //chromosome
    private char genes[] = new char[7];
    private int fitness;
    private  String target = "bonjour";
    private String alphabets="abcdefghijklmnopqrstuvwxyz";
    public  Individual()
    {
        for(int i=0;i<genes.length;i++)
        {
            genes[i]=alphabets.charAt(new Random().nextInt(alphabets.length()));
        }
    }

    public int getFitness() {
        return fitness;
    }

    public char[] getGenes() {
        return genes;
    }

    public void calculateFitness(){
        int matches = 0;
        for (int i = 0; i < genes.length; i++) {
            if (genes[i] == target.charAt(i)) {
                matches++;
            }
        }
        fitness = matches;
    }


    @Override
    public int compareTo(Object o) {
        Individual individual = (Individual) o;
        if (this.getFitness() < ((Individual) o).getFitness()) return -1;
        else if (this.getFitness() > ((Individual) o).getFitness()) return 1;
        return 0;
    }

}