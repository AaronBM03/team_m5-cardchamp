package es.teamm5.cardchamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import es.teamm5.cardchamp.model.Card;
import es.teamm5.cardchamp.model.Championship;
import es.teamm5.cardchamp.model.Color;
import es.teamm5.cardchamp.model.Position;

public class MainActivity extends AppCompatActivity {

    Button btnNewGame;
    Button btnContGame;
    Button btnQuickMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializator();
        listeners();

        //crearBD();
        System.out.println("Empieza ****************");
//        System.out.println(recuperarClub(1));
        testQueries();
        System.out.println("Acaba ****************");
    }



    public static int DB_VERSION = 1;
    public static String DB_NAME = "cardchamp.db";


    public void testChampionship(){
        Card player = new Card(1, "Aaron", Color.BRONZE, 0, Position.GK, 60, 46, 46, 46, 46, 46, 46, 46, 7, 1);
        Championship championship = new Championship("Champions League", Color.BRONZE, null, 0);
        System.out.println(championship);
        championship.generateNewMatch(this, player);
        System.out.println(championship);
    }

    public void testQueries()
    {
        System.out.println(Queries.generateRandomPlayer(this));
    }

    public void crearBD()
    {
        SQLiteConnection db2 = new SQLiteConnection(this, DB_NAME, null, DB_VERSION);
        try {
            db2.createDataBase();
            db2.openDataBase();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void initializator()
    {
        btnNewGame = findViewById(R.id.btnNewGame);
        btnContGame = findViewById(R.id.btnContGame);
        btnQuickMatch = findViewById(R.id.btnQuickMatch);
    }

    private void listeners()
    {
        btnNewGame.setOnClickListener(view -> {
            // TODO CreateCardActivity
        });

        btnContGame.setOnClickListener(view -> {
            // TODO ContinueGameActivity
        });

        btnQuickMatch.setOnClickListener(view -> {
            // TODO MatchActivity
            Intent i = new Intent(MainActivity.this, MatchActivity.class);
            i.putExtra("quickMatch", true);
            startActivity(i);
        });
    }

    /*public Club recuperarClub(int id) {
        SQLiteDatabase db = getReadableDatabase();
        System.out.println(db.getMaximumSize());
        System.out.println(db.getPageSize());
        System.out.println(db.getPath());
        String[] valores_recuperar = {"id", "name"};
        Cursor c = db.query("club", valores_recuperar, "id=" + id,
                null, null, null, null, null);
        if(c != null) {
            c.moveToFirst();
        }
        Club clubs = new Club(c.getInt(0), c.getString(1));
        db.close();
        c.close();
        return clubs;
    }*/

    /*private SQLiteDatabase getReadableDatabase()
    {
        ConexionSQLite db2 = new ConexionSQLite(this, DB_NAME, null, DB_VERSION);
        db2.openDataBase();
        return db2.getReadableDatabase();
    }*/
}