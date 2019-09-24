import java.io.*;
import java.util.*;

public class Employee{
    
    String name;
    int no;
    int age;
    String state;
    int zip;
    int[] advisor;

    //(1)No Argument Constructor
    public Employee(){
	//System.out.println("Constructor called");
	name=null;
	no=0;
	age=0;
	state=null;
	zip=0;
	advisor=null;		
    }
    
    public static Employee[] em = null;  
    public static int totalNumber;
    public static String[] head = new String[8];
    
    
    //Read Data File
    public static void readfile(String fname){
	
	int icount = 0; 
	String line = "";
	
	try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fname);
	    // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

	    while((line = bufferedReader.readLine()) != null) {
                //parse line
		if(icount==0){
		    totalNumber = Integer.parseInt(line);
		    em = new Employee[totalNumber];
		    System.out.println("total number of employee: "+totalNumber);
		    icount++;
                }else{
		    if (icount==1){
			String[] lineStr = line.split(",");
			for(int i=0;i<8;i++){
			    //System.out.println(lineStr[0]);
			    head[i]=lineStr[i];
			}
			icount++;
		    }else{
			
			String[] lineStr = line.split(",");
			//System.out.println(lineStr.length);
			//System.out.println(icount);
			if(lineStr.length!=0) {
			    if(icount > em.length+2){
				System.out.println("There are too many students in the file. ");
				break;
			    }
			    //System.out.println("No.: "+icount);
			    em[icount-2] = new Employee();
			    em[icount-2].name = lineStr[0];
			    em[icount-2].no = Integer.parseInt(lineStr[1]);
			    em[icount-2].age = Integer.parseInt(lineStr[2]);
			    em[icount-2].state = lineStr[3];
			    em[icount-2].zip = Integer.parseInt(lineStr[4]);
			    if (lineStr.length==8){
				em[icount-2].advisor = new int[3];
				em[icount-2].advisor[0]=Integer.parseInt(lineStr[5]);
				em[icount-2].advisor[1]=Integer.parseInt(lineStr[6]);
				em[icount-2].advisor[2]=Integer.parseInt(lineStr[7]);
				
			    }
			    if (lineStr.length==7){
				em[icount-2].advisor = new int[2];
				em[icount-2].advisor[0]=Integer.parseInt(lineStr[5]);
				em[icount-2].advisor[1]=Integer.parseInt(lineStr[6]);
				
			    }	
			    if (lineStr.length==6){
				em[icount-2].advisor = new int[1];
				em[icount-2].advisor[0]=Integer.parseInt(lineStr[5]);
			    }		
			    icount++;
			}
		    }    
                }
            }
            bufferedReader.close(); // Always close files.         
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +  fname + "'");                
        }catch(IOException ex) {
            System.out.println("Error reading file '" + fname + "'");                  
        }
	System.out.println("Finish reading data from file "+ fname);
	
    }//End of data reading

    
    //Copy Constructor
    public Employee (Object obj) {
	if ((obj != null) && (obj instanceof Employee)){
	    // Creates new instance of Employee object Employee em= (Employee) obj;
	    Employee emcopy =(Employee) obj;
	    this.name = new String(emcopy.name);
	    this.no = emcopy.no;
	    this.age = emcopy.age;
	    this.state = new String(emcopy.state);
	    this.zip = emcopy.zip;
	    this.advisor = emcopy.advisor;
	    
	}
    } // End of Copy Constructor


    public String getName(){
	System.out.println("Get Name: "+name);
	return name;
    }

    
    public int getNumber(){
	System.out.println("Get Number: "+no);
	return no;
    }

    
    public int getAge(){
	System.out.println("Get Age: "+age);
	return age;
    }

    
    public String getState(){
	System.out.println("Get State: "+state);
	return state;
    }

    
    public int getZip(){
	System.out.println("Get Zip: "+zip);
	return zip;
    }

    
    public int[] getAdvisor(){
	if (advisor.length==3){
	    System.out.println("Get Advisor: "+advisor[0]+","+advisor[1]+","+advisor[2]);
	}
	if (advisor.length==2){
	    System.out.println("Get Advisor: "+advisor[0]+","+advisor[1]);
	}
	if (advisor.length==1){
	    System.out.println("Get Advisor: "+advisor[0]);
	}
	return advisor;
    }


    public void setName(String nameset){
	System.out.println("Set Name to: "+nameset);
	this.name=nameset;
    }
    
    
    public void setNumber(int noset){
	System.out.println("Set Number: "+noset);
	this.no=noset;
    }
    
    
    public void setAge(int ageset){
	System.out.println("Set Age: "+ageset);
	this.age=ageset;
    }
    
    
    public void setState(String stateset){
	System.out.println("Set State: "+stateset);
	this.state=stateset;
    }
    
    
    public void setZip(int zipset){
	System.out.println("Set Zip: "+zipset);
	this.zip=zipset;
    }
    
    
    public void setAdvisor(int advisorno, int advisorset){
	//System.out.println("Set advisor No.: "+advisorno+" to "+advisorset);
	this.advisor[advisorno-1]=advisorset;
    }


    public static String toString;
    public String toString(){
	if (advisor.length==3){
	    toString=(name+","+no+","+age+","+state+","+zip+","+advisor[0]+","+advisor[1]+","+advisor[2]);
	    System.out.println(toString);
	}
	if (advisor.length==2){
	    toString=(name+","+no+","+age+","+state+","+zip+","+advisor[0]+","+advisor[1]);
	    System.out.println(toString);
	}
	if (advisor.length==1){	    
	    toString=(name+","+no+","+age+","+state+","+zip+","+advisor[0]);
	    System.out.println(toString);
	}
	return toString;
    }

    
    public static boolean equals;
    public boolean equals(Object obj){
	if ((obj != null) && (obj instanceof Employee)){
	    Employee emcopy=(Employee) obj;
	    if (this.no==emcopy.no){
		equals=true;
	    }else{
		equals=false;
	    }
	}
	return equals;
    }
    
    /*
    public static int[] getAllAdvisors;
    public static int ic;
    public static int icount;
    */
    
    public static int[] getAllAdvisors;
    public static int icount;
    public static int[] getAllAdvisors(Employee e1, Employee e2){
    int ic;
	if ((e1 != null) && (e2 != null)){
	    Employee em1=(Employee) e1;
	    Employee em2=(Employee) e2;
	    	    
	    int no1=em1.advisor.length;
	    int no2=em2.advisor.length;
	    System.out.print(em1.name+" has "+no1+" advisor(s)");
	    for (int i=0;i<no1;i++){
		System.out.print(", "+em1.advisor[i]);	    
	    }
	    System.out.print("\n");
	    
	    System.out.print(em2.name+" has "+no2+" advisor(s)");
	    for (int i=0;i<no2;i++){
		System.out.print(", "+em2.advisor[i]);	    
	    }
	    System.out.print("\n");
	    
	    for (int i=0;i<no1;i++){
		for (int j=0;j<no2;j++){
		    if (em1.advisor[i]==em2.advisor[j]){
			em1.advisor[i]=0;
			em2.advisor[j]=0;
		    }
		}
	    }
	    icount=0;
	    for (int i=0;i<no1;i++){
		if (em1.advisor[i]!=0){
		    icount++;
		}
	    }
	    for (int j=0;j<no2;j++){		    
		if (em2.advisor[j]!=0){
		    icount++;
		}
	    }
	    
	    getAllAdvisors=new int[icount];

	    ic=0;
	    for (int i=0;i<no1;i++){
		if (e1.advisor[i]!=0){
		    getAllAdvisors[ic]=em1.advisor[i];
		    ic++;
		}
	    }
	    for (int j=0;j<no2;j++){		    
		if (e2.advisor[j]!=0){
		    getAllAdvisors[ic]=em2.advisor[j];
		    ic++;
		}
	    }
 
	}
	
	System.out.print("Distinct advisors are");
	for (int i=0;i<icount;i++){
	    System.out.print(", "+getAllAdvisors[i]);	    
	}
	System.out.print("\n ");	 
	return getAllAdvisors;
    }



	
    public static void main(String[] args) {
	
	//read data from test.csv test data file
	readfile("test.csv");	
	System.out.println("\n");
	

	//(2)Copy constructor
	System.out.println("(2) Copy constructor");
	System.out.println("Copy Employee no. 6's info into emcopy1");
	Employee emcopy1 = new Employee (em[5]);	
	System.out.println("name copied into emcopy1");
	System.out.println(emcopy1.name);
	System.out.println("Set emcopy1 name to Geferry");
	emcopy1.name="Geferry";
	System.out.println("name of emcopy1");
	System.out.println(emcopy1.name);
	System.out.println("name of Empolyee no.6");
	System.out.println(em[5].name);	
	System.out.println("\n");


	//(3)get and set method
	System.out.println("(3) get and set method");
	System.out.println("Employee no. 1 has name of "+em[0].getName());
	System.out.println("Set Employee no.2 name to Tommy");
	System.out.println("Before set");
	System.out.println(em[0].getName());
	em[2].setName("Tommy");
	System.out.println("After set");
	System.out.println(em[0].getName());
	System.out.println("Employee no. 3 advisor 1 to advisor 9");
	System.out.println("Before set");
	em[2].toString();	
	em[2].setAdvisor(1,9);
	System.out.println("After set");
	em[2].toString();
	System.out.println("\n");
	

	//(4)toString method testing
	System.out.println("(4) toString method");
	em[2].toString();
	em[6].toString();
	System.out.println("\n");
	
	
	//(5)equal method testing
	System.out.println("(5) equal method");
	System.out.println(em[2].equals(em[4]));
	System.out.println(em[2].equals(em[2]));
	System.out.println("\n");
	
	//(6)getAllAdvisors method testing
	System.out.println("(6) getAllAdvisors method");
	System.out.println("In total "+getAllAdvisors(em[0],em[3]).length+" distinct advisors");
	System.out.println("\n");
	System.out.println("In total "+getAllAdvisors(em[3],em[5]).length+" distinct advisors");


	
    }
    
    
}
