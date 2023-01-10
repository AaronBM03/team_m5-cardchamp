package es.teamm5.cardchamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.teamm5.cardchamp.model.Card;
import es.teamm5.cardchamp.model.Stats;

public class CreateCardActivity extends AppCompatActivity
{
    private static final int INC_FOR_SIMPLE_CLICK = 1;
    private static final int INC_FOR_LONG_CLICK = 10;
    private static final int MAX_CARD_STAT_VALUE = 99;
    private static final int MIN_CARD_STAT_VALUE = 0;
    private static final int POINTS_FOR_BRONZE_CARD = 270;
    private static final int POINTS_FOR_SILVER_CARD = 390;
    private static final int POINTS_FOR_GOLD_CARD = 450;
    private static final int POINTS_FOR_ICON_CARD = 520;

    int points; // TODO deberá cambiar dependiendo la carta seleccionada

    TextView txtPoints;
    TextView txtCardPac;
    TextView txtCardSho;
    TextView txtCardPas;
    TextView txtCardDri;
    TextView txtCardDef;
    TextView txtCardPhy;

    List<Button> btns;

    Button btnIncPac;
    Button btnIncSho;
    Button btnIncPas;
    Button btnIncDri;
    Button btnIncDef;
    Button btnIncPhy;

    Button btnDecPac;
    Button btnDecSho;
    Button btnDecPas;
    Button btnDecDri;
    Button btnDecDef;
    Button btnDecPhy;

    Button btnCreate;

