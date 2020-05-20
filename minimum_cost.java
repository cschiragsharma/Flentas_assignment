import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;
public class minimum_cost {
	static long minimumCost(long price[], int n) 
    { 
      
        // Sort the price array 
        Arrays.sort(price); 
          
        long totalCost = 0; 
      
        // Calculate minimum price 
        // of n-2 most costly person 
        for (int i = n - 1; i > 1; i -= 2) 
        { 
            if (i == 2) 
            { 
                totalCost += price[2] + price[0]; 
            } 
            else
            { 
      
                // Both the ways as discussed above 
                long price_first = price[i] + price[0] + 2 * price[1]; 
                long price_second = price[i] + price[i - 1] + 2 * price[0]; 
                totalCost += Math.min(price_first, price_second); 
            } 
        } 
      
        // Calculate the minimum price 
        // of the two cheapest person 
        if (n == 1) 
        { 
            totalCost += price[0]; 
        } 
        else
        { 
            totalCost += price[1]; 
        } 
      
        return totalCost; 
    } 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
        String strLine = "";
        String str_data = "";
        int i =1;
        try {
             BufferedReader br = new BufferedReader(new FileReader("input.txt"));             
             String noOfTestCases = br.readLine();
             for( i=1;i<=Integer.parseInt(noOfTestCases);i++)  //typecasted Stringto int
             {
            	 int n = Integer.parseInt(br.readLine());
            	 String a = br.readLine(); // to read multiple integers line
            	 long [] numArr = Stream.of(a.split(" ")).mapToLong(Integer::parseInt).toArray();
            	 System.out.println(minimumCost(numArr, n));
             }
             
             while (strLine != null)
             {
                if (strLine == null)
                  break;
                str_data = strLine;
                strLine = br.readLine();
                System.out.println(str_data);
             }
            
             br.close();
            }catch (FileNotFoundException e) {
                System.err.println("File not found");
            } catch (IOException e) {
                System.err.println("Unable to read the file.");
            }
        
		long price[] = { 600,800,150,700 }; 
        int n = price.length; 
      
        
	}

}
