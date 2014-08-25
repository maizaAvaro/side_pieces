package program1;

import java.util.List;

import junit.framework.TestCase;

/**
 * Class that tests the Table class
 *
 */
public class TableTest extends TestCase 
{

	/**
	 * Tests the method select of the Table class
	 */
	public void testSelect() 
	{
		
		Table movie = new Table ("movie", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");
		
		Table select = new Table ("select", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");
		
		Comparable [] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
        Comparable [] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
        Comparable [] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
        Comparable [] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
        
        movie.insert (film0);
        movie.insert (film1);
        movie.insert (film2);
        movie.insert (film3);
        
        select.insert(film0);
        
        Table t_select = movie.select ("title == 'Star_Wars'");
        
        List <Comparable []> selectList = select.getTuples();
        List <Comparable []> t_selectList = t_select.getTuples();
        
        int selectSize = selectList.size();
        int t_selectSize = t_selectList.size();
        
        assertTrue("Lists are of equal size", selectSize == t_selectSize);
        
        assertTrue("The two tables are equal", select.compare(t_select));
        
        select.print();
        t_select.print();

	} // testSelect
	
	/**
	 * Tests the method project of the Table class
	 */
	public void testProject()
	{
		
		Table movie = new Table ("movie", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");
		
		Table project = new Table ("project", "title year",
                "String Integer", "title year");
		
		Comparable [] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
        Comparable [] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
        Comparable [] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
        Comparable [] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
        Comparable [] film4 = { "Star_Wars", 1977 };
        Comparable [] film5 = { "Star_Wars_2", 1980 };
        Comparable [] film6 = { "Rocky", 1985 };
        Comparable [] film7 = { "Rambo", 1978 };
        
        movie.insert (film0);
        movie.insert (film1);
        movie.insert (film2);
        movie.insert (film3);
        
        project.insert(film4);
        project.insert(film5);
        project.insert(film6);
        project.insert(film7);
        
        Table t_project = movie.project ("title year");
        
        List <Comparable []> projectList = project.getTuples();
        List <Comparable []> t_projectList = t_project.getTuples();
        
        int projectSize = projectList.size();
        int t_projectSize = t_projectList.size();
        
        assertTrue("Lists are of equal size", projectSize == t_projectSize);
        
        assertTrue("The tables are equal", project.compare(t_project));
        
        project.print();
        t_project.print();
		
	}	// testProject
	
	/**
	 * Tests the method union of the Table class
	 */
	public void testUnion()
	{
		
		Table movie = new Table ("movie", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");

		Table cinema = new Table ("cinema", "title year length genre studioName producerNo",
                  "String Integer Integer String String Integer", "title year");
		
		Comparable [] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
        Comparable [] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
        Comparable [] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
        Comparable [] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
        Comparable [] film4 = { "Galaxy_Quest", 1999, 104, "comedy", "DreamWorks", 67890 };
        
        movie.insert (film0);
        movie.insert (film1);
        movie.insert (film2);
        movie.insert (film3);
        
        cinema.insert (film2);
        cinema.insert (film3);
        cinema.insert (film4);
        
        Table union = new Table ("union", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");
        
        union.insert (film0);
        union.insert (film1);
        union.insert (film2);
        union.insert (film3);
        union.insert (film2);
        union.insert (film3);
        union.insert (film4);

        Table t_union = movie.union (cinema);
        
        List <Comparable []> unionList = union.getTuples();
        List <Comparable []> t_unionList = t_union.getTuples();
        
        int unionSize = unionList.size();
        int t_unionSize = t_unionList.size();
        
        assertTrue("Lists are of equal size", unionSize == t_unionSize);
        
        assertTrue("The tables are equal", union.compare(t_union));
        
        union.print();
        t_union.print();
		
	}	// testUnion
	
	/**
	 * Tests the method minus of the Table class
	 */
	public void testMinus()
	{
		
		Table movie = new Table ("movie", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");

		Table cinema = new Table ("cinema", "title year length genre studioName producerNo",
                  "String Integer Integer String String Integer", "title year");
		
		Comparable [] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
        Comparable [] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
        Comparable [] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
        Comparable [] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
        Comparable [] film4 = { "Galaxy_Quest", 1999, 104, "comedy", "DreamWorks", 67890 };
        
        movie.insert (film0);
        movie.insert (film1);
        movie.insert (film2);
        movie.insert (film3);
        
        cinema.insert (film2);
        cinema.insert (film3);
        cinema.insert (film4);
        
        Table minus = new Table ("minus", "title year length genre studioName producerNo",
                "String Integer Integer String String Integer", "title year");
        
        minus.insert(film0);
        minus.insert(film1);
        minus.insert(film4);
        
        Table t_minus = movie.minus (cinema);
        
        List <Comparable []> minusList = minus.getTuples();
        List <Comparable []> t_minusList = t_minus.getTuples();
        
        int minusSize = minusList.size();
        int t_minusSize = t_minusList.size();
        
        assertTrue("Lists are of equal size", minusSize == t_minusSize);
        
        assertTrue("The tables are equal", minus.compare(t_minus));
        
        minus.print();
        t_minus.print();
		
	}	// testMinus

}	// TableTest