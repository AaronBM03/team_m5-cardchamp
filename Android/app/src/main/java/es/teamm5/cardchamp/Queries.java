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
    // *********************** QUERIES FROM TABLE <nation> ********************************************************************
    private static final String SELECT_NATION_NAME_BY_ID = " SELECT name FROM nation WHERE id = ?"; // Concat the id
    private static final String SELECT_NATION_ID_BY_NAME = " SELECT id FROM nation WHERE name = ?"; // Concat the name

    // *********************** QUERIES FROM TABLE <club> **********************************************************************
    private static final String SELECT_CLUB_NAME_BY_ID = " SELECT name FROM club WHERE id = ?"; // Concat the id
    private static final String SELECT_CLUB_ID_BY_NAME = " SELECT id FROM club WHERE name = ?"; // Concat the name

    // *********************** QUERIES FROM TABLE <match> *********************************************************************


    // *********************** QUERIES FROM TABLE <championship> **************************************************************


    // *********************** QUERIES FROM TABLE <card> **********************************************************************
    private static final String SELECT_NAME_BY_ID = " SELECT name FROM card WHERE id = ?"; // Concat the id
    private static final String SELECT_RARITY_BY_ID = " SELECT rarity FROM card WHERE id = ?"; // Concat the id
    private static final String SELECT_CARD_AVG_BY_ID = " SELECT cardAvg FROM card WHERE id = ?"; // Concat the id
    private static final String SELECT_RATING_BY_ID = " SELECT rating FROM card WHERE id = ?"; // Concat the id
    private static final String SELECT_PACE_BY_ID = " SELECT pace FROM card WHERE id = ?"; // Concat the id
    private static final String SELECT_SHOOTING_BY_ID = " SELECT shooting FROM card WHERE id = ?"; // Concat the id
    private static final String SELECT_PASSING_BY_ID = " SELECT passing FROM card WHERE id = ?"; // Concat the id
    private static final String SELECT_DRIBBLING_BY_ID = " SELECT dribbling FROM card WHERE id = ?"; // Concat the id
    private static final String SELECT_DEFENDING_BY_ID = " SELECT defending FROM card WHERE id = ?"; // Concat the id
    private static final String SELECT_PHYSICALITY_BY_ID = " SELECT physicality FROM card WHERE id = ?"; // Concat the id
    private static final String SELECT_COLOR_BY_ID = " SELECT color FROM card WHERE id = ?"; // Concat the id
    private static final String SELECT_POSITION_BY_ID = " SELECT position FROM card WHERE id = ?"; // Concat the id
    private static final String SELECT_ID_BY_NAME = " SELECT id FROM card WHERE name = ?"; // Concat the name
    private static final String SELECT_ALL_BY_CARD_AVG = " SELECT * FROM card WHERE cardAvg = ?"; // Concat the cardAvg
    private static final String SELECT_ALL_RANDOM = "SELECT * FROM Card ORDER BY RANDOM() LIMIT 1";

    public static Card searchOpponentCard(Context ctx, int playerAvg) {
        SQLiteDatabase db = getReadableDatabase(ctx);

        String[] args = {String.valueOf(playerAvg)};
        Cursor c = db.rawQuery(SELECT_ALL_BY_CARD_AVG, args);
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
            System.err.println("The selected Query has failed, please, review it.");
        }
        db.close();
        c.close();
        return opponent;
    }

    public static Card generateRandomPlayer(Context ctx)
    {
        SQLiteDatabase db = getReadableDatabase(ctx);
        Cursor c = db.rawQuery(SELECT_ALL_RANDOM, null);
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
            System.err.println("The selected Query has failed, please, review it.");
        }
        c.close();
        db.close();
        return randomPlayer;
    }

    private static SQLiteDatabase getReadableDatabase(Context ctx) {
        // TODO Cambiar el contexto
        SQLiteConnection db2 = new SQLiteConnection(ctx, MainActivity.DB_NAME, null, MainActivity.DB_VERSION);
        db2.openDataBase();
        return db2.getReadableDatabase();
    }
}
