import java.util.Collections;
import java.util.List;

public class MaxOperation implements MathOperation {

    @Override
    public Integer calculate(List<Integer> ints) {
        return Collections.max(ints);
    }

//    @Override
//    public Integer calculate(List<Integer> ints) {
//        Integer min = Integer.MAX_VALUE;
//        for (Integer i: ints) {
//            if(i<min) {
//                min = i;
//            }
//        }
//        return min;
//    }
}
