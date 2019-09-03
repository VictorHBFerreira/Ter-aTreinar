package br.com.fiap.petshop.resource;

import br.com.fiap.petshop.model.Animal;
import br.com.fiap.petshop.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("animal")
public class AnimalResource {

    @Autowired
    private AnimalRepository rep;

    //URL - http://localhost:8080/animal/pesquisa/nome?raca=vira
    @GetMapping("pesquisa/{nome}")
    public List<Animal> pesquisar(@PathVariable String nome,
                                                @RequestParam String raca){
        return rep.findByNomeContainsAndRacaContains(nome,raca);
    }

    //URL - http://localhost:8080/animal/pesquisa/castrado/true
    @GetMapping("pesquisa/castrado/{castrado}")
    public List<Animal> pesquisar(@PathVariable boolean castrado){
        return rep.findByCastrado(castrado);
    }

    //URL - http://localhost:8080/animal/pesquisa?nome=luck
    @GetMapping("pesquisa")
    public List<Animal> pesquisar(@RequestParam String nome){
        return rep.findByNomeContains(nome);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id){
        rep.deleteById(id);
    }

    @PutMapping("{id}")
    public Animal atualizar(@RequestBody Animal animal, @PathVariable int id){
        animal.setCodigo(id);
        return rep.save(animal);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Animal cadastrar(@RequestBody Animal animal){
        return rep.save(animal);
    }

    @GetMapping("{id}")
    public Animal buscar(@PathVariable int id){
        return rep.findById(id).get();
    }

    @GetMapping
    public List<Animal> listar(){
        return rep.findAll();
    }

}
