import { Component, OnInit } from '@angular/core';

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/dashboard', title: 'Dashboard',  icon: 'dashboard', class: '' },
    { path: '/user-profile', title: 'Minha conta',  icon:'person', class: '' },
    { path: '/consolidado', title: 'Consolidado',  icon:'content_paste', class: '' },
    { path: '/carteiras', title: 'Carteira',  icon:'content_paste', class: '' },
    { path: '/acoes', title: 'Ações',  icon:'content_paste', class: '' },
    { path: '/fiis', title: 'FIIs',  icon:'content_paste', class: '' },
    { path: '/tesouro-direto', title: 'Tesouro Direto',  icon:'content_paste', class: '' },
    { path: '/renda-fixa', title: 'Renda Fixa',  icon:'content_paste', class: '' },
    { path: '/moedas', title: 'Moedas',  icon:'content_paste', class: '' },
    { path: '/reserva-emergencia', title: 'Reserva de Emergência',  icon:'content_paste', class: '' },
    { path: '/typography', title: 'Impostos',  icon:'library_books', class: '' },
    // { path: '/icons', title: 'Icons',  icon:'bubble_chart', class: '' },
    // { path: '/maps', title: 'Maps',  icon:'location_on', class: '' },
    // { path: '/notifications', title: 'Notifications',  icon:'notifications', class: '' },
    // { path: '/upgrade', title: 'Upgrade to PRO',  icon:'unarchive', class: 'active-pro' },
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
      if ($(window).width() > 991) {
          return false;
      }
      return true;
  };
}
