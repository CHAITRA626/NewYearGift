package com.codebind.maven_project;
import java.util.*;
import java.util.Scanner;
public class MavenProject {
	static Scanner cin=new Scanner(System.in);
	static ArrayList<Choco> chocolates=new ArrayList<Choco>();
	static ArrayList<Choco> candies=new ArrayList<Choco>();
	static ArrayList<Sweet> sweets=new ArrayList<Sweet>();
	static HashMap<String,Integer> Weight=new HashMap<String,Integer>();
	static HashMap<String,Integer> Price=new HashMap<String,Integer>();
	public static void main(String args[])
	{
		Chocolates();
		Sweets();
		System.out.println("Total weight of gift is:"+totalWeight());
		int sort_ByType=cin.nextInt();
		if(sort_ByType==1) {
			Comparator<Choco> Choco_by_Price=new Comparator<Choco>() {
				@Override
				public int compare(Choco c1,Choco c2)
				{
					return((Integer)c1.getPrice()).compareTo(c2.getPrice());
				}
			};
			Collections.sort(chocolates,Choco_by_Price);
		}
		else {
			Comparator<Choco> Choco_by_Weight=new Comparator<Choco>() {
				@Override
				public int compare(Choco c1,Choco c2)
				{
					return((Integer)c1.getWeight()).compareTo(c2.getWeight());}
			};
			Collections.sort(chocolates,Choco_by_Weight);
		}
		System.out.println("Sorted list:");
		for(Choco chocolate:chocolates) {
			System.out.println(chocolate.getPrice());
		}
		Range(sort_ByType);
		}
		public static void Chocolates() {
			System.out.println("enter the chocolate number:");
			int nc=cin.nextInt();
			for(int i=1;i<=nc;i++) {
				System.out.println("enter the type(enter the number):1.candy 2.wafer 3.chips 4.bar");
				int choco_Type=cin.nextInt();
				System.out.println("enter the chocolate weight:");
				int choco_Weight=cin.nextInt();
				System.out.println("enter the chocolate price:");
				int choco_Price=cin.nextInt();
				if(choco_Type==1) {
					System.out.println("enter candy name:");
					String canName=cin.next();
					if(Weight.containsKey(canName)) {
						Weight.put(canName,(int)Weight.get(canName)+choco_Weight);
					}
					else
						Weight.put(canName,choco_Weight);
					if(Price.containsKey(canName)) {
						Price.put(canName,(int)Price.get(canName)+choco_Price);
					}
					else
						Price.put(canName,choco_Price);

				}
				Choco c=new Choco(choco_Weight,choco_Price);
				chocolates.add(c);
				if(choco_Type==1) {
					candies.add(c);
				}
			}
		}
		public static void Sweets()
		{
			System.out.println("enter the sweets number:");
			int swt=cin.nextInt();
			for(int j=1;j<=swt;j++) {
				System.out.println("enter the sweet weight:");
				int sweet_Weight=cin.nextInt();
				System.out.println("enter the sweet price:");
				int sweet_Price=cin.nextInt();
				Sweet n=new Sweet(sweet_Weight,sweet_Price);
				sweets.add(n);
			}
		}
		public static int totalWeight() {
			int weight=0;
			for(Choco chocolate:chocolates) {
				weight+=chocolate.getWeight();
			}
			for(Sweet n:sweets) {
				weight+=n.getWeight();
			}
			return weight;
		}
		public static void Range(int sortByType) {
			int lowlimit,highlimit;
			if(sortByType==1) {
				System.out.println("enter lower limit:");
				lowlimit=cin.nextInt();
				System.out.println("enter higher limit:");
				highlimit=cin.nextInt();
				Set<Map.Entry<String,Integer>> candySet=Price.entrySet();
				Iterator<Map.Entry<String,Integer>> candyIterator=candySet.iterator();
				while(candyIterator.hasNext()) {
					Map.Entry<String,Integer> candyElement=(Map.Entry<String,Integer>)candyIterator.next();
					int currentPrice=(int)candyElement.getValue();
					if(currentPrice>=lowlimit && currentPrice<=highlimit)
						System.out.println(candyElement.getKey());
				}
			}
			else
			{
				System.out.println("enter lower limit:");
				lowlimit=cin.nextInt();
				System.out.println("enter higher limit:");
				highlimit=cin.nextInt();
				Set<Map.Entry<String,Integer>> candySet=Weight.entrySet();
				Iterator<Map.Entry<String,Integer>> candyIterator=candySet.iterator();
				while(candyIterator.hasNext()) {
					Map.Entry<String,Integer> candyElement=(Map.Entry<String,Integer>)candyIterator.next();
					int currentWeight=(int)candyElement.getValue();
					if(currentWeight>=lowlimit && currentWeight<=highlimit)
						System.out.println(candyElement.getKey());
				}
			}
		}
}
