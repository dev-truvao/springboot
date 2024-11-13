package springboot.github.dev_truvao.produtosapi.controller;

import org.springframework.web.bind.annotation.*;
import springboot.github.dev_truvao.produtosapi.model.Produto;
import springboot.github.dev_truvao.produtosapi.repository.ProductRepository;

import java.util.List;
import java.util.UUID;


@RestController //--> Marcação que informa que é uma classe que irá receber requições REST
@RequestMapping("produtos") //--> Marcação que informa qual e a URL base
public class ProdutoController {

    private ProductRepository productRepository;

    public ProdutoController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @PostMapping //--> Marcação que recebe dados/envia dados
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("produto recebido:" + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        productRepository.save(produto);
        return produto;
    }
    @GetMapping("{id}")
    public Produto obterProduto(@PathVariable("id") String id){
        return productRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletarProduto(@PathVariable("id") String id){
        productRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizarProduto(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);
        productRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("name") String name){
        return productRepository.findByName(name);
    }
}
