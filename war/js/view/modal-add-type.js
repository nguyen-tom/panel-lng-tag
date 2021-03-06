var ModalAddTypeView = Backbone.View.extend({
	 tagName:"div",
	initialize:function () {
        this.template = _.template(tpl.get('modal_add_type'));
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
        "click #btn-cancel": "cancel"
    },
    showModal:function(){
    	console.log("SHOW MODAL>>>");
    	console.log("My modal :" + $('#myModal'));
    	  // initialized with no keyboard
    	
    	$('#myModal').modal({show:true}) ;
    },
    cancel:function(event){
    	modalEl.modal('hide');
    },
    change:function (event) {
        var target = event.target;
        console.log('changing ' + target.id + ' from: ' + target.defaultValue + ' to: ' + target.value);
    },
    addType:function(event){
    	console.log("Click Add New Types ...");
    	var input_name  = $("#name").val();
    	var input_des   = $("#description").val();
    	var input_max   = $("#max_item").val();
    	var input_min   = $("#min_item").val();
    	console.log("[" + input_name + "," + input_des +" ,"  + input_max + ", " + input_min + "]")
    	this.model.set({"name" : input_name,"description":input_des,"maxItem":input_max,"minItem": input_min});
    	listType.create(this.model,{ 
    			success:function () {
    				console.log("close modal");
                   app.navigate('types', false);
                   modalEl.modal('hide');
    			 }
                });
    }
   
});