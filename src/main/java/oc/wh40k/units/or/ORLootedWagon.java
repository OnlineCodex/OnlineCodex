package oc.wh40k.units.or;


import oc.*;

public class ORLootedWagon extends Eintrag {


    OptionsUpgradeGruppe FK2;
    OptionsZaehlerGruppe BeutepanzaFK;
    OptionsUpgradeGruppe RammGruppe;

    public ORLootedWagon() {

        name = "Looted Wagon";
        grundkosten = 37;

        add(ico = new oc.Picture("oc/wh40k/images/Beutepanza.gif"));


        ogE.addElement(new OptionsGruppeEintrag("Panzakanonä", 30));
        add(FK2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Fette Wumme", 5));
        ogE.addElement(new OptionsGruppeEintrag("Bazzukka", 5));
        ogE.addElement(new OptionsGruppeEintrag("Gitbrenna", 5));
        add(BeutepanzaFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Todeswalzä", 10));
        ogE.addElement(new OptionsGruppeEintrag("Vastärktä Rammä", 5));
        add(RammGruppe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zugetakkat", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Megagreifa", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rote Farbä", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbombschlueda", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzlich Panzerung", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grothälfaz", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Abrizzbirnä", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Entaplankä", 15));

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
    }
}
