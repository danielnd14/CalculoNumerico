package rungeKutta;

import java.math.BigDecimal;

public class CN {
    public static void main(String args[]) {
        long time = System.currentTimeMillis();
        System.out.println("================================================================================\n");
        BigDecimal dois = new BigDecimal(2);
        BigDecimal um = new BigDecimal(1);
        BigDecimal tres = new BigDecimal(3);
        String expressaoImprimivel;
        BigDecimal valor[] = RungeKuttaQuartaOrdem.resolverEdo(
                new BigDecimal(0),
                new BigDecimal(1),
                new BigDecimal(1),
                new BigDecimal(10),
                (x, y) -> x.subtract(dois.multiply(y)).add(um));/*y' = x - 2y -1*/

        expressaoImprimivel = "y' = x - 2y -1";
        imprimir(expressaoImprimivel, valor);

        valor = RungeKuttaQuartaOrdem.resolverEdo(
                new BigDecimal(0),
                new BigDecimal(-1),
                new BigDecimal(Math.PI),
                new BigDecimal(10),
                (x, y) ->
                        new BigDecimal(
                                -Math.sin(x.doubleValue())).multiply(y));/*y' = -sin(x)y*/

        expressaoImprimivel = "y' = -sin(x)y";
        imprimir(expressaoImprimivel, valor);
        valor = RungeKuttaQuartaOrdem.resolverEdo(
                new BigDecimal(1.0),
                new BigDecimal(1.0),
                new BigDecimal(3.0),
                new BigDecimal(20.0),
                (x, y) ->
                        new BigDecimal(
                                Math.sqrt(x.doubleValue())).add(um).multiply(dois));/*y' = ((x¹/²)+1)y*/

        expressaoImprimivel = "y' = ((x¹/²)+1)y";
        imprimir(expressaoImprimivel, valor);

        valor = RungeKuttaQuartaOrdem.resolverEdo(
                new BigDecimal(1.0),
                new BigDecimal(1.0),
                new BigDecimal(2.0),
                new BigDecimal(50.0),
                (x, y) ->
                        x.pow(2).subtract(tres.multiply(x)).subtract(um).subtract(y));/*y' = x²-3x-1-y*/

        expressaoImprimivel = "y' = x²-3x-1-y";
        imprimir(expressaoImprimivel, valor);

        System.out.println("================================================================================");
        System.out.println("tempo gasto: " + ((System.currentTimeMillis() - time) / 1000.000) + " segundos");
    }

    private static void imprimir(String expressaoImprimivel, BigDecimal[] valor) {
        System.out.println(expressaoImprimivel + " ->\t\t\tX1:\t" + valor[0].doubleValue() + "\t|\tY1:\t" + valor[1].doubleValue() + "\n");
    }
}
