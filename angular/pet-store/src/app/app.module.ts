import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppPetComponent } from './app-pet/app-pet.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { PetListComponent } from './public/pet/pet-list/pet-list.component';
import { PetDetailComponent } from './public/pet/pet-detail/pet-detail.component';
import { CreatePetComponent } from './admin/pet/create-pet/create-pet.component';
import { LoginComponent } from './public/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    AppPetComponent,
    PetListComponent,
    PetDetailComponent,
    CreatePetComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
