package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

import java.util.ArrayList;
import java.util.List;

public class NEUndyingLegion extends Eintrag {

    private final OptionsEinzelUpgrade pylon;
    private final List<RuestkammerStarter> Warriors = new ArrayList<>();

    public NEUndyingLegion() {
        name = "Undying Legion";
        grundkosten = 100;

        add(ico = new oc.Picture("oc/wh40k/images/UndyingLegion.gif"));

        add(pylon = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "NEPylonKammer", "Pylon", 420));

        seperator();

        for (int i = 0; i < 5; i++) {
            RuestkammerStarter starter = new RuestkammerStarter(ID, randAbstand, cnt, new NEWarriorsKammer(), "Warriors", 1);
            starter.setButtonText("Warriors");
            add(starter);
            Warriors.add(starter);
        }
        Warriors.get(4).setAktiv(false);

        complete();
    }

    @Override
    public void refreshen() {
        pylon.setSelected(true);

        adjustOptions();

        Warriors.get(0).setLegal(Warriors.get(0).isSelected());
        Warriors.get(1).setLegal(Warriors.get(1).isSelected());
        Warriors.get(2).setLegal(Warriors.get(2).isSelected());
        Warriors.get(3).setLegal(Warriors.get(3).isSelected());
        Warriors.get(4).setAktiv(Warriors.get(3).isSelected() && Warriors.get(2).isSelected() && Warriors.get(1).isSelected() && Warriors.get(0).isSelected());
        Warriors.get(0).setAktiv(true);
        Warriors.get(1).setAktiv(true);
        Warriors.get(2).setAktiv(true);
        Warriors.get(3).setAktiv(true);

        aktualisiereKammerStarterLocation();
    }

    //Entfernt aus dem Vektor alle überzähligen nicht ausgewählten Einträge.
    //Fügt einen neuen auswählbaren Eintrag hinter dem letzten der gleichen Einheit ein, falls alle ausgewählt wurden.
    //Könnte man evtl. in Eintrag übermehmen...
    private void adjustOptions() {
        for (int i = 0; i < Warriors.size() - 1 && Warriors.size() > (4 + 1); i++) {
            if (!Warriors.get(i).isSelected()) {
                remove(Warriors.get(i));
                Warriors.remove(i);
                i--;
            }
        }

        if (Warriors.get(Warriors.size() - 1).isSelected()) {
            RuestkammerStarter ruest = new RuestkammerStarter(ID, randAbstand, cnt, new NEWarriorsKammer(), "Warriors", 1);
            addAt(ruest, 1 + Warriors.size() - 1);
            ruest.setButtonText("Warriors");
            Warriors.add(ruest);
        }
    }
}