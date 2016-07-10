package match.regex.test;
import java.io.*;
import java.util.Scanner;

public class InputManager {
	public static int fileSize(String rootfile){
		return new File(rootfile).listFiles().length-1;
	}
	public static boolean checkfile(String filepath)
	{
		File f=new File(filepath);
		
		return f.exists();
	}

	public static void main(String args[]) throws IOException{
		
		
		//String inputfilename="origin";
		String inputfilename=args[0];
		String profileID=args[1];
		String outputfile=args[2];
		RegexTestPatternMatcher.readProperties(profileID);
		//System.out.println(inputfilename);
		int serverNumber= fileSize(inputfilename);
	

		for(int j=1;j<=serverNumber;j++)
		{
			OutputManager.setupoutfile(j);
			int lognumber=fileSize(inputfilename+"/bento"+j);
			//System.out.println("lognumber"+lognumber);
			boolean log0exist=checkfile(inputfilename+"/bento"+j+"/bento.log");
			int start;
			if(log0exist==true)
			{
				start=lognumber-1;
			}
			else
			{
				start=lognumber;
			}
			
			for(int i=start;i>=1;i--)
		    {  
		    	String filename=inputfilename+"/bento"+j+"/bento.log."+i;
		    	//System.out.println(filename);
		    	
		    	File file=new File(filename);
		    
				Scanner reader=new Scanner(file);

				String current;
				while(reader.hasNextLine())
				{
					current=reader.nextLine();
					RegexTestPatternMatcher.stringReceiver(current);
				}
				
				reader.close();
		    }
			if(log0exist==true)
			{
				String filename=inputfilename+"/bento"+j+"/bento.log";
		    	//System.out.println(filename);
		    	
		    	File file=new File(filename);
		    
				Scanner reader=new Scanner(file);

				String current;
				while(reader.hasNextLine())
				{
					current=reader.nextLine();
					RegexTestPatternMatcher.stringReceiver(current);
				}
				reader.close();
			}
		}
		
		MainManager.merge(outputfile);	
}
}
