define([
  'jquery',
  'underscore',
  'backbone',
], function($, _, Backbone){
	var Utils = Backbone.Model.extend({
		
		
		showView:function (viewParent, view) {
	        if (this.currentView) this.currentView.close();
	        viewParent.render().$el.html(view.render().el);
	        this.currentView = view;
	        return view;
	    },
		checkLogined:function(callback){
	    	$.ajax("/auth/logined", {
	    	       type: "get",
	    	       dataType: "json",
	    	       success: function(data) {
	    	    	   if(data.result == 10){
	    	    		   console.log("logined");
	    	    		   return callback(true);
	    	    	   }else{
	    	    		   return callback(false);
	    	    	   }
	    	       },
	    	       error: function() {
	    	         return callback(false);
	    	       }
	    	     });
	    }
		
	});
	
	
	
	return Utils;
});

