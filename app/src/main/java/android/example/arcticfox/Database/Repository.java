package android.example.arcticfox.Database;


import android.app.Application;
import android.example.arcticfox.DAO.PartDAO;
import android.example.arcticfox.DAO.ProductDAO;
import android.example.arcticfox.Entity.Part;
import android.example.arcticfox.Entity.Product;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private PartDAO mPartDAO;
    private ProductDAO mProductDAO;
    private List<Product> mAllProducts;
    private List<Part> mAllParts;

    private static int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application){
        BicycleDatabaseBuilder db=BicycleDatabaseBuilder.getDatabase(application);
        mPartDAO = db.partDAO();
        mProductDAO = db.productDAO();
    }
    public List<Product>getAllProducts(){
        databaseExecutor.execute(()-> mAllProducts=mProductDAO.getAllProducts());

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllProducts;
    }
    public void insert(Product product){

        databaseExecutor.execute(()-> mProductDAO.insert(product));
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void delete(Product product){

        databaseExecutor.execute(()-> mProductDAO.delete(product));
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public List<Part>getAllParts(){
        databaseExecutor.execute(()-> mAllParts=mPartDAO.getAllParts());

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return mAllParts;
    }
    public void insert(Part part){

        databaseExecutor.execute(()-> mPartDAO.insert(part));
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void delete(Part part){

        databaseExecutor.execute(()-> mPartDAO.delete(part));
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
