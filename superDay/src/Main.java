import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }


//array of integers find the sub array that has the largest sum.
    // L = [1,2,3,-5,0,1,2]
// L2 = [
    // loop to find int > 0
    public List<Integer> FindSubArray (int [] L){
        List<Integer> subArray = new ArrayList<>();
        for(int i =0; i < L.length; i++){
            if (L[i] > 0){
                subArray.add(L[i]);
            }
        }
        return subArray;
    }



}