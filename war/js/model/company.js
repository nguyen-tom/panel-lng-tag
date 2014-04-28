define([
  'jquery',
  'underscore',
  'backbone',
], function($, _, Backbone){

		var Company  = Backbone.Model.extend({
			url : "company/company",
			defaults :{
				"id":null,
				"name": null,
				"address":"",
				"taxcode":"",
			},
			 save: function (attributes, options) {
				  options       = options || {};
				  attributes    = attributes || {};
				 
				  this.set(attributes);
				 
				  options.data  = this.toJSON();
				 
				  return Backbone.Model.prototype.save.call(this, attributes, options);
				},
			 
		});
		
		return Company;

});