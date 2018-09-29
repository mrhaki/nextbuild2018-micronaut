package nextbuild;

import io.reactivex.Single;

import java.util.List;

public interface SampleOperations {

    Single<String> hello();

    Single<List<Conference>> conferences();
}
