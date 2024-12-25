package cn.whiteWorld.trend;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import cn.hutool.core.util.NetUtil;
@SpringBootApplication
@EnableEurekaClient
public class ThirdPartIndexDataApplication {
    public static void main(String[] args) {
        int port = 8090;
        int eurekaPort = 8761;
        if(NetUtil.isUsableLocalPort(eurekaPort)){
            System.out.printf("the server isn't working at port", eurekaPort);
            System.exit(1);
        }
        if(args!=null && args.length>0){
            for (String arg : args) {
                if (arg.startsWith("port=")) {
                    port = Integer.parseInt(arg.split("=")[1]);
                }
            }
        }
        if(!NetUtil.isUsableLocalPort(port)){
            System.out.printf("the third part index data isn't working at port", port);
            System.exit(1);
        }
        new SpringApplicationBuilder(ThirdPartIndexDataApplication.class)
                .properties("server.port=" + port).run(args);
    }
}
