import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'character',
    loadChildren: () => import('./features/character/character.routes'),
  },
  
  { path: '', redirectTo: 'character', pathMatch: 'full' },

  { path: '**', loadComponent: () => import('./features/not-found/not-found.component') },
];
