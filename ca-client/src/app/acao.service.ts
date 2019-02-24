import {Injectable} from '@angular/core';
import {AppSettings} from "./app.settings";
import {Acao} from "./domain/acao";
import {HttpClient} from '@angular/common/http';
import * as localForage from "localforage";
import {Observable} from "rxjs/Observable";
import {from} from "rxjs/internal/observable/from";


@Injectable()
export class AcaoService {

  private url: string;

  constructor(private http : HttpClient){
    this.url  = AppSettings.ACAO_ENDPOINT;
  }

  getFromApi(sigla: string) : Observable<Acao[]> {
    return this.http.get<Acao[]>(this.url + sigla);
  }


  pesquisar(sigla: string): Observable<Acao[]>  {
     localForage.getItem(sigla).then(cacheAcoes => {
      console.log("Ações no cache: " + cacheAcoes);

      if (cacheAcoes === null) {
        console.log("Atualizado ações via API");
        this.getFromApi(sigla).subscribe(acoesFromApi => localForage.setItem(sigla, acoesFromApi));
      }

    });

    return from(localForage.getItem(sigla));
  }

}
