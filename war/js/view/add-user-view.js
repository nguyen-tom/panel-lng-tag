var AddTypeView = Backbone.View.extend({
	 tagName:"div",
	initialize:function () {
        this.template = _.template(tpl.get('add_user'));
        this.model.bind("change", this.render, this);
        console.log( this.et);
    },

    render:function (eventName) {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    },
    events:{
        "change input":"change",
        "click #btn-add": "addType",
    },
    change:function (event) {
        var target = event.target;
        console.log('changing ' + target.id + ' from: ' + target.defaultValue + ' to: ' + target.value);
    },
    addType:function(event){
    	console.log("Click Add New Types ...");
    	var input_account  = $("#account").val();
    	var input_password   = $("#password").val();
    	var input_email   = $("#email").val();
    	
    	console.log("[" + input_account + "," + input_password +" ,"  + input_email + "]")
    	this.model.set({"" : input_name,"description":input_des,"maxItem":input_max,"minItem": input_min});
    	listType.create(this.model,{ 
    			success:function () {
                   app.navigate('types', false);
    			 }
                });
    }
   
});
