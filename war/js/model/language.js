define([
  'jquery',
  'underscore',
  'backbone',
], function($, _, Backbone){
		var Language  = Backbone.Model.extend({
			url : "/lang/language",
			defaults :{
				"id":null,
				"name": null,
				"description":""
			},
			 save: function (attributes, options) {
				  options       = options || {};
				  attributes    = attributes || {};
				 
				  this.set(attributes);
				 
				  options.data  = this.toJSON();
				 
				  return Backbone.Model.prototype.save.call(this, attributes, options);
				},
			 
		});
	 return Language;
});