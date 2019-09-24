import java.io.*;
import java.util.*;

public class EmployeeSet{

    public static class Employee{
	String name;
	int no;
	int age;
	String state;
	int zip;
	int[] advisor;
	
	//Constructor for Employee object
	public Employee(){
	    //System.out.println("Constructor called");
	    name=null;
	    no=0;
	    age=0;
	    state=null;
	    zip=0;
	    advisor=null;		
	}
    }  


    //EmployeeSet No Argument Constructor    
    public static Employee[] em = null;
    public EmployeeSet(){
	final int initial_capacity=10;
	em = new Employee[initial_capacity];
	for (int i=0;i<initial_capacity;i++){
	    em[i]=new Employee();
	}
    }
    

    //EmployeeSet Copy Constructor
    public EmployeeSet(Object obj) {
	if ((obj != null) && (obj instanceof Employee)){
	    // Creates new instance of EmployeeSet collection EmployeeSet datacopy= (EmployeeSet) obj;
	    EmployeeSet datacopy = (EmployeeSet) obj;
	    for (int i=0;i<datacopy.em.length;i++){
		this.em[i].name =new String(datacopy.em[i].name);
		this.em[i].no   = datacopy.em[i].no;
		this.em[i].age  = datacopy.em[i].age;
		this.em[i].state= new String(datacopy.em[i].state);
		this.em[i].zip  = datacopy.em[i].zip;
		for (int j=0;j<this.em[i].advisor.length;i++){
		    this.em[i].advisor[j] = datacopy.em[i].advisor[j];
		}
	    }
	}
    }
    

    //Returns the Actual Number of Elements in This Collection.
    public int size;
    public int size(){
	size=0;
	for (int i=0;i<this.em.length;i++){
	    if (em[i].name!=null){
		size++;
	    }
	}
	return size;
    }


    //Returns the Capacity of This Collection Instance.
    public int capacity(){
	return this.em.length;
    }


    //Adds One Given Employee Object to the First Available Space of the Employee Array
    public boolean same;
    public void add(Employee a){
	if ((a != null) && (a instanceof Employee)){
	    same=this.contains(a);
	    if (same==true){
		System.out.println("!There already has been an employee with the same Employee Number in the database, fail to add current employee info.");
		System.out.println("Employee name and number "+a.name+" "+a.no); 
		System.out.println("\n"); 
	    }else{
		if (this.size()<this.capacity()){
		    //System.out.println("size"+this.size());
		    //System.out.println("capacity"+this.capacity());
		    int position=this.size();
		    this.em[position].name=a.name;
		    this.em[position].no=a.no;
		    this.em[position].age =a.age;
		    this.em[position].state =a.state;
		    this.em[position].zip = a.zip;
		    this.em[position].advisor = new int[a.advisor.length];
		    for (int j=0;j<a.advisor.length;j++){
			this.em[position].advisor[j] = a.advisor[j];
		    }
		}else{
		    int icapacity=this.capacity();
		    this.ensureCapacity(2*icapacity);
		    this.em[icapacity].name=a.name;
		    this.em[icapacity].no=a.no;
		    this.em[icapacity].age =a.age;
		    this.em[icapacity].state =a.state;
		    this.em[icapacity].zip = a.zip;
		    this.em[icapacity].advisor = new int[a.advisor.length];
		    for (int j=0;j<a.advisor.length;j++){
			this.em[icapacity].advisor[j] = a.advisor[j];
		    }
		}
	    }
	}
    }


    
    //Check Whether this Collection Contains the Input Parameter.
    public boolean contains;
    public boolean contains(Employee a){
	if (a == null){
	    contains=false;
	    //System.out.println("oooooo");
	}else{
	    int isize= this.size();
	    for (int i=0;i<isize;i++){		
		if (this.em[i].no==a.no){
		    //System.out.println("found");
		    contains=true;
		    break;
		}else{
		    contains=false;
		}
	    }
	}
	return contains;
    }


    
    //Remove from the Collection the Employee with the Given Employee Number "eno".
    public boolean remove=false;
    public boolean remove(int eno){
	
	int isize= this.size();
	for (int i=0;i<isize;i++){		
	    if (this.em[i].no==eno){
		//System.out.println("found");
		//System.out.println(i);
		//System.out.println(this.em[i].no);		
		if (i!=isize-1){
		    for (int j=i+1;j<isize;j++){
			this.em[j-1].name =this.em[j].name;
			this.em[j-1].no   =this.em[j].no;
			this.em[j-1].age  =this.em[j].age;
			this.em[j-1].state=this.em[j].state;
			this.em[j-1].zip  =this.em[j].zip;
			this.em[j-1].advisor=null;
			this.em[j-1].advisor=new int[this.em[j].advisor.length];
			for (int k=0;k<this.em[j].advisor.length;k++){
			    this.em[j-1].advisor[k]=this.em[j].advisor[k];
			}
		    }
		    this.em[isize-1].name =null;
		    this.em[isize-1].no   =0;
		    this.em[isize-1].age  =0;
		    this.em[isize-1].state=null;
		    this.em[isize-1].zip  =0;
		    this.em[isize-1].advisor=null;
		}else{
		    this.em[i].name =null;
		    this.em[i].no   =0;
		    this.em[i].age  =0;
		    this.em[i].state=null;
		    this.em[i].zip  =0;
		    this.em[isize-1].advisor=null;
		}
		remove=true;
		break;
	    }else{
		remove=false;
	    }
	}
	return remove;
    }



