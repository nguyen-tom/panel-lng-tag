package com.panel.note.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2014-04-23 15:47:40")
/** */
public final class LanguageMeta extends org.slim3.datastore.ModelMeta<com.panel.note.model.Language> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Language, java.util.Date> createAt = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Language, java.util.Date>(this, "createAt", "createAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Language> currency = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Language>(this, "currency", "currency");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Language> description = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Language>(this, "description", "description");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Language, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Language, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Language> keyEncode = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Language>(this, "keyEncode", "keyEncode");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Language> name = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Language>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Language, java.util.Date> updateAt = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Language, java.util.Date>(this, "updateAt", "updateAt", java.util.Date.class);

    private static final LanguageMeta slim3_singleton = new LanguageMeta();

    /**
     * @return the singleton
     */
    public static LanguageMeta get() {
       return slim3_singleton;
    }

    /** */
    public LanguageMeta() {
        super("Language", com.panel.note.model.Language.class);
    }

    @Override
    public com.panel.note.model.Language entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.panel.note.model.Language model = new com.panel.note.model.Language();
        model.setCreateAt((java.util.Date) entity.getProperty("createAt"));
        model.setCurrency((java.lang.String) entity.getProperty("currency"));
        model.setDescription((java.lang.String) entity.getProperty("description"));
        model.setKey(entity.getKey());
        model.setKeyEncode((java.lang.String) entity.getProperty("keyEncode"));
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setUpdateAt((java.util.Date) entity.getProperty("updateAt"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.panel.note.model.Language m = (com.panel.note.model.Language) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("createAt", m.getCreateAt());
        entity.setProperty("currency", m.getCurrency());
        entity.setProperty("description", m.getDescription());
        entity.setProperty("keyEncode", m.getKeyEncode());
        entity.setProperty("name", m.getName());
        entity.setProperty("updateAt", m.getUpdateAt());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.panel.note.model.Language m = (com.panel.note.model.Language) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.panel.note.model.Language m = (com.panel.note.model.Language) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(com.panel.note.model.Language) is not defined.");
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
        com.panel.note.model.Language m = (com.panel.note.model.Language) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCreateAt() != null){
            writer.setNextPropertyName("createAt");
            encoder0.encode(writer, m.getCreateAt());
        }
        if(m.getCurrency() != null){
            writer.setNextPropertyName("currency");
            encoder0.encode(writer, m.getCurrency());
        }
        if(m.getDescription() != null){
            writer.setNextPropertyName("description");
            encoder0.encode(writer, m.getDescription());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getKeyEncode() != null){
            writer.setNextPropertyName("keyEncode");
            encoder0.encode(writer, m.getKeyEncode());
        }
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
    protected com.panel.note.model.Language jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.panel.note.model.Language m = new com.panel.note.model.Language();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("createAt");
        m.setCreateAt(decoder0.decode(reader, m.getCreateAt()));
        reader = rootReader.newObjectReader("currency");
        m.setCurrency(decoder0.decode(reader, m.getCurrency()));
        reader = rootReader.newObjectReader("description");
        m.setDescription(decoder0.decode(reader, m.getDescription()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("keyEncode");
        m.setKeyEncode(decoder0.decode(reader, m.getKeyEncode()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("updateAt");
        m.setUpdateAt(decoder0.decode(reader, m.getUpdateAt()));
        return m;
    }
}