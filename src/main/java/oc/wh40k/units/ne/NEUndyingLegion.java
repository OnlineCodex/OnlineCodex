package oc.wh40k.units.ne;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

import java.util.Vector;

public class NEUndyingLegion extends Eintrag {


	private final OptionsEinzelUpgrade pylon;
    private final Vector<RuestkammerStarter> Warriors = new Vector<RuestkammerStarter>();//4+

    public NEUndyingLegion() {
        name = "Undying Legion";
        grundkosten = 100;

        add(ico = new oc.Picture("oc/wh40k/images/UndyingLegion.gif"));


        add(pylon = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "NEPylonKammer", "Pylon", 420));


        seperator();

        for (int i = 0; i < 5; i++) {
            Warriors.add(new RuestkammerStarter(ID, randAbstand, cnt, NEWarriorsKammer.class, "Warriors", 1));
            Warriors.get(i).initKammer();
            add(Warriors.get(i));
            Warriors.get(i).setButtonText("Warriors");
        }
        Warriors.get(4).setAktiv(false);

        complete();

    }

    public void refreshen() {
        pylon.setSelected(true);

        adjustOptions(Warriors, 4, NEWarriorsKammer.class, "Warriors", 1, 1);
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
    public void adjustOptions(Vector<RuestkammerStarter> starter, int minOptions, Class<NEWarriorsKammer> unit, String unitName, int offset, int einrueck) {


        for (int i = 0; i < starter.size() - 1 && starter.size() > (minOptions + 1); i++) {
            if (!starter.get(i).isSelected()) {
                remove(starter.get(i));
                starter.remove(i);
                i--;
            }
        }

        if (starter.lastElement().isSelected()) {
            RuestkammerStarter ruest = new RuestkammerStarter(ID, randAbstand, cnt, unit, unitName, einrueck);
            starter.add(ruest);
            ruest.initKammer();
            addAt(ruest, offset + starter.size() - 1);
            ruest.setButtonText(unitName);
        }

    }


}
