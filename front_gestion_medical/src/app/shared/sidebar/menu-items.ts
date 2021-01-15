import { RouteInfo } from './sidebar.metadata';

export const ROUTES: RouteInfo[] = [
  {
    path: '',
    title: 'Cabinet Medical',
    icon: 'mdi mdi-dots-horizontal',
    class: 'nav-small-cap',
    extralink: true,
    submenu: []
  },
  
  {
    path: '',
    title: 'Menu Principal',
    icon: 'mdi mdi-dots-horizontal',
    class: 'nav-small-cap',
    extralink: true,
    submenu: []
  },
  {
    path: '/component/dashboard',
    title: 'Patient',
    icon: 'mdi mdi-code-array',
    class: '',
    extralink: false,
    submenu: []
  },
  {
    path: '/Npatient',
    title: 'Nouveau Patient',
    icon: 'mdi mdi-folder-account',
    class: '',
    extralink: false,
    submenu: []
  },
  {
    path: '/NAntecedant',
    title: 'Nouvel antecedant',
    icon: 'mdi mdi-folder-account',
    class: '',
    extralink: false,
    submenu: []
  }
];
