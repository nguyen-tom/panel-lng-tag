define([
  'jquery',
  'underscore',
  'backbone',
], function($, _, Backbone){
		var ContentRightView  = Backbone.View.extend({
			el:$("#content-right"),
			render:function (eventName) {
		        return this;
		   }
		});
	
		return ContentRightView;
});