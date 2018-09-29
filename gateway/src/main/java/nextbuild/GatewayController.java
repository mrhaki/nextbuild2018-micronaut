package nextbuild;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import java.util.List;
import java.util.stream.Collectors;

@Controller("/")
public class GatewayController {

    private final SampleOperations client;

    public GatewayController(final SampleOperations client) {
        this.client = client;
    }

    @Get("/hello")
    Single<String> helloNextBuild() {
        return client.hello();
    }

    @Get("/conferences")
    Single<List<String>> conferenceNames() {
        return client.conferences()
                     .map(conferences -> conferences.stream().map(c -> c.getName()).collect(Collectors.toList()));
    }
}