    Card player;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);

        initializer();
        refreshLabels();
        listeners();
    }

    private void listeners()
    {
        btnCreate.setOnClickListener(view -> {
            player.setId(1); // TODO Discutir como deberíamos poner el id

            // TODO Añadir como parámetro al setName el getText del label que se tiene que crear aun
            // player.setName(txtName.getText());

            // TODO Discutir como añadir el nation_id and club_id
            // TODO Discutir como añadir el color and rarity

            // TODO Añadir como parámetro al setPosition el getText del label que se tiene que crear aun
            // player.setPosition(txtPos.getText());

            // TODO Discutir fórmula para poner rating (NO == QUE cardAvg)
            // player.setRating();

            // TODO Realizar insert en la base de datos
        });

        for (Button btn : btns)
        {
            btn.setOnClickListener(view ->
            {
                switch (view.getId())
                {
                    case R.id.btnIncPac:
                        incrementStat(Stats.PAC, INC_FOR_SIMPLE_CLICK);
                        break;

                    case R.id.btnIncSho:
                        incrementStat(Stats.SHO, INC_FOR_SIMPLE_CLICK);
                        break;

                    case R.id.btnIncPas:
                        incrementStat(Stats.PAS, INC_FOR_SIMPLE_CLICK);
                        break;

                    case R.id.btnIncDri:
                        incrementStat(Stats.DRI, INC_FOR_SIMPLE_CLICK);
                        break;

                    case R.id.btnIncDef:
                        incrementStat(Stats.DEF, INC_FOR_SIMPLE_CLICK);
                        break;

                    case R.id.btnIncPhy:
                        incrementStat(Stats.PHY, INC_FOR_SIMPLE_CLICK);
                        break;

                    case R.id.btnDecPac:
                        decreaseStat(Stats.PAC, INC_FOR_SIMPLE_CLICK);
                        break;

                    case R.id.btnDecSho:
                        decreaseStat(Stats.SHO, INC_FOR_SIMPLE_CLICK);
                        break;

                    case R.id.btnDecPas:
                        decreaseStat(Stats.PAS, INC_FOR_SIMPLE_CLICK);
                        break;

                    case R.id.btnDecDri:
                        decreaseStat(Stats.DRI, INC_FOR_SIMPLE_CLICK);
                        break;

                    case R.id.btnDecDef:
                        decreaseStat(Stats.DEF, INC_FOR_SIMPLE_CLICK);
                        break;

                    case R.id.btnDecPhy:
                        decreaseStat(Stats.PHY, INC_FOR_SIMPLE_CLICK);
                        break;
                }
            });

            btn.setOnLongClickListener(view ->
            {
                switch (view.getId())
                {
                    case R.id.btnIncPac:
                        incrementStat(Stats.PAC, INC_FOR_LONG_CLICK);
                        break;

                    case R.id.btnIncSho:
                        incrementStat(Stats.SHO, INC_FOR_LONG_CLICK);
                        break;

                    case R.id.btnIncPas:
                        incrementStat(Stats.PAS, INC_FOR_LONG_CLICK);
                        break;

                    case R.id.btnIncDri:
                        incrementStat(Stats.DRI, INC_FOR_LONG_CLICK);
                        break;

                    case R.id.btnIncDef:
                        incrementStat(Stats.DEF, INC_FOR_LONG_CLICK);
                        break;

                    case R.id.btnIncPhy:
                        incrementStat(Stats.PHY, INC_FOR_LONG_CLICK);
                        break;

                    case R.id.btnDecPac:
                        decreaseStat(Stats.PAC, INC_FOR_LONG_CLICK);
                        break;

                    case R.id.btnDecSho:
                        decreaseStat(Stats.SHO, INC_FOR_LONG_CLICK);
                        break;

                    case R.id.btnDecPas:
                        decreaseStat(Stats.PAS, INC_FOR_LONG_CLICK);
                        break;

                    case R.id.btnDecDri:
                        decreaseStat(Stats.DRI, INC_FOR_LONG_CLICK);
                        break;

                    case R.id.btnDecDef:
                        decreaseStat(Stats.DEF, INC_FOR_LONG_CLICK);
                        break;

                    case R.id.btnDecPhy:
                        decreaseStat(Stats.PHY, INC_FOR_LONG_CLICK);
                        break;
                }
                return true;
            });
        }
    }


    private void initializer()
    {
        txtPoints = findViewById(R.id.txtPoints);
        txtCardPac = findViewById(R.id.txtCardPac);
        txtCardSho = findViewById(R.id.txtCardSho);
        txtCardPas = findViewById(R.id.txtCardPas);
        txtCardDri = findViewById(R.id.txtCardDri);
        txtCardDef = findViewById(R.id.txtCardDef);
        txtCardPhy = findViewById(R.id.txtCardPhy);

        btnIncPac = findViewById(R.id.btnIncPac);
        btnIncSho = findViewById(R.id.btnIncSho);
        btnIncPas = findViewById(R.id.btnIncPas);
        btnIncDri = findViewById(R.id.btnIncDri);
        btnIncDef = findViewById(R.id.btnIncDef);
        btnIncPhy = findViewById(R.id.btnIncPhy);

        btnDecPac = findViewById(R.id.btnDecPac);
        btnDecSho = findViewById(R.id.btnDecSho);
        btnDecPas = findViewById(R.id.btnDecPas);
        btnDecDri = findViewById(R.id.btnDecDri);
        btnDecDef = findViewById(R.id.btnDecDef);
        btnDecPhy = findViewById(R.id.btnDecPhy);

        btnCreate = findViewById(R.id.btnCreate);

        player = new Card();

        btns = new ArrayList<>();
        btns.add(btnIncPac);
        btns.add(btnIncSho);
        btns.add(btnIncPas);
        btns.add(btnIncDri);
        btns.add(btnIncDef);
        btns.add(btnIncPhy);

        btns.add(btnDecPac);
        btns.add(btnDecSho);
        btns.add(btnDecPas);
        btns.add(btnDecDri);
        btns.add(btnDecDef);
        btns.add(btnDecPhy);

        points = POINTS_FOR_BRONZE_CARD;
    }

    private void refreshLabels()
    {
        txtPoints.setText(String.valueOf(points));
        txtCardPac.setText(String.valueOf(player.getPace()));
        txtCardSho.setText(String.valueOf(player.getShooting()));
        txtCardPas.setText(String.valueOf(player.getPassing()));
        txtCardDri.setText(String.valueOf(player.getDribbling()));
        txtCardDef.setText(String.valueOf(player.getDefending()));
        txtCardPhy.setText(String.valueOf(player.getPhysicality()));
    }

    private void refreshPoints(int amount, boolean isDec)
    {
        points = isDec ? points + amount : points - amount;
    }

    /**
     * Function to know if the stat can be incremented
     * @param stat 0 - PAC | 1 - SHO | 2 - PAS | 3 - DRI | 4 - DEF | 5 - PHY | 10 - GlobalPoints
     * @param amountIncremented the amount that is going to increment the stat
     * @return true if the stat can be incremented, false if not
     */
    private boolean canIncrement(Stats stat, int amountIncremented)
    {
        if(player.getStat(stat) + amountIncremented > CreateCardActivity.MAX_CARD_STAT_VALUE){
            Toast.makeText(CreateCardActivity.this, "Stats cannot value more than 99 points", Toast.LENGTH_SHORT).show();
            return false;
        } else if (points - amountIncremented < 0) {
            Toast.makeText(CreateCardActivity.this, "You don't have enough points", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * Function to know if the stat can be decreased
     * @param stat 0 - PAC | 1 - SHO | 2 - PAS | 3 - DRI | 4 - DEF | 5 - PHY | 10 - GlobalPoints
     * @param amountDecreas the amount that is going to decreas the stat
     * @return true if the stat can be decreased, false if not
     */
    private boolean canDecreas(Stats stat, int amountDecreas)
    {
        return player.getStat(stat) - amountDecreas >= CreateCardActivity.MIN_CARD_STAT_VALUE;
    }

    private void incrementStat(Stats stat, int amountIncremented)
    {
        if (canIncrement(stat, amountIncremented))
        {
            player.setStat(stat, player.getStat(stat) + amountIncremented);
            refreshPoints(amountIncremented, false);
        }
        refreshLabels();
    }

    private void decreaseStat(Stats stat, int amountDecreased)
    {
        if (canDecreas(stat, amountDecreased))
        {
            player.setStat(stat, player.getStat(stat) - amountDecreased);
            refreshPoints(amountDecreased, true);
        } else
        {
            Toast.makeText(CreateCardActivity.this, "Stats cannot value less than 0 points", Toast.LENGTH_SHORT).show();
        }

        refreshLabels();
    }
}