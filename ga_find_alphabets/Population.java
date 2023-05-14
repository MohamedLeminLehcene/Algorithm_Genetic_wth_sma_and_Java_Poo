package ma.enset.ga_find_alphabets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Population {
    ArrayList<Individual> individuals = new ArrayList<>();
    Individual firstFitness;
    Individual secondFitness;
    private static int populaion = 20;
    private String target = "bonjour";

    Random random = new Random();

    public void initializePopulation(){
        for (int i = 0; i < populaion ; i++) {
            individuals.add(new Individual());
        }
    }

    public void calculateIndividualFitnessValue(){
        for (int i = 0; i < populaion; i++) {
            individuals.get(i).calculateFitness();
        }
    }

    public void sortPoplation(){
        Collections.sort(individuals, Comparator.reverseOrder());
    }
    public void selection(){
        firstFitness = individuals.get(0);
        secondFitness = individuals.get(1);
    }


    public void crossover(){
        int crossoverPoint = 1 + new Random().nextInt(5);

        Individual individual1 = new Individual();
        Individual individual2 = new Individual();

        for (int i = 0; i < individual1.getGenes().length; i++) {
            individual1.getGenes()[i] = firstFitness.getGenes()[i];
            individual2.getGenes()[i] = secondFitness.getGenes()[i];
        }

        for (int i = 0; i < crossoverPoint; i++) {
            individual1.getGenes()[i] = secondFitness.getGenes()[i];
            individual2.getGenes()[i] = firstFitness.getGenes()[i];
        }

      /*
        individuals.set(0, individual1);
        individuals.set(1, individual2);
       */

        individuals.set(individuals.size()-2,individual1);
        individuals.set(individuals.size()-1,individual2);

        //System.out.println("Crossover Point : " + crossoverPoint);
    }

    public void mutation(){
        int index = random.nextInt(7);
        for (int i = 0; i <target.length(); i++) {
            if(individuals.get(0).getGenes()[index] != target.charAt(i))
                individuals.get(0).getGenes()[index] = target.charAt(random.nextInt(7));

            index = random.nextInt(7);
            if(individuals.get(1).getGenes()[index] != target.charAt(i))
                individuals.get(1).getGenes()[index] = target.charAt(random.nextInt(7));
        }
    }

    public Individual getFitnessInd()
    {
        return individuals.get(0);
    }

    public Individual getBestIndividual(){
        return individuals.get(0);
    }


}