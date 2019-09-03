package br.com.fiap.petshop.repository;

import br.com.fiap.petshop.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository
                    extends JpaRepository<Animal, Integer> {

    List<Animal> findByNomeContains(String nome);

    //Pesquisar os animais por castrado
    List<Animal> findByCastrado(boolean castrado);

    //Pesquisar os animais por parte do nome e raça
    List<Animal> findByNomeContainsAndRacaContains(String nome, String raca);

}
