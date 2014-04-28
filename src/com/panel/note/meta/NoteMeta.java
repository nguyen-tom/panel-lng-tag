package com.panel.note.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2014-04-25 14:28:13")
/** */
public final class NoteMeta extends org.slim3.datastore.ModelMeta<com.panel.note.model.Note> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.util.Date> createAt = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.util.Date>(this, "createAt", "createAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.lang.Boolean> enable = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.lang.Boolean>(this, "enable", "enable", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.util.Date> endAt = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.util.Date>(this, "endAt", "endAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Note> key_encode = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Note>(this, "key_encode", "key_encode");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.lang.Long> lat = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.lang.Long>(this, "lat", "lat", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.lang.Long> lng = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.lang.Long>(this, "lng", "lng", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.util.Date> startAt = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.util.Date>(this, "startAt", "startAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Note, org.slim3.datastore.ModelRef<com.panel.note.model.Type>, com.panel.note.model.Type> typeRef = new org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Note, org.slim3.datastore.ModelRef<com.panel.note.model.Type>, com.panel.note.model.Type>(this, "typeRef", "typeRef", org.slim3.datastore.ModelRef.class, com.panel.note.model.Type.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.util.Date> updateAt = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.util.Date>(this, "updateAt", "updateAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Note, org.slim3.datastore.ModelRef<com.panel.note.model.User>, com.panel.note.model.User> userRef = new org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Note, org.slim3.datastore.ModelRef<com.panel.note.model.User>, com.panel.note.model.User>(this, "userRef", "userRef", org.slim3.datastore.ModelRef.class, com.panel.note.model.User.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Note, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final NoteMeta slim3_singleton = new NoteMeta();

    /**
     * @return the singleton
     */
    public static NoteMeta get() {
       return slim3_singleton;
    }

    /** */
    public NoteMeta() {
        super("Note", com.panel.note.model.Note.class);
    }

    @Override
    public com.panel.note.model.Note entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.panel.note.model.Note model = new com.panel.note.model.Note();
        model.setCreateAt((java.util.Date) entity.getProperty("createAt"));
        model.setEnable(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("enable")));
        model.setEndAt((java.util.Date) entity.getProperty("endAt"));
        model.setKey(entity.getKey());
        model.setKey_encode((java.lang.String) entity.getProperty("key_encode"));
        model.setLat(longToPrimitiveLong((java.lang.Long) entity.getProperty("lat")));
        model.setLng(longToPrimitiveLong((java.lang.Long) entity.getProperty("lng")));
        model.setStartAt((java.util.Date) entity.getProperty("startAt"));
        if (model.getTypeRef() == null) {
            throw new NullPointerException("The property(typeRef) is null.");
        }
        model.getTypeRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("typeRef"));
        model.setUpdateAt((java.util.Date) entity.getProperty("updateAt"));
        if (model.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) is null.");
        }
        model.getUserRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("userRef"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.panel.note.model.Note m = (com.panel.note.model.Note) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("createAt", m.getCreateAt());
        entity.setProperty("enable", m.isEnable());
        entity.setProperty("endAt", m.getEndAt());
        entity.setProperty("key_encode", m.getKey_encode());
        entity.setProperty("lat", m.getLat());
        entity.setProperty("lng", m.getLng());
        entity.setProperty("startAt", m.getStartAt());
        if (m.getTypeRef() == null) {
            throw new NullPointerException("The property(typeRef) must not be null.");
        }
        entity.setProperty("typeRef", m.getTypeRef().getKey());
        entity.setProperty("updateAt", m.getUpdateAt());
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        entity.setProperty("userRef", m.getUserRef().getKey());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.panel.note.model.Note m = (com.panel.note.model.Note) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.panel.note.model.Note m = (com.panel.note.model.Note) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.panel.note.model.Note m = (com.panel.note.model.Note) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.panel.note.model.Note m = (com.panel.note.model.Note) model;
        if (m.getTypeRef() == null) {
            throw new NullPointerException("The property(typeRef) must not be null.");
        }
        m.getTypeRef().assignKeyIfNecessary(ds);
        if (m.getUserRef() == null) {
            throw new NullPointerException("The property(userRef) must not be null.");
        }
        m.getUserRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.panel.note.model.Note m = (com.panel.note.model.Note) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
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
        com.panel.note.model.Note m = (com.panel.note.model.Note) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCreateAt() != null){
            writer.setNextPropertyName("createAt");
            encoder0.encode(writer, m.getCreateAt());
        }
        writer.setNextPropertyName("enable");
        encoder0.encode(writer, m.isEnable());
        if(m.getEndAt() != null){
            writer.setNextPropertyName("endAt");
            encoder0.encode(writer, m.getEndAt());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getKey_encode() != null){
            writer.setNextPropertyName("key_encode");
            encoder0.encode(writer, m.getKey_encode());
        }
        writer.setNextPropertyName("lat");
        encoder0.encode(writer, m.getLat());
        writer.setNextPropertyName("lng");
        encoder0.encode(writer, m.getLng());
        if(m.getStartAt() != null){
            writer.setNextPropertyName("startAt");
            encoder0.encode(writer, m.getStartAt());
        }
        if(m.getTypeRef() != null && m.getTypeRef().getKey() != null){
            writer.setNextPropertyName("typeRef");
            encoder0.encode(writer, m.getTypeRef(), maxDepth, currentDepth);
        }
        if(m.getUpdateAt() != null){
            writer.setNextPropertyName("updateAt");
            encoder0.encode(writer, m.getUpdateAt());
        }
        if(m.getUserRef() != null && m.getUserRef().getKey() != null){
            writer.setNextPropertyName("userRef");
            encoder0.encode(writer, m.getUserRef(), maxDepth, currentDepth);
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.panel.note.model.Note jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.panel.note.model.Note m = new com.panel.note.model.Note();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("createAt");
        m.setCreateAt(decoder0.decode(reader, m.getCreateAt()));
        reader = rootReader.newObjectReader("enable");
        m.setEnable(decoder0.decode(reader, m.isEnable()));
        reader = rootReader.newObjectReader("endAt");
        m.setEndAt(decoder0.decode(reader, m.getEndAt()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("key_encode");
        m.setKey_encode(decoder0.decode(reader, m.getKey_encode()));
        reader = rootReader.newObjectReader("lat");
        m.setLat(decoder0.decode(reader, m.getLat()));
        reader = rootReader.newObjectReader("lng");
        m.setLng(decoder0.decode(reader, m.getLng()));
        reader = rootReader.newObjectReader("startAt");
        m.setStartAt(decoder0.decode(reader, m.getStartAt()));
        reader = rootReader.newObjectReader("typeRef");
        decoder0.decode(reader, m.getTypeRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("updateAt");
        m.setUpdateAt(decoder0.decode(reader, m.getUpdateAt()));
        reader = rootReader.newObjectReader("userRef");
        decoder0.decode(reader, m.getUserRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}