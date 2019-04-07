package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class ORMeganobzKammer extends RuestkammerVater {

	private AnzahlPanel Gargbosse;
	private OptionsZaehlerGruppe GargbosseFK;
	private RuestkammerStarter PikkUp;
	private RuestkammerStarter Kampfpanza;
	private OptionsEinzelZaehler Trophäenstange;

    public ORMeganobzKammer() {
    }

    @Override
	public void initButtons(boolean... defaults) {
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

        PikkUp = new RuestkammerStarter(ID, randAbstand, cnt, ORTrukkKammer.class, "Trukk");
        PikkUp.initKammer();
        add(PikkUp);

        Kampfpanza = new RuestkammerStarter(ID, randAbstand, cnt, ORFahrzeugruestkammer.class, "Battlewagon");
        Kampfpanza.initKammer();
        Kampfpanza.setSeperator(0);
        add(Kampfpanza);

        sizeSetzen();

    }

    //@OVERRIDE
    @Override
	public void refreshen() {

        Trophäenstange.setMaxAnzahl(Gargbosse.getModelle());
        GargbosseFK.setMaxAnzahl(Gargbosse.getModelle());
        PikkUp.setAktiv(!Kampfpanza.isSelected());
        Kampfpanza.setAktiv(!PikkUp.isSelected());

    }
}
