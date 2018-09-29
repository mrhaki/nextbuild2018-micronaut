package nextbuild;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("conferences.mongo")
public class ConferenceRepositoryConfiguration {
    private String database;
    private String collection;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(final String database) {
        this.database = database;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(final String collection) {
        this.collection = collection;
    }
}
