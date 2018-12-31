package sjq.light.expr.util;

public class CalcUtil {

    public static Object add(Object value1, Object value2) throws IncomputableException {
        if(value1 instanceof Long && value2 instanceof Long) {
            Long v1 = (Long)value1;
            Long v2 = (Long)value2;
            return  v1+v2;
        } else if(value1 instanceof Double) {
            Double v1 = (Double)value1;
            Double v2 = ((Number)value2).doubleValue();
            return  v1+v2;
        } else if(value2 instanceof Double) {
            Double v1 = ((Number)value1).doubleValue();
            Double v2 = (Double)value2;
            return  v1+v2;
        } else if(value1 instanceof String) {
            String v1 = (String)value1;
            String v2 = (String)value2;
            return v1 + v2;
        }
        
        throw new IncomputableException();
    }

    public static Object sub(Object value1, Object value2) throws IncomputableException {
        if(value1 instanceof Long && value2 instanceof Long) {
            Long v1 = (Long)value1;
            Long v2 = (Long)value2;
            return  v1-v2;
        } else if(value1 instanceof Double) {
            Double v1 = (Double)value1;
            Double v2 = ((Number)value2).doubleValue();
            return  v1-v2;
        } else if(value2 instanceof Double) {
            Double v1 = ((Number)value1).doubleValue();
            Double v2 = (Double)value2;
            return  v1-v2;
        }
        
        throw new IncomputableException();
    }

    public static Object mul(Object value1, Object value2) throws IncomputableException {
        if(value1 instanceof Long && value2 instanceof Long) {
            Long v1 = (Long)value1;
            Long v2 = (Long)value2;
            return  v1*v2;
        } else if(value1 instanceof Double) {
            Double v1 = (Double)value1;
            Double v2 = ((Number)value2).doubleValue();
            return  v1*v2;
        } else if(value2 instanceof Double) {
            Double v1 = ((Number)value1).doubleValue();
            Double v2 = (Double)value2;
            return  v1*v2;
        }
        
        throw new IncomputableException();
    }

    public static Object div(Object value1, Object value2) throws IncomputableException {
        if(value1 instanceof Long && value2 instanceof Long) {
            Long v1 = (Long)value1;
            Long v2 = (Long)value2;
            return  v1/v2;
        } else if(value1 instanceof Double) {
            Double v1 = (Double)value1;
            Double v2 = ((Number)value2).doubleValue();
            return  v1/v2;
        } else if(value2 instanceof Double) {
            Double v1 = ((Number)value1).doubleValue();
            Double v2 = (Double)value2;
            return  v1/v2;
        }
        
        throw new IncomputableException();
    }
    
}
