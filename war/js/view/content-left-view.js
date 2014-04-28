define([
  'jquery',
  'underscore',
  'backbone',
], function($, _, Backbone){
		var ContentLeftView  = Backbone.View.extend({
			el: $('#content-left'),
			render:function (eventName) {
		        return this;
		   }
		});
	
	return ContentLeftView;
});