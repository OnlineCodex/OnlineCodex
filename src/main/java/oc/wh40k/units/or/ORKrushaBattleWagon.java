package oc.wh40k.units.or;

import oc.*;

public class ORKrushaBattleWagon extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;


    public ORKrushaBattleWagon() {

        name = "\'Krusha\' Battle Wagon";
        grundkosten = 160;

        add(ico = new oc.Picture("oc/wh40k/images/KrushaBattleWagon.gif"));

        ogE.addElement(new OptionsGruppeEintrag("synchr. Fette Wumme", "synchronisierte Fette Wumme", 0));
        add(o2def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        ogE.addElement(new OptionsGruppeEintrag("synchr. Bazzukka", "synchronisierte Bazzukka", 0));
        ogE.addElement(new OptionsGruppeEintrag("synchr. Gitbrenna", "synchronisierter Gitbrenna", 0));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kanonä", 10));
        ogE.addElement(new OptionsGruppeEintrag("Schleuda", 15));
        ogE.addElement(new OptionsGruppeEintrag("Zzapwumme", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Fette Wumme", "synchronisierte Fette Wumme", 0));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zugetakkat", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rotä Farbä", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grothälfaz", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbombschlueda", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzaplattenz", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Entaplankä", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Abrizzbirnä", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Megagreifa", 5));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured Top", 10));

        complete();


    }

    //@OVERRIDE
    public void refreshen() {
        o2.setMaxAnzahl(o1.isSelected() ? 2 : 3);
        o2def.setMaxAnzahl(o1.isSelected() ? 2 : 3);
        o2def.setAnzahl(0, o2def.getMaxAnzahl() - o2.getAnzahl());
    }
}
