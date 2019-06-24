package com.example.shoppingapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.shoppingapp.models.Cart;
import com.example.shoppingapp.models.Product;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "shopdb";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "cart";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PRODUCT_NAME = "name";
    public static final String COLUMN_PRODUCT_PRICE = "price";
    public static final String COLUMN_PRODUCT_IMAGE = "image";
    public static final String COLUMN_QUANTITY = "quantity";

    SQLiteDatabase database;

    Context context;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME + " ("+
                COLUMN_ID + " INTEGER primary key autoincrement," +
                COLUMN_PRODUCT_NAME + " VARCHAR, "+
                COLUMN_PRODUCT_PRICE + " INTEGER, "+
                COLUMN_PRODUCT_IMAGE + " VARCHAR, "+
                COLUMN_QUANTITY + " INTEGER )";
        try{
            db.execSQL(CREATE_QUERY);
        }catch (SQLException e){
            Log.e("db",e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_QUERY = "DROP TABLE "+TABLE_NAME;
        db.execSQL(DROP_QUERY);
        onCreate(db);
    }

    public boolean isProductAlreadyInCart(Product product){
        String query = "select * from "+ TABLE_NAME+" where  "+ COLUMN_ID + "=?";
        String[] args = new String[]{product.getName()};
        Cursor cursor = database.rawQuery(query,args );
        int count=  cursor.getCount();
        cursor.close();
        if(count ==0){
            // item does not exist
            return false;
        }else{
            return true;
        }
    }

    public void addToCart(Product product){
        if(isProductAlreadyInCart(product)){
            // increment the quantity
            // update statment and increase the quantity by 1
            ContentValues values = new ContentValues();
            //values.put(COLUMN_QUANTITY, );
        }else{
            ContentValues values = new ContentValues();
            values.put(COLUMN_PRODUCT_NAME, product.getName());
            values.put(COLUMN_PRODUCT_IMAGE, product.getImage());
            values.put(COLUMN_QUANTITY, 1);
            values.put(COLUMN_PRODUCT_PRICE, product.getPrice());

            database.insert(TABLE_NAME,null, values);
        }
    }

    public void updateCartQuantity(Cart cart){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_QUANTITY, cart.getQuantity());
        database.update(TABLE_NAME, contentValues, COLUMN_ID+ "=?", new String[]{String.valueOf(cart.getCartItemId())});
    }


    public boolean deleteFromCart(String productName){
        String whereClause = COLUMN_ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(productName)};
        return database.delete(TABLE_NAME, whereClause, whereArgs) > 0;
    }





    public ArrayList<Cart> getAllCart(){
        ArrayList<Cart> list = new ArrayList<>();
        String[] columns = {COLUMN_ID, COLUMN_PRODUCT_NAME, COLUMN_PRODUCT_IMAGE, COLUMN_PRODUCT_PRICE, COLUMN_QUANTITY};
        Cursor cursor = database.query(TABLE_NAME, columns, null, null, null, null, null);
        if(cursor !=null && cursor.moveToFirst()){
            do{
                Cart cart = new Cart();
                cart.setProductName(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_NAME)));
                cart.setProductImage(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCT_IMAGE)));
                list.add(cart);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }



}
