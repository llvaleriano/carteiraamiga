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
    { path: '/Objetivos', title: 'Objetivos',  icon:'content_paste', class: '' },
    { path: '/Consolidado', title: 'Consolidado',  icon:'content_paste', class: '',  },
    { path: '/Acoes', title: 'Acoes',  icon:'content_paste', class: '' },
    { path: '/FIIs', title: 'FIIs',  icon:'content_paste', class: '' },
    { path: '/RendaFixa', title: 'Renda Fixa',  icon:'content_paste', class: '' },
    { path: '/ReservaEmergencia', title: 'Reserva de Emergencia',  icon:'content_paste', class: '' },
    { path: '/Moedas', title: 'Moedas',  icon:'content_paste', class: '' },
    { path: '/ImpostoRenda', title: 'Imposto de Renda',  icon:'content_paste', class: '' },
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
