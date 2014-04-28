define([
  'jquery',
  'underscore',
  'backbone',
], function($, _, Backbone){
	
		var AppView  = Backbone.View.extend({
			el:$('#container'),
			
			render:function (eventName) {
		        return this;
		   }
		   
		});
		
		return AppView;
});