package oc.wh40k.units.dk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKShadowswordKammer extends RuestkammerVater {

  OptionsEinzelUpgrade o1;
  OptionsEinzelUpgrade o2;
  OptionsUpgradeGruppe o4;
  OptionsEinzelZaehler o5;
  OptionsEinzelZaehler o5x;
  OptionsUpgradeGruppe o6;

  public DKShadowswordKammer() {
	  
  }
  
  public void initButtons(boolean... defaults) {
    name = "Shadowsword";
    grundkosten = 450;


    add(ico = new oc.Picture("oc/wh40k/images/Shadowsword.gif"));
    


    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
    add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzlicher Sturmbolter", 10));
    add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Maschinengewehr", 10));
    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "snychr. schw. Bolter", "synchronisierter schwerer Bolter", 25));

    seperator(3);

    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Befehlspanzer", 25));

    seperator();

    ogE.addElement(new OptionsGruppeEintrag("zwei Seitenkuppeln", 0));
    ogE.addElement(new OptionsGruppeEintrag("vier Seitenkuppeln", 100));
    ogE.addElement(new OptionsGruppeEintrag("zusätzliche Panzerplatten", 0));
    add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

    seperator();

    add(o5x = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "schwerer Bolter", 0, 0));
    add(o5 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "schwerer Flamer", "schwerer Flammenwerfer", 0, 0));

    seperator(5);

    ogE.addElement(new OptionsGruppeEintrag("Laserkanonen", 0));
    ogE.addElement(new OptionsGruppeEintrag("Zieloptik", 0));
    add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

    sizeSetzen();

  }

  public void refreshen() {
    o4.alwaysSelected();

    o1.setAktiv(!o2.isSelected());
    o2.setAktiv(!o1.isSelected());

    o5.setAktiv(o4.isSelected("zwei Seitenkuppeln") || o4.isSelected("vier Seitenkuppeln"));
    o5.setMaxAnzahl(o4.isSelected("zwei Seitenkuppeln") ? 2 : 4);
    o5x.setAktiv(o4.isSelected("zwei Seitenkuppeln") || o4.isSelected("vier Seitenkuppeln"));

    o5.setMaxAnzahl(o4.isSelected("zwei Seitenkuppeln") ? 2 : 4);
    o5x.setMaxAnzahl(o5.getMaxAnzahl());
    o5x.setAnzahl(o5x.getMaxAnzahl() - o5.getAnzahl());

    o6.setAktiv(o4.isSelected("zwei Seitenkuppeln") || o4.isSelected("vier Seitenkuppeln"));
    o6.alwaysSelected();
  }
}
