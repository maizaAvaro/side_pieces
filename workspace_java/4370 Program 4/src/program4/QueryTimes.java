package program4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

public class QueryTimes {
	
	private Table student;
	private Table professor;
	private Table course;
	private Table teaching;
	private Table transcript;
	private Comparable [][][] resultTest;
	private String fileName;
	private int[] tups1;
	private int[] tups2;
	private int[] tups3;
	private int[] tups4;
	private int[] tups5;
	private int[] tups6;
	
	public QueryTimes(int flip)
	{
		
		TupleGenerator test = new TupleGeneratorImpl ();

        test.addRelSchema ("Student",
                           "id name address status",
                           "Integer String String String",
                           "id",
                           null);
        
        test.addRelSchema ("Professor",
                           "id name deptId",
                           "Integer String String",
                           "id",
                           null);
        
        test.addRelSchema ("Course",
                           "crsCode deptId crsName descr",
                           "String String String String",
                           "crsCode",
                           null);
        
        test.addRelSchema ("Teaching",
                           "crsCode semester profId",
                           "String String Integer",
                           "crsCode semester",
                           new String [][] {{ "profId", "Professor", "id" },
                                            { "crsCode", "Course", "crsCode" }});
        
        test.addRelSchema ("Transcript",
                           "studId crsCode semester grade",
                           "Integer String String String",
                           "studId crsCode semester",
                           new String [][] {{ "studId", "Student", "id"},
                                            { "crsCode", "Course", "crsCode" },
                                            { "crsCode semester", "Teaching", "crsCode semester" }});
        
        tups1 = new int [] { 50, 1000, 2000, 50000, 50 };
        tups2 = new int [] { 100, 1000, 2000, 50000, 50 };
        tups3 = new int [] { 500, 1000, 2000, 50000,  125};
        tups4 = new int [] { 1000, 1000, 2000, 50000, 175 };
        tups5 = new int [] { 5000, 1000, 2000, 50000, 250 };
		tups6 = new int [] { 10000, 1000, 2000, 50000, 500 };
		
		fileName = "src/test.csv";
		student = new Table ("Student", "id name address status", "Integer String String String", "id");
		professor = new Table ("Professor","id name deptId", "Integer String String", "id");
		course = new Table ("Course", "crsCode deptId crsName descr", "String String String String", "crsCode");
		teaching = new Table ("Teaching", "crsCode semester profId", "String String Integer", "crsCode semester");
		transcript = new Table ("Transcript", "studId crsCode semester grade", "Integer String String String", "studId crsCode semester");
        
		if(flip == 1)
		{
			resultTest = test.generate (getTupsArray1());
		}else if(flip == 2)
		{
			resultTest = test.generate (getTupsArray2());
		}else if(flip == 3)
		{
			resultTest = test.generate (getTupsArray3());
		}else if(flip == 4)
		{
			resultTest = test.generate (getTupsArray4());
		}else if(flip == 5)
		{
			resultTest = test.generate (getTupsArray5());
		}else if(flip == 6)
		{
			resultTest = test.generate (getTupsArray6());
		}
		
		
		
	} //QueryTimes
	
	public void setFileName(String fileName)
	{
		
		this.fileName = fileName;
		
	} // setFileName
	
	public String getFileName()
	{
		
		return fileName;
		
	} // getFileName
	
	public int[] getTupsArray1()
	{
		
		return tups1;
		
	} // getTupsArray1
	
	public int[] getTupsArray2()
	{
		
		return tups2;
		
	} // getTupsArray2
	
	public int[] getTupsArray3()
	{
		
		return tups3;
		
	} // getTupsArray3
	
	public int[] getTupsArray4()
	{
		
		return tups4;
		
	} // getTupsArray4
	
	public int[] getTupsArray5()
	{
		
		return tups5;
		
	} // getTupsArray5
	
	public int[] getTupsArray6()
	{
		
		return tups6;
		
	} // getTupsArray6

