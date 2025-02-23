//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String story = "";

	public MadLib()
	{
		verbs.add("punched");
		nouns.add("Walmart");
		adjectives.add("massive");
		story=("I punched Walmart in a massive way");
	}

	public MadLib(String fileName)
	{
		//load stuff
		loadNouns();
		loadVerbs();
		loadAdjectives();
		try
		{
			//Read the different parts of the story and concatenate the resulting
			//story using the symbols to tell you the parts of speech
			Scanner reader = new Scanner(new File("story.dat"));
			
			String storyUntrans = " ";

			while(reader.hasNext()){
				storyUntrans += reader.next() + " ";
				}
				reader.close();
			Scanner stor = new Scanner(storyUntrans);
			while(stor.hasNext()){
				String word = stor.next();
				if(word.equals("#")){
					story += getRandomNoun() + " ";
				}
				else if(word.equals("@")){
					story += getRandomVerb() + " ";
				}
				else if(word.equals("&")){
					story += getRandomAdjective() + " ";
				}
				else{
					story += word + " ";
				}
			}
			
			stor.close();
			//While there is more of the story, read in the word/symbol

				//If what was read in is one of the symbols, find a random
				//word to replace it.
			


		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}

	}

	public void loadNouns()
	{
		try
		{
			Scanner nounscan = new Scanner(new File("nouns.dat"));

			while(nounscan.hasNext()){
				nouns.add(nounscan.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("nouns.dat does not exist");
		}

	}

	public void loadVerbs()
	{
		try
		{
			Scanner verbscan = new Scanner(new File("verbs.dat"));

			while(verbscan.hasNext()){
				verbs.add(verbscan.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("verbs.dat does not exist");
		}
	}

	public void loadAdjectives()
	{
		try
		{
			Scanner adjscan = new Scanner(new File("adjectives.dat"));

			while(adjscan.hasNext()){
				adjectives.add(adjscan.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("adjectives.dat does not exist");
		}
	}

	public String getRandomVerb()
	{
		int spot = (int)(Math.random()*verbs.size());
		return "" + verbs.get(spot);
	}

	public String getRandomNoun()
	{
		Random rand = new Random();
		return "" + nouns.get(rand.nextInt(nouns.size()));
	}

	public String getRandomAdjective()
	{
		int spot = (int)(Math.random()*verbs.size());
		return "" + adjectives.get(spot);
	}

	public String toString()
	{
		return "" + story;
	}
}