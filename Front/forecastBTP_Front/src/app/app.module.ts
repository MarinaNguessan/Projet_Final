import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { IonicModule } from '@ionic/angular';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CreateSiteComponent } from './create-site/create-site.component';
import { SiteListComponent } from './site-list/site-list.component';
import { UpdateSiteComponent } from './update-site/update-site.component';
import { IndexComponent } from './index/index.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CityListComponent } from './city-list/city-list.component';
import { RiskComponent } from './risk/risk.component';
import { CreatePeriodComponent } from './create-period/create-period.component';
import { PreventiveActionComponent } from './preventive-action/preventive-action.component';
import { CompanyComponent } from './company/company.component';
import { LoginComponent } from './authentification/login/login.component';
import { RegisterComponent } from './authentification/register/register.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DashboardComponent,
    CreateSiteComponent,
    SiteListComponent,
    UpdateSiteComponent,
    IndexComponent,
    CityListComponent,
    RiskComponent,
    CreatePeriodComponent,
    PreventiveActionComponent,
    CompanyComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    IonicModule.forRoot(),
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
