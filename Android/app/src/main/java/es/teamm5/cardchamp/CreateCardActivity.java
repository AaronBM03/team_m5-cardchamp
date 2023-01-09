package es.teamm5.cardchamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.teamm5.cardchamp.model.Card;

public class CreateCardActivity extends AppCompatActivity
{
    private static final int INC_FOR_SIMPLE_CLICK = 1;
    private static final int INC_FOR_LONG_CLICK = 10;

    int points = 200; // TODO deberá cambiar dependiendo la carta seleccionada

    TextView txtPoints;
    TextView txtCardPac;
    TextView txtCardSho;
    TextView txtCardPas;
    TextView txtCardDri;
    TextView txtCardDef;
    TextView txtCardPhy;

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

    List<Button> btns;

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
                        player.setPace(player.getPace() + INC_FOR_SIMPLE_CLICK);
                        refreshPoints(INC_FOR_SIMPLE_CLICK, false);
                        break;

                    case R.id.btnIncSho:
                        player.setShooting(player.getShooting() + INC_FOR_SIMPLE_CLICK);
                        refreshPoints(INC_FOR_SIMPLE_CLICK, false);
                        break;

                    case R.id.btnIncPas:
                        player.setPassing(player.getPassing() + INC_FOR_SIMPLE_CLICK);
                        refreshPoints(INC_FOR_SIMPLE_CLICK, false);
                        break;

                    case R.id.btnIncDri:
                        player.setDribbling(player.getDribbling() + INC_FOR_SIMPLE_CLICK);
                        refreshPoints(INC_FOR_SIMPLE_CLICK, false);
                        break;

                    case R.id.btnIncDef:
                        player.setDefending(player.getDefending() + INC_FOR_SIMPLE_CLICK);
                        refreshPoints(INC_FOR_SIMPLE_CLICK, false);
                        break;

                    case R.id.btnIncPhy:
                        player.setPhysicality(player.getPhysicality() + INC_FOR_SIMPLE_CLICK);
                        refreshPoints(INC_FOR_SIMPLE_CLICK, false);
                        break;

                    case R.id.btnDecPac:
                        player.setPace(player.getPace() - INC_FOR_SIMPLE_CLICK);
                        refreshPoints(INC_FOR_SIMPLE_CLICK, true);;
                        break;

                    case R.id.btnDecSho:
                        player.setShooting(player.getShooting() - INC_FOR_SIMPLE_CLICK);
                        refreshPoints(INC_FOR_SIMPLE_CLICK, true);
                        break;

                    case R.id.btnDecPas:
                        player.setPassing(player.getPassing() - INC_FOR_SIMPLE_CLICK);
                        refreshPoints(INC_FOR_SIMPLE_CLICK, true);
                        break;

                    case R.id.btnDecDri:
                        player.setDribbling(player.getDribbling() - INC_FOR_SIMPLE_CLICK);
                        refreshPoints(INC_FOR_SIMPLE_CLICK, true);
                        break;

                    case R.id.btnDecDef:
                        player.setDefending(player.getDefending() - INC_FOR_SIMPLE_CLICK);
                        refreshPoints(INC_FOR_SIMPLE_CLICK, true);
                        break;

                    case R.id.btnDecPhy:
                        player.setPhysicality(player.getPhysicality() - INC_FOR_SIMPLE_CLICK);
                        refreshPoints(INC_FOR_SIMPLE_CLICK, true);
                        break;
                }
                refreshLabels();
            });

            btn.setOnLongClickListener(view ->
            {
                switch (view.getId())
                {
                    case R.id.btnIncPac:
                        player.setPace(player.getPace() + INC_FOR_LONG_CLICK);
                        refreshPoints(INC_FOR_LONG_CLICK, false);
                        break;

                    case R.id.btnIncSho:
                        player.setShooting(player.getShooting() + INC_FOR_LONG_CLICK);
                        refreshPoints(INC_FOR_LONG_CLICK, false);
                        break;

                    case R.id.btnIncPas:
                        player.setPassing(player.getPassing() + INC_FOR_LONG_CLICK);
                        refreshPoints(INC_FOR_LONG_CLICK, false);
                        break;

                    case R.id.btnIncDri:
                        player.setDribbling(player.getDribbling() + INC_FOR_LONG_CLICK);
                        refreshPoints(INC_FOR_LONG_CLICK, false);
                        break;

                    case R.id.btnIncDef:
                        player.setDefending(player.getDefending() + INC_FOR_LONG_CLICK);
                        refreshPoints(INC_FOR_LONG_CLICK, false);
                        break;

                    case R.id.btnIncPhy:
                        player.setPhysicality(player.getPhysicality() + INC_FOR_LONG_CLICK);
                        refreshPoints(INC_FOR_LONG_CLICK, false);
                        break;

                    case R.id.btnDecPac:
                        player.setPace(player.getPace() - INC_FOR_LONG_CLICK);
                        refreshPoints(INC_FOR_LONG_CLICK, true);
                        break;

                    case R.id.btnDecSho:
                        player.setShooting(player.getShooting() - INC_FOR_LONG_CLICK);
                        refreshPoints(INC_FOR_LONG_CLICK, true);
                        break;

                    case R.id.btnDecPas:
                        player.setPassing(player.getPassing() - INC_FOR_LONG_CLICK);
                        refreshPoints(INC_FOR_LONG_CLICK, true);
                        break;

                    case R.id.btnDecDri:
                        player.setDribbling(player.getDribbling() - INC_FOR_LONG_CLICK);
                        refreshPoints(INC_FOR_LONG_CLICK, true);
                        break;

                    case R.id.btnDecDef:
                        player.setDefending(player.getDefending() - INC_FOR_LONG_CLICK);
                        refreshPoints(INC_FOR_LONG_CLICK, true);
                        break;

                    case R.id.btnDecPhy:
                        player.setPhysicality(player.getPhysicality() - INC_FOR_LONG_CLICK);
                        refreshPoints(INC_FOR_LONG_CLICK, true);
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
        if (isDec)
        {
            points += amount;
        } else
        {
            points -= amount;
        }
    }
}