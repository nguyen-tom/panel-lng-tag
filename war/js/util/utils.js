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
		
		
	});
	
	
	return Utils;
});

