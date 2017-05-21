(function () {
  'use strict';

  angular.module('SouzaCar.pages', [
    'ui.router',

    'SouzaCar.pages.financial'
  ])
      .config(routeConfig);

  /** @ngInject */
  function routeConfig($urlRouterProvider, baSidebarServiceProvider) {
    $urlRouterProvider.otherwise('/financial');
  }

})();
