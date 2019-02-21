package oc.wh40k.units.or;

import oc.*;

public class ORNobzKammer extends RuestkammerVater {

	private AnzahlPanel Bosse;
	private OptionsEinzelUpgrade Bossbikaz;
	private OptionsZaehlerGruppe BosseCC;
	private OptionsZaehlerGruppe BosseFK;
	private OptionsEinzelUpgrade Panzarüstung;
	private OptionsEinzelZaehler Trophäenstange;
	private OptionsEinzelUpgrade Waaaghbanner;
	private OptionsEinzelZaehler Munigrotz;
	private RuestkammerStarter PikkUp;
    private RuestkammerStarter Kampfpanza;

    public ORNobzKammer() {
    }

    public void initButtons(boolean... defaults) {
        grundkosten = 0;

        Bosse = new AnzahlPanel(ID, randAbstand, cnt, "Nobz", 3, 10, 18);
        add(Bosse);

        add(ico = new oc.Picture("oc/wh40k/images/Bosse.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Fette Spalta", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiekrallä", 25));
        BosseCC = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
        add(BosseCC);

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Wumme", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Wumme", 3));
        ogE.addElement(new OptionsGruppeEintrag("Bazzukka-Kombi", 5));
        ogE.addElement(new OptionsGruppeEintrag("Gitbrenna-Kombi", 10));
        BosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
        add(BosseFK);

        seperator(5);

        add(Waaaghbanner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Waaaghbanner", 20));

        seperator(5);

        add(Trophäenstange = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Trophäenstange", Bosse.getModelle(), 5));
        add(Munigrotz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Munigrotz", Bosse.getModelle(), 3));

        seperator(5);

        add(Panzarüstung = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzarüstungen", 4, Bosse.getModelle()));
        add(Bossbikaz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bossbikaz", 27, Bosse.getModelle()));

        seperator();

        PikkUp = new RuestkammerStarter(ID, randAbstand, cnt, ORTrukkKammer.class, "Trukk");
        PikkUp.initKammer();
        add(PikkUp);

        Kampfpanza = new RuestkammerStarter(ID, randAbstand, cnt, ORFahrzeugruestkammer.class, "Battlewagon");
        Kampfpanza.initKammer();
        add(Kampfpanza);

        sizeSetzen();
    }

    //@OVERRIDE
    public void refreshen() {
        Bossbikaz.setAktiv(!Panzarüstung.isSelected());
        Panzarüstung.setAktiv(!Bossbikaz.isSelected());

        BosseFK.setMaxAnzahl(Bosse.getModelle());
        BosseCC.setMaxAnzahl(Bosse.getModelle());
        Panzarüstung.setModelle(Bosse.getModelle());
        Trophäenstange.setMaxAnzahl(Bosse.getModelle());
        Munigrotz.setMaxAnzahl(Bosse.getModelle());

        Bossbikaz.setModelle(Bosse.getModelle());

        PikkUp.setAktiv(!Kampfpanza.isSelected() && !Bossbikaz.isSelected());
        Kampfpanza.setAktiv(!PikkUp.isSelected() && !Bossbikaz.isSelected());
        Kampfpanza.getPanel().setLocation((int) Kampfpanza.getPanel().getLocation().getX(), (int) PikkUp.getPanel().getLocation().getY() + PikkUp.getPanel().getSize().height);

    }

}
