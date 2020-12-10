public class GeneticAlgorithm
{

    private double mutationRate;
    private double crossoverRate;
    private int elitismCount;
    private double knapsackVolume;
    private int populationSize;

    public Population initPopulation(int length)
    {
        return null;
    }

    GeneticAlgorithm(int populationSize,double mutationRate,double crossoverRate, int elitismCount,double knapsackVolume)
    {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
        this.knapsackVolume = knapsackVolume;

    }

    public boolean isTerminationConditionMet(int generation, int maxGenerations) {
        return false;
    }
}
