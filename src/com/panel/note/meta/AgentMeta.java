package com.panel.note.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2014-05-06 08:27:02")
/** */
public final class AgentMeta extends org.slim3.datastore.ModelMeta<com.panel.note.model.Agent> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Agent, org.slim3.datastore.ModelRef<com.panel.note.model.Company>, com.panel.note.model.Company> companyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.Agent, org.slim3.datastore.ModelRef<com.panel.note.model.Company>, com.panel.note.model.Company>(this, "companyRef", "companyRef", org.slim3.datastore.ModelRef.class, com.panel.note.model.Company.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Agent> email = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Agent>(this, "email", "email");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Agent, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Agent, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Agent> level = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Agent>(this, "level", "level");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Agent> password = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.Agent>(this, "password", "password");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Agent, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.Agent, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final AgentMeta slim3_singleton = new AgentMeta();

    /**
     * @return the singleton
     */
    public static AgentMeta get() {
       return slim3_singleton;
    }

    /** */
    public AgentMeta() {
        super("Agent", com.panel.note.model.Agent.class);
    }

    @Override
    public com.panel.note.model.Agent entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.panel.note.model.Agent model = new com.panel.note.model.Agent();
        if (model.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) is null.");
        }
        model.getCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyRef"));
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setKey(entity.getKey());
        model.setLevel((java.lang.String) entity.getProperty("level"));
        model.setPassword((java.lang.String) entity.getProperty("password"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.panel.note.model.Agent m = (com.panel.note.model.Agent) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        entity.setProperty("companyRef", m.getCompanyRef().getKey());
        entity.setProperty("email", m.getEmail());
        entity.setProperty("level", m.getLevel());
        entity.setProperty("password", m.getPassword());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 2);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.panel.note.model.Agent m = (com.panel.note.model.Agent) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.panel.note.model.Agent m = (com.panel.note.model.Agent) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.panel.note.model.Agent m = (com.panel.note.model.Agent) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.panel.note.model.Agent m = (com.panel.note.model.Agent) model;
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        m.getCompanyRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.panel.note.model.Agent m = (com.panel.note.model.Agent) model;
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
        com.panel.note.model.Agent m = (com.panel.note.model.Agent) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCompanyRef() != null && m.getCompanyRef().getKey() != null){
            writer.setNextPropertyName("companyRef");
            encoder0.encode(writer, m.getCompanyRef(), maxDepth, currentDepth);
        }
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder0.encode(writer, m.getEmail());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getLevel() != null){
            writer.setNextPropertyName("level");
            encoder0.encode(writer, m.getLevel());
        }
        if(m.getPassword() != null){
            writer.setNextPropertyName("password");
            encoder0.encode(writer, m.getPassword());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.panel.note.model.Agent jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.panel.note.model.Agent m = new com.panel.note.model.Agent();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("companyRef");
        decoder0.decode(reader, m.getCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("email");
        m.setEmail(decoder0.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("level");
        m.setLevel(decoder0.decode(reader, m.getLevel()));
        reader = rootReader.newObjectReader("password");
        m.setPassword(decoder0.decode(reader, m.getPassword()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}