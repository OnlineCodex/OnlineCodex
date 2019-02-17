package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORDethrollaBattleFortress extends Eintrag {

	private final OptionsZaehlerGruppe o1, o2;

    public ORDethrollaBattleFortress() {

        name = "\'Dethrolla\' Battle Fortress";
        grundkosten = 325;

        add(ico = new oc.Picture("oc/wh40k/images/DethrollaBattleFortress.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Kannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Lobba", 0));
        ogE.addElement(new OptionsGruppeEintrag("Zzap gun", 0));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("twin Rokkit Launcha", 0));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha", 0));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("bolt-on Big Shoota", 5));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armour plates", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boarding plank", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot riggers", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot bomm launcha", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red paint job", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Reinforced ram", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb chukkas", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deff rolla", 10));

        complete();


    }

    //@OVERRIDE
    public void refreshen() {
        o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
    }
}
