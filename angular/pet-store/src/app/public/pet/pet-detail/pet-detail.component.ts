import { Component, OnInit } from '@angular/core';
import { PetService } from 'src/app/services/pet.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-pet-detail',
  templateUrl: './pet-detail.component.html',
  styleUrls: ['./pet-detail.component.css']
})
export class PetDetailComponent implements OnInit {

  pet = {
    name:'',
    photourl:''
  };
  
  constructor(
    private petService: PetService,
    private route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.getPet(this.route.snapshot.paramMap.get('id'));
  }

  getPet(id):void{
    this.petService.getPet(id)
      .subscribe(
        data => {
          this.pet = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
}
