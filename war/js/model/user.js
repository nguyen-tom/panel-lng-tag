var User  = Backbone.Model.extend({
	url : "/user",
	defaults :{
		"id":null,
		"account": null,
		"password":"",
		"emal":"",
		"address":"",
		"first-name":"",
		"last-name": "",
		"mobile-phone":"",
		"id-company":"",
		"id-language":"",
		
	},
	 save: function (attributes, options) {
		  options       = options || {};
		  attributes    = attributes || {};
		 
		  this.set(attributes);
		 
		  options.data  = this.toJSON();
		 
		  return Backbone.Model.prototype.save.call(this, attributes, options);
		},
	 
});