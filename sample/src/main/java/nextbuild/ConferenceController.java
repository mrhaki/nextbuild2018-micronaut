package nextbuild;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.reactivex.Flowable;
import io.reactivex.Single;

import java.util.List;

@Secured("ROLE_ADMIN")
@Controller("/conferences")
public class ConferenceController {

    private final ConferenceRepository repository;

    public ConferenceController(final ConferenceRepository repository) {
        this.repository = repository;
    }

    @Get("/")
    Single<List<Conference>> conferences() {
        return Flowable.fromPublisher(repository.findAll()).toList();
    }
}
