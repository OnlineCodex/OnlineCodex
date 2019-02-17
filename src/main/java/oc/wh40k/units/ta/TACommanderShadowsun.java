package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TACommanderShadowsun extends Eintrag {

	private final OptionsZaehlerGruppe o1;
	private final OptionsEinzelUpgrade oe1;

    public TACommanderShadowsun() {
        name = "Commander Shadowsun";
        grundkosten = getPts("Commander Shadowsun");

        add(ico = new oc.Picture("oc/wh40k/images/OShaserra.gif"));

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "MV62 Command-link Drone", "MV62 Command-link Drone", getPts("MV62 Command-link Drone")));

        ogE.addElement(new OptionsGruppeEintrag("MV52 Shield Drone", "MV52 Shield Drone", getPts("MV52 Shield Drone")));
        add(o1 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));
        
        seperator();

        addWarlordTraits("Exemplar of the Kauyon", true);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        setUnikat(true);
        power = 9 + o1.getAnzahl();
        if (oe1.isSelected()) {
            power++;
        }

    }

}
