package oc.wh40k.units;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface Unique<T> {

    default Type uniqueGroupType() {
        for (Type t : getClass().getGenericInterfaces()) {
            if (t instanceof ParameterizedType) {
                ParameterizedType pt = (ParameterizedType) t;
                if (Unique.class.equals(pt.getRawType())) {
                    return pt.getActualTypeArguments()[0];
                }
            }
        }
        throw new IllegalStateException(getClass() + " implements Unique is implemented wrong!");
    }
}