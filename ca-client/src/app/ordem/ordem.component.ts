import {Component} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {AcaoService} from "../acao.service";
import {Acao} from "../domain/acao";

@Component({
  selector: 'ca-ordem',
  templateUrl: './ordem.component.html',
  providers: [AcaoService]
})
export class OrdemComponent {
  sugestoesAtivos: Acao[];

  ordemForm = new FormGroup ({
                ativo: new FormControl(''),
                valor: new FormControl(''),
                quantidade: new FormControl('')
  });


  constructor(private acaoService: AcaoService) {
  }

  pesquisar(event): void {
    // this.sugestoesAtivos = this.acaoService.pesquisar(event.query);
    this.acaoService.pesquisar(event.query)
      .subscribe(acoes => this.sugestoesAtivos = acoes);
    console.log("ordem.component.ts - ações encontradas " + this.sugestoesAtivos);
  }

  onSubmit() {
    console.warn(this.ordemForm.value);
  }

}
