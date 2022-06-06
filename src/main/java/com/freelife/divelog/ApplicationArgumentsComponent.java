package com.freelife.divelog;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * show Argument가 있으면 Get show argument를 출력
 * Created by Kane on 2022/06/06.
 */
@Component
public class ApplicationArgumentsComponent {
    private boolean hasShowArgument;

    public ApplicationArgumentsComponent(ApplicationArguments appArguments) {
        this.hasShowArgument = appArguments.containsOption("show");
        if (this.hasShowArgument) {
            System.out.println("Get show argument.");
        }
    }
}
