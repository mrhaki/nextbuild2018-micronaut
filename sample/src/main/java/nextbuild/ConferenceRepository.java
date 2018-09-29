package nextbuild;

import com.mongodb.client.model.Filters;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;

@Singleton
public class ConferenceRepository {

    private final MongoClient mongoClient;
    private final ConferenceRepositoryConfiguration configuration;

    public ConferenceRepository(
            final MongoClient mongoClient, 
            final ConferenceRepositoryConfiguration configuration) {
        
        this.mongoClient = mongoClient;
        this.configuration = configuration;
    }

    public Publisher<Conference> findAll() {
        return getCollection().find();
    }

    public Maybe<Conference> find(String name) {
        return Flowable.fromPublisher(
                getCollection()
                        .find(Filters.eq("name", name))
                        .limit(1)
        ).firstElement();
    }

    public Single<Conference> save(Conference conference) {
        return find(conference.getName())
                .switchIfEmpty(
                        Single.fromPublisher(getCollection().insertOne(conference))
                              .map(success -> conference)
                );
    }
    
    private MongoCollection<Conference> getCollection() {
        return mongoClient
                .getDatabase(configuration.getDatabase())
                .getCollection(configuration.getCollection(), Conference.class);
    }
}
