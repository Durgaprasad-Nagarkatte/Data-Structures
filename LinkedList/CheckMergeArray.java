class CheckMergeArray 
{ 
    // merge arr1 and arr2 into a new result array 
    public static int[] mergeArrays(int[] arr1, int[] arr2) 
    {  
      // write your code here
      int n1 = arr1.length;
      int n2 = arr2.length;
      int k=0, l=0;

      int i = 0;
      int n = n1 + n2;
      int[] arr = new int[n];

      while(i < n){
        if (k < n1 && l < n2){
          if (arr1[k] <= arr2[l]){
            arr[i] = arr1[k];
            k++;
            i++;
          }
          else{
            arr[i] = arr2[l];
            l++;
            i++;
          }
        }
      }
      System.out.println(arr);

      while (k < n1){
          arr[i] = arr1[k];
          k++;
          i++;
      }

      while (l < n2){
          arr[i] = arr2[l];
          l++;
          i++;
      }

      return arr; // make a new resultant array and return your results in that
    } 

    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 6, 7, 8};
        int[] arr = mergeArrays(arr1, arr2);
        System.out.print(arr);
    }
}