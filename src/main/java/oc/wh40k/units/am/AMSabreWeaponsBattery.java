package oc.wh40k.units.am;

import oc.*;

public class AMSabreWeaponsBattery extends RuestkammerVater {

    AnzahlPanel Buggies;
    OptionsZaehlerGruppe BuggiesFK;
    OptionsEinzelUpgrade crew;

    public AMSabreWeaponsBattery() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGHeavyWeaponsSquad.jpg"));


        seperator();

        Buggies = new AnzahlPanel(ID, randAbstand, cnt, "Sabre Gun Platform", "Sabre Gun Platforms", 1, 3, 30);
        add(Buggies);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL Heavy Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("2 TL Heavy Stubbers", 10));
        ogE.addElement(new OptionsGruppeEintrag("TL Autocannon", 10));
        ogE.addElement(new OptionsGruppeEintrag("TL Lascannon", 20));
        ogE.addElement(new OptionsGruppeEintrag("Defence searchlight", 0));
        add(BuggiesFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(crew = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Additional Crewman", 2, 1));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Defence Searchlight", 0));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        BuggiesFK.setMaxAnzahl(Buggies.getModelle());
        BuggiesFK.setLegal(BuggiesFK.getAnzahl() == BuggiesFK.getMaxAnzahl());
        crew.setModelle(BuggiesFK.getAnzahl());
    }

}
