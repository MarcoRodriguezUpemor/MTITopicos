import { NgModule } from '@angular/core';
import { Routes,RouterModule } from '@angular/router';
import { AppPetComponent } from './app-pet/app-pet.component';
import { PetListComponent } from './public/pet/pet-list/pet-list.component';
import { PetDetailComponent } from './public/pet/pet-detail/pet-detail.component';
import { CreatePetComponent } from './admin/pet/create-pet/create-pet.component';
import { LoginComponent } from './public/login/login.component';

const routes = [
  { path: 'login',component:LoginComponent,pathMatch:'full'},
  { path: 'pets',component:PetListComponent,  pathMatch: 'full'},
  { path: 'pets/:id',component:PetDetailComponent,pathMatch: 'full'},
  { path: 'admin/pets/create', component:CreatePetComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}