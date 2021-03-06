package Array1;
import java.util.*;

public class ArrangeNumbersInArray {

	public static int tripletSum(int arr[], int expectedSum) {
		Arrays.sort(arr);
		int n=arr.length;
		int triplets=0;
		for(int i=0;i<n;i++) {
			int remainingSum= expectedSum-arr[i];
			int pairs=0;

			pairs=pairSum(arr, remainingSum, i+1, n-1);
			triplets+=pairs;
		}
		printValue(triplets, "Triplets Sum");
		return triplets;
	}

	public static int pairSum(int arr[], int expectedSum, int start, int end) {
		//Arrays Sorted
		int i=start;
		int pairs=0;
		int j=end;
		while(i<j) { 
			int currentSum=arr[i]+arr[j];
			
			if(currentSum < expectedSum) {
				i++;
			}
			else if(currentSum > expectedSum) {
				j--;
			}
			else {
				int elementAtStart=arr[i];
				int elementAtEnd=arr[j];
				
				//Equal to sum
				if(elementAtStart == elementAtEnd) {
					//check if all elements are same.
					int totalElements=(j-i)+1;
					pairs+=(totalElements*(totalElements-1) / 2);
				
					return pairs;
				}
				else {
					int currentStart=i+1;
					int	currentEnd=j-1;
					
					while(currentStart <= currentEnd && elementAtStart == arr[currentStart]) {
						currentStart++;
					}

					while(currentEnd >= currentStart && elementAtEnd == arr[currentEnd]) {
						currentEnd--;
					}
					
					int startCount=currentStart-i;
					int endCount=j-currentEnd;
					pairs+=(startCount*endCount);
					
					i=currentStart;
					j=currentEnd;
				}
			}
		}

		return pairs;	
	}
	
	public static int pairSum(int arr[], int expectedSum) {
		Arrays.sort(arr);  //O(n/2)
		int i=0;
		int pairs=0;
		int j=arr.length-1;
		while(i<j) { 
			int currentSum=arr[i]+arr[j];
			
			if(currentSum < expectedSum) {
				i++;
			}
			else if(currentSum > expectedSum) {
				j--;
			}
			else {
				int elementAtStart=arr[i];
				int elementAtEnd=arr[j];
				
				//Equal to sum
				if(elementAtStart == elementAtEnd) {
					//check if all elements are same.
					int totalElements=(j-i)+1;
					pairs+=(totalElements*(totalElements-1) / 2);
				
					printValue(pairs, "Pair Sum");
					return pairs;
				}
				else {
					int currentStart=i+1;
					int	currentEnd=j-1;
					
					while(currentStart <= currentEnd && elementAtStart == arr[currentStart]) {
						currentStart++;
					}

					while(currentEnd >= currentStart && elementAtEnd == arr[currentEnd]) {
						currentEnd--;
					}
					
					int startCount=currentStart-i;
					int endCount=j-currentEnd;
					pairs+=(startCount*endCount);
					
					i=currentStart;
					j=currentEnd;
				}
			}
		}

		printValue(pairs, "Pair Sum");
		return pairs;	
	}
	
	public static int findUnique(int arr[]) {
		if(arr.length <= 1) {
			printValue(-1, "Unique in Array");
			return -1;
		}

		int ans=0;
		for(int i=0;i<arr.length;i++) {
			ans^=arr[i];
		}
		printValue(ans, "Unique in Array");
		return ans;
	}

	
	public static int findDuplicate(int arr[]) {
		if(arr.length <= 1) {
			printValue(-1, "Duplicate in Array");
			return -1;
		}

		HashMap<Integer, Boolean> map=new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], true);
				//already exists.
			}else {
				map.put(arr[i], false);
				//putting in first time
			}
		}
		int ans=0;
		Set<Integer> keys=map.keySet();
		for(int i: keys) {
			if(map.get(i)) {
				ans=i;
				break;
			}
		}

		printValue(ans, "Duplicate in Array");
		return ans;
	}

	public static void swap(int arr[], int index1, int index2) {
		int temp=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=temp;
	}
	
	
	public static void swapAlternate(int arr[]) {
		int n=arr.length;
		if(n <= 1) {
			printArray(arr, "Swap Alternate");
			return;
		}
		//if 0 or 1 elements print as it is.
		for(int i=0;i<n-1;i+=2) {
			swap(arr, i, i+1);
		}
		printArray(arr, "Swap Alternate");
		
	}
	
	public static int [] arrangeNumbers(int n) {
		int arr[]=new int[n];
		
		int limit1= n%2 == 0 ? n/2 : (n/2)+1;		//in case of even numbers, mod+1.
		int k=0;
		int value=1;
		for(int i=0; i<limit1; i++, k++, value+=2){
			arr[i]=value;
			
		}
		value=2;
		for(int i=n-1; i>=k; i--,value+=2) {
			arr[i]=value;
		}
		printArray(arr, "Arrange Numbers");
		return arr;
	}
	

	public static int[] inputArray() {
		Scanner sc=new Scanner(System.in);
		int n =sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		return arr;
	}
	
	public static void printArray(int arr[], String text) {
		System.out.println(text);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void printValue(int n, String text) {
		if(text != null) {
			System.out.println(text);
		}
		System.out.print(n);
		System.out.println();
	}

	
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=inputArray();
		tripletSum(arr, n);
//		findDuplicate(arr);
//		findUnique(arr);
//		swapAlternate(arr);
//		int n=sc.nextInt();
//		int arr[]=arrangeNumbers(n);
		sc.close();
	}
}
