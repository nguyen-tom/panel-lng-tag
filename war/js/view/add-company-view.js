var AddCompanyView = Backbone.View.extend({
	 tagName:"div",
	initialize:function () {
        this.template = _.template(tpl.get('add_company'));
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
    	console.log("Click Add Company...");
    	var input_name      = $("#name").val();
    	var input_address   = $("#address").val();
    	var input_taxcode   = $("#taxcode").val();
    	console.log("[" + input_name + "," + input_address +" ,"  + input_taxcode +  "]")
    	this.model.set({"name" : input_name,"address":input_address,"taxcode":input_taxcode});
    	companyCollection.create(this.model,{ 
    			success:function () {
                   app.navigate('company', false);
    			 }
                });
    }
   
});
