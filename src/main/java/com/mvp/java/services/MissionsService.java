package com.mvp.java.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MissionsService {
    
    private final String specsPath = "/specs/";

    public String getMissionInfo(String missionName) throws IOException {
        final StringBuilder fileContents = new StringBuilder(2000);
        final InputStream is = this.getClass().getResourceAsStream(specsPath + missionName);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContents.append(line).append("\n");
            }
        }
        return fileContents.toString();
    }
}
