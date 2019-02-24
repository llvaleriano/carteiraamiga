package br.com.vl.carteiraamiga.web.dto;

import lombok.Data;

@Data
public class AcaoDto {

    private Integer id;
    private String sigla;
    private String nome;

    public AcaoDto(Integer id, String sigla, String nome) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
    }

}
