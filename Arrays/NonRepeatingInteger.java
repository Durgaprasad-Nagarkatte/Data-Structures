import java.util.HashMap;

class NonRepeatingInteger{
    public static Integer findFirstUnique(int[] arr){
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(Integer elem: arr){
            if (hs.containsKey(elem)){
                hs.put(elem, hs.get(elem)+1);
            }
            else{
                hs.put(elem, 1);
            }
        }

        for(Integer elem: arr){
            if (hs.containsKey(elem)){
                if (hs.get(elem) == 1){
                    return elem;
                }
            }
        }

        /*
        for(HashMap.Entry<Integer, Integer> elem: hs.entrySet()){
            System.out.println(elem.getKey() + " " + elem.getValue());
        }*/
        return 0;
    }

    public static void main(String[] args){
        int[] arr = {9, 2, 3, 2, 6, 6};
        int[] arr1 = {4, 5, 1, 2, 0, 4};
        int result = findFirstUnique(arr1);
        System.out.println(result);
    }
}