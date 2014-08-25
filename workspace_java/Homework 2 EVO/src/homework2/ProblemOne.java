package homework2;

import org.jscience.mathematics.number.Float64;
import org.jenetics.*;
import org.jenetics.util.Factory;
import org.jenetics.util.Function;

import static java.lang.Math.PI;
import static java.lang.Math.sin;
import static java.lang.Math.abs;

final class RealFunctionOne implements Function<Genotype<Float64Gene>, Float64>
{

	int counter;
	
	public RealFunctionOne()
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

		final double x = genotype.getChromosome(0).getGene().doubleValue();
		final double y = genotype.getChromosome(1).getGene().doubleValue();
		
		double functionOne = (abs(x) + abs(y)) * (1 + abs(sin(abs(x) + PI)) + abs(sin(abs(y) * PI)));
		double functionTwo = (abs(x) + abs(y)) * (1 +abs(sin(3 * abs(x) * PI)) + abs(sin(3 * abs(y) * PI)));
		
		counter++;
		
		return Float64.valueOf(functionTwo);
		
	} // apply
	
} // Real

public class ProblemOne 
{
	
	public static void main(String[] args) 
	{
		
		RealFunctionOne functionCall = new RealFunctionOne();
		
		Factory<Genotype<Float64Gene>> genotypeFactory = Genotype.valueOf(new Float64Chromosome(-60, 40), new Float64Chromosome(-30,70));
		
		Function<Genotype<Float64Gene>, Float64> fitnessFunction = functionCall;
		
		GeneticAlgorithm<Float64Gene, Float64> geneticAlgorithm = new GeneticAlgorithm<>(genotypeFactory, fitnessFunction,  Optimize.MINIMUM);
		
		geneticAlgorithm.setStatisticsCalculator(new NumberStatistics.Calculator<Float64Gene, Float64>());
		
		geneticAlgorithm.setPopulationSize(97);
		
		geneticAlgorithm.setSelectors(new RouletteWheelSelector<Float64Gene, Float64>());
		
		geneticAlgorithm.setAlterers(new Mutator<Float64Gene>(0.55), new SinglePointCrossover<Float64Gene>(0.06));
		
		geneticAlgorithm.setup();
		
		geneticAlgorithm.evolve(35);
		
		System.out.println(geneticAlgorithm.getBestStatistics());
		
		System.out.println("Fitness function called " + functionCall.getCounter() + " times.");

	} // main

} // ProblemOne
