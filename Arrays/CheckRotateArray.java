class CheckRotateArray{
    public static void rotateArray(int[] arr){
        int curr = 0, next = 0, last = 0;
        int n = arr.length;

        if (n < 1){
            return;
        }
        last = arr[n-1];
        curr = arr[0];
        for(int i = 0; i < n-1; i++){
            next = arr[i+1];
            arr[i+1] = curr;
            curr = next;
        
        }

        arr[0] = last;

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        int[] arr = {9, 2, 3, 2, 6, 6};
        int[] arr1 = {4, 5, 1, 2, 0, 4};
        rotateArray(arr1);
    }
}