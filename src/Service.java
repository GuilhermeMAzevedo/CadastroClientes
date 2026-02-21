import java.util.List;
import java.util.regex.Pattern;

public class Service {
    private Repository repository;
    private int counter = 1;

    private static final Pattern ID_PATTERN = Pattern.compile(
            "^[0-9]+$"
    );

    private static final Pattern NAME_PATTERN = Pattern.compile(
            "^[a-zA-ZÀ-ÿ\s]+$"
    );

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$"
    );

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^[0-9]+$"
    );

    public Service(Repository repository){
        this.repository = repository;
    }

    public String generateId(){
        return String.valueOf(counter++);
    }

    public Model create(String name, String email, String phone) {
        validateInputs(name, email, phone);
        String id = generateId();
        Model model = new Model(id, name.trim(), email.trim(), phone.trim());

        repository.save(model);

        return model;

    }

    public List<Model> listAll(){
        return repository.findAll();
    }

    public void update(String id, String name, String email, String phone){
        validateId(id);
        validateInputs(name, email, phone);
        repository.updateById(id.trim(), name.trim(), email.trim(), phone.trim());
    }

    public void delete(String id){
        validateId(id);
        repository.deleteById(id.trim());

    }

    public Model findById(String id){
        validateId(id);
        Model model = repository.findById(id.trim());

        return model;

    }

    private void validateInputs(String name, String email, String phone){
        validateName(name);
        validateEmail(email);
        validatePhone(phone);
    }

    private void validateId(String id){
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("O campo do ID está vazio");
        }

        String trimmedId = id.trim();


        if (!ID_PATTERN.matcher(trimmedId).matches()) {
            throw new IllegalArgumentException("O ID são apenas números");
        } else if (repository.findById(trimmedId) == null){
            throw new IllegalArgumentException("ID não encontrado");
        }
    }

    private void validateName(String name){
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

    private void validateEmail(String email){
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

    private void validatePhone(String phone){
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
