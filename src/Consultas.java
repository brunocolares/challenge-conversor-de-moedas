import modelo.Conversion;
import modelo.ConversionRates;

public class Consultas {
    private Requisicoes requisicoes;

    public ConversionRates findConversionRates(int opcao) {
        requisicoes = new Requisicoes();
        Conversion conversion = new Conversion();
        switch (opcao) {
            case 1: {
                conversion.setBaseCode("USD");
                conversion.setTargetCode("ARS");
                break;
            }
            case 2: {
                conversion.setBaseCode("ARS");
                conversion.setTargetCode("USD");
                break;
            }
            case 3: {
                conversion.setBaseCode("USD");
                conversion.setTargetCode("BRL");
                break;
            }
            case 4: {
                conversion.setBaseCode("BRL");
                conversion.setTargetCode("USD");
                break;
            }
            case 5: {
                conversion.setBaseCode("USD");
                conversion.setBaseCode("COP");
                break;
            }
            case 6: {
                conversion.setBaseCode("COP");
                conversion.setTargetCode("USD");
                break;
            }
            default: {
                System.out.println("Programa finalizado.");
                return null;
            }
        }
        return requisicoes.findConversionRates(conversion);
    }

    public double calcular(double moeda, double valor) {
        return valor * moeda;
    }

}
