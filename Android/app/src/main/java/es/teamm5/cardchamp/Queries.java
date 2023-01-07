package es.teamm5.cardchamp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Random;

import es.teamm5.cardchamp.model.Card;
import es.teamm5.cardchamp.model.Color;
import es.teamm5.cardchamp.model.Position;

public class Queries
{
    public static Card searchOpponentCard(Context ctx, int playerAvg) {
        SQLiteDatabase db = getReadableDatabase(ctx);

        String[] args = {String.valueOf(playerAvg)};
        Cursor c = db.rawQuery("SELECT * FROM Card WHERE cardAvg=?", args);
        if (c != null) {
            int count = c.getCount();
            c.moveToPosition(new Random().nextInt(count));
        }

        Card opponent = null;
        try {
            opponent = new Card(c.getInt(0),
                    c.getString(c.getColumnIndexOrThrow("name")),
                    Color.values()[c.getInt(c.getColumnIndexOrThrow("color"))],
                    c.getInt(c.getColumnIndexOrThrow("rarity")),
                    Position.values()[c.getInt(c.getColumnIndexOrThrow("position"))],
                    c.getInt(c.getColumnIndexOrThrow("cardAvg")),
                    c.getInt(c.getColumnIndexOrThrow("rating")),
                    c.getInt(c.getColumnIndexOrThrow("pace")),
                    c.getInt(c.getColumnIndexOrThrow("shooting")),
                    c.getInt(c.getColumnIndexOrThrow("passing")),
                    c.getInt(c.getColumnIndexOrThrow("dribbling")),
                    c.getInt(c.getColumnIndexOrThrow("defending")),
                    c.getInt(c.getColumnIndexOrThrow("physicality")),
                    c.getInt(c.getColumnIndexOrThrow("nation_id")),
                    c.getInt(c.getColumnIndexOrThrow("club_id"))
            );
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        db.close();
        c.close();
        return opponent;
    }

    public static Card generateRandomPlayer(Context ctx)
    {
        SQLiteDatabase db = getReadableDatabase(ctx);
        Cursor c = db.rawQuery("SELECT * FROM Card ORDER BY RANDOM() LIMIT 1", null);
        if (c != null) {
            c.moveToFirst();
        }

        Card randomPlayer = null;
        try {
            randomPlayer = new Card(c.getInt(0),
                    c.getString(c.getColumnIndexOrThrow("name")),
                    Color.values()[c.getInt(c.getColumnIndexOrThrow("color"))],
                    c.getInt(c.getColumnIndexOrThrow("rarity")),
                    Position.values()[c.getInt(c.getColumnIndexOrThrow("position"))],
                    c.getInt(c.getColumnIndexOrThrow("cardAvg")),
                    c.getInt(c.getColumnIndexOrThrow("rating")),
                    c.getInt(c.getColumnIndexOrThrow("pace")),
                    c.getInt(c.getColumnIndexOrThrow("shooting")),
                    c.getInt(c.getColumnIndexOrThrow("passing")),
                    c.getInt(c.getColumnIndexOrThrow("dribbling")),
                    c.getInt(c.getColumnIndexOrThrow("defending")),
                    c.getInt(c.getColumnIndexOrThrow("physicality")),
                    c.getInt(c.getColumnIndexOrThrow("nation_id")),
                    c.getInt(c.getColumnIndexOrThrow("club_id"))
            );
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        c.close();
        db.close();
        return randomPlayer;
    }

    private static SQLiteDatabase getReadableDatabase(Context ctx) {
        // TODO Cambiar el contexto
        ConexionSQLite db2 = new ConexionSQLite(ctx, MainActivity.DB_NAME, null, MainActivity.DB_VERSION);
        db2.openDataBase();
        return db2.getReadableDatabase();
    }
}
