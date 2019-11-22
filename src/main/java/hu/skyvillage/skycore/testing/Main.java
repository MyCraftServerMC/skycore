package hu.skyvillage.skycore.testing;

import com.google.firebase.database.FirebaseDatabase;
import hu.skyvillage.skycore.SkyCore;

import java.io.IOException;

public class Main {
    private static volatile boolean done;
    public static void main(String[] args) throws IOException {
        new SkyCore().getInstance().init();
        //System.out.println(new Database().get("mode"));
        FirebaseDatabase.getInstance().getReference("mod").setValue((Object) "asd", (error, ref) -> {
            System.console().writer().println(ref.getKey());
            done = true;
        });
    }
}
