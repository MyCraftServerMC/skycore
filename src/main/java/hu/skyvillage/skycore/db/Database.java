package hu.skyvillage.skycore.db;

import com.google.firebase.database.*;
import hu.skyvillage.skycore.paper.PaperCorePlugin;

public class Database {

    public String result;

    public String get(String path) {
        long start = System.currentTimeMillis();
        FirebaseDatabase.getInstance().getReference(path).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                result = (String) snapshot.getValue();
                System.out.println(result);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println(PaperCorePlugin.PREFIX + "Error!");
            }
        });
        System.out.println(PaperCorePlugin.PREFIX+"Getting Info. Time: " + (System.currentTimeMillis()-start));
        return result;
    }

    public void set(String path, String value) {
        long start = System.currentTimeMillis();
        FirebaseDatabase.getInstance().getReference(path).setValue((Object) value, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                System.out.println(PaperCorePlugin.PREFIX+"Refreshing Info. Time: " + (System.currentTimeMillis()-start));
            }
        });
    }
}
