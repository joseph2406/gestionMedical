import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NouvPatientComponent } from './component/nouv-patient/nouv-patient.component';

import { FullComponent } from './layouts/full/full.component';

export const Approutes: Routes = [
  
  {
    path: '',
    component: FullComponent,
    children: [
      { path: 'Npatient', pathMatch: 'full', component: NouvPatientComponent}, 
      { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
      {
        path: 'dashboard',
        loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule)
      },
      {
        path: 'component',
        loadChildren: () => import('./component/component.module').then(m => m.ComponentsModule)
      }
    ]
  },
  
  {
    path: '**',
    redirectTo: '/dashboard'
  }
];
