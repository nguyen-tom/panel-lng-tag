Backbone.View.prototype.close = function () {
    console.log('Closing view ' + this);
    if (this.onClose) {
        this.onClose();
      }
    this.remove();
    this.unbind();
};

// Router
var AppRouter = Backbone.Router.extend({
 
    routes:{
        "":"load",
        "types": "types",
        "types/:id": "loadDetailType",
        "company/:id":"loadDetailCompany",
        "note"   : "notes"
    },
    load:function () {
    	console.log('loading...');
    	if(this.listMenuView) this.listMenuView.remove();
        this.listMenuView  = new ListMenuView();
        
        contentLeftView.render().$el.append(this.listMenuView.render().el);
        rowTopView.render().$el.append(contentLeftView.render().el);
        appView.render().$el.append(rowTopView.render().el);
        appView.render().$el.append(listObjectsView.render().el);
    },
    loadDetailType:function(_id){
    	this.load();
    	console.log('Router : show detail Type...' + _id);
    	var type =  listType.get(_id);
    	type.fetch({data :{ id: _id } , type: "POST"});
    	var detailType = new DetailTypeView({model:type,models:listType});
    	detailObjectView.render().$el.html(detailType.render().el);
    },
    loadDetailCompany:function(_id){
    	this.load();
    	console.log('Router : show detail Company...' + _id);
    	var type =  listType.get(_id);
    	type.fetch({data :{ id: _id } , type: "POST"});
    	var detailType = new DetailTypeView({model:type,models:listType});
    	detailObjectView.render().$el.html(detailType.render().el);
    },
    types:function(){
    	   console.log('Router TYPES...:' + listType.length);
    	   var listTypeView  = new ListView({model:listType});
		   app.showView(listObjectsView,listTypeView)
    },
    notes:function(){
    	if(appView) this.load();
    	console.log('Router note. runing...');
    	this.reset();
    },
    reset :function (){
    	console.log('reset.view...');
    	if(content) content.render().$el.empty();
    	appView.render().$el.append(content.render().el);
    },
    showView:function (viewParent, view) {
        if (this.currentView) this.currentView.close();
        viewParent.render().$el.html(view.render().el);
        this.currentView = view;
        return view;
    },

    before:function (callback) {
        if (this.wineList) {
            if (callback) callback();
        } else {
            this.wineList = new WineCollection();
            this.wineList.fetch({success:function () {
                $('#sidebar').html(new WineListView({model:app.wineList}).render().el);
                if (callback) callback();
            }});
        }
    }
   
}); 
var vent  = _.extend({}, Backbone.Events);
var appView  = new AppView();
var rowTopView  = new RowTopView();
var contentLeftView  = new ContentLeftView();
var contentRightView = new ContentRightView();
var listObjectsView  = new ListObjectsView();
var detailObjectView  = new DetailObjetsView();
var listType;
var companyCollection;
tpl.loadTemplates(['add_type','update_type','item_list_type','add_company','list_menu',"list_type"], function (){
    app = new AppRouter();
    Backbone.emulateJSON = true;
    Backbone.history.start();
});

 