    //The Following Method Guarantees the Capacity of the Collection.
    public void ensureCapacity(int minimumCapacity){
	if (minimumCapacity>=0){
	    
	    int isize=this.size();
	    System.out.println("Capacity of data collection before enlarging "+isize);
	    
	    /*
	    EmployeeSet datacp =null;
	    datacp =new EmployeeSet();
	    datacp.em = new Employee[minimumCapacity];
	    //Employee[] datacp = new Employee[minimumCapacity];
	    for (int i=0;i<minimumCapacity;i++){
		datacp.em[i]=new Employee();
	    }
	 
	    
	    //System.arraycopy(this.em, 0, datacp.em, 0, isize);
	    
	    for (int i=0;i<isize;i++){
		System.out.println(i);
		datacp.em[i].name=this.em[i].name;
		datacp.em[i].no   =this.em[i].no;
		datacp.em[i].age  =this.em[i].age;
		datacp.em[i].state=this.em[i].state;
		datacp.em[i].zip  =this.em[i].zip;
	    }

	    System.out.println("after copy to datacp: "+datacp.em[0].name);
	    System.out.println("after copy to datacp: "+this.em[0].name);
	    */

	    Employee[] datacp= new Employee[minimumCapacity];
		for (int i=0;i<minimumCapacity;i++){
		    datacp[i]=new Employee();
		}
	    System.arraycopy(this.em, 0, datacp, 0, isize);

	    
	    //System.out.println("after copy to datacp: "+datacp[0].name);
	    //System.out.println("after copy to datacp: "+this.em[0].name);
	    
	    /*this.em = new Employee[minimumCapacity];
	    for (int i=0;i<minimumCapacity;i++){
		this.em[i]=new Employee();
	    }

	    
	    	    
	    for (int i=0;i<isize;i++){
		System.out.println(i);
		this.em[i].name=new String(datacp[i].name);
		this.em[i].no   =datacp[i].no;
		this.em[i].age  =datacp[i].age;
		this.em[i].state=new String(datacp[i].state);
		this.em[i].zip  =datacp[i].zip;

	    }
	    */
	    //for (int i=0;i<minimumCapacity;i++){
	    //this.em[i]=datacp.em[i];
	    //}

	    this.em=datacp;
	    System.out.println("Capacity of data collection has been enlarged to "+this.em.length);
	}
    }
    
    //Adds One Employee Object in Ascending Order of Employee Numbers.
    public boolean addOrNot;
    public boolean ordered;
    public void addOrdered(Employee a){	
	for (int i=0;i<this.size()-1;i++){
	    if (this.em[i].no>this.em[i+1].no){
		ordered=false;
		System.out.println("Employee Number array are not in ascending order");
	    }else{
		ordered=true;
	    }
	}
	
	if ((a != null) && (a instanceof Employee) && (ordered=true)){
	    same=this.contains(a);
	    if (same==true){
		System.out.println("!There already has been an employee with the same Employee Number in the database, fail to add current employee info.");
		System.out.println("Employee name and number "+a.name+" "+a.no); 
		System.out.println("\n"); 
	    }else{
		if (this.size()<this.capacity()){
		    int isize=this.size();
		    //System.out.println("size of current data collection "+isize);
		    for (int i=0;i<isize;i++){
			if (this.em[i].no>a.no){
			    addOrNot=true;
			    for (int j=isize;j>i;j--){
				this.em[j].name =this.em[j-1].name;
				this.em[j].no   =this.em[j-1].no;
				this.em[j].age  =this.em[j-1].age;
				this.em[j].state=this.em[j-1].state;
				this.em[j].zip  =this.em[j-1].zip;
				this.em[j].advisor=null;
				this.em[j].advisor=new int[this.em[j-1].advisor.length];
				for (int k=0;k<this.em[j-1].advisor.length;k++){
				    this.em[j].advisor[k]=this.em[j-1].advisor[k];
				}
			    }
			    this.em[i].name =a.name;
			    this.em[i].no   =a.no;
			    this.em[i].age  =a.age;
			    this.em[i].state=a.state;
			    this.em[i].zip  =a.zip;
			    this.em[i].advisor=null;
			    this.em[i].advisor=new int[a.advisor.length];
			    for (int k=0;k<a.advisor.length;k++){
				this.em[i].advisor[k]=a.advisor[k];
			    }
			    break;
			}else{
			    addOrNot=false;
			}
		    }
		    if (addOrNot==false){
			this.add(a);
		    }
		}else{
		    int icapacity=this.capacity();
		    this.ensureCapacity(2*icapacity);
		    int isize=this.size();
		    for (int i=0;i<isize;i++){
			if (this.em[i].no>a.no){
			    addOrNot=true;
			    for (int j=isize;j>i;j--){
				this.em[j].name =this.em[j-1].name;
				this.em[j].no   =this.em[j-1].no;
				this.em[j].age  =this.em[j-1].age;
				this.em[j].state=this.em[j-1].state;
				this.em[j].zip  =this.em[j-1].zip;
				this.em[j].advisor=null;
				this.em[j].advisor=new int[this.em[j-1].advisor.length];
				for (int k=0;k<this.em[j-1].advisor.length;k++){
				    this.em[j].advisor[k]=this.em[j-1].advisor[k];
				}
			    }
			    //System.out.println("add a.name "+a.name);
			    this.em[i].name =a.name;
			    this.em[i].no   =a.no;
			    this.em[i].age  =a.age;
			    this.em[i].state=a.state;
			    this.em[i].zip  =a.zip;
			    this.em[i].advisor=null;
			    this.em[i].advisor=new int[a.advisor.length];
			    for (int k=0;k<a.advisor.length;k++){
				this.em[i].advisor[k]=a.advisor[k];
			    }
			    break;
			}else{
			    addOrNot=false;  
			}
		    }
		    if (addOrNot==false){
			this.add(a);
		    }
		}
	    }
	}	
    }
    

   

