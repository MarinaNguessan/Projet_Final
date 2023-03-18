import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateSiteComponent } from './create-site/create-site.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { IndexComponent } from './index/index.component';
import { SiteListComponent } from './site-list/site-list.component';

const routes: Routes = [


  {path:'dashboard', component:DashboardComponent,
  children : [
    {
      path : "index" ,
      component : IndexComponent
    },
    {path:'createSite', component:CreateSiteComponent},
    {path:'siteList', component:SiteListComponent},
    {path:'updateSite/id', component:SiteListComponent},
  ]
},

]



;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
