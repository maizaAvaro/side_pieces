package homework4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.jenetics.*;
import org.jenetics.Statistics.Calculator;
import org.jenetics.util.*;
import org.jscience.mathematics.number.Float64;

class FitnessFunction implements Function<Genotype<EnumGene<Integer>>, Float64>
{
	
	private final double[][] _adjacence;
	
	public FitnessFunction(final double[][] adjacence)
	{
		
		_adjacence = adjacence;
		
	} // FitnessFunction constructor

	@Override
	public Float64 apply(Genotype<EnumGene<Integer>> genotype) 
	{
		
		Chromosome<EnumGene<Integer>> path = genotype.getChromosome();
		
		double length = 0.0;
		
		for(int i = 0, n = path.length(); i < n; ++i)
		{
			
			final int from = path.getGene(i).getAllele();
			final int to = path.getGene((i + 1) % n).getAllele();
			
			length += _adjacence[from][to];
			
		} // for
		
		return Float64.valueOf(length);
		
	} // apply
	
} // FitnessFunction

public class TravelingSalesman 
{
	
	public static void main(String[] args) 
	{
		
		final int stops = Integer.parseInt(args[0])	;
		
		Function<Genotype<EnumGene<Integer>>, Float64> fitnessFunction = new FitnessFunction(adjacencyMatrix(stops));
		
		Factory<Genotype<EnumGene<Integer>>> genotypeFactory = Genotype.valueOf(PermutationChromosome.ofInteger(stops));
		
		final GeneticAlgorithm<EnumGene<Integer>, Float64> geneticAlgorithm = new GeneticAlgorithm<>(genotypeFactory, fitnessFunction, Optimize.MINIMUM);
		
		geneticAlgorithm.setStatisticsCalculator(new Calculator<EnumGene<Integer>, Float64>());
		
		geneticAlgorithm.setPopulationSize(5000);
		
		geneticAlgorithm.setAlterers(new SwapMutator<EnumGene<Integer>>(0.2), new PartiallyMatchedCrossover<Integer>(0.3));
		
		geneticAlgorithm.setup();
		
		geneticAlgorithm.evolve(3000);
		
		System.out.println(geneticAlgorithm.getBestStatistics() + "\n");
		System.out.println(geneticAlgorithm.getBestPhenotype());

	} // main

	private static double[][] adjacencyMatrix(int stops) 
	{
		
		//Build array for storing city data
		int[][] cityData = new int[stops][2];
		
		String csvFile = "tspData.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int lineCount=0;
	 
		try 
		{
	 
			br = new BufferedReader(new FileReader(csvFile));
			
			String[] data;
			
			while ((line = br.readLine()) != null) 
			{
			       
				data = line.split(cvsSplitBy);
	 
				cityData[lineCount][0]=Integer.parseInt(data[0]);
				cityData[lineCount][1]=Integer.parseInt(data[1]);
	 
				lineCount++;
			} // while 
	 
		} catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		
		} catch (IOException e) 
		{
		
			e.printStackTrace();
		
		} finally 
		{
			if (br != null) 
			{
				
				try 
				{
				
					br.close();
				
				} catch (IOException e) 
				{
					
					e.printStackTrace();
				
				} // try-catch
			
			} // if
		
		} // try-catch-finally
		
		double[][] matrix = new double[stops][stops];
		
		for(int i = 0; i < stops; ++i)
		{
			
			for(int j = 0; j < stops; ++j)
			{
				double distance = Math.sqrt(Math.pow(cityData[i][0]-cityData[j][0], 2) + Math.pow(cityData[i][1]-cityData[j][1], 2));
				matrix[i][j] = distance;
				
			} // for 
			
		} // for
		
		return matrix;
		
	} // adjacencyMatrix

} // TravelingSalesman
