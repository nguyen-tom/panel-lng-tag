define([
  'jquery',
  'underscore',
  'backbone',
  'app_registry',
  'view/app-views',
  'view/content-left-view',
  'view/content-right-view',
  'view/list-menu-view',
  'view/detail-object-view',
  'view/detail-type-view',
  'view/row-top-view',
  'view/login',
  'view/nav',
  'model/type'
], function($, _, Backbone,app_registry,
		AppView, 
		ContentLeftView,
		ContentRightView,
		ListMenuView,
		DetailObjetsView,
		DetailTypeView,
		RowTopView,
		LoginView,
		NavView,
		Type
		){
	
//	Backbone.View.prototype.close = function () {
//	    console.log('Closing view ' + this);
//	    if (this.onClose) {
//	        this.onClose();
//	      }
//	    this.remove();
//	    this.unbind();
//	};
//  
   var AppRouter = Backbone.Router.extend({
	  routes:{
	        "dashboard":"load",
	        "login":"login",
	        "/types": "types",
	        "types/:id": "loadDetailType",
	        "company/:id":"loadDetailCompany",
	        "note"   : "notes"
	    }

  });

  var initialize = function(){
//	  var appView  = new AppView();
//	 // var rowTopView  = new RowTopView();
//	  var contentLeftView  = new ContentLeftView();
//	  var contentRightView = new ContentRightView();
//	 //x var listObjectsView  = new ListObjectsView();
//	  var detailObjectView  = new DetailObjetsView();
//	 // var modalEl = $("#myModal");
//	  var listType;
//	  var companyCollection;
	  
    var app_router = new AppRouter;
    window.router = app_router;
    console.log(app_router);
    app_router.on("route:load", function(){
    	console.log("Router : Load");
    	console.log(window.authori);
    	if(window.authori && window.authori.authoried() == true) {
    		$("#login").css({"padding-top":"0px"});
    		if(this.listMenuView) this.listMenuView.remove();
        	window.appView = new AppView();
        	window.appView = appView;
            window.contentLeftView  = new ContentLeftView();
            window.rowTopView       = new RowTopView();
            window.listMenuView     = new ListMenuView();
        	window.detailObjectsView =  new DetailObjetsView();
        	console.log(window.authori);
        	window.navView  = new NavView({model:window.authori});
        	$("#nav").html(window.navView.render().el);
        	
            window.contentLeftView.render().$el.html(
            		window.listMenuView.render().el
            );
            window.rowTopView.render().$el.append(window.contentLeftView.render().el);
            window.appView.render().$el.append(window.rowTopView.render().el);
    	}else{
    		console.log("not logined");
    	}
    });
    app_router.on('route:login',function(){
    	console.log('Router : Login');
    	$("#nav").html("");
    	if(window.appView) window.appView.close();
    	var loginView  = new LoginView();
    	$('#login').html(loginView.render().el);
    });
    app_router.on('route:loadDetailType',function(_id){
    	
    	
    	console.log("ListType :" + app_registry.models.listType);
    	console.log('Router : show detail Type...' + _id);
    	var type =  app_registry.models.listType.get(_id);
    	type.fetch({data :{ id: _id } , type: "POST"});
    	var detailType = new DetailTypeView({model:type,models:app_registry.models.listType});
    	app_registry.views.detailObjectsView.render().$el.html(detailType.render().el);
    });
    
    app_router.on('route:loadDetailCompany',function(_id){
    	console.log('Router : show detail Company...' + _id);
    	var type =  listType.get(_id);
    	type.fetch({data :{ id: _id } , type: "POST"});
    	var detailType = new DetailTypeView({model:type,models:listType});
    	app_registry.views.detailObjectsView.render().$el.html(detailType.render().el);
    });
    
    app_router.on('route:types',function(){
    	   console.log('Router TYPES...:' + listType.length);
    	   var listTypeView  = new ListView({model:listType});
		   app.showView(listObjectsView,listTypeView)
    });
    app_router.on('route:notes',function(){
    	console.log('Router note. runing...');
    	this.reset();
    });
    console.log('init router...');
    Backbone.history.start();
    Backbone.emulateJSON = true;
  };
  
  
  
  return {
    initialize: initialize
  };
  
  
  
});
















 