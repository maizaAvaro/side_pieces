package homework2;

import org.jscience.mathematics.number.Float64;
import org.jenetics.*;
import org.jenetics.util.Factory;
import org.jenetics.util.Function;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.E;
import static java.lang.Math.exp;
import static java.lang.Math.sqrt;

final class RealFunctionTwo implements Function<Genotype<Float64Gene>, Float64>
{
	
	int counter;
	
	public RealFunctionTwo()
	{
		
		counter = 0;
		
	} // constructor
	
	public int getCounter()
	{
		
		return counter;
		
	} // getCounter

	@Override
	public Float64 apply(Genotype<Float64Gene> genotype) 
	{
		int dimension = 30;
		final Chromosome<Float64Gene> x = genotype.getChromosome();
		double sumOne = 0.0;
		double sumTwo = 0.0;
		
		for(int i = 0; i < dimension; ++i)
		{
			sumOne += (x.getGene(i).doubleValue() * x.getGene(i).doubleValue());
			sumTwo += (cos(2 * PI * x.getGene(i).doubleValue()));
		} // for
		
		double ackley = -20.0 * exp(-0.2 * sqrt((1.0/dimension) * sumOne)) - exp((1.0/dimension) * sumTwo) + 20.0 + E;
		
		counter++;
		
		return Float64.valueOf(ackley);
		
	} // apply
	
} // Real

public class ProblemTwo 
{
	
	public static void main(String[] args) 
	{
		
		RealFunctionTwo functionCall = new RealFunctionTwo();
	
		Factory<Genotype<Float64Gene>> genotypeFactory = Genotype.valueOf(new Float64Chromosome(-30, 30, 30));
		
		Function<Genotype<Float64Gene>, Float64> fitnessFunction = functionCall;
			
		GeneticAlgorithm<Float64Gene, Float64> geneticAlgorithm = new GeneticAlgorithm<>(genotypeFactory, fitnessFunction);
		
		geneticAlgorithm.setStatisticsCalculator(new NumberStatistics.Calculator<Float64Gene, Float64>());
		
		geneticAlgorithm.setPopulationSize(423);
		
		geneticAlgorithm.setSelectors(new RouletteWheelSelector<Float64Gene, Float64>());
		
		geneticAlgorithm.setAlterers(new Mutator<Float64Gene>(0.55), new SinglePointCrossover<Float64Gene>(0.06));
		
		geneticAlgorithm.setup();
		
		geneticAlgorithm.evolve(500);
		
		System.out.println(geneticAlgorithm.getBestStatistics());
		
		System.out.println("Fitness function called " + functionCall.getCounter() + " times.");

	} // main

} // ProblemTwo
