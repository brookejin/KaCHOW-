/*Shivasuryan Vummidi
APCS2 pd5
HW 15: QuickSort
2017-03-08

TREMENDOUS HELP FROM MAX KORSUN
*/
/*****************************************************
 * class QuickSort
 * (skeleton) <<delete this line if untrue>>
 * Implements quicksort algo to sort an array of ints in place
 *
 * @SEEthisNOW
 * PIVOT/ARRAY/RUNTIME(s)
 * (upper + lower) div 2 /backwards/0.2706
 * (upper + lower) div 2 /forwards /0.2746
 *  upper                /backwards/0.2366
 *  upper                /forwards /0.2510
 *  lower                /backwards/0.2384
 *  lower                /forwards /0.5806
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Pick a pivot, and partition the array based on the pivot. Pick another pivot in each partition and keep going until we reach 1-element arrays. At this point, we have reached the places where they are supposed to be and we just merge them together.
 * 
 * 2a. Worst pivot choice / array state and associated runtime: 
 * lower/forwards/0.5806s
 * 2b. Best pivot choice / array state and associated runtime:
 * upper/backwards/0.2366s
 * 3. Approach to handling duplicate values in array:
 * With duplicate values, the method really doesn't care about duplicates as much as we expected, so it would just place them accordingly.
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) 
    {
	qsortH(d,0,d.length-1);


    }

    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.
 public static int partition( int arr[], int a, int b, int c)
    {
	int v = arr[c];

	swap( c, b, arr);
	int s = a;

	for( int i = a; i < b; i++ ) {
	    if ( arr[i] <= v) {
		swap( i, s, arr );
		s++;}
	}
	swap(s,b,arr);

	return s;
    }
    public static void qsortH(int[] arr,int  lower,int upper){
       	if(upper - lower <= 1) return;
		if(lower + 1 == arr.length -1 || upper -1 == 0){
			return;
		}
		else{
		
			int partPoint= partition(arr, lower, upper, lower);
			//System.out.println(partPoint);
			qsortH(arr,partPoint + 1, upper);
			qsortH(arr, lower, partPoint - 1);
		}
    }
    

    //main method for testing
    public static void main( String[] args ) 
    {
	
	//get-it-up-and-running, static test case:
	//int [] arr1 = {12, 7, 3, 5, 1};
	int [] arr1 = {1, 3, 5, 7, 7, 12, 7, 7, 7, 12};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	/*int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);



	
	//get-it-up-and-running, static test case w/ dupes:
	/*int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);*/
        
	  /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) */
	  /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) */


    }//end main

}//end class QuickSort
