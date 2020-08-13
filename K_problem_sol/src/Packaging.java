public class Packaging
{

    public static void main(String[] args) {
        int numItems =10;
        int maxGenerations = 50;
        int populationSize = 10;
        double mutationRate = 0.1;
        double crossoverRate = 0.7;

        double Knapsack_capacity = 40;
        int elitism_count = 1;

        Item items[] = new Item[numItems];

        for (int itemIndex = 0; itemIndex < numItems; itemIndex++)
        {
            int volume = (int) (10 * Math.random()+1);
            int benefit = (int) (10 * Math.random()+1);
            items[itemIndex] = new Item(volume, benefit);
        }

        GeneticAlgorithm ga = new GeneticAlgorithm(populationSize,mutationRate,crossoverRate,elitism_count,Knapsack_capacity);

        Population population = ga.initPopulation(items.length);

        int generation = 1;
// Start evolution loop
        while (ga.isTerminationConditionMet(generation, maxGenerations) == false)
        {
            
        }

    }
}
