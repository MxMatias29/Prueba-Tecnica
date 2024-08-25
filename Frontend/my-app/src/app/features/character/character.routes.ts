import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadComponent: () => import('./character.component'),
  },
  {
    path: ':id',
    loadComponent: () => import('./detail/detail.component'),
  },
];

export default routes;
