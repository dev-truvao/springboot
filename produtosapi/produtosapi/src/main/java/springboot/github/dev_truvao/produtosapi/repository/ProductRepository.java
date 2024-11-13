package springboot.github.dev_truvao.produtosapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import springboot.github.dev_truvao.produtosapi.model.Produto;

import java.util.List;

public interface ProductRepository extends JpaRepository<Produto, String> {

    List<Produto> findByName(String name);
}
