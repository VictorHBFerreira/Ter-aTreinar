package br.com.fiap.petshop.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="animal",sequenceName = "SQ_T_ANIMAL",allocationSize = 1)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal")
    private int codigo;

    private String nome;

    private String raca;

    private boolean castrado;

    private LocalDate dataNasc;

    public LocalDate getDataNasc() { return dataNasc;    }

    public void setDataNasc(LocalDate dataNasc) {    this.dataNasc = dataNasc;    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }
}
