package oc.wh40k.units.ta;

import java.util.Vector;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

//[IA Experimental]

public class TAXV109YvahraBattlesuit extends Eintrag {

	private final Vector<RuestkammerStarter> rk;
	private final OptionsZaehlerGruppe o5;
	
	public TAXV109YvahraBattlesuit() {
        name = "XV109 Y'vahra Battlesuit";
        überschriftSetzen = true;
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/KrisisKampfanzugteam.gif"));

        seperator();

        rk = new Vector<RuestkammerStarter>();
        for (int i = 0; i < 1; i++) {
            rk.add(new RuestkammerStarter(ID, randAbstand, cnt, TAXV109YvahraKammer.class, "XV109 Y'vahra Battlesuit"));
            rk.lastElement().initKammer(false, false, false, false, false, false, true);
            rk.lastElement().setGrundkosten(getPts("XV109 Y'vahra Battlesuit"));
            add(rk.lastElement());
            rk.lastElement().setAbwaehlbar(false);
        }

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shielded missile drone", getPts("Shielded missile drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV52 shield drone", getPts("MV52 shield drone")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        complete();
    }

    @Override
    public void refreshen() {
        o5.getPanel().setLocation(
                (int) o5.getPanel().getLocation().getX(),
                (int) rk.get(0).getPanel().getLocation().getY() + rk.get(0).getPanel().getSize().height + 5
        );

        power = 20;
        if (o5.isSelected()) {
            power += 2;
        }
    }

}
