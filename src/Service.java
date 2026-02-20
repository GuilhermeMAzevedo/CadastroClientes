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
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O campo do nome está vazio");
        } else if (email == null || email.isBlank()){
            throw new IllegalArgumentException("O campo do E-mail está vazio");
        } else if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("O campo do telefone está vazio");
        } else {
            String id = generateId();
            Model model = new Model(id, name, email, phone);

            repository.save(model);

            return model;
        }
    }

    public List<Model> listAll(){
        return repository.findAll();
    }

    public void update(String id, String name, String email, String phone){
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("O campo do ID está vazio");
        } else if (repository.findById(id) == null){
            throw new IllegalArgumentException("ID não encontrado");
        } else if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O campo do nome está vazio");
        } else if (email == null || email.isBlank()){
            throw new IllegalArgumentException("O campo do E-mail está vazio");
        } else if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("O campo do telefone está vazio");
        } else {
            repository.updateById(id, name, email, phone);
        }
    }

    public void delete(String id){
        if (id == null) {
            throw new IllegalArgumentException("O campo do ID está vazio");
        } else if (repository.findById(id) == null){
            throw new IllegalArgumentException("ID não encontrado");
        } else {
            repository.deleteById(id);
        }
    }

    public Model findById(String id){
        Model model = repository.findById(id);
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("O campo do ID está vazio");
        } else if (repository.findById(id) == null){
            throw new IllegalArgumentException("ID não encontrado");
        } else {
            return repository.findById(id);
        }
    }
}
