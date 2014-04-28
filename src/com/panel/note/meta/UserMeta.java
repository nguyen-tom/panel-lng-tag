package com.panel.note.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2014-04-25 14:28:13")
/** */
public final class UserMeta extends org.slim3.datastore.ModelMeta<com.panel.note.model.User> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User> UIUD = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User>(this, "UIUD", "UIUD");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User> account = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User>(this, "account", "account");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User> address = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User>(this, "address", "address");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User> city = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User>(this, "city", "city");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.User, org.slim3.datastore.ModelRef<com.panel.note.model.Company>, com.panel.note.model.Company> companyRef = new org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.User, org.slim3.datastore.ModelRef<com.panel.note.model.Company>, com.panel.note.model.Company>(this, "companyRef", "companyRef", org.slim3.datastore.ModelRef.class, com.panel.note.model.Company.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User> email = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User>(this, "email", "email");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User> firstName = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User>(this, "firstName", "firstName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.User, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.User, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.User, org.slim3.datastore.ModelRef<com.panel.note.model.Language>, com.panel.note.model.Language> language = new org.slim3.datastore.ModelRefAttributeMeta<com.panel.note.model.User, org.slim3.datastore.ModelRef<com.panel.note.model.Language>, com.panel.note.model.Language>(this, "language", "language", org.slim3.datastore.ModelRef.class, com.panel.note.model.Language.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User> lastName = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User>(this, "lastName", "lastName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User> mobilePhone = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User>(this, "mobilePhone", "mobilePhone");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User> password = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User>(this, "password", "password");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.User, java.lang.Integer> permission = new org.slim3.datastore.CoreAttributeMeta<com.panel.note.model.User, java.lang.Integer>(this, "permission", "permission", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User> urlAvatar = new org.slim3.datastore.StringAttributeMeta<com.panel.note.model.User>(this, "urlAvatar", "urlAvatar");

    private static final UserMeta slim3_singleton = new UserMeta();

    /**
     * @return the singleton
     */
    public static UserMeta get() {
       return slim3_singleton;
    }

    /** */
    public UserMeta() {
        super("User", com.panel.note.model.User.class);
    }

    @Override
    public com.panel.note.model.User entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.panel.note.model.User model = new com.panel.note.model.User();
        model.setUIUD((java.lang.String) entity.getProperty("UIUD"));
        model.setAccount((java.lang.String) entity.getProperty("account"));
        model.setAddress((java.lang.String) entity.getProperty("address"));
        model.setCity((java.lang.String) entity.getProperty("city"));
        if (model.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) is null.");
        }
        model.getCompanyRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("companyRef"));
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setFirstName((java.lang.String) entity.getProperty("firstName"));
        model.setKey(entity.getKey());
        if (model.getLanguage() == null) {
            throw new NullPointerException("The property(language) is null.");
        }
        model.getLanguage().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("language"));
        model.setLastName((java.lang.String) entity.getProperty("lastName"));
        model.setMobilePhone((java.lang.String) entity.getProperty("mobilePhone"));
        model.setPassword((java.lang.String) entity.getProperty("password"));
        model.setPermission(longToPrimitiveInt((java.lang.Long) entity.getProperty("permission")));
        model.setUrlAvatar((java.lang.String) entity.getProperty("urlAvatar"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.panel.note.model.User m = (com.panel.note.model.User) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("UIUD", m.getUIUD());
        entity.setProperty("account", m.getAccount());
        entity.setProperty("address", m.getAddress());
        entity.setProperty("city", m.getCity());
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        entity.setProperty("companyRef", m.getCompanyRef().getKey());
        entity.setProperty("email", m.getEmail());
        entity.setProperty("firstName", m.getFirstName());
        if (m.getLanguage() == null) {
            throw new NullPointerException("The property(language) must not be null.");
        }
        entity.setProperty("language", m.getLanguage().getKey());
        entity.setProperty("lastName", m.getLastName());
        entity.setProperty("mobilePhone", m.getMobilePhone());
        entity.setProperty("password", m.getPassword());
        entity.setProperty("permission", m.getPermission());
        entity.setProperty("urlAvatar", m.getUrlAvatar());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.panel.note.model.User m = (com.panel.note.model.User) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.panel.note.model.User m = (com.panel.note.model.User) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(com.panel.note.model.User) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.panel.note.model.User m = (com.panel.note.model.User) model;
        if (m.getCompanyRef() == null) {
            throw new NullPointerException("The property(companyRef) must not be null.");
        }
        m.getCompanyRef().assignKeyIfNecessary(ds);
        if (m.getLanguage() == null) {
            throw new NullPointerException("The property(language) must not be null.");
        }
        m.getLanguage().assignKeyIfNecessary(ds);
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
        com.panel.note.model.User m = (com.panel.note.model.User) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getUIUD() != null){
            writer.setNextPropertyName("UIUD");
            encoder0.encode(writer, m.getUIUD());
        }
        if(m.getAccount() != null){
            writer.setNextPropertyName("account");
            encoder0.encode(writer, m.getAccount());
        }
        if(m.getAddress() != null){
            writer.setNextPropertyName("address");
            encoder0.encode(writer, m.getAddress());
        }
        if(m.getCity() != null){
            writer.setNextPropertyName("city");
            encoder0.encode(writer, m.getCity());
        }
        if(m.getCompanyRef() != null && m.getCompanyRef().getKey() != null){
            writer.setNextPropertyName("companyRef");
            encoder0.encode(writer, m.getCompanyRef(), maxDepth, currentDepth);
        }
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder0.encode(writer, m.getEmail());
        }
        if(m.getFirstName() != null){
            writer.setNextPropertyName("firstName");
            encoder0.encode(writer, m.getFirstName());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getLanguage() != null && m.getLanguage().getKey() != null){
            writer.setNextPropertyName("language");
            encoder0.encode(writer, m.getLanguage(), maxDepth, currentDepth);
        }
        if(m.getLastName() != null){
            writer.setNextPropertyName("lastName");
            encoder0.encode(writer, m.getLastName());
        }
        if(m.getMobilePhone() != null){
            writer.setNextPropertyName("mobilePhone");
            encoder0.encode(writer, m.getMobilePhone());
        }
        if(m.getPassword() != null){
            writer.setNextPropertyName("password");
            encoder0.encode(writer, m.getPassword());
        }
        writer.setNextPropertyName("permission");
        encoder0.encode(writer, m.getPermission());
        if(m.getUrlAvatar() != null){
            writer.setNextPropertyName("urlAvatar");
            encoder0.encode(writer, m.getUrlAvatar());
        }
        writer.endObject();
    }

    @Override
    protected com.panel.note.model.User jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.panel.note.model.User m = new com.panel.note.model.User();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("UIUD");
        m.setUIUD(decoder0.decode(reader, m.getUIUD()));
        reader = rootReader.newObjectReader("account");
        m.setAccount(decoder0.decode(reader, m.getAccount()));
        reader = rootReader.newObjectReader("address");
        m.setAddress(decoder0.decode(reader, m.getAddress()));
        reader = rootReader.newObjectReader("city");
        m.setCity(decoder0.decode(reader, m.getCity()));
        reader = rootReader.newObjectReader("companyRef");
        decoder0.decode(reader, m.getCompanyRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("email");
        m.setEmail(decoder0.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("firstName");
        m.setFirstName(decoder0.decode(reader, m.getFirstName()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("language");
        decoder0.decode(reader, m.getLanguage(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("lastName");
        m.setLastName(decoder0.decode(reader, m.getLastName()));
        reader = rootReader.newObjectReader("mobilePhone");
        m.setMobilePhone(decoder0.decode(reader, m.getMobilePhone()));
        reader = rootReader.newObjectReader("password");
        m.setPassword(decoder0.decode(reader, m.getPassword()));
        reader = rootReader.newObjectReader("permission");
        m.setPermission(decoder0.decode(reader, m.getPermission()));
        reader = rootReader.newObjectReader("urlAvatar");
        m.setUrlAvatar(decoder0.decode(reader, m.getUrlAvatar()));
        return m;
    }
}