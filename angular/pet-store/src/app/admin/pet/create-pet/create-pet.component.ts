import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import { PetService } from 'src/app/services/pet.service';
import { TagService } from 'src/app/services/tag.service';

@Component({
  selector: 'app-create-pet',
  templateUrl: './create-pet.component.html',
  styleUrls: ['./create-pet.component.css']
})
export class CreatePetComponent implements OnInit {
  submitted = false;
  pet = {
    "category": {
      "id": 0,
      "name": "string"
    },
    "id": 0,
    "name": "string",
    "photourl": "string",
    "price": 0,
    "status": true,
    "tag": {
      "id": 0,
      "name": "string"
    }
  };

  categorys = [];
  tags = [];

  constructor(
    private petService: PetService, 
    private categoryService: CategoryService,
    private tagService: TagService
  ) { }

  ngOnInit(): void {
    this.retrieveCategoryTag();
  }

  retrieveCategoryTag(): void {
    this.categoryService.getAll()
      .subscribe(
        data => {
          this.categorys = data;
        },
        error => {
          console.log(error);
        });

    this.tagService.getAll()
        .subscribe(
          data => {
            this.tags = data;
          },
          error => {
            console.log(error);
          }
        )
  }

  savePet(): void {
    const data = {
      name: this.pet.name,
      price: this.pet.price,
      status: this.pet.status,
      photourl:this.pet.photourl,
      category: {
        id: this.pet.category.id
      },
      tag: {
        id: this.pet.tag.id
      }
    };

    this.petService.create(data).subscribe(
      response => {
        this.submitted = true;
      }, error => {
        console.log(error);
      });
  }

  newPet(): void {
    this.submitted = false;
    this.pet = {
      "category": {
        "id": 0,
        "name": "string"
      },
      "id": 0,
      "name": "string",
      "photourl": "string",
      "price": 0,
      "status": true,
      "tag": {
        "id": 0,
        "name": "string"
      }
    }
  }

}
