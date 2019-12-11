class SecondMaximumValue{
    public static int findSecondMaximum(int[] arr){
        int second_max = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                second_max = max;
                max = arr[i];
            }
            else{
                if (arr[i] > second_max && arr[i] != max){
                    second_max = arr[i];
                }
            }
        }

        return second_max;
    } 

    public static void main(String[] args){
        int[] arr = {9, 2, 3, 2, 6, 6};
        int[] arr1 = {4, 5, 1, 2, 0, 4};
        int[] arr3 = {9, 2, 3, 6};
        int[] arr4 = {4, 4, 4, 4, 4};
        int result = findSecondMaximum(arr4);
        System.out.println(result);
    }
}