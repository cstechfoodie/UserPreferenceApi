package io.swagger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import io.swagger.model.Client;
import io.swagger.repositories.ClientRepository;
import io.swagger.repositories.ClientRepositoryImpl;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "io.swagger", "io.swagger.api" })
public class Swagger2SpringBoot implements CommandLineRunner {
	
//	@Bean
//	org.springframework.data.redis.connection.jedis.JedisConnectionFactory jedisConnectionFactory() {
//	    return new org.springframework.data.redis.connection.jedis.JedisConnectionFactory();
//	}
//	 
//	@Bean
//	public RedisTemplate<String, Client> redisTemplate() {
//	    RedisTemplate<String, Client> template = new RedisTemplate<>();
//	    template.setConnectionFactory(jedisConnectionFactory());
//	    return template;
//	}
	

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
    	
        new SpringApplication(Swagger2SpringBoot.class).run(args);
        
//        Client a = new Client();
//        a.setUuid("2345");
//        a.setFirstName("1234first");
//        a.setLastName("1234last");    
//        ClientRepository r = new ClientRepositoryImpl(new RedisTemplate<String, Client>());
//        r.save(a);
//        String str = r.findOne("1234").toString();
//        System.out.print(str);
    
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
