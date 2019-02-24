package br.com.vl.carteiraamiga.web.dto;

import br.com.vl.carteiraamiga.domain.Ativo;
import br.com.vl.carteiraamiga.domain.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class CarteiraDto {
    private Long id;
    private Usuario usuario;
    private String nome;
    private String descricao;
    private List<Ativo> ativos;
}
