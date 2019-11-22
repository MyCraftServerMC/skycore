package hu.skyvillage.skycore;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import hu.skyvillage.skycore.db.Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SkyCore {
    public static void init() throws IOException {
        FileInputStream refreshToken = new FileInputStream("D:\\token.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(refreshToken))
                .setDatabaseUrl("https://sky1-village.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);

    }

    public SkyCore getInstance() {
        return this;
    }

    public static void main(String[] args) throws IOException {
        init();

        final String mod = new Database().get("users/asd/email");
        new Database().set("events/test/type","FALL_OUT");
        String sWhatever;

        Scanner scanIn = new Scanner(System.in);
        sWhatever = scanIn.nextLine();

        scanIn.close();

    }
}
