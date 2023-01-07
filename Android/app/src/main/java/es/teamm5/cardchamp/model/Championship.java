package es.teamm5.cardchamp.model;

import android.content.Context;

import es.teamm5.cardchamp.Queries;

import java.util.ArrayList;
import java.util.List;

public class Championship {
    private static final int TOTAL_MATCHES = 10;
    private String name;
    private Color color;
    private List<Match> matches;
    private int currentMatch;

    /**
     * @param name         Name of the championship
     * @param color        Color/rarity of the championship
     * @param matches      List of matches for the championship. If passed a null, it initializes an empty list
     * @param currentMatch Current match of the championship
     */
    public Championship(String name, Color color, List<Match> matches, int currentMatch) {
        super();
        this.name = name;
        this.color = color;
        this.matches = (matches != null) ? matches : new ArrayList<>();
        this.currentMatch = currentMatch;
    }


    public Championship() {

    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Color getColor() {
        return color;
    }


    public void setColor(Color color) {
        this.color = color;
    }


    public List<Match> getMatches() {
        return matches;
    }


    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }


    public int getCurrentMatch() {
        return currentMatch;
    }


    public void setCurrentMatch(int currentMatch) {
        this.currentMatch = currentMatch;
    }

    public void generateNewMatch(Context ctx, Card player) {
        Match match = new Match(player);
        match.setOpponent(Queries.searchOpponentCard(ctx, player.getCardAvg()));
        matches.add(currentMatch, match);
    }

    @Override
    public String toString() {
        return "Championship{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", matches=" + matches +
                ", currentMatch=" + currentMatch +
                '}';
    }
}
