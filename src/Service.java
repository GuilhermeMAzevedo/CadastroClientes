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

    public Customer create(String name, String email, String phone) {
        validateEmailForCreate(email.trim());
        String id = generateId();
        Customer customer = new Customer(id, name.trim(), email.trim(), phone.trim());

        repository.save(customer);

        return customer;

    }

    public List<Customer> listAll(){
        List<Customer> customers = repository.findAll();
        if (customers.isEmpty()){
            throw new IllegalArgumentException("Nenhum cliente foi cadastrado");
        } else {
            return customers;
        }
    }

    public void update(String id, String name, String email, String phone){
        validateId(id.trim());
        validateEmailForUpdate(id.trim(), email.trim());
        repository.updateById(id.trim(), name.trim(), email.trim(), phone.trim());
    }

    public void delete(String id){
        validateId(id);
        repository.deleteById(id.trim());

    }

    public Customer findById(String id){
        validateId(id);
        Customer customer = repository.findById(id.trim());

        return customer;
    }

    public void validateEmailForCreate(String email){
        Validator.validateEmail(email.trim());

        if (repository.existsByEmail(email)) {
            throw new IllegalArgumentException("Já existe um cliente com esse E-mail.");
        }
    }

    public void validateEmailForUpdate(String id, String email){
        Validator.validateEmail(email.trim());

        boolean emailInUseByOther = repository.findAll().stream().anyMatch(customer -> customer.getEmail().equalsIgnoreCase(email) && !customer.getId().equals(id));
        if (emailInUseByOther){
            throw new IllegalArgumentException("Já existe OUTRO cliente usando esse E-mail.");
        }
    }

    private void validateId(String id){
        String trimmedId = id.trim();
        if (repository.findById(trimmedId) == null){
            throw new IllegalArgumentException("ID não encontrado");
        }
    }
}
