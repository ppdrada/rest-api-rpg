package com.avaliacao.projetoindividualcontinuada2.dominios;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Jogador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;

    private String categoria;

    @Min(0)
    @Max(10)
    private Integer vida;

    @Min(0)
    @Max(10)
    private Integer ataque;

    @ManyToMany
    private List<Campanha> campanha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public List<Campanha> getCampanha() {
        return campanha;
    }

    public void setCampanha(List<Campanha> campanha) {
        this.campanha = campanha;
    }
}
