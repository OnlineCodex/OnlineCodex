package oc.wh40k.units.or;

import oc.*;

public class ORMeganobzKammer extends RuestkammerVater {

    private final AnzahlPanel Gargbosse;
    private final OptionsZaehlerGruppe GargbosseFK;
    private final RuestkammerStarter PikkUp;
    private final RuestkammerStarter Kampfpanza;
    private final OptionsEinzelZaehler Trophäenstange;

    public ORMeganobzKammer() {
        grundkosten = 0;
        name = "Meganobz";

        add(Gargbosse = new AnzahlPanel(ID, randAbstand, cnt, "Gargbosse", 3, 10, 40));

        add(ico = new oc.Picture("oc/wh40k/images/Gargbosse.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Killsaws", 10));
        ogE.addElement(new OptionsGruppeEintrag("Bazzukka-Kombi", "Bazzukka-Kombiwaffe", 5));
        ogE.addElement(new OptionsGruppeEintrag("Gitbrenna-Kombi", "Gitbrenna-Kombiwaffe", 5));
        add(GargbosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator(5);

        add(Trophäenstange = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Trophäenstange", Gargbosse.getModelle(), 5));

        seperator();

        PikkUp = new RuestkammerStarter(ID, randAbstand, cnt, new ORTrukkKammer(), "Trukk");
        add(PikkUp);

        Kampfpanza = new RuestkammerStarter(ID, randAbstand, cnt, new ORFahrzeugruestkammer(), "Battlewagon");
        Kampfpanza.setSeperator(0);
        add(Kampfpanza);

        sizeSetzen();

    }

    @Override
    public void refreshen() {
        Trophäenstange.setMaxAnzahl(Gargbosse.getModelle());
        GargbosseFK.setMaxAnzahl(Gargbosse.getModelle());
        PikkUp.setAktiv(!Kampfpanza.isSelected());
        Kampfpanza.setAktiv(!PikkUp.isSelected());
    }
}