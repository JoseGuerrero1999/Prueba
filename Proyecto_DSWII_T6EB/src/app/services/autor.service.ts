import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Autor } from '../models/autor.model';
import { Observable } from 'rxjs';
const baseUrl = 'http://localhost:8090/url/autor  ';

@Injectable({
  providedIn: 'root'
})
export class AutorService {

  constructor(private http:HttpClient) { }

  consultaautor(nombre :string): Observable<any>{
    return this.http.get(baseUrl + "/listaautor/" + nombre)
}

registraautor(autor :Autor): Observable<any>{
  return this.http.post(baseUrl + "/registraautor", autor);
}

actualizaautor(autor :Autor): Observable<any>{
return this.http.put(baseUrl + "/editaautor", autor);
}

eliminaautor(idautor : number): Observable<any>{
return this.http.delete(baseUrl + "/eliminaautor/" + idautor);
}



}
