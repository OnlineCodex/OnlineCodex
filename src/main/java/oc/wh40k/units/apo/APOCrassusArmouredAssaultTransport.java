//IA1 2nd Ed

package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class APOCrassusArmouredAssaultTransport extends Eintrag {

  OptionsEinzelUpgrade oe1;
  OptionsEinzelUpgrade oe2;
  OptionsZaehlerGruppe o5;
  OptionsZaehlerGruppe o5x;
  OptionsZaehlerGruppe o4;
  OptionsZaehlerGruppe o4x;

  public APOCrassusArmouredAssaultTransport() {
    name = "Crassus Armoured Assault Transport";
    grundkosten = 250;

    add(ico = new oc.Picture("oc/wh40k/images/Shadowsword.gif"));
 
    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
    add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 10));
	add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "heavy stubber", "pintle-mounted heavy stubber", 10));
	add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "storm bolter", "pintle-mounted storm bolter", 10));

    seperator();

    ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", "Front sponson with Heavy Bolter", 0));
    add(o4x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
    ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", "Front sponson with Heavy Flamer", 0));
    ogE.addElement(new OptionsGruppeEintrag("Autocannon", "Front sponson with Autocannon", 5));
    ogE.addElement(new OptionsGruppeEintrag("Lascannon", "Front sponson with Lascannon", 10));
    add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

    seperator();

    ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", "Side sponson with Heavy Bolter", 0));
    add(o5x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
    ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", "Side sponson with Heavy Flamer", 0));
    ogE.addElement(new OptionsGruppeEintrag("Autocannon", "Side sponson with Autocannon", 5));
    ogE.addElement(new OptionsGruppeEintrag("Lascannon", "Side sponson with Lascannon", 10));
    ogE.addElement(new OptionsGruppeEintrag("Armour plates", 0));
    add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

    complete();

  }

  public void refreshen() {
      o5.setMaxAnzahl(o5.isSelected("Armour plates") ? 1 : 2);
      o5x.setMaxAnzahl(o5.isSelected("Armour plates") ? 1 : 2);

      o5.setButtonMaxAnzahl("Armour plates", 1);
      
      o4x.setAnzahl(0, o4x.getMaxAnzahl() - o4.getAnzahl());
      o5x.setAnzahl(0, o5x.getMaxAnzahl() - o5.getAnzahl());
      
      oe1.setAktiv(!oe2.isSelected());
      oe2.setAktiv(!oe1.isSelected());

  }
}
