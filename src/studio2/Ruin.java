package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Whats your starting number of chips");
		double startAmount = in.nextDouble();
		double forever= startAmount;
		System.out.println("Win chance?");
		double winChance = in.nextDouble();
		System.out.println("Whats your win limit?");
		double winLimit = in.nextDouble();
		System.out.println("How many simulations would you like to run?");
		double simulation = in.nextDouble();
		double Losses=0.0;
		double Wins=0.0;
		double a = (1.0-winChance)/winChance;
		int bestGame=0;
		for(int i=1; i <= simulation; i++)
		{
			int games=0;
			while(startAmount!=0 && startAmount!=winLimit)
			{
				if(Math.random()<=winChance)
					{
				startAmount++;
				games++;
					}
			else
				{
				startAmount--;
				games++;
				}
				if (games>bestGame)
				{
					bestGame=games;
				}
			}
	
		
		if(startAmount == 0)
		{
			System.out.println("Simultation "+ i+ ": "+ games+ " LOSE");
			Losses++;
		}
		else
		{
			System.out.println("Simultation "+ i+ ": "+ games+" WIN");
			Wins++;
		}
		startAmount= forever;
		}
		System.out.println("Losses: " + Math.round(Losses) + " Simulations: " + Math.round(simulation));
		if(winChance==.5)
		{
		System.out.println("Ruin Rate from Simulation: " + (Losses/simulation) + " Expected Ruin Rate: " + (1.0-(startAmount/winLimit)));
		}
		else
		System.out.println("Ruin Rate from Simulation: " + (Losses/simulation) + " Expected Ruin Rate: " + (Math.pow(a, startAmount) - Math.pow(a, winLimit))/(1.0-Math.pow(a, winLimit)));
		System.out.println("Best Game "+ bestGame);

	}
}
