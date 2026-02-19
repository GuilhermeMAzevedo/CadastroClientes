import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<Model> listModels = new ArrayList<>();

    public void save(Model model){
        listModels.add(model);
    }

    public List<Model> findAll(){
        return List.copyOf(listModels);
    }

    public Model findById(String id){
        for (int i = 0; i < listModels.size(); i++) {
            if (listModels.get(i).getId().equals(id)){
                return listModels.get(i);
            }
        }

        return null;
    }

    public void deleteById(String id){
        Model model = findById(id);
        if (model != null) {
            listModels.remove(model);
        }
    }

    public void updateById(String id, String name, String email, String phone){
        Model model = findById(id);
        if (model != null) {
            model.setName(name);
            model.setEmail(email);
            model.setPhone(phone);
        }
    }

}
