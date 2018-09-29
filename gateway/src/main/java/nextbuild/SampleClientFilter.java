package nextbuild;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.ClientFilterChain;
import io.micronaut.http.filter.HttpClientFilter;
import org.reactivestreams.Publisher;

@Filter("/conferences")
public class SampleClientFilter implements HttpClientFilter {
    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(final MutableHttpRequest<?> mutableHttpRequest, final ClientFilterChain clientFilterChain) {
        return clientFilterChain.proceed(mutableHttpRequest.basicAuth("admin", "admin"));
    }
}
