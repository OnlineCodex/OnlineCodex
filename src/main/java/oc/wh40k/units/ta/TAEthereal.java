package oc.wh40k.units.ta;

import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.ETHEREAL;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.TAU_EMPIRE;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class TAEthereal extends Eintrag {

	private final OptionsZaehlerGruppe o1;
	private final OptionsEinzelUpgrade hd;

    public TAEthereal() {
    	super(TAU_EMPIRE, CHARACTER, INFANTRY, ETHEREAL);

        name = "Ethereal";
        grundkosten = getPts("Ethereal");

        add(ico = new oc.Picture("oc/wh40k/images/Himmlischer.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Honour blade", getPts("Honour blade")));
        ogE.addElement(new OptionsGruppeEintrag("Equalizers", "", getPts("Equalizers")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(hd = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hover Drone", getPts("Ethereal with Hover Drone") - getPts("Ethereal")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o1 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

        seperator();

        addWeapons(TAKampfanzugKammer.class, true);

        seperator();

		addWarlordTraits("", true);

        addToInformationVector("Ethereal", 1);

        complete();
    }

    @Override
    public void refreshen() {
        power = 2;
        if (o1.getAnzahl() > 0) {
            power++;
        }
        if (hd.isSelected()) {
            power++;
        }
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
}
