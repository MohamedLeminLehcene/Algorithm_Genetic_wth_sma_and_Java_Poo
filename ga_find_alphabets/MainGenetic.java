package ma.enset.ga_find_alphabets;

import java.util.Arrays;
import java.util.Random;

public class MainGenetic {
    private static final int MAX_IT = 50;
    private static final int MAX_FITNESS = 7;

    public static void main(String[] args) {
        Population population = new Population();
        population.initializePopulation();
        population.calculateIndividualFitnessValue();
        population.sortPoplation();
        System.out.println("bonjour");

        int it=0;
        //while (population.getFitnessInd().getFitness()<MAX_FITNESS)
        while (true)
        {
            population.selection();
            population.crossover();

            Random random = new Random();
            if(random.nextInt(101)<50)
                population.mutation();
            population.calculateIndividualFitnessValue();
            population.sortPoplation();

            System.out.println("Geness : "+Arrays.toString(population.getBestIndividual().getGenes())+" fitness value : "+population.getBestIndividual().getFitness());

            if(population.getBestIndividual().getFitness()==MAX_FITNESS){
                break;
            }

            it++;
        }


    }
}