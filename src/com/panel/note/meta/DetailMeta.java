package com.panel.note.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2014-05-06 08:27:02")
/** */
public final class DetailMeta extends org.slim3.datastore.ModelMeta<com.panel.note.model.Detail> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Detail, java.util.Date> createAt = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Detail, java.util.Date>(this, "createAt", "createAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Detail> description = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Detail>(this, "description", "description");

    /** */
    public final org.slim3.datastore.StringCollectionAttributeMeta<com.panel.note.model.Detail, java.util.List<java.lang.String>> imgs = new org.slim3.datastore.StringCollectionAttributeMeta<com.panel.note.model.Detail, java.util.List<java.lang.String>>(this, "imgs", "imgs", java.util.List.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Detail, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Detail, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Detail, java.lang.Integer> price = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Detail, java.lang.Integer>(this, "price", "price", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Detail, java.util.Date> updateAt = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Detail, java.util.Date>(this, "updateAt", "updateAt", java.util.Date.class);

    private static final DetailMeta slim3_singleton = new DetailMeta();

    /**
     * @return the singleton
     */
    public static DetailMeta get() {
       return slim3_singleton;
    }

    /** */
    public DetailMeta() {
        super("Detail", com.panel.note.model.Detail.class);
    }

    @Override
    public com.panel.note.model.Detail entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.panel.note.model.Detail model = new com.panel.note.model.Detail();
        model.setCreateAt((java.util.Date) entity.getProperty("createAt"));
        model.setDescription((java.lang.String) entity.getProperty("description"));
        model.setImgs(toList(java.lang.String.class, entity.getProperty("imgs")));
        model.setKey(entity.getKey());
        model.setPrice(longToPrimitiveInt((java.lang.Long) entity.getProperty("price")));
        model.setUpdateAt((java.util.Date) entity.getProperty("updateAt"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.panel.note.model.Detail m = (com.panel.note.model.Detail) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("createAt", m.getCreateAt());
        entity.setProperty("description", m.getDescription());
        entity.setProperty("imgs", m.getImgs());
        entity.setProperty("price", m.getPrice());
        entity.setProperty("updateAt", m.getUpdateAt());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.panel.note.model.Detail m = (com.panel.note.model.Detail) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.panel.note.model.Detail m = (com.panel.note.model.Detail) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(com.panel.note.model.Detail) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.panel.note.model.Detail m = (com.panel.note.model.Detail) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCreateAt() != null){
            writer.setNextPropertyName("createAt");
            encoder0.encode(writer, m.getCreateAt());
        }
        if(m.getDescription() != null){
            writer.setNextPropertyName("description");
            encoder0.encode(writer, m.getDescription());
        }
        if(m.getImgs() != null){
            writer.setNextPropertyName("imgs");
            writer.beginArray();
            for(java.lang.String v : m.getImgs()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("price");
        encoder0.encode(writer, m.getPrice());
        if(m.getUpdateAt() != null){
            writer.setNextPropertyName("updateAt");
            encoder0.encode(writer, m.getUpdateAt());
        }
        writer.endObject();
    }

    @Override
    protected com.panel.note.model.Detail jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.panel.note.model.Detail m = new com.panel.note.model.Detail();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("createAt");
        m.setCreateAt(decoder0.decode(reader, m.getCreateAt()));
        reader = rootReader.newObjectReader("description");
        m.setDescription(decoder0.decode(reader, m.getDescription()));
        reader = rootReader.newObjectReader("imgs");
        {
            java.util.ArrayList<java.lang.String> elements = new java.util.ArrayList<java.lang.String>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("imgs");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.String v = decoder0.decode(reader, (java.lang.String)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setImgs(elements);
            }
        }
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("price");
        m.setPrice(decoder0.decode(reader, m.getPrice()));
        reader = rootReader.newObjectReader("updateAt");
        m.setUpdateAt(decoder0.decode(reader, m.getUpdateAt()));
        return m;
    }
}