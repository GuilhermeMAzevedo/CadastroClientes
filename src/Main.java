public class Main {
    public static void main(String[] args) {
        Model m1 = new Model("1", "Guilherme", "gui@gmail.com", "85987654321");
        Model m2 = new Model("2", "pedro", "pedro@gmail.com", "85988876543");
        Model m3 = new Model("3", "joao", "jao@gmail.com", "85987765432");
        Repository r = new Repository();
        r.addListModels(m1);
        r.addListModels(m2);
        r.addListModels(m3);
        r.printListModels();
        r.removeListModels("2");
        r.printListModels();
    }
}
