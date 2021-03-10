package manager;

import domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import repository.ProductRepository;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Manager {
    ProductRepository repository = new ProductRepository();

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] getAll() {
        return repository.findAll();
    }

    public void removeById(int id) {
        repository.removeById(id);
    }



}
