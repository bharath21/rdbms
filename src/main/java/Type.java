import java.util.List;

public enum Type implements isEligible{
    String{
        @Override
        public boolean isEligible(Object newColumnData, List<Integer> parameters) {
            String data = (java.lang.String) newColumnData;
            return (data.length()<=20);
        }
    },
    Integer{
        @Override
        public boolean isEligible(Object newColumnData,List<Integer> parameters) {
            Integer data = (java.lang.Integer) newColumnData;
            return (data>=-1024 && data<=1024);
        }
    }
}
