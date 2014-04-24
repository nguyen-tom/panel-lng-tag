var ListView = Backbone.View.extend({
    initialize:function () {
    	this.template = _.template(tpl.get('list_type'));
        this.model.on("reset", this.render, this);
        this.model.on("remove",this.render,this);
        this.model.on("add",this.render,this);
        var self = this;
        var type  = new Type();
        this.addTypeView  = new AddTypeView({model:type,vent:vent,models:this.model});
        console.log("model in AddTypeView : " + vent);
    },
    events:{
    	"click #btn-add-type":"addType"
    },
    
    addType:function(event){
    	console.log("click button Add Type");
    	var type = new Type();
    	var addTypeView  = new AddTypeView({model:type});
    	Events.trigger("showAddType");
    },
    render:function (eventName) {
    	console.log("render List Type : " + this.model.length);
    	  $(this.el).html(this.template(this.model.toJSON()));
    	 this.$namein = this.$("#list-item");
        _.each(this.model.models, function (Type) {
        	 this.$namein.append(new ItemTypeView({model:Type}).render().el);
        }, this);
      
        return this;
    }
 
});
 var ItemTypeView = Backbone.View.extend({
	tagName:"li",
	className:"list-group-item",
    initialize:function () {
    	this.template = _.template(tpl.get('item_list_type'));
        this.model.bind("change", this.render, this);
    },
    render:function (eventName) {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    },
    close:function () {
        $(this.el).unbind();
        $(this.el).remove();
    }
 
});