require.config({
  paths: {
    jquery: 'libs/jquery/jquery-1.9.1.min',
    'jquery.cookie'  : 'libs/jquery/jquery.cookie',
    underscore: 'libs/backbone/underscore-min',
    backbone: 'libs/backbone/backbone-min',
    bootstrap: 'libs/bootstrap/bootstrap',	
    modal:     'libs/bootstrap/modal',	
    transition: 'libs/bootstrap/transition'	,
    text      : 'libs/require/text',
   
    			
  },
  shim: {
      jquery: {
        exports: '$'
      },
      underscore: {
        deps:["jquery"],
        exports: '_'
      },
      backbone: {
        deps:["jquery","underscore"],
        exports: 'Backbone'
      },
      'jquery.cookie': {     //<-- cookie depends on Jquery and exports nothing
          deps: ['jquery']
      },
      waitSeconds: 15
    }

});

require([
  'app',
], function(App){
  App.initialize();
});
