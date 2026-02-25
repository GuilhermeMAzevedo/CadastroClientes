import java.util.regex.Pattern;

public class Validator {
    private Validator() {
    }

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

    public static void validateId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("O campo do ID está vazio");
        }

        String trimmedId = id.trim();


        if (!ID_PATTERN.matcher(trimmedId).matches()) {
            throw new IllegalArgumentException("O ID são apenas números");
        }
    }

    public static void validateName(String name){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O campo do nome está vazio");
        }

        String trimmedName = name.trim();

        if (trimmedName.length() < 2) {
            throw new IllegalArgumentException("O nome deve ter no mínimo 2 caracteres");
        } else if (trimmedName.length() > 100) {
            throw new IllegalArgumentException("O nome deve ter no máximo 100 caracteres");
        } else if (!NAME_PATTERN.matcher(trimmedName).matches()) {
            throw new IllegalArgumentException("O nome deve conter apenas letras e espaços (Ex: João da Silva)");
        }
    }

    public static void validateEmail(String email){
        if (email == null || email.isBlank()){
            throw new IllegalArgumentException("O campo do E-mail está vazio");
        }

        String trimmedEmail = email.trim();

        if (trimmedEmail.length() > 254) {
            throw new IllegalArgumentException("E-mail muito longo (Máximo de 254 caracteres)");
        } else if (!EMAIL_PATTERN.matcher(trimmedEmail).matches()){
            throw new IllegalArgumentException("Formato do E-mail inválido (Ex: seunome@exemplo.com)");
        }
    }

    public static void validatePhone(String phone){
        if (phone == null || phone.isBlank()){
            throw new IllegalArgumentException("O campo do telefone está vazio");
        }

        String trimmedPhone = phone.trim();

        if (trimmedPhone.length() != 11) {
            throw new IllegalArgumentException("O telefone com o DDD tem que ter 11 dígitos (Ex: 11987654321)");
        } else if (!PHONE_PATTERN.matcher(trimmedPhone).matches()) {
            throw new IllegalArgumentException("O telefone deve conter apenas números (Ex: 11987654321)");
        }
    }
}