import java.util.List;

public enum Constraint implements isEligible{
    REQUIRED {
        @Override
        public boolean isEligible(Object newColumnData, List<Integer> params) {
            if(newColumnData instanceof String)
                return !newColumnData.equals("");
            else if(newColumnData instanceof Integer)
                return !newColumnData.equals(-1);
            return false;
        }
    },
    MIN{
        @Override
        public boolean isEligible(Object newColumnData, List<Integer> parameters) {
            if(!(newColumnData instanceof Integer)){
                return true;
            }
            if((Integer)newColumnData>=parameters.get(0)){
                return true;
            }
            return false;
        }
    }
}
