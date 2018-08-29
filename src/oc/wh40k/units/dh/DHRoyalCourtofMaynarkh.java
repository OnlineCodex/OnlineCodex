package oc.wh40k.units.dh;

import java.util.ArrayList;
import java.util.HashMap;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class DHRoyalCourtofMaynarkh extends Eintrag {

	RuestkammerStarter[] lord = new RuestkammerStarter[5];
    RuestkammerStarter[] kryptomant = new RuestkammerStarter[5];

	public DHRoyalCourtofMaynarkh() {
		name = "Royal Court of Maynarkh";
		grundkosten = 0;
		überschriftSetzen = true;
        setEintragsCNT(0.0);
        
        addToInformationVector("DHHerrscherrat", 1);

		add(ico = new oc.Picture("oc/wh40k/images/NEHerrscherrat.jpg"));
		

		seperator();

		lord[0] = new RuestkammerStarter(ID, randAbstand, cnt, "DHMaynarkhLordKammer", "", 0);
		lord[0].initKammer();
        lord[0].setButtonText("Maynarkh Lord");
		add(lord[0]);

		seperator();

		lord[1] = new RuestkammerStarter(ID, randAbstand, cnt, "DHMaynarkhLordKammer", "", 0);
		lord[1].initKammer();
        lord[1].setButtonText("Maynarkh Lord");
		add(lord[1]);

		seperator();

		lord[2] = new RuestkammerStarter(ID, randAbstand, cnt, "DHMaynarkhLordKammer", "", 0);
		lord[2].initKammer();
        lord[2].setButtonText("Maynarkh Lord");
		add(lord[2]);

		seperator();

		lord[3] = new RuestkammerStarter(ID, randAbstand, cnt, "DHMaynarkhLordKammer", "", 0);
		lord[3].initKammer();
        lord[3].setButtonText("Maynarkh Lord");
		add(lord[3]);

		seperator();

		lord[4] = new RuestkammerStarter(ID, randAbstand, cnt, "DHMaynarkhLordKammer", "", 0);
		lord[4].initKammer();
        lord[4].setButtonText("Maynarkh Lord");
		add(lord[4]);

		seperator();

		kryptomant[0] = new RuestkammerStarter(ID, randAbstand, cnt, "DHKrytpomantKammer", "", 0);
		kryptomant[0].initKammer();
        kryptomant[0].setButtonText("Kryptomant");
		add(kryptomant[0]);

		seperator();

		kryptomant[1] = new RuestkammerStarter(ID, randAbstand, cnt, "DHKrytpomantKammer", "", 0);
		kryptomant[1].initKammer();
        kryptomant[1].setButtonText("Kryptomant");
		add(kryptomant[1]);

		seperator();

		kryptomant[2] = new RuestkammerStarter(ID, randAbstand, cnt, "DHKrytpomantKammer", "", 0);
		kryptomant[2].initKammer();
        kryptomant[2].setButtonText("Kryptomant");
		add(kryptomant[2]);

		seperator();

		kryptomant[3] = new RuestkammerStarter(ID, randAbstand, cnt, "DHKrytpomantKammer", "", 0);
		kryptomant[3].initKammer();
        kryptomant[3].setButtonText("Kryptomant");
		add(kryptomant[3]);

		seperator();

		kryptomant[4] = new RuestkammerStarter(ID, randAbstand, cnt, "DHKrytpomantKammer", "", 0);
		kryptomant[4].initKammer();
        kryptomant[4].setButtonText("Kryptomant");
		add(kryptomant[4]);

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
        int highLords = getCountFromInformationVector("DHHochlord");
        int councils = getCountFromInformationVector("DHHerrscherrat");
        if(councils > highLords) {
            setFehlermeldung("Zu viele Räte!");
        } else {
            String duplicateItem = checkDuplicateItems();
            if(duplicateItem == null) {
                setFehlermeldung("");
            } else {
                setFehlermeldung("Doppelt: " + duplicateItem);
            }
        }
        
	}

	@Override
	public void deleteYourself() {
		addToInformationVector("DHHerrscherrat", -1);
		super.deleteYourself();
	}
    
    /**
     * Check if any item is selected for more than 1 Kryptomant
     * @return Name of the item, or NULL if no duplicates found
     */
    private String checkDuplicateItems() {
        ArrayList<String> items = new ArrayList<String>();
        items.add("Aura des Schreckens");
        items.add("Schleier der Finsternis");
        items.add("Flammenblick");
        items.add("Solarimpuls");
        items.add("Chronometrum");
        items.add("Zeitsplittermantel");
        items.add("Hochspannungsfeld");
        items.add("Ätherkristall");
        items.add("Schockwelleninduktor");
        items.add("Harfe der Dissonanz");
        
        HashMap<String, Integer> itemMap = new HashMap<String, Integer>();
        for(RuestkammerStarter krypto : kryptomant) {
            String text = krypto.getText();
            for(String item : items) {
                if(text.contains(item)) {
                    if(itemMap.containsKey(item))
                        return item;
                    else
                        itemMap.put(item, 1);
                }
            }
        }
        
        return null;
    }

}
