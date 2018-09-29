package nextbuild;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.reactivex.Single;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/")
public class HelloController {
    
    @Get(value = "/hello", produces = MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello NextBuild. " + Thread.currentThread().getName();
    }
    
    @Get(value="/hello-reactive", produces = MediaType.TEXT_PLAIN)
    public Single<String> helloReactive() {
        return Single.just("Hello NextBuild. " + Thread.currentThread().getName());
    }
    
    @Get("/hello-message")
    public Single<Message> helloMessage() {
        return Single.just(new Message("Hello NextBuild!"));
    }
    
}
