import java.util.List;

public class Service {
    private Repository repository;
    private int counter = 1;

    public Service(Repository repository){
        this.repository = repository;
    }

    public String generateId(){
        return String.valueOf(counter++);
    }

    public Model create(String name, String email, String phone) {
        validateEmailForCreate(email.trim());
        String id = generateId();
        Model model = new Model(id, name.trim(), email.trim(), phone.trim());

        repository.save(model);

        return model;

    }

    public List<Model> listAll(){
        List<Model> models = repository.findAll();
        if (models.isEmpty()){
            throw new IllegalArgumentException("Nenhum cliente foi cadastrado");
        } else {
            return models;
        }
    }

    public void update(String id, String name, String email, String phone){
        validateId(id.trim());
        validateEmailForCreate(email.trim());
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

    public void validateEmailForCreate(String email){
        Validator.validateEmail(email.trim());

        if (repository.existsByEmail(email)) {
            throw new IllegalArgumentException("Já existe um cliente com esse E-mail.");
        }
    }

    private void validateId(String id){
        String trimmedId = id.trim();
        if (repository.findById(trimmedId) == null){
            throw new IllegalArgumentException("ID não encontrado");
        }
    }
}
