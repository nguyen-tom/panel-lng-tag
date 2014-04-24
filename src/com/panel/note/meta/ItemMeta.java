package com.panel.note.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2014-04-23 15:47:40")
/** */
public final class ItemMeta extends org.slim3.datastore.ModelMeta<com.panel.note.model.Item> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Item> content = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Item>(this, "content", "content");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Item> countLike = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Item>(this, "countLike", "countLike");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Item, java.util.Date> createAt = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Item, java.util.Date>(this, "createAt", "createAt", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Item> description = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Item>(this, "description", "description");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Item, org.slim3.datastore.ModelRef<com.panel.note.model.Detail>, com.panel.note.model.Detail> detailRef = new org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Item, org.slim3.datastore.ModelRef<com.panel.note.model.Detail>, com.panel.note.model.Detail>(this, "detailRef", "detailRef", org.slim3.datastore.ModelRef.class, com.panel.note.model.Detail.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Item, java.lang.Boolean> enable = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Item, java.lang.Boolean>(this, "enable", "enable", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Item, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Item, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Item, org.slim3.datastore.ModelRef<com.panel.note.model.Language>, com.panel.note.model.Language> langRef = new org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Item, org.slim3.datastore.ModelRef<com.panel.note.model.Language>, com.panel.note.model.Language>(this, "langRef", "langRef", org.slim3.datastore.ModelRef.class, com.panel.note.model.Language.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Item> note = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Item>(this, "note", "note");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Item, org.slim3.datastore.ModelRef<com.panel.note.model.Note>, com.panel.note.model.Note> noteRef = new org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Item, org.slim3.datastore.ModelRef<com.panel.note.model.Note>, com.panel.note.model.Note>(this, "noteRef", "noteRef", org.slim3.datastore.ModelRef.class, com.panel.note.model.Note.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Item, java.util.Date> updateAt = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Item, java.util.Date>(this, "updateAt", "updateAt", java.util.Date.class);

    private static final ItemMeta slim3_singleton = new ItemMeta();

    /**
     * @return the singleton
     */
    public static ItemMeta get() {
       return slim3_singleton;
    }

    /** */
    public ItemMeta() {
        super("Item", com.panel.note.model.Item.class);
    }

    @Override
    public com.panel.note.model.Item entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.panel.note.model.Item model = new com.panel.note.model.Item();
        model.setContent((java.lang.String) entity.getProperty("content"));
        model.setCountLike((java.lang.String) entity.getProperty("countLike"));
        model.setCreateAt((java.util.Date) entity.getProperty("createAt"));
        model.setDescription((java.lang.String) entity.getProperty("description"));
        if (model.getDetailRef() == null) {
            throw new NullPointerException("The property(detailRef) is null.");
        }
        model.getDetailRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("detailRef"));
        model.setEnable(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("enable")));
        model.setKey(entity.getKey());
        if (model.getLangRef() == null) {
            throw new NullPointerException("The property(langRef) is null.");
        }
        model.getLangRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("langRef"));
        model.setNote((java.lang.String) entity.getProperty("note"));
        if (model.getNoteRef() == null) {
            throw new NullPointerException("The property(noteRef) is null.");
        }
        model.getNoteRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("noteRef"));
        model.setUpdateAt((java.util.Date) entity.getProperty("updateAt"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.panel.note.model.Item m = (com.panel.note.model.Item) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("content", m.getContent());
        entity.setProperty("countLike", m.getCountLike());
        entity.setProperty("createAt", m.getCreateAt());
        entity.setProperty("description", m.getDescription());
        if (m.getDetailRef() == null) {
            throw new NullPointerException("The property(detailRef) must not be null.");
        }
        entity.setProperty("detailRef", m.getDetailRef().getKey());
        entity.setProperty("enable", m.isEnable());
        if (m.getLangRef() == null) {
            throw new NullPointerException("The property(langRef) must not be null.");
        }
        entity.setProperty("langRef", m.getLangRef().getKey());
        entity.setProperty("note", m.getNote());
        if (m.getNoteRef() == null) {
            throw new NullPointerException("The property(noteRef) must not be null.");
        }
        entity.setProperty("noteRef", m.getNoteRef().getKey());
        entity.setProperty("updateAt", m.getUpdateAt());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.panel.note.model.Item m = (com.panel.note.model.Item) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.panel.note.model.Item m = (com.panel.note.model.Item) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(com.panel.note.model.Item) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.panel.note.model.Item m = (com.panel.note.model.Item) model;
        if (m.getDetailRef() == null) {
            throw new NullPointerException("The property(detailRef) must not be null.");
        }
        m.getDetailRef().assignKeyIfNecessary(ds);
        if (m.getLangRef() == null) {
            throw new NullPointerException("The property(langRef) must not be null.");
        }
        m.getLangRef().assignKeyIfNecessary(ds);
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
        com.panel.note.model.Item m = (com.panel.note.model.Item) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getContent() != null){
            writer.setNextPropertyName("content");
            encoder0.encode(writer, m.getContent());
        }
        if(m.getCountLike() != null){
            writer.setNextPropertyName("countLike");
            encoder0.encode(writer, m.getCountLike());
        }
        if(m.getCreateAt() != null){
            writer.setNextPropertyName("createAt");
            encoder0.encode(writer, m.getCreateAt());
        }
        if(m.getDescription() != null){
            writer.setNextPropertyName("description");
            encoder0.encode(writer, m.getDescription());
        }
        if(m.getDetailRef() != null && m.getDetailRef().getKey() != null){
            writer.setNextPropertyName("detailRef");
            encoder0.encode(writer, m.getDetailRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("enable");
        encoder0.encode(writer, m.isEnable());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getLangRef() != null && m.getLangRef().getKey() != null){
            writer.setNextPropertyName("langRef");
            encoder0.encode(writer, m.getLangRef(), maxDepth, currentDepth);
        }
        if(m.getNote() != null){
            writer.setNextPropertyName("note");
            encoder0.encode(writer, m.getNote());
        }
        if(m.getNoteRef() != null && m.getNoteRef().getKey() != null){
            writer.setNextPropertyName("noteRef");
            encoder0.encode(writer, m.getNoteRef(), maxDepth, currentDepth);
        }
        if(m.getUpdateAt() != null){
            writer.setNextPropertyName("updateAt");
            encoder0.encode(writer, m.getUpdateAt());
        }
        writer.endObject();
    }

    @Override
    protected com.panel.note.model.Item jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.panel.note.model.Item m = new com.panel.note.model.Item();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("content");
        m.setContent(decoder0.decode(reader, m.getContent()));
        reader = rootReader.newObjectReader("countLike");
        m.setCountLike(decoder0.decode(reader, m.getCountLike()));
        reader = rootReader.newObjectReader("createAt");
        m.setCreateAt(decoder0.decode(reader, m.getCreateAt()));
        reader = rootReader.newObjectReader("description");
        m.setDescription(decoder0.decode(reader, m.getDescription()));
        reader = rootReader.newObjectReader("detailRef");
        decoder0.decode(reader, m.getDetailRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("enable");
        m.setEnable(decoder0.decode(reader, m.isEnable()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("langRef");
        decoder0.decode(reader, m.getLangRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("note");
        m.setNote(decoder0.decode(reader, m.getNote()));
        reader = rootReader.newObjectReader("noteRef");
        decoder0.decode(reader, m.getNoteRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("updateAt");
        m.setUpdateAt(decoder0.decode(reader, m.getUpdateAt()));
        return m;
    }
}