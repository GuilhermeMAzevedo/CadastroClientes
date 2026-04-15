import java.util.regex.Pattern;

public class Validator {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_EMAIL_LENGTH = 254;
    private static final int PHONE_DIGITS = 11;

    private Validator() {}

    private static final Pattern ID_PATTERN = Pattern.compile(
            "^[0-9]+$"
    );

    private static final Pattern NAME_PATTERN = Pattern.compile(
            "^[a-zA-ZÀ-ÿ\s]+$"
    );

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
    );

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^[0-9]+$"
    );

    private static String validateNotBlank(String value, String fieldName){
        if (value == null || value.isBlank()){
            throw new IllegalArgumentException("O campo do " + fieldName + " está vazio");
        }
        return value.trim();
    }

    public static void validateId(String id) {
        String trimmedId = validateNotBlank(id, "ID");

        if (!ID_PATTERN.matcher(trimmedId).matches()) {
            throw new IllegalArgumentException("O ID são apenas números");
        }
    }

    public static void validateName(String name){
        String trimmedName = validateNotBlank(name, "nome");

        if (trimmedName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("O nome deve ter no mínimo " + MIN_NAME_LENGTH + " caracteres");
        } else if (trimmedName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("O nome deve ter no máximo " + MAX_NAME_LENGTH + " caracteres");
        } else if (!NAME_PATTERN.matcher(trimmedName).matches()) {
            throw new IllegalArgumentException("O nome deve conter apenas letras e espaços (Ex: João da Silva)");
        }
    }

    public static void validateEmail(String email){
        String trimmedEmail = validateNotBlank(email, "E-mail");

        if (trimmedEmail.length() > MAX_EMAIL_LENGTH) {
            throw new IllegalArgumentException("E-mail muito longo (Máximo de " + MAX_EMAIL_LENGTH + " caracteres)");
        } else if (!EMAIL_PATTERN.matcher(trimmedEmail).matches()){
            throw new IllegalArgumentException("Formato do E-mail inválido (Ex: seunome@exemplo.com)");
        }
    }

    public static void validatePhone(String phone){
        String trimmedPhone = validateNotBlank(phone, "telefone");

        if (trimmedPhone.length() != PHONE_DIGITS) {
            throw new IllegalArgumentException("O telefone com o DDD tem que ter " + PHONE_DIGITS + " dígitos (Ex: 11987654321)");
        } else if (!PHONE_PATTERN.matcher(trimmedPhone).matches()) {
            throw new IllegalArgumentException("O telefone deve conter apenas números (Ex: 11987654321)");
        }
    }
}