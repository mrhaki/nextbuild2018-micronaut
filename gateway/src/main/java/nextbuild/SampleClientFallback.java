package nextbuild;

import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Single;

import java.util.Collections;
import java.util.List;

@Fallback
public class SampleClientFallback implements SampleOperations {
    @Override
    public Single<String> hello() {
        return Single.just("Hello NextBuild 2018!");
    }

    @Override
    public Single<List<Conference>> conferences() {
        return Single.just(Collections.emptyList());
    }
}
