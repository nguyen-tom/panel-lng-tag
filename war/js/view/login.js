define([
  'jquery',
  'underscore',
  'backbone',
  'app_registry',
  'model/authori',
  'text!/tpl/login.html'
], function($, _, Backbone,app_registry,Authori,LoginTemplate){
	
	var LoginView  = Backbone.View.extend({
		initialize: function(options) {
			 this.template = _.template(LoginTemplate);
			 this.showLogin();
		 },
		 events :{
			 "click #submit":"login"
		 },
		 
		 login:function(e){
			 e.preventDefault();
			 var input_company  = $('#company-id').val();
			 var input_username = $('#email').val();
			 var input_password = $('#password').val();
			 var self = this;
			 $.ajax("/login", {
	    	       type: "POST",
	    	       data :{
	    	    	  'shop': input_company,
	    	    	  'user-name' : input_username,
	    	    	  'password' : input_password
	    	       },
	    	       dataType: "json",
	    	       success: function(data) {
	    	    	   if(data.result == 10){
	    	    		    console.log("login completed");
	    	    		    window.authori.load();
	    	    		    self.hideFormLogin();
	    					window.router.navigate("dashboard",true);
	    	    	   }else{
	    	    		   
	    	    	   }
	    	       },
	    	       error: function() {
	    	         
	    	       }
	    	     });
			
		 },
		 showLogin:function(){
			 $("#login").css("padding-top","30px");
		 },
		 hideFormLogin:function(){
			 $("#login").css("padding-top","0px");
			 $('#login').hide();
		 },
		 render:function(){
				$(this.el).html(this.template());
				return this;
			}
	});
	return LoginView;
});
	