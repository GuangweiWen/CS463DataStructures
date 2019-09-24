public class addition {
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
	
	int number = 10;
	int step = 1;
	int summation =0;
	
	for (int i=0; i<number; i++)
	    {
		summation+=step;
		//	step++;
		step *=2;
	    }
	
	System.out.println("Summation for number " + number +" is: " + summation);
    }
    
}
