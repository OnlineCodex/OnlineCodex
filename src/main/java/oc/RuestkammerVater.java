package oc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.WindowListener;
import java.util.Set;

import static oc.RefreshListener.Priority.RUESTKAMMER_VATER;
import static oc.RefreshListener.addRefreshListener;

public abstract class RuestkammerVater extends OptionsCollection implements BuildaSTK {

	private static final Logger LOGGER = LoggerFactory.getLogger(RuestkammerVater.class);

	protected int cntX = randAbstand;
	protected boolean legal = true;
	protected OptionsButtonUpgrade chosenRelic = null;
	boolean uniqueError = false;
	protected boolean warlord = false;
	boolean warlordSelected = false;
	private JButton ok = new JButton("OK");
	private JLabel error = new JLabel();
	private JFrame frame = new JFrame();
    protected String type = "";
	protected Set<KeyWord> keywords;

	public RuestkammerVater() {
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getRootPane().setDefaultButton(ok); // reagiert dadurch auf die Tastendrücke auch wenn andere Buttons den Focus ham
		frame.setIconImage(BuildaHQ.oCLogo);
		frame.requestFocus();
		frame.setResizable(false);

		panel.add(ok);
		panel.add(error);
		panel.setLocation(0, 0);

		frame.add(panel);
    }

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}

	void setzteRefreshListener(int ID) {
		this.ID = ID;
		addRefreshListener(RUESTKAMMER_VATER, ID, this::refreshRuestkammerVater);
	}

	private void refreshRuestkammerVater() {
		LOGGER.info("RuestkammerVater refresh");
		refreshen();
		uniqueError = false;
		Dimension size = new Dimension(getBreite(), getHöhe() + 85); // +55 hier weil der OK button noch mitgerechnet werden muss
		if (!frame.getSize().equals(size)) {
			panel.setSize(size);
			frame.setSize(size);
			frame.repaint();
			panel.repaint();

			ok.setLocation(size.width - 130, size.height - 85);
			error.setLocation(10, size.height - 85);
		}

		chosenRelic = null;
		for (int i = 0; i < optionen.size(); ++i) {
			if (optionen.elementAt(i) instanceof OptionsUpgradeGruppe) {
				chosenRelic = ((OptionsUpgradeGruppe) optionen.elementAt(i)).getChosenRelic();
				if (chosenRelic != null) {
					uniqueError = chosenRelic.hasUniqueError();
					break;
				}
			} else if (optionen.elementAt(i) instanceof OptionsEinzelUpgrade) {
				chosenRelic = ((OptionsEinzelUpgrade) optionen.elementAt(i)).getChosenRelic();
				if (chosenRelic != null) {
					uniqueError = chosenRelic.hasUniqueError();
					break;
				}
			}
		}
		if (chosenRelic == null) {
			for (int i = 0; i < optionen.size(); ++i) {
				if (optionen.elementAt(i) instanceof OptionsUpgradeGruppe) {
					((OptionsUpgradeGruppe) optionen.elementAt(i)).enableRelics();
				} else if (optionen.elementAt(i) instanceof OptionsEinzelUpgrade) {
					((OptionsEinzelUpgrade) optionen.elementAt(i)).enableRelics();
				}
			}
		} else {
			for (int i = 0; i < optionen.size(); ++i) {
				if (optionen.elementAt(i) instanceof OptionsUpgradeGruppe) {
					((OptionsUpgradeGruppe) optionen.elementAt(i)).disableOtherRelics(chosenRelic);
				} else if (optionen.elementAt(i) instanceof OptionsEinzelUpgrade) {
					((OptionsEinzelUpgrade) optionen.elementAt(i)).disableOtherRelics(chosenRelic);
				}
			}
		}

		refreshen();
	}

	@Override
	public int getBreite() {
		return this.panel.getSize().width;
	}

	public void sizeSetzen(int a, int b) {
		frame.setSize(a + 10, b + 16);  // signiert +6 weglassen
		panel.setSize(a + 10, b + 16);  // signiert +6 weglassen
		ok.setBounds(a - 116, b - 75, 100, 20); // signiert y nur -54

		if (BILDSCHIRMHÖHE <= 800 && b > 650) {
			frame.setLocation(100, 10);
		} else {
			frame.setLocation(100, 100);
		}
	}

	public void sizeSetzen() {
		int a = 0;
		int b = 0;
		for (int i = 0; i < optionen.size(); i++) {
			int x = optionen.elementAt(i).getPanel().getX() + optionen.elementAt(i).getPanel().getWidth();
			int y = optionen.elementAt(i).getPanel().getY() + optionen.elementAt(i).getPanel().getHeight();
			a = x > a ? x : a;
			b = y > b ? y : b;
		}
		sizeSetzen(a + 15, b);
	}

	void setCloseListener(WindowListener wl, FocusListener fl, ActionListener al) {
		frame.addWindowListener(wl);
		ok.addActionListener(al);
	}

	public String getText() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < optionen.size(); ++i) {
			if (optionen.elementAt(i).isSelected()) {
				sb.append(optionen.elementAt(i).getText());
			}
		}

		if (optionen.size() != 0 && !(optionen.elementAt(0) instanceof AnzahlPanel)) {
			if (sb.length() > 2 && BuildaHQ.kurzerText && name.equals("")) {
				return sb.toString().substring(2, sb.length());
			} // das substring schneidet das erste Komma mit dem Leerzeichen weg
			else if (sb.length() > 2 && !BuildaHQ.kurzerText && name.equals("")) {
				return sb.toString().substring(1, sb.length());
			}
		}

		return sb.toString();
	}

	public void setUeberschrift(String s) {
		frame.setTitle(s);
	}

	public void refreshen(){}

	public abstract void initButtons(boolean... b);

	public void deleteYourself() {
		LOGGER.info("RuestkammerStarter-deleteyourself");
		for (int i = 0; i < optionen.size(); i++) {
			if (optionen.elementAt(i) instanceof OptionsUpgradeGruppe) {
				((OptionsUpgradeGruppe) optionen.elementAt(i)).deleteYourself();
			} else if (optionen.elementAt(i) instanceof OptionsEinzelUpgrade) {
				((OptionsEinzelUpgrade) optionen.elementAt(i)).deleteYourself();
			}
		}
		frame.dispose();
	}

	public boolean isLegal() {
		return legal;
	}

    public void setType(String s) {
        type = s;
    }

	public void setKeywords(Set<KeyWord> keywords) {
		this.keywords = keywords;
	}
	
	public void removeKeyword(KeyWord key) {
		keywords.remove(key);
	}
	
	public void addKeyword(KeyWord key) {
		keywords.add(key);
	}
}