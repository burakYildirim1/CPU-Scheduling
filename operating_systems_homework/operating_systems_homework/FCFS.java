package operating_systems_homework;

public class FCFS {
	
	int prosesSayisi; 

	int toplamIslemSuresi=0;
	int tamamlanmaSuresi=0;
	float bekleme=0;
	float ortBekleme;
		
	public FCFS(int prosesSayisi, int [][] prosesMatris)
	{
		this.prosesSayisi=prosesSayisi;
		sort(prosesMatris);
		
//		int [] varisSure = new int[prosesSayisi];
//		int [] patlamaZamani=new int[prosesSayisi];
//		int [] beklemeSuresi=new int[prosesSayisi];
//		
//		for (int i = 0; i < prosesSayisi; i++) 
//		{
//			varisSure[i] = prosesMatris[i][0];
//			System.out.println(prosesMatris[i][0]);
//			patlamaZamani[i] = prosesMatris[i][1]; 
//		}
//		
//		
//		
//		
//		beklemeSuresi[0] = 0;
//		for (int i = 1; i < prosesSayisi; i++) 
//		{
//			beklemeSuresi[i] = patlamaZamani[i-1] + beklemeSuresi[i-1];
//		}
//		
//		for (int i : beklemeSuresi) 
//		{
//			bekleme += i;
//		}
//		
//	
//		ortBekleme = bekleme / prosesSayisi;
//      System.out.println("ort bekleme : "+ortBekleme);
		
		int a = totalWaitingTime(prosesMatris,prosesSayisi);
		System.out.println(a);
		
		System.out.println(avarageTime(a, prosesSayisi));
		
	}
	
	
	
	
    public static int totalWaitingTime(int[][] array, int len)
    {
        int result = 0;
        int sum = 0;
        for(int i=1; i<len; i++)
        {
            sum += (array[i-1][1]);
            result += sum;  
        }
            
        return result;
    }
    
    public static double avarageTime(int sum, int len)
    {
        return (double)sum/(double)len;
    }
	
	
	

	public void sort(int array[][])
	{
	    boolean sorted = false;
	    int temp;
	    int temp2;
		
		for (int i = 0; i < prosesSayisi; i++) 
		{
			
			for (int j = 0; j < 1; j++) 
			{
				
			    while(!sorted) 
			    {
			        sorted = true;
			        for (int k = 0; k < array.length - 1; k++) 
			        {
			            if (array[k][0] > array[k+1][0]) 
			            {
			                temp = array[k][0];
			                temp2 = array[k][1];
			                array[k][0] = array[k+1][0];
			                array[k][1] = array[k+1][1];
			                array[k+1][0] = temp;
			                array[k+1][1] = temp2;
			                sorted = false;
			            }
			        }
			    }
			    

					
			}
				
		}
		
//	    for (int b = 0; b < prosesSayisi; b++) 
//	    {
//			
//			for (int m = 0; m < 1; m++) 
//			{
//				System.out.println("-----------------------------");
//				System.out.println(array[b][m]+" "+array[b][m+1]);
//			}
//			
//		}
	}
	
}
