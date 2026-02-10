import br.com.alura.currencyconverter.ApiRecord;
import br.com.alura.currencyconverter.CheckCurrencyInfo;
import static br.com.alura.currencyconverter.CheckInput.checkInput;

void main() {
    Scanner reading = new Scanner(System.in);

    System.out.println("Bem-vindo(a) ao Conversor de Moedas!");
    System.out.println("Temos várias opções de moedas:");
    System.out.println("- BRL: Real");
    System.out.println("- USD: Dólar");
    System.out.println("- EUR: Euro");
    System.out.println("Dentre outros. Se você souber o código de três dígitos da sua moeda desejada (como os exemplos acima), provavelmente aceitamos!");

    while(true) {
        String baseCurrencyName = checkInput(reading, "Qual moeda deseja converter? Digite o código de 3 letras ou digite SAIR para encerrar o serviço.");
        if (baseCurrencyName == null) break;

        String targetCurrencyName = checkInput(reading, "Para qual moeda deseja converter? Digite o código de 3 letras ou digite SAIR para encerrar o serviço.");
        if (targetCurrencyName == null) break;

        String convertAmount = checkInput(reading, "Quanto deseja converter? Digite o valor ou digite SAIR para encerrar o serviço.");
        if (convertAmount == null) break;

        try {
            double convertAmountNum = Double.parseDouble(convertAmount.replace(",", "."));

            CheckCurrencyInfo apiChecker = new CheckCurrencyInfo();
            try {
                ApiRecord myCurrency = apiChecker.currencyConversion(baseCurrencyName, targetCurrencyName, convertAmountNum);
                if (myCurrency.conversion_result() == 0) {
                    System.out.println("Use apenas moedas existentes!");
                } else {
                    String prettyBase = String.format("%.2f", convertAmountNum);
                    String prettyTarget = String.format("%.2f", myCurrency.conversion_result());
                    String prettyRate = String.format("%.2f", myCurrency.conversion_rate());
                    System.out.println("A conversão foi um sucesso!");
                    System.out.println("Valor em " + baseCurrencyName + ": " + prettyBase);
                    System.out.println("Valor em " + targetCurrencyName + ": " + prettyTarget);
                    System.out.println("Cotação do " + baseCurrencyName + " hoje: " + prettyRate);
                }
            } catch (Exception e) {
                System.out.println("Algum erro aconteceu! Veja abaixo:");
                throw new RuntimeException(e);
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro. Digite apenas números válidos (ex.: 10.50).");
        }

    }
}
