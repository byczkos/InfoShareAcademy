import java.util.Collections;
import java.util.List;

public class MinOperation implements MathOperation {

    @Override
    public Integer calculate(List<Integer> ints) {
        return Collections.min(ints);
    }
}
