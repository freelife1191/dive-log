package com.freelife.divelog.web.diveresort;

import com.freelife.divelog.core.diveresort.application.DiveResortEditor;
import com.freelife.divelog.core.diveresort.application.DiveResortFinder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class DiveResortHandler {
    private final DiveResortFinder diveResortFinder;
    private final DiveResortEditor diveResortEditore;

    public DiveResortHandler(DiveResortFinder diveResortFinder, DiveResortEditor diveResortEditore) {
        this.diveResortFinder = diveResortFinder;
        this.diveResortEditore = diveResortEditore;
    }

    public ServerResponse findAll(ServerRequest request) {
        return ServerResponse.ok().body(diveResortFinder.findAll());
    }
}
