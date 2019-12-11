class Rearrange{

    public static void reArrange(int[] arr){
        int index = 0, temp = 0;
        int n = arr.length;

        for (int i = 0; i < n-1; i++){
            if (arr[i] > 0){
                index = i + 1;
                while(index < n){
                    if (arr[index] < 0){
                        temp = arr[i];
                        arr[i] = arr[index];
                        arr[index] = temp;
                        break;
                    }
                    index++;
                }
                if (index >= n){
                    break;
                }
            }
        }

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args){
        int[] arr = {-10, -1, 20, -4, -5, -9, -6};
        int[] arr1 = {4, -4};
        reArrange(arr1);
    }
}