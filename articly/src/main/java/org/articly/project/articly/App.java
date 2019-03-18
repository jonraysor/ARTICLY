package org.articly.project.articly;
import org.json.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        

    		System.out.println(Backend.getHTML());
		JSONObject obj = new JSONObject(Backend.getHTML());
		String pageName = obj.getString("Copyright");
		
		System.out.println(pageName);
        
    }
}
