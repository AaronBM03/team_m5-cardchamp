package es.teamm5.cardchamp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import es.teamm5.cardchamp.model.Card;
import es.teamm5.cardchamp.model.Match;
import es.teamm5.cardchamp.model.MatchStatus;

public class MatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        Intent i = getIntent();
        if (i.getBooleanExtra("quickMatch", true))
        {
            quickMatch();
        } else
        {
            // TODO Generariamos otro partido pero en concordancia con el torneo del que venga
        }

        // TODO Cerrar activity u otro Intent para volver
    }

    private void quickMatch()
    {
        Card player = Queries.generateRandomPlayer(this);
        Card opponent = Queries.searchOpponentCard(this, player.getCardAvg());

        Match quickMatch = new Match(player, opponent);

        System.out.println("*********** QUICK MATCH ***********");
        System.out.println("Player: " + player);
        System.out.println("Opponent: " + opponent);

        while (quickMatch.getStatus() == MatchStatus.NOT_FINISHED)
        {
            // TODO Listener unificado de todos los botones que tengamos en la Activity
            // quickMatch.resolveRound(TODO Añadir Stat del boton que se clicke);
        }
    }
}