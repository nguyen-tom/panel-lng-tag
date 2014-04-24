package com.panel.note.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2014-04-23 15:47:40")
/** */
public final class CompanyMeta extends org.slim3.datastore.ModelMeta<com.panel.note.model.Company> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Company> address = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Company>(this, "address", "address");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Company, java.util.Date> join = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Company, java.util.Date>(this, "join", "join", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Company, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Company, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Company> name = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Company>(this, "name", "name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Company> taxCode = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Company>(this, "taxCode", "taxCode");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Company, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Company, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Company> website = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Company>(this, "website", "website");

    private static final CompanyMeta slim3_singleton = new CompanyMeta();

    /**
     * @return the singleton
     */
    public static CompanyMeta get() {
       return slim3_singleton;
    }

    /** */
    public CompanyMeta() {
        super("Company", com.panel.note.model.Company.class);
    }

    @Override
    public com.panel.note.model.Company entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.panel.note.model.Company model = new com.panel.note.model.Company();
        model.setAddress((java.lang.String) entity.getProperty("address"));
        model.setJoin((java.util.Date) entity.getProperty("join"));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setTaxCode((java.lang.String) entity.getProperty("taxCode"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        model.setWebsite((java.lang.String) entity.getProperty("website"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.panel.note.model.Company m = (com.panel.note.model.Company) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("address", m.getAddress());
        entity.setProperty("join", m.getJoin());
        entity.setProperty("name", m.getName());
        entity.setProperty("taxCode", m.getTaxCode());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("website", m.getWebsite());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.panel.note.model.Company m = (com.panel.note.model.Company) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.panel.note.model.Company m = (com.panel.note.model.Company) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.panel.note.model.Company m = (com.panel.note.model.Company) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.panel.note.model.Company m = (com.panel.note.model.Company) model;
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
        com.panel.note.model.Company m = (com.panel.note.model.Company) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAddress() != null){
            writer.setNextPropertyName("address");
            encoder0.encode(writer, m.getAddress());
        }
        if(m.getJoin() != null){
            writer.setNextPropertyName("join");
            encoder0.encode(writer, m.getJoin());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getTaxCode() != null){
            writer.setNextPropertyName("taxCode");
            encoder0.encode(writer, m.getTaxCode());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        if(m.getWebsite() != null){
            writer.setNextPropertyName("website");
            encoder0.encode(writer, m.getWebsite());
        }
        writer.endObject();
    }

    @Override
    protected com.panel.note.model.Company jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.panel.note.model.Company m = new com.panel.note.model.Company();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("address");
        m.setAddress(decoder0.decode(reader, m.getAddress()));
        reader = rootReader.newObjectReader("join");
        m.setJoin(decoder0.decode(reader, m.getJoin()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("taxCode");
        m.setTaxCode(decoder0.decode(reader, m.getTaxCode()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        reader = rootReader.newObjectReader("website");
        m.setWebsite(decoder0.decode(reader, m.getWebsite()));
        return m;
    }
}