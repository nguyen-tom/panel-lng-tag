package com.panel.note.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2014-05-06 08:27:02")
/** */
public final class TypeMeta extends org.slim3.datastore.ModelMeta<com.panel.note.model.Type> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Type, java.util.Date> createAt = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Type, java.util.Date>(this, "createAt", "createAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Type> description = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Type>(this, "description", "description");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Type, java.lang.Boolean> enable = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Type, java.lang.Boolean>(this, "enable", "enable", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Type, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Type, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Type, java.lang.Integer> maxItem = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Type, java.lang.Integer>(this, "maxItem", "maxItem", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Type, java.lang.Integer> minItem = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Type, java.lang.Integer>(this, "minItem", "minItem", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Type> name = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Type>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Type, java.util.Date> updateAt = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Type, java.util.Date>(this, "updateAt", "updateAt", java.util.Date.class);

    private static final TypeMeta slim3_singleton = new TypeMeta();

    /**
     * @return the singleton
     */
    public static TypeMeta get() {
       return slim3_singleton;
    }

    /** */
    public TypeMeta() {
        super("Type", com.panel.note.model.Type.class);
    }

    @Override
    public com.panel.note.model.Type entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.panel.note.model.Type model = new com.panel.note.model.Type();
        model.setCreateAt((java.util.Date) entity.getProperty("createAt"));
        model.setDescription((java.lang.String) entity.getProperty("description"));
        model.setEnable(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("enable")));
        model.setKey(entity.getKey());
        model.setMaxItem(longToPrimitiveInt((java.lang.Long) entity.getProperty("maxItem")));
        model.setMinItem(longToPrimitiveInt((java.lang.Long) entity.getProperty("minItem")));
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setUpdateAt((java.util.Date) entity.getProperty("updateAt"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.panel.note.model.Type m = (com.panel.note.model.Type) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("createAt", m.getCreateAt());
        entity.setProperty("description", m.getDescription());
        entity.setProperty("enable", m.isEnable());
        entity.setProperty("maxItem", m.getMaxItem());
        entity.setProperty("minItem", m.getMinItem());
        entity.setProperty("name", m.getName());
        entity.setProperty("updateAt", m.getUpdateAt());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.panel.note.model.Type m = (com.panel.note.model.Type) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.panel.note.model.Type m = (com.panel.note.model.Type) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(com.panel.note.model.Type) is not defined.");
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
        com.panel.note.model.Type m = (com.panel.note.model.Type) model;
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
        writer.setNextPropertyName("enable");
        encoder0.encode(writer, m.isEnable());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("maxItem");
        encoder0.encode(writer, m.getMaxItem());
        writer.setNextPropertyName("minItem");
        encoder0.encode(writer, m.getMinItem());
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getUpdateAt() != null){
            writer.setNextPropertyName("updateAt");
            encoder0.encode(writer, m.getUpdateAt());
        }
        writer.endObject();
    }

    @Override
    protected com.panel.note.model.Type jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.panel.note.model.Type m = new com.panel.note.model.Type();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("createAt");
        m.setCreateAt(decoder0.decode(reader, m.getCreateAt()));
        reader = rootReader.newObjectReader("description");
        m.setDescription(decoder0.decode(reader, m.getDescription()));
        reader = rootReader.newObjectReader("enable");
        m.setEnable(decoder0.decode(reader, m.isEnable()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("maxItem");
        m.setMaxItem(decoder0.decode(reader, m.getMaxItem()));
        reader = rootReader.newObjectReader("minItem");
        m.setMinItem(decoder0.decode(reader, m.getMinItem()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("updateAt");
        m.setUpdateAt(decoder0.decode(reader, m.getUpdateAt()));
        return m;
    }
}