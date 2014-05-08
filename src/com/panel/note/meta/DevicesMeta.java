package com.panel.note.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2014-05-06 08:27:02")
/** */
public final class DevicesMeta extends org.slim3.datastore.ModelMeta<com.panel.note.model.Devices> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Devices> UIUD = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Devices>(this, "UIUD", "UIUD");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Devices> header = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Devices>(this, "header", "header");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Devices, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Devices, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Devices, java.lang.Long> lat = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Devices, java.lang.Long>(this, "lat", "lat", long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Devices, java.lang.Long> lng = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Devices, java.lang.Long>(this, "lng", "lng", long.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Devices, org.slim3.datastore.ModelRef<com.panel.note.model.Note>, com.panel.note.model.Note> noteRef = new org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Devices, org.slim3.datastore.ModelRef<com.panel.note.model.Note>, com.panel.note.model.Note>(this, "noteRef", "noteRef", org.slim3.datastore.ModelRef.class, com.panel.note.model.Note.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Devices> platform = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Devices>(this, "platform", "platform");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Devices, java.util.Date> scanAt = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Devices, java.util.Date>(this, "scanAt", "scanAt", java.util.Date.class);

    private static final DevicesMeta slim3_singleton = new DevicesMeta();

    /**
     * @return the singleton
     */
    public static DevicesMeta get() {
       return slim3_singleton;
    }

    /** */
    public DevicesMeta() {
        super("Devices", com.panel.note.model.Devices.class);
    }

    @Override
    public com.panel.note.model.Devices entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.panel.note.model.Devices model = new com.panel.note.model.Devices();
        model.setUIUD((java.lang.String) entity.getProperty("UIUD"));
        model.setHeader((java.lang.String) entity.getProperty("header"));
        model.setKey(entity.getKey());
        model.setLat(longToPrimitiveLong((java.lang.Long) entity.getProperty("lat")));
        model.setLng(longToPrimitiveLong((java.lang.Long) entity.getProperty("lng")));
        if (model.getNoteRef() == null) {
            throw new NullPointerException("The property(noteRef) is null.");
        }
        model.getNoteRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("noteRef"));
        model.setPlatform((java.lang.String) entity.getProperty("platform"));
        model.setScanAt((java.util.Date) entity.getProperty("scanAt"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.panel.note.model.Devices m = (com.panel.note.model.Devices) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("UIUD", m.getUIUD());
        entity.setProperty("header", m.getHeader());
        entity.setProperty("lat", m.getLat());
        entity.setProperty("lng", m.getLng());
        if (m.getNoteRef() == null) {
            throw new NullPointerException("The property(noteRef) must not be null.");
        }
        entity.setProperty("noteRef", m.getNoteRef().getKey());
        entity.setProperty("platform", m.getPlatform());
        entity.setProperty("scanAt", m.getScanAt());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.panel.note.model.Devices m = (com.panel.note.model.Devices) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.panel.note.model.Devices m = (com.panel.note.model.Devices) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(com.panel.note.model.Devices) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.panel.note.model.Devices m = (com.panel.note.model.Devices) model;
        if (m.getNoteRef() == null) {
            throw new NullPointerException("The property(noteRef) must not be null.");
        }
        m.getNoteRef().assignKeyIfNecessary(ds);
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
        com.panel.note.model.Devices m = (com.panel.note.model.Devices) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getUIUD() != null){
            writer.setNextPropertyName("UIUD");
            encoder0.encode(writer, m.getUIUD());
        }
        if(m.getHeader() != null){
            writer.setNextPropertyName("header");
            encoder0.encode(writer, m.getHeader());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("lat");
        encoder0.encode(writer, m.getLat());
        writer.setNextPropertyName("lng");
        encoder0.encode(writer, m.getLng());
        if(m.getNoteRef() != null && m.getNoteRef().getKey() != null){
            writer.setNextPropertyName("noteRef");
            encoder0.encode(writer, m.getNoteRef(), maxDepth, currentDepth);
        }
        if(m.getPlatform() != null){
            writer.setNextPropertyName("platform");
            encoder0.encode(writer, m.getPlatform());
        }
        if(m.getScanAt() != null){
            writer.setNextPropertyName("scanAt");
            encoder0.encode(writer, m.getScanAt());
        }
        writer.endObject();
    }

    @Override
    protected com.panel.note.model.Devices jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.panel.note.model.Devices m = new com.panel.note.model.Devices();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("UIUD");
        m.setUIUD(decoder0.decode(reader, m.getUIUD()));
        reader = rootReader.newObjectReader("header");
        m.setHeader(decoder0.decode(reader, m.getHeader()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("lat");
        m.setLat(decoder0.decode(reader, m.getLat()));
        reader = rootReader.newObjectReader("lng");
        m.setLng(decoder0.decode(reader, m.getLng()));
        reader = rootReader.newObjectReader("noteRef");
        decoder0.decode(reader, m.getNoteRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("platform");
        m.setPlatform(decoder0.decode(reader, m.getPlatform()));
        reader = rootReader.newObjectReader("scanAt");
        m.setScanAt(decoder0.decode(reader, m.getScanAt()));
        return m;
    }
}