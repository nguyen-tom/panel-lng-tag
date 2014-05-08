define([
  'jquery',
  'underscore',
  'backbone',
  'app_registry',
  'text!/tpl/nav.html'
], function($, _, Backbone,app_registry,NavTemplate){

	var NavView  = Backbone.View.extend({
		
		initialize: function(options) {
			 this.template = _.template(NavTemplate);
			  this.model.bind("change", this.render, this);
			  console.log(this.model.usr_id);
			 
		 },
		 render:function(){
				$(this.el).html(this.template(this.model.toJSON()));
				return this;
			}
	});
	return NavView;
});
