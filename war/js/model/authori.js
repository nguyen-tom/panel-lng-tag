define([
  'jquery',
  'underscore',
  'backbone',
  'jquery.cookie'
], function($, _, Backbone){
	
	var Authori = Backbone.Model.extend({
		url : "/login",
		defaults:{
			"token_id":null,
			"usr_id": null,
			"usr_name":null
		},
		
		authoried:function(){
			if(this.usr_id){
				return true;
			}else{
				return false;
			}
		},
		getUserName:function(){
			return this.usr_name;
		},
		 save: function (attributes, options) {
			  options       = options || {};
			  attributes    = attributes || {};
			 
			  this.set(attributes);
			 
			  options.data  = this.toJSON();
			 
			  return Backbone.Model.prototype.save.call(this, attributes, options);
	    },
	    load:function(){
	    	this.token_id = $.cookie("token_id");
	    	this.usr_id   = $.cookie("usr_id");
	    	this.usr_name = $.cookie("usr_name");
	    },
	    
		
	});
	
	return Authori;
	
});