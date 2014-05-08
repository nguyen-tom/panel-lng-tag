define([
        'jquery',
        'underscore',
        'backbone',
        ], function() {
    var app_registry = {};
    app_registry.global_event_obj = _.extend({}, Backbone.Events);
    app_registry.models = {};
    app_registry.views  = {};
    app_registry.modals = {};
    app_registry.router = null;
    return app_registry;
});