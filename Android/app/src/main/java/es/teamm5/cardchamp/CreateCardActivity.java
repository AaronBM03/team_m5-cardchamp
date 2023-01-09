package es.teamm5.cardchamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

    int points = 200; // TODO deberá cambiar dependiendo la carta seleccionada

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
                        if (canIncrement(0, MAX_CARD_STAT_VALUE, INC_FOR_SIMPLE_CLICK))
                        {
                            player.setPace(player.getPace() + INC_FOR_SIMPLE_CLICK);
                            refreshPoints(INC_FOR_SIMPLE_CLICK, false);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The pace stat cannot value more than 99 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnIncSho:
                        if (canIncrement(1, MAX_CARD_STAT_VALUE, INC_FOR_SIMPLE_CLICK))
                        {
                            player.setShooting(player.getShooting() + INC_FOR_SIMPLE_CLICK);
                            refreshPoints(INC_FOR_SIMPLE_CLICK, false);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The shooting stat cannot value more than 99 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnIncPas:
                        if (canIncrement(2, MAX_CARD_STAT_VALUE, INC_FOR_SIMPLE_CLICK))
                        {
                            player.setPassing(player.getPassing() + INC_FOR_SIMPLE_CLICK);
                            refreshPoints(INC_FOR_SIMPLE_CLICK, false);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The passing stat cannot value more than 99 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnIncDri:
                        if (canIncrement(3, MAX_CARD_STAT_VALUE, INC_FOR_SIMPLE_CLICK))
                        {
                            player.setDribbling(player.getDribbling() + INC_FOR_SIMPLE_CLICK);
                            refreshPoints(INC_FOR_SIMPLE_CLICK, false);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The dribbling stat cannot value more than 99 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnIncDef:
                        if (canIncrement(4, MAX_CARD_STAT_VALUE, INC_FOR_SIMPLE_CLICK))
                        {
                            player.setDefending(player.getDefending() + INC_FOR_SIMPLE_CLICK);
                            refreshPoints(INC_FOR_SIMPLE_CLICK, false);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The deffending stat cannot value more than 99 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnIncPhy:
                        if (canIncrement(5, MAX_CARD_STAT_VALUE, INC_FOR_SIMPLE_CLICK))
                        {
                            player.setPhysicality(player.getPhysicality() + INC_FOR_SIMPLE_CLICK);
                            refreshPoints(INC_FOR_SIMPLE_CLICK, false);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The physicality stat cannot value more than 99 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnDecPac:
                        if (canDecrement(0, MIN_CARD_STAT_VALUE, INC_FOR_SIMPLE_CLICK))
                        {
                            player.setPace(player.getPace() - INC_FOR_SIMPLE_CLICK);
                            refreshPoints(INC_FOR_SIMPLE_CLICK, true);;
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The pace stat cannot value less than 0 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnDecSho:
                        if (canDecrement(1, MIN_CARD_STAT_VALUE, INC_FOR_SIMPLE_CLICK))
                        {
                            player.setShooting(player.getShooting() - INC_FOR_SIMPLE_CLICK);
                            refreshPoints(INC_FOR_SIMPLE_CLICK, true);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The shooting stat cannot value less than 0 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnDecPas:
                        if (canDecrement(2, MIN_CARD_STAT_VALUE, INC_FOR_SIMPLE_CLICK))
                        {
                            player.setPassing(player.getPassing() - INC_FOR_SIMPLE_CLICK);
                            refreshPoints(INC_FOR_SIMPLE_CLICK, true);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The passing stat cannot value less than 0 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnDecDri:
                        if (canDecrement(3, MIN_CARD_STAT_VALUE, INC_FOR_SIMPLE_CLICK))
                        {
                            player.setDribbling(player.getDribbling() - INC_FOR_SIMPLE_CLICK);
                            refreshPoints(INC_FOR_SIMPLE_CLICK, true);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The dribbling stat cannot value less than 0 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnDecDef:
                        if (canDecrement(4, MIN_CARD_STAT_VALUE, INC_FOR_SIMPLE_CLICK))
                        {
                            player.setDefending(player.getDefending() - INC_FOR_SIMPLE_CLICK);
                            refreshPoints(INC_FOR_SIMPLE_CLICK, true);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The deffending stat cannot value less than 0 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnDecPhy:
                        if (canDecrement(5, MIN_CARD_STAT_VALUE, INC_FOR_SIMPLE_CLICK))
                        {
                            player.setPhysicality(player.getPhysicality() - INC_FOR_SIMPLE_CLICK);
                            refreshPoints(INC_FOR_SIMPLE_CLICK, true);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The physicality stat cannot value less than 0 points", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                refreshLabels();
            });

            btn.setOnLongClickListener(view ->
            {
                switch (view.getId())
                {
                    case R.id.btnIncPac:
                        if (canIncrement(0, MAX_CARD_STAT_VALUE, INC_FOR_LONG_CLICK))
                        {
                            player.setPace(player.getPace() + INC_FOR_LONG_CLICK);
                            refreshPoints(INC_FOR_LONG_CLICK, false);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The pace stat cannot value more than 99 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnIncSho:
                        if (canIncrement(1, MAX_CARD_STAT_VALUE, INC_FOR_LONG_CLICK))
                        {
                            player.setShooting(player.getShooting() + INC_FOR_LONG_CLICK);
                            refreshPoints(INC_FOR_LONG_CLICK, false);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The shooting stat cannot value more than 99 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnIncPas:
                        if (canIncrement(2, MAX_CARD_STAT_VALUE, INC_FOR_LONG_CLICK))
                        {
                            player.setPassing(player.getPassing() + INC_FOR_LONG_CLICK);
                            refreshPoints(INC_FOR_LONG_CLICK, false);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The passing stat cannot value more than 99 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnIncDri:
                        if (canIncrement(3, MAX_CARD_STAT_VALUE, INC_FOR_LONG_CLICK))
                        {
                            player.setDribbling(player.getDribbling() + INC_FOR_LONG_CLICK);
                            refreshPoints(INC_FOR_LONG_CLICK, false);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The dribbling stat cannot value more than 99 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnIncDef:
                        if (canIncrement(4, MAX_CARD_STAT_VALUE, INC_FOR_LONG_CLICK))
                        {
                            player.setDefending(player.getDefending() + INC_FOR_LONG_CLICK);
                            refreshPoints(INC_FOR_LONG_CLICK, false);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The deffending stat cannot value more than 99 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnIncPhy:
                        if (canIncrement(5, MAX_CARD_STAT_VALUE, INC_FOR_LONG_CLICK))
                        {
                            player.setPhysicality(player.getPhysicality() + INC_FOR_LONG_CLICK);
                            refreshPoints(INC_FOR_LONG_CLICK, false);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The physicality stat cannot value more than 99 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnDecPac:
                        if (canDecrement(0, MIN_CARD_STAT_VALUE, INC_FOR_LONG_CLICK))
                        {
                            player.setPace(player.getPace() - INC_FOR_LONG_CLICK);
                            refreshPoints(INC_FOR_LONG_CLICK, true);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The pace stat cannot value less than 0 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnDecSho:
                        if (canDecrement(1, MIN_CARD_STAT_VALUE, INC_FOR_LONG_CLICK))
                        {
                            player.setShooting(player.getShooting() - INC_FOR_LONG_CLICK);
                            refreshPoints(INC_FOR_LONG_CLICK, true);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The shooting stat cannot value less than 0 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnDecPas:
                        if (canDecrement(2, MIN_CARD_STAT_VALUE, INC_FOR_LONG_CLICK))
                        {
                            player.setPassing(player.getPassing() - INC_FOR_LONG_CLICK);
                            refreshPoints(INC_FOR_LONG_CLICK, true);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The passing stat cannot value less than 0 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnDecDri:
                        if (canDecrement(3, MIN_CARD_STAT_VALUE, INC_FOR_LONG_CLICK))
                        {
                            player.setDribbling(player.getDribbling() - INC_FOR_LONG_CLICK);
                            refreshPoints(INC_FOR_LONG_CLICK, true);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The dribbling stat cannot value less than 0 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnDecDef:
                        if (canDecrement(4, MIN_CARD_STAT_VALUE, INC_FOR_LONG_CLICK))
                        {
                            player.setDefending(player.getDefending() - INC_FOR_LONG_CLICK);
                            refreshPoints(INC_FOR_LONG_CLICK, true);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The deffending stat cannot value less than 0 points", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.btnDecPhy:
                        if (canDecrement(5, MIN_CARD_STAT_VALUE, INC_FOR_LONG_CLICK))
                        {
                            player.setPhysicality(player.getPhysicality() - INC_FOR_LONG_CLICK);
                            refreshPoints(INC_FOR_LONG_CLICK, true);
                        } else
                        {
                            Toast.makeText(CreateCardActivity.this, "The physicality stat cannot value less than 0 points", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                refreshLabels();
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
     * @param stat 0 - PAC | 1 - SHO | 2 - PAS | 3 - DRI | 4 - DEF | 5 - PHY
     * @param max maxValue that this stat can value
     * @param amountIncremented the amount that is going to increment the stat
     * @return true if the stat can be incremented, false if not
     */
    private boolean canIncrement(int stat, int max, int amountIncremented)
    {
        switch (stat)
        {
            case 0:
                return (player.getPace() + amountIncremented) <= max;

            case 1:
                return (player.getShooting() + amountIncremented) <= max;

            case 2:
                return (player.getPassing() + amountIncremented) <= max;

            case 3:
                return (player.getDribbling() + amountIncremented) <= max;

            case 4:
                return (player.getDefending() + amountIncremented) <= max;

            case 5:
                return (player.getPhysicality() + amountIncremented) <= max;

            default:
                return false;
        }
    }

    /**
     * Function to know if the stat can be decremented
     * @param stat 0 - PAC | 1 - SHO | 2 - PAS | 3 - DRI | 4 - DEF | 5 - PHY
     * @param min minValue that this stat can value
     * @param amountDecrement the amount that is going to decrement the stat
     * @return true if the stat can be decremented, false if not
     */
    private boolean canDecrement(int stat, int min, int amountDecrement)
    {
        switch (stat)
        {
            case 0:
                return (player.getPace() - amountDecrement) >= min;

            case 1:
                return (player.getShooting() - amountDecrement) >= min;

            case 2:
                return (player.getPassing() - amountDecrement) >= min;

            case 3:
                return (player.getDribbling() - amountDecrement) >= min;

            case 4:
                return (player.getDefending() - amountDecrement) >= min;

            case 5:
                return (player.getPhysicality() - amountDecrement) >= min;

            default:
                return false;
        }
    }
}