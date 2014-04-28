define([
  'jquery',
  'underscore',
  'backbone',
  'text!/tpl/update_type.html'
], function($, _, Backbone,UpdateTypeTemplate){

		var DetailTypeView  = Backbone.View.extend({
			tagName : 'div',
			initialize:function (models) {
		        this.template = _.template( UpdateTypeTemplate );
		        this.models = models;
		        this.model.bind("change", this.render, this);
//		        console.log("init : " + listType.length);
		    },
		    render:function (eventName) {
		        $(this.el).html(this.template(this.model.toJSON()));
		        return this;
		    },
		    events:{
		        "change input":"change",
		        "click #btn-edit": "editType",
		        "click #btn-delete" : "deleteType"
		    },
		    change:function (event) {
		        var target = event.target;
		        console.log('changing ' + target.id + ' from: ' + target.defaultValue + ' to: ' + target.value);
		    },
		    deleteType:function(event){
		    	console.log("deleted Type :" + this.model.get('name'));
		    	listType.remove(this.model);
		    	this.close();
		    },
		    editType : function(event){
		    	console.log("Click Edit Type  ..." + this.model.get("id"));
		    	var input_name  = $("#name").val();
		    	var input_des   = $("#description").val();
		    	var input_max   = $("#max_item").val();
		    	var input_min   = $("#min_item").val();
		    	console.log("[" + input_name + "," + input_des +" ,"  + input_max + ", " + input_min + "]")
		    	this.model.set({"name": input_name,"description":input_des,"maxItem":input_max,"minItem": input_min});
		    	this.model.save();
		    	this.models.reset();
		    	
		    }
		    
			
		});
		return DetailTypeView;
		
});