import { Component, OnInit } from '@angular/core';
import { Autor } from 'src/app/models/autor.model';
import { AutorService } from 'src/app/services/autor.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-autor',
  templateUrl: './autor.component.html',
  styleUrls: ['./autor.component.css']
})
export class AutorComponent implements OnInit {

autores: Autor [] = [];
filtro : string = "";

autor: Autor = {

}


  constructor(private autorservice:AutorService) { }

  ngOnInit(): void {
  }

  consulta(){
    console.log(">>> consulta >> " + this.filtro);
     this.autorservice.consultaautor(this.filtro==""?"todos":this.filtro).subscribe(
         x => this.autores = x
     )
 }

 registra(){
     console.log(">>> registra >> ");
     this.autorservice.registraautor(this.autor).subscribe(
         x => Swal.fire('Mensaje', x.mensaje,'info')
     )
 }

}

