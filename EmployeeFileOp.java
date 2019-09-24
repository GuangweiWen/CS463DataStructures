import java.io.*;
import java.util.*;

/*class employee{
    String LastName;
    String FirstName;
    String Number;
    String State;
    String Zip;
    int Age;
    String Sex;	    
}
*/


public class EmployeeFileOp{

    private static int icount=302;   
    private static BufferedReader br = null;
    private static String line = "";
    private static String cvsSplitBy = ",";

    /*
    public static void readnumberofrows(String fname) {
	
	try { 
            br = new BufferedReader(new FileReader(fname));
	    br.mark((int)fname.length());
            while ((line = br.readLine()) != null) {
		icount++;
            } 
	    br.reset();
	} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	
	icount=icount-1;
	System.out.println("In total "+icount+" employees");
	String[][] dataread = new String[icount][7];
	int[] age = new int[icount];
    }

    */
    
    private static int[] age = new int[icount];
    private static String[][] dataread = new String[icount][7];
    
    public static void read(String fname){
	
	try {
	    int i;
	    i=0;
            br = new BufferedReader(new FileReader(fname));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] data = line.split(cvsSplitBy);
		
		if (i==icount)
		    {break;
		    }

		
		if (i==0)
		    {
			dataread[i][0] =  data[0]; //Name
			dataread[i][2] =  data[1]; //Number
			dataread[i][3] =  data[2]; //State
			dataread[i][4] =  data[3]; //Zip code
			dataread[i][5] =  data[5]; //Age
			dataread[i][6] =  data[6]; //Sex
			//System.out.println(i);
			i++;
		    }
		
		else
		    {			
			dataread[i][0] =  data[0]; // "Last Name
			//System.out.println(dataread[i][0]);
			dataread[i][1] =  data[1]; // First Name"
			dataread[i][2] =  data[2]; // Number
			dataread[i][3] =  data[3]; // State
			dataread[i][4] =  data[4]; // Zip code
			dataread[i][5] =  data[6]; // Age
			dataread[i][6] =  data[7]; // Sex
			//System.out.println(i);
			i++;
		    }
		
	    }
	    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    
	
    private static int j=0;
    public static void write(String fname){
	try {
	    File file = new File(fname);	    
	    FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw); 
	    bw.write(dataread[0][0]+","+dataread[0][2]+","+dataread[0][3]+","+dataread[0][4]+","+dataread[0][5]+","+dataread[0][6]+"\n");
	    for(int i=1;i<icount;i++){
		age[i]=Integer.parseInt(dataread[i][5]);
		if (age[i]<=30){
		    j++;
		    bw.write(dataread[i][0]+","+dataread[i][1]+","+dataread[i][2]+","+dataread[i][3]+","+dataread[i][4]+","+dataread[i][5]+","+dataread[i][6]+"\n");
		}
	    }
	    bw.close();
	    fw.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	System.out.println("In total "+j+" employee under 30 or equal 30 years old");
	System.out.println("Finish writing to file "+ fname);
    }	
    

    

	public static void main(String[] args) {
	    
	    //readnumberofrows("./core_dataset.csv"); //read the data file
		read("./core_dataset.csv"); //read the data file
		write("./young_employee.csv");  //write employees info to a csv file
	}

}