    public static void main(String[] args) {


        String fname="core_dataset.csv";
	String fnameout="ordered_no.csv";



	//Read data from the data file of core_dataset.csv
	int icount = 0; 
	String line = "";
	EmployeeSet data =null;	
	data = new EmployeeSet();
	String[] header= new String[8];
	try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fname);
	    // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
	    
	    while((line = bufferedReader.readLine()) != null) {
                //parse line
		String[] lineStr = line.split(",");
		if(icount==0){	 
		    if(lineStr.length!=0) {
			header[0]=lineStr[0];
			header[1]=lineStr[1];
			header[2]=lineStr[5];
			header[3]=lineStr[2];
			header[4]=lineStr[3];
			header[5]="Advisor 1";
			header[6]="Advisor 2";
			header[7]="Advisor 3";
		    }
		    icount++;
                }else{
		    if(lineStr.length!=0) {
			Employee addEm = new Employee();
			addEm.name=lineStr[0]+", "+lineStr[1];
			addEm.no=Integer.parseInt(lineStr[2]);
			addEm.age=Integer.parseInt(lineStr[6]);
			addEm.state=lineStr[3];
			addEm.zip=Integer.parseInt(lineStr[4]);
			addEm.advisor=new int[3];
			addEm.advisor[0]=0;
			addEm.advisor[1]=0;
			addEm.advisor[2]=0;
			data.addOrdered(addEm);
			icount++;			
		    }    
                }
            }
            bufferedReader.close(); // Always close files.
	    System.out.println("Total number of employee read "+icount);
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +  fname + "'");                
        }catch(IOException ex) {
            System.out.println("Error reading file '" + fname + "'");                  
        }
	System.out.println("Finish reading data from file "+ fname);
	System.out.println("\n");


	//Actual Number of Elements in Current Collection
	System.out.println("Actual Number of Elements in Current Collection: "+data.size());
	System.out.println("\n");

	
	//Capacity of Current Collection
	System.out.println("Capacity of Current Collection: "+data.capacity());
	System.out.println("\n");


	//Add Method (addOrdered)
	Employee a = new Employee();
	a.name="Ndzi,  Horia";
	a.no=1204033042;
	a.age=31;
	a.state="CA";
	a.zip=12048;
	a.advisor=new int[3];
	a.advisor[0]=0;
	a.advisor[1]=0;
	a.advisor[2]=0;
	data.addOrdered(a);
	System.out.println("Add Ndzi, Horia with Employee Number 1204033042");
	System.out.println("\n");



	//Contain Method, to Check the Collection Contains a certain Employee
	System.out.println("Contains Ndzi, Horia? "+data.contains(a));
	System.out.println("\n");



	//Remove a Employee info with the Employee's Number
	System.out.println("Remove Emoloyee with Number 1204033042? "+data.remove(1204033042));
	System.out.println("Remove Emoloyee with Number 120? "+data.remove(120));
	System.out.println("\n");
	
	
	//Write All Employee info in file ordered_no.csv with Employee Number in Acsending order.
	try {
	    File file = new File(fnameout);	    
	    FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(header[0]+","+header[1]+","+header[2]+","+header[3]+","+header[4]+","+header[5]+","+header[6]+","+header[7]+"\n");
	    for (int i=0;i<data.size();i++){
		if (data.em[i].advisor.length==3){
		    bw.write(data.em[i].name+","+data.em[i].no+","+data.em[i].age+","+data.em[i].state+","+data.em[i].zip+","+data.em[i].advisor[0]+","+data.em[i].advisor[1]+","+data.em[i].advisor[2]+"\n");
		}
		if (data.em[i].advisor.length==2){
		    bw.write(data.em[i].name+","+data.em[i].no+","+data.em[i].age+","+data.em[i].state+","+data.em[i].zip+","+data.em[i].advisor[0]+","+data.em[i].advisor[1]+"\n");
		}
		if (data.em[i].advisor.length==1){	    
		    bw.write(data.em[i].name+","+data.em[i].no+","+data.em[i].age+","+data.em[i].state+","+data.em[i].zip+","+data.em[i].advisor[0]+"\n");
		}
	    }   
	    
	    bw.close();
	    fw.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	System.out.println("Finish writing to file "+ fnameout);


	



	/*
	String toString=null;
	for (int i=0;i<data.size();i++){
	    if (data.em[i].advisor.length==3){
		toString=(data.em[i].name+","+data.em[i].no+","+data.em[i].age+","+data.em[i].state+","+data.em[i].zip+","+data.em[i].advisor[0]+","+data.em[i].advisor[1]+","+data.em[i].advisor[2]);
		System.out.println(toString);
	    }
	    if (data.em[i].advisor.length==2){
		toString=(data.em[i].name+","+data.em[i].no+","+data.em[i].age+","+data.em[i].state+","+data.em[i].zip+","+data.em[i].advisor[0]+","+data.em[i].advisor[1]);
		System.out.println(toString);
	    }
	    if (data.em[i].advisor.length==1){	    
		toString=(data.em[i].name+","+data.em[i].no+","+data.em[i].age+","+data.em[i].state+","+data.em[i].zip+","+data.em[i].advisor[0]);
		System.out.println(toString);
	    }
	}
	*/
	
	/*
	EmployeeSet data =null;	
	data = new EmployeeSet();
	data.em[0].name="Tom";
	data.em[0].no=3;
	data.em[0].age=30;
	data.em[0].state="NM";
	data.em[0].zip=88005;
	data.em[0].advisor=new int[3];
	data.em[0].advisor[0]=0;
	data.em[0].advisor[1]=0;
	data.em[0].advisor[2]=0;


	Employee a = new Employee();
	a.name="Tommy";
	a.no=11;
	a.age=31;
	a.state="CA";
	a.zip=12048;
	a.advisor=new int[3];
	a.advisor[0]=0;
	a.advisor[1]=0;
	a.advisor[2]=0;
	data.add(a);
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}

	Employee b = new Employee();
	b.name="Gordon";
	b.no=17;
	b.age=33;
	b.state="MA";
	b.zip=11488;
	b.advisor=new int[3];
	b.advisor[0]=0;
	b.advisor[1]=0;
	b.advisor[2]=0;
	data.add(b);
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}

	
	System.out.println("\n");
	EmployeeSet datacp = new EmployeeSet(data);
	System.out.println("Copied data colleciton em[0].name: "+datacp.em[0].name);
	System.out.println("Number of element for copied data collection: "+datacp.size());
	System.out.println("Capacity of the copied data collection: "+datacp.capacity());

	
	
	System.out.println("\n");
	System.out.println("Contains Gordon? "+data.contains(b));
	System.out.println("Data in data collection ");
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}
	System.out.println("Removes employee with no 100? "+data.remove(100));
	System.out.println("Data in data collection ");
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}

	System.out.println("Removes employee with no 111? "+data.remove(111));
	System.out.println("Data in data collection ");
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}

	

	System.out.println("\n");
	System.out.println("Test addOrdered in the following");
	Employee c = new Employee();
	c.name="Germy";
	c.no=18;
	c.age=39;
	c.state="MI";
	c.zip=11678;
	c.advisor=new int[3];
	c.advisor[0]=0;
	c.advisor[1]=0;
	c.advisor[2]=0;	
	data.addOrdered(c);
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}

	
	System.out.println("\n");
	Employee d = new Employee();
	d.name="Jesus";
	d.no=8;
	d.age=23;
	d.state="MN";
	d.zip=11988;
	d.advisor=new int[3];
	d.advisor[0]=0;
	d.advisor[1]=0;
	d.advisor[2]=0;
	data.addOrdered(d);
	for (int i=0;i<data.size();i++){
	    System.out.println(data.em[i].name+data.em[i].no);
	}

	*/
	

    }
	
}
    

