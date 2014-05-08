define([
  'jquery',
  'underscore',
  'backbone',
], function($, _, Backbone){
		var AppView  = Backbone.View.extend({
			el:$('#container'),
			
			render:function (eventName) {
		        return this;
		   },
//		   close: function(){
//			      this.remove();
//			      this.unbind();
//			      //this.model.unbind("change", this.modelChanged);
//			    }
		   
		});
		
		return AppView;
});