package nextbuild;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceStartedEvent;
import io.reactivex.Flowable;

import javax.inject.Singleton;

@Singleton
public class ConferenceLoader implements ApplicationEventListener<ServiceStartedEvent> {
    
    private final ConferenceRepository repository;

    public ConferenceLoader(final ConferenceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(final ServiceStartedEvent serviceStartedEvent) {
        Flowable.just("NextBuild", "JFall", "JavaLand", "JFokus", "OracleCodeOne")
                .map(name -> new Conference(name))
                .flatMapSingle(repository::save)
                .subscribe(System.out::println);
    }
}
