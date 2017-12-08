package rungeKutta;

import java.math.BigDecimal;

class RungeKuttaQuartaOrdem {

    static BigDecimal[] resolverEdo(BigDecimal x0,
                                    BigDecimal y0,
                                    BigDecimal x1,
                                    BigDecimal subIntervalos,
                                    EquacaoDiferencial edo) {
        int precisaoDecimal = 12;

        BigDecimal h = x1.subtract(x0);
        h = h.divide(subIntervalos, precisaoDecimal, BigDecimal.ROUND_HALF_UP);
        BigDecimal y1 = new BigDecimal(0);

        BigDecimal dois = new BigDecimal("2");
        BigDecimal seis = new BigDecimal("6");

        BigDecimal f0;
        BigDecimal f1;
        BigDecimal f2;
        BigDecimal f3;

        while (x0.compareTo(x1) < 0) {

            f0 = edo.obterValorEDO(x0, y0);

            /*f1 = f(x0 + h/2, y0 + (h/2)f0)*/
            f1 = edo.obterValorEDO(x0.add(h.divide(dois, precisaoDecimal, BigDecimal.ROUND_HALF_UP)),
                    y0.add(h.divide(dois, precisaoDecimal, BigDecimal.ROUND_HALF_UP).multiply(f0)));

            /*f2 = f(x0 + h/2, y0 + (h/2)f1)*/
            f2 = edo.obterValorEDO(x0.add(h.divide(dois, precisaoDecimal, BigDecimal.ROUND_HALF_UP)),
                    y0.add(h.divide(dois, precisaoDecimal, BigDecimal.ROUND_HALF_UP).multiply(f1)));

            /*f3 = f(x0 + h, y0 + hf2)*/
            f3 = edo.obterValorEDO(x0.add(h),
                    y0.add(h.multiply(f2)));

            /*y0 +h/6(f0 + 2f1 + 2f2 + f3)*/
            y1 = y0.add(h.divide(seis, precisaoDecimal, BigDecimal.ROUND_HALF_DOWN)
                    .multiply(f0.add(f1.multiply(dois).add(f2.multiply(dois)).add(f3))));

            x0 = x0.add(h);

            y0 = y1;


        }
        return new BigDecimal[]{x1, y1};
    }

}
