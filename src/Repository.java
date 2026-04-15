import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<Customer> listCustomers = new ArrayList<>();

    public void save(Customer customer){
        listCustomers.add(customer);
    }

    public List<Customer> findAll(){
        return List.copyOf(listCustomers);
    }

    public Customer findById(String id){
        for (int i = 0; i < listCustomers.size(); i++) {
            if (listCustomers.get(i).getId().equals(id)){
                return listCustomers.get(i);
            }
        }

        return null;
    }

    public void deleteById(String id){
        Customer customer = findById(id);
        listCustomers.remove(customer);
    }

    public void updateById(String id, String name, String email, String phone){
        Customer customer = findById(id);

        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);

    }

    public boolean existsByEmail(String email){
        return listCustomers.stream()
                .anyMatch(customer -> customer.getEmail().equalsIgnoreCase(email));
    }
}
