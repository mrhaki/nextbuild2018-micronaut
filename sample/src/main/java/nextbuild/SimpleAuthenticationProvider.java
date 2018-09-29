package nextbuild;

import io.micronaut.core.util.CollectionUtils;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;

@Singleton
public class SimpleAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Publisher<AuthenticationResponse> authenticate(final AuthenticationRequest authenticationRequest) {
        if (authenticationRequest.getIdentity().equals("admin") &&
                authenticationRequest.getSecret().equals("admin")) {
            return Flowable.just(new UserDetails("admin", CollectionUtils.setOf("ROLE_ADMIN")));
        } else {
            return Flowable.just(new AuthenticationFailed());
        }
    }
}
