class RearrangeSorted{
    public static void maxMin(int[] arr) {
        
        int n = arr.length;
        int[] new_arr = new int[n];
        
        int start_index = 0, last_index = n-1, curr_index = 0;
        
        while(start_index <= last_index){
            if(curr_index%2 == 0){
                System.out.println(curr_index%2);
                new_arr[curr_index++] = arr[last_index--];
            }
            else{
                System.out.println(curr_index%2);
                new_arr[curr_index++] = arr[start_index++];
            }
        }

        for(int i = 0; i < n; i++){
            System.out.print(new_arr[i] + " ");
        }

    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        maxMin(arr1);
    }
}