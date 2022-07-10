package InterfacesАndAbstraction.Exercise._5_Тelephony;

import java.util.List;

public class Smartphone implements Browsable,Callable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    private boolean containsNumber(String url) {
        for (int i = 0; i < url.length(); i++) {
            if (Character.isDigit(url.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean containsCharacter(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (containsNumber(url)) {
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (containsCharacter(number)) {
                sb.append("Invalid number!").append(System.lineSeparator());
            } else {
                sb.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