	/**
	 * Driver to test for query wars - with some code recycled from Dr. John Miller
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException 
	{
		int run = 1;
		
		while(run < 7)
		{
			
			QueryTimes query = new QueryTimes(run);
			
	        ArrayList<Integer> studentId = new ArrayList<Integer>();
	        Integer upperBound = 0;
	        Integer lowerBound = 0;
	        
	        for (int i = 0; i < query.resultTest.length; i++) {
	            for (int j = 0; j < query.resultTest [i].length; j++) {
	                switch(i)
	                {
	                case 0:
	                	studentId.add((Integer)query.resultTest[i][j][0]);
	                	query.student.insert(query.resultTest[i][j]);
	                	break;
	                case 1:
	                	query.professor.insert(query.resultTest[i][j]);
	                	break;
	                case 2:
	                	query.course.insert(query.resultTest[i][j]);
	                	break;
	                case 3:
	                	query.teaching.insert(query.resultTest[i][j]);
	                	break;
	                case 4:
	                	query.transcript.insert(query.resultTest[i][j]);
	                	break;
	                default:
	                	//oh god what's happening
	                	break;
	                }
	            } // for
	        } // for
	        
	        Random generator = new Random();
	        int index = 0;
	        int[] tupleArray = { 50, 1000, 2000, 50000, 50 };
	        
	        if(run == 1)
	        {
	        	tupleArray = query.getTupsArray1();
	        }else if(run == 2)
	        {
	        	tupleArray = query.getTupsArray2();
	        }else if(run == 3)
	        {
	        	tupleArray = query.getTupsArray3();
	        }else if(run ==4)
	        {
	        	tupleArray = query.getTupsArray4();
	        }else if(run == 5)
	        {
	        	tupleArray = query.getTupsArray5();
	        }else if(run == 6)
	        {
	        	tupleArray = query.getTupsArray6();
	        }
	        
	        // Set the file name for the .csv file and execute the point query
	        if(run == 1)
	        {
	        	query.setFileName("src/ArrayList_BpTree_PointSelect_1.csv");
	        }else if(run == 2)
	        {
	        	query.setFileName("src/ArrayList_BpTree_PointSelect_2.csv");
	        }else if(run == 3)
	        {
	        	query.setFileName("src/ArrayList_BpTree_PointSelect_3.csv");
	        }else if(run ==4)
	        {
	        	query.setFileName("src/ArrayList_BpTree_PointSelect_4.csv");
	        }else if(run == 5)
	        {
	        	query.setFileName("src/ArrayList_BpTree_PointSelect_5.csv");
	        }else if(run == 6)
	        {
	        	query.setFileName("src/ArrayList_BpTree_PointSelect_6.csv");
	        }
	        
			PrintWriter pw1 = new PrintWriter(query.getFileName(), "UTF-8");
	        
	        for(int i = 0; i < 5; ++i)
	        {
	        	
	        	index = Math.abs(generator.nextInt() % studentId.size());
	        	
	        	double startTime = System.nanoTime() * 1.0;
	        	
	            query.student.select("id = "+ studentId.get(index));

				double endTime = System.nanoTime() * 1.0;
				
				double factor = 1000000.0;
				double conversion = (endTime - startTime)/factor; // ns to ms
				
				pw1.println(""+tupleArray[0]+", "+ conversion);
	        	
	        } // for
	        
	        pw1.close();
	        
	        // Set the file name for the .csv file and execute the range query
	        if(run == 1)
	        {
	        	query.setFileName("src/ArrayList_BpTree_RangeSelect_1.csv");
	        }else if(run == 2)
	        {
	        	query.setFileName("src/ArrayList_BpTree_RangeSelect_2.csv");
	        }else if(run == 3)
	        {
	        	query.setFileName("src/ArrayList_BpTree_RangeSelect_3.csv");
	        }else if(run ==4)
	        {
	        	query.setFileName("src/ArrayList_BpTree_RangeSelect_4.csv");
	        }else if(run == 5)
	        {
	        	query.setFileName("src/ArrayList_BpTree_RangeSelect_5.csv");
	        }else if(run == 6)
	        {
	        	query.setFileName("src/ArrayList_BpTree_RangeSelect_6.csv");
	        }
	        
	        PrintWriter pw2 = new PrintWriter(query.getFileName(), "UTF-8");
	        
	        for(int i = 0; i < 5; ++i)
	        {
	        	
	        	lowerBound = Math.abs(generator.nextInt() % 500000);
	        	upperBound = Math.abs((generator.nextInt() % 500000)) + lowerBound;
	        	
	        	double startTime = System.nanoTime() * 1.0;
	        	
	        	query.student.select("id >= "+ lowerBound + " && id <= " + upperBound);
	        	
	        	double endTime = System.nanoTime() * 1.0;
				
				double factor = 1000000.0;
				double conversion = (endTime - startTime)/factor; // ns to ms
				
				pw2.println(""+tupleArray[0]+", "+ conversion);
	        	
	        } // for
	        
	        pw2.close();
	        
	        // Set the file name for the .csv file and execute the join query
	        if(run == 1)
	        {
	        	query.setFileName("src/FileList_ExtHash_Join_1.csv");
	        }else if(run == 2)
	        {
	        	query.setFileName("src/FileList_ExtHash_Join_2.csv");
	        }else if(run == 3)
	        {
	        	query.setFileName("src/FileList_ExtHash_Join_3.csv");
	        }else if(run ==4)
	        {
	        	query.setFileName("src/FileList_ExtHash_Join_4.csv");
	        }else if(run == 5)
	        {
	        	query.setFileName("src/FileList_ExtHash_Join_5.csv");
	        }else if(run == 6)
	        {
	        	query.setFileName("src/FileList_ExtHash_Join_6.csv");
	        }
	        
	        PrintWriter pw3 = new PrintWriter(query.getFileName(), "UTF-8");
	        
	        for(int k = 0; k < 5; ++k)
	        {
	        	
	        	QueryTimes nextQuery = new QueryTimes(run);
	        	
	        	 for (int i = 0; i < nextQuery.resultTest.length; i++) {
	 	            for (int j = 0; j < nextQuery.resultTest [i].length; j++) {
	 	                switch(i)
	 	                {
	 	                case 0:
	 	                	nextQuery.student.insert(query.resultTest[i][j]);
	 	                	break;
	 	                case 1:
	 	                	nextQuery.professor.insert(query.resultTest[i][j]);
	 	                	break;
	 	                case 2:
	 	                	nextQuery.course.insert(query.resultTest[i][j]);
	 	                	break;
	 	                case 3:
	 	                	nextQuery.teaching.insert(query.resultTest[i][j]);
	 	                	break;
	 	                case 4:
	 	                	nextQuery.transcript.insert(query.resultTest[i][j]);
	 	                	break;
	 	                default:
	 	                	//oh god what's happening
	 	                	break;
	 	                }
	 	            } // for
	 	        } // for
	        	
	        	double startTime = System.nanoTime() * 1.0;
	        	
	        	nextQuery.student.join("id == studId", nextQuery.transcript);
	        	
	        	double endTime = System.nanoTime() * 1.0;
				
				double factor = 1000000.0;
				double conversion = (endTime - startTime)/factor; // ns to ms
				
				pw3.println(""+(tupleArray[0] + tupleArray[4])+", "+ conversion);
	        	
	        } // for
	        
	        pw3.close();
	        
	        run++;
			
		} // while
        
	} // main

} // queryTimes
