
public class WaterTwo {

	public static void main(String[] args) {
		
	// Program works 90%. Doesn't work if the highest number appears twice.
		
//Test Case #1 = Expected Output is 6
	//int arr[] = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
	//int revArr[] = new int[] {1,2,1,2,3,1,0,1,2,0,1,0};
	
//Test Case #2 = Expected Output is 9	
	//int arr[] = new int[]{4,2,0,3,2,5};
	//int revArr[] = new int[] {5,2,3,0,2,4};
	
//Test Case #3 = Expected Output is 5		
	//int arr[] = new int[]{0,0,0,3,6,5,0,1,3};
	//int revArr[]= new int[] {3,1,0,5,6,3,0,0,0};
	
//Test Case #4 = Expected Output is 38		
	int arr[] = new int[]{0,5,3,3,0,5,0,1,3,0,8,7,4,0,8};
	int revArr[]= new int[] {8,0,4,7,8,0,3,1,0,5,0,3,3,5,0};
	
	
	int maxHeightOfArray = 0;
	int arrayLength = (arr.length -1);
	int potentialWater = 0;
	int blocksTaken =0;
	int waterFilled =0;
	int indexOfTallest =0;

	int maxHeight=0;
	int maxHeightLeft = 0;
	int maxHeightRight =0;
	int startIndex=0;
	int endIndex=0;
	
	boolean forward= false;
	
	//This Calculates The Highest Column In The Array
	for (int r=0; r<=arrayLength; r++) {
		if (arr[r]>maxHeightOfArray) {
			maxHeightOfArray = arr[r];
			indexOfTallest = r;
			
		}	
	}
	
	
	
	
	//System.out.println(indexOfTallest);	
	
	
	for (int i =0; i< indexOfTallest; i++) {
		if (arr[i]>=maxHeightLeft) {
			startIndex=i;
			maxHeightLeft=arr[i];
			//System.out.println("ITERATION: " + i);
			//System.out.println("The starting index for this iteration is: " + startIndex);
			//System.out.println("The starting height for this iteration is: " + maxHeightLeft);
			
			for (int k =(i+1); k<= indexOfTallest; k++) {
				if (arr[k] >= maxHeightLeft) {
				endIndex= k;
				maxHeightRight=arr[k];
				//System.out.println("The ending index for this iteration is: " + endIndex);
				//System.out.println("The ending height for this iteration is: " + maxHeightRight);
				
				if (maxHeightLeft >= maxHeightRight) {
					maxHeight=maxHeightLeft;
				}else {
					maxHeight = maxHeightLeft;
				}
				//System.out.println("The max height for this iteration is: "+ maxHeight);
				
				for(int f = (startIndex+1); f<endIndex;f++) {
					
					blocksTaken+=arr[f];
					potentialWater+=maxHeight;
				}
				//System.out.println("The potential water for this iteration is: " + potentialWater);
				//System.out.println("The blocks taken for this iteration is: " + blocksTaken);
				
				waterFilled= potentialWater-blocksTaken;
				//System.out.println("The waterFilled for this iteration is: " + waterFilled);
				//System.out.println("-------------------------");
				
				startIndex =endIndex;
				endIndex=0;
				
				break;
				
				
			}
			
			}
			
			
		}
		if ((i+1) == indexOfTallest) {
			forward =true;
			maxHeightLeft =0;
			maxHeightRight=0;
			maxHeight =0;
		}
	}
	
	if (forward==true) {
		//System.out.println("Time to go backwards");
		//System.out.println("--------------------");
		for (int i =0; i< indexOfTallest; i++) {
			if (revArr[i]>maxHeightLeft) {
				startIndex=i;
				maxHeightLeft=revArr[i];
				//System.out.println("ITERATION: " + i);
				//System.out.println("The starting index for this iteration is: " + startIndex);
				//System.out.println("The starting height for this iteration is: " + maxHeightLeft);
				
				for (int k =(i+1); k<= indexOfTallest; k++) {
					if (revArr[k] >= maxHeightLeft) {
					endIndex= k;
					maxHeightRight=revArr[k];
					//System.out.println("The ending index for this iteration is: " + endIndex);
					//System.out.println("The ending height for this iteration is: " + maxHeightRight);
					
					if (maxHeightLeft >= maxHeightRight) {
						maxHeight=maxHeightLeft;
					}else {
						maxHeight = maxHeightLeft;
					}
					//System.out.println("The max height for this iteration is: "+ maxHeight);
					
					for(int f = (startIndex+1); f<endIndex;f++) {
						blocksTaken+=revArr[f];
						potentialWater+=maxHeight;
					}
					//System.out.println("The potential water for this iteration is: " + potentialWater);
					//System.out.println("The blocks taken for this iteration is: " + blocksTaken);
					
					waterFilled= potentialWater-blocksTaken;
					//System.out.println("The waterFilled for this iteration is: " + waterFilled);
					//System.out.println("-------------------------");
					
					startIndex =endIndex;
					endIndex=0;
					break;
					
				}
				
				}
				
				
			}
			if ((i+1) == indexOfTallest) {
				forward =false;
			}
		}
	}
	System.out.println("There are " + waterFilled + " blocks of water filled");
	
	
	
	
	
	
	
	
}

}
	