package es.teamm5.cardchamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import es.teamm5.cardchamp.model.Card;

public class CreateCardActivity extends AppCompatActivity
{
    int points = 0; // TODO deberá cambiar dependiendo la carta seleccionada

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

        listeners();
    }

    public void myOnClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnIncPac:
                player.setPace(player.getPace() + 1);
                points--;
                break;

            case R.id.btnIncSho:
                player.setShooting(player.getShooting() + 1);
                points--;
                break;

            case R.id.btnIncPas:
                player.setPassing(player.getPassing() + 1);
                points--;
                break;

            case R.id.btnIncDri:
                player.setDribbling(player.getDribbling() + 1);
                points--;
                break;

            case R.id.btnIncDef:
                player.setDefending(player.getDefending() + 1);
                points--;
                break;

            case R.id.btnIncPhy:
                player.setPhysicality(player.getPhysicality() + 1);
                points--;
                break;

            case R.id.btnDecPac:
                player.setPace(player.getPace() - 1);
                points++;
                break;

            case R.id.btnDecSho:
                player.setShooting(player.getShooting() - 1);
                points++;
                break;

            case R.id.btnDecPas:
                player.setPassing(player.getPassing() - 1);
                points++;
                break;

            case R.id.btnDecDri:
                player.setDribbling(player.getDribbling() - 1);
                points++;
                break;

            case R.id.btnDecDef:
                player.setDefending(player.getDefending() - 1);
                points++;
                break;

            case R.id.btnDecPhy:
                player.setPhysicality(player.getPhysicality() - 1);
                points++;
                break;
        }
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
    }

    private void initializer()
    {
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
    }
}