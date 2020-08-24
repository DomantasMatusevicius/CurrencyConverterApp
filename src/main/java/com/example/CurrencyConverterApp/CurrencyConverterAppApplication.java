package com.example.CurrencyConverterApp;

//import com.example.CurrencyConverterApp.data.ActiveUserStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CurrencyConverterAppApplication {

//    @Bean
//    public ActiveUserStore activeUserStore(){
//        return new ActiveUserStore();
//    }

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConverterAppApplication.class, args);
    }

}
