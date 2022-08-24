package android.example.arcticfox.Database;

import android.content.Context;
import android.example.arcticfox.DAO.PartDAO;
import android.example.arcticfox.DAO.ProductDAO;
import android.example.arcticfox.Entity.Part;
import android.example.arcticfox.Entity.Product;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class, Part.class}, version = 1, exportSchema = false)
public abstract class BicycleDatabaseBuilder extends RoomDatabase {
    public abstract ProductDAO productDAO();
    public abstract PartDAO partDAO();

    private static volatile BicycleDatabaseBuilder INSTANCE;

    static BicycleDatabaseBuilder getDatabase(final Context context){
        if (INSTANCE == null)
        synchronized (BicycleDatabaseBuilder.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BicycleDatabaseBuilder.class, "myBicycleDatabase.db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }


}
