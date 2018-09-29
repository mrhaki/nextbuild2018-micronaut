package nextbuild;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.Client;
import io.micronaut.retry.annotation.Retryable;
import io.reactivex.Single;

import java.util.List;

@Retryable(delay = "200ms")
@Client(id = "sample")
public interface SampleClient extends SampleOperations {

    @Get("/hello-reactive")
    @Override
    Single<String> hello();

    @Get("/conferences")
    @Override
    Single<List<Conference>> conferences();
}
