package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

import java.util.Vector;

public class TAXV104RiptideBattlesuits extends Eintrag {

    Vector<RuestkammerStarter> rk;
    OptionsZaehlerGruppe o5;

    public TAXV104RiptideBattlesuits() {
        name = "XV104 Riptide Battlesuits";
        überschriftSetzen = true;
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/KrisisKampfanzugteam.gif"));


        seperator();

        rk = new Vector<RuestkammerStarter>();
        for (int i = 0; i < 1; i++) {
            rk.add(new RuestkammerStarter(ID, randAbstand, cnt, TAXV104RiptideKammer.class, "Riptide Shas'vre"));
            rk.lastElement().initKammer(false, false, false, false, false, false, true);
            rk.lastElement().setGrundkosten(getPts("XV104 Riptide Battlesuit"));
            add(rk.lastElement());
        }

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MV84 Shielded Missile Drone", getPts("MV84 Shielded Missile Drone")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        complete();
    }

    @Override
    public void refreshen() {
        o5.getPanel().setLocation(
                (int) o5.getPanel().getLocation().getX(),
                (int) rk.get(0).getPanel().getLocation().getY() + rk.get(0).getPanel().getSize().height + 5
        );

        power = 14;
        if (o5.isSelected()) {
            power += 2;
        }
    }
}
