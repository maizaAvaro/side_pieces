package homework4;

import java.util.BitSet;

import org.jenetics.*;
import org.jenetics.util.Factory;
import org.jenetics.util.Function;
import org.jenetics.util.ISeq;

final class NQueensFunction implements Function<Genotype<BitGene>, Integer>
{
	
	int counter;
	int queens;
	int bestConflicts;
	String bestPhenotype;
	
	public NQueensFunction(int _queens)
	{
		
		counter = 0;
		queens = _queens;
		bestConflicts = 999;
		bestPhenotype = "";
		
	} // constructor
	
	public int getCounter()
	{
		
		return counter;
		
	} // getCounter
	
	public int getBestConflicts()
	{
		
		return bestConflicts;
		
	} // getBestConflicts
	
	public String getBestPhenotypeMine()
	{
		
		return bestPhenotype;
		
	} // getBestPhenotype

	@Override
	public Integer apply(Genotype<BitGene> genotype) 
	{
		
		int[][] board = new int[queens][queens];
		int row=0;
		int col=0;
		BitSet bset = ((BitChromosome)genotype.getChromosome()).toBitSet();
		
		if(bset.cardinality() > queens)
		{
			
			while(bset.cardinality() != queens)
			{
			     
				int index = (int) (Math.random() * (bset.size() - 1));
				
				if(bset.get(index))
				{
					
					bset.flip(index);
				
				}else
				{
					
					// do nothing
					
				} // if-else
			     
			} // while
			
		}else if(bset.cardinality() < queens)
		{
			
			while(bset.cardinality() != queens)
			{
				
				int index = (int) (Math.random() * (bset.size() - 1));
				
				if(bset.get(index))
				{
				
					// do nothing
				
				}else
				{
				
					bset.flip(index);
				
				} // if-else
				
			} // while
			
		} // if-else
		
		if(bset.cardinality()!=queens)
			return 999;
		
		for(int i=0;i<(queens*queens);++i)
		{
			if(bset.get(i))
				board[row][col] = 1;
			else
				board[row][col] = 0;
			
			if(col<queens-1)
				col++;
			else
			{
				col=0;
				row++;
			}
		}
		
		int conflicts = 0;
		
		//Iterate through whole board
		for(int i=0;i<(queens*queens);++i)
		{
			row=i/queens;
			col=i%queens;
			
			if(board[row][col]==1)
			{
				//Check row
				for(int r=0;r<queens;r++)
				{
					if(r!=row && board[r][col]==1)
						conflicts++;
				}
				
				//Check col
				for(int c=0;c<queens;c++)
				{
					if(c!=col && board[row][c]==1)
						conflicts++;
				}
				//Check topright diagonal
				int tempR=row-1;
				int tempC=col+1;
				while(tempR >= 0 && tempR < queens && tempC >= 0 && tempC < queens)
				{
					if(board[tempR][tempC]==1)
						conflicts++;
					
					tempR--;
					tempC++;
				}
				//Check bottomright diagonal
				tempR=row+1;
				tempC=col+1;
				while(tempR >= 0 && tempR < queens && tempC >= 0 && tempC < queens)
				{
					if(board[tempR][tempC]==1)
						conflicts++;
					
					tempR++;
					tempC++;
				}
				//Check bottomleft diagonal
				tempR=row+1;
				tempC=col-1;
				while(tempR >= 0 && tempR < queens && tempC >= 0 && tempC < queens)
				{
					if(board[tempR][tempC]==1)
						conflicts++;
					
					tempR++;
					tempC--;
				}
				//Check topleft diagonal
				tempR=row-1;
				tempC=col-1;
				while(tempR >= 0 && tempR < queens && tempC >= 0 && tempC < queens)
				{
					if(board[tempR][tempC]==1)
						conflicts++;
					
					tempR--;
					tempC--;
				}
			}
		}
		
		counter++;
		
		//System.out.println(conflicts + " ::: " + bestConflicts);
		
		if(conflicts < bestConflicts)
		{
			
			bestConflicts = conflicts;
			bestPhenotype = "[";
			
			boolean temp;
			for(int i = bset.size(); i >= 0; --i)
			{
				
				if((i != bset.size()) && (i != 0) && (i % 8 == 0))
					bestPhenotype = bestPhenotype + "|";
				
				temp = bset.get(i);
				if(temp)
				{
					
					bestPhenotype = bestPhenotype + "1";
					
				}else
				{
					
					bestPhenotype = bestPhenotype + "0";
					
				} // if-else
				
			} // for
			
			bestPhenotype = bestPhenotype + "] --> " + Integer.toString(bestConflicts);
			
		} // if
		
		return conflicts;
		
	} // apply
	
} // NQueensFunction

public class NQueens 
{
	
	public static void main(String[] args) 
	{
		
		int N = Integer.parseInt(args[0]);
		
		NQueensFunction functionCall = new NQueensFunction(N);
		
		Factory<Genotype<BitGene>> genotypeFactory = Genotype.valueOf(new BitChromosome(N*N, 1.0/N));
		
		//Factory<Genotype<BitGene>> genotypeFactory = Genotype.valueOf(new BitChromosome("0101010101010100000000000000000000000000000000000"));
		
		//Factory<Genotype<BitGene>> genotypeFactory = Genotype.valueOf(new BitChromosome(bits));
		
		Function<Genotype<BitGene>, Integer> fitnessFunction = functionCall;
			
		GeneticAlgorithm<BitGene, Integer> geneticAlgorithm = new GeneticAlgorithm<>(genotypeFactory, fitnessFunction, Optimize.MINIMUM);
		
		geneticAlgorithm.setStatisticsCalculator(new NumberStatistics.Calculator<BitGene, Integer>());
		
		geneticAlgorithm.setPopulationSize(13000);
		
		geneticAlgorithm.setSelectors(new RouletteWheelSelector<BitGene, Integer>());
		
		geneticAlgorithm.setAlterers(new SwapMutator<BitGene>(0.5));
		
		geneticAlgorithm.setup();
		
		geneticAlgorithm.evolve(12000);
		
		System.out.println(geneticAlgorithm.getBestStatistics());
		
		System.out.println("\nFitness function called " + functionCall.getCounter() + " times.");
		System.out.println("Number of queens: " + N + "\n");
		System.out.println(functionCall.getBestPhenotypeMine());
		System.out.println(geneticAlgorithm.getBestPhenotype());

	} // main

} // NQueens
