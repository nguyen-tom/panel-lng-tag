define([
  'jquery',
  'underscore',
  'backbone',
  'router',
  'app_registry',
  'model/authori',
  'util/utils'
], function($, _, Backbone, AppRouter,app_registry,Authori,Utils){
  var initialize = function(){
	  app_registry.modals.El  = $('#myModal');
	  Backbone.View.prototype.close = function () {
		  this.$el.empty();
		  this.unbind();
		};
	  
	  Utils = new Utils();
	 var authori = new Authori();
	  window.authori= authori ;
	  window.authori.load();
	  console.log("Authorizial :" + authori.authoried());
	  AppRouter.initialize();
	  
	  if(window.authori.authoried() == true){
		  $("#login").css({"padding-top":"0px"});
		  //window.location.hash = "#dashboard";
		  window.router.navigate("dashboard",true);
	  }else{
		  $("#login").css({"padding-top":"30px"});
		  window.router.navigate("login",true);
	  }
//	  Utils.checkLogined(function(islogined){
//		  console.log( app_registry.router);
//		  if(islogined == true){
//			  app_registry.router.navigate("dashboard",true);
//		  }else{
//			 // window.location.hash ="/login";
//			  app_registry.router.navigate("login",true);
//		  }
//	  });
  }
  return {
    initialize: initialize
    
  };
});