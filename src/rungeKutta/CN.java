package rungeKutta;

import java.math.BigDecimal;

public class CN {
    public static void main(String args[]) {
        long time = System.currentTimeMillis();

        BigDecimal valor[] = RungeKutta.resolverEdo(
                new BigDecimal(0.0),
                new BigDecimal(0.5),
                new BigDecimal(1.0),
                new BigDecimal(5.0),
                (x, y) -> y.subtract(x.pow(2).subtract(new BigDecimal(1))));/*y' = y - (x² - 1)*/

        System.out.println("X1: " + valor[0].doubleValue() + " | Y1: " + valor[1].doubleValue());
        System.out.println("tempo gasto: " + ((System.currentTimeMillis() - time) / 1000.000) + " segundos");
    }
}